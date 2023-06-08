package Control;

import Model.Article;
import Model.Response;
import Control.ResponseWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GuardianContentApi {

  /**
   * Dimensione pagina
   */
  private static final int PAGE_SIZE = 200;
  /**
   * Numero massimo di articoli
   */
  private static final int TOTAL_ARTICLE = 1000;

  static {
// Only one time
    Unirest.setObjectMapper(new ObjectMapper() {
      private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
          = new com.fasterxml.jackson.databind.ObjectMapper();

      public <T> T readValue(String value, Class<T> valueType) {
        try {
          return jacksonObjectMapper.readValue(value, valueType);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }

      public String writeValue(Object value) {
        try {
          return jacksonObjectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

  /**
   * URL dell'API
   */
  private final static String TARGET_URL = "https://content.guardianapis.com/search";
  /**
   * Formato data
   */
  private final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  /**
   * Chiave per utilizzare l'API
   */
  private final String apiKey;
  /**
   * Sezione in cui cercare gli articoli
   */
  private String section;
  /**
   * Tag degli articoli da cercare
   */
  private String tag;
  /**
   * Cerca articoli pubblicati fino a quella data
   */
  private Date toDate;
  /**
   * Cerca articoli pubblicati da quella data in poi
   */
  private Date fromDate;

  /**
   * Costruttore della classe
   * @param apiKey chiave per utilizzare l'API
   */
  public GuardianContentApi(final String apiKey) {
    this.apiKey = apiKey;
  }

  /**
   * Imposta la sezione
   * @param section
   */
  public void setSection(String section) {
    this.section = section;
  }

  /**
   * Imposta la data di partenza per cercare gli articoli
   * @param date
   */
  public void setFromDate(Date date) {
    this.fromDate = date;
  }

  /**
   * Imposta la data fino alla quale cercare articoli
   * @param date
   */
  public void setToDate(Date date) {
    this.toDate = date;
  }

  /**
   * Ritorna il tag
   * @return tag degli articoli
   */
  public String getTag() {
    return tag;
  }

  /**
   * imposta il tag
   * @param tag
   */
  public void setTag(String tag) {
    this.tag = tag;
  }

  /**
   * Ritorna gli articoli ricevuti dall'API
   * @param query Richiesta da effettuare all'API
   * @return NULL se la richiesta non è andata a buon fine, altrimenti un Array di Article
   * @throws UnirestException
   */
  public Article[] getContent(String query) throws UnirestException {

    int i=1,totalPages=1,dimLogic=0;

    Article[] art=new Article[TOTAL_ARTICLE];

    while(i<=totalPages && dimLogic<TOTAL_ARTICLE){
      HttpRequest request = Unirest.get(TARGET_URL)
              .queryString("show-fields", "body-text").
              queryString("page-size",PAGE_SIZE).queryString("page",i).queryString("q", query)
              .header("accept", "application/json").queryString("api-key", apiKey);

      HttpResponse<ResponseWrapper> response = request.asObject(ResponseWrapper.class);
      totalPages=response.getBody().getResponse().getTotal();

      if(response.getBody().getResponse().getStatus().compareTo("ok")==0 && (dimLogic+response.getBody().getResponse().getResults().length)<=art.length){

        System.arraycopy(response.getBody().getResponse().getResults(),0,art,dimLogic,response.getBody().getResponse().getResults().length);
        dimLogic+=response.getBody().getResponse().getResults().length;

        i++;
      }
      else {
        totalPages=TOTAL_ARTICLE+1;
      }

      if(dimLogic==0){
        return null;
      }

    }


    return art;

  }
}
