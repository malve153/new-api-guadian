package Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvRecurse;
import Model.Field;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Article implements Serializable {

  @CsvBindByPosition(position = 0)
  String id;
  @CsvBindByPosition(position = 2)
  String webTitle;
  @CsvRecurse
  Field fields;

  public Article(final String id, final String webTitle, final Field fields) {
    this.id = id;
    this.webTitle = webTitle;
    this.fields = fields;

  }

  public Article() {

  }

  public String getId() {
    return id;
  }

  public void setId(final String id) {
    this.id = id;
  }



  public String getWebTitle() {
    return webTitle;
  }

  public void setWebTitle(final String webTitle) {
    this.webTitle = webTitle;
  }

  public Field getFields() { return  fields; }

  public void setFields(final Field fields) { this.fields = fields; }

  /*
  public void addWordsToMap() {
    StringTokenizer tokener;
    String currentWord;
    while(tokener.hasMoreTokens()){
      currentWord=tokener.nextToken();
      //inserisci nella sorted-map
    }
  }
*/
  @Override
  public String toString() {
    return "Article{" +
        "id='" + id + '\'' +
        ", webTitle='" + webTitle + '\'' +
        ", bodyText='" + fields + '\'' +
        '}';
  }
}
