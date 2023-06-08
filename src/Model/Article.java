package Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvRecurse;
import Model.Field;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Article implements Serializable {

  /**
   * Id dell'articolo
   */
  @CsvBindByPosition(position = 0)
  String id;
  /**
   * Titolo dell'articolo
   */
  @CsvBindByPosition(position = 2)
  String webTitle;
  /**
   * Campo contenente il testo dell'articolo
   */
  @CsvRecurse
  Field fields;

  /**
   * Costruttore della classe
   * @param id Id dell'articolo
   * @param webTitle Titolo dell'articolo
   * @param fields Campo contenente il testo dell'articolo
   */
  public Article(final String id, final String webTitle, final Field fields) {
    this.id = id;
    this.webTitle = webTitle;
    this.fields = fields;

  }

  /**
   * Costruttore di default
   */
  public Article() {

  }

  /**
   * Ritorna l'id dell'articolo
   * @return Id dell'articolo
   */
  public String getId() {
    return id;
  }

  /**
   * Imposta l'id dell'articolo
   * @param id
   */
  public void setId(final String id) {
    this.id = id;
  }

  /**
   * Ritorna il titolo dell'articolo
   * @return titolo dell'articolo
   */
  public String getWebTitle() {
    return webTitle;
  }

  /**
   * imposta il titolo dell'articolo
   * @param webTitle
   */
  public void setWebTitle(final String webTitle) {
    this.webTitle = webTitle;
  }

  /**
   * Ritorna il testo dell'articolo
   * @return testo dell'articolo
   */
  public Field getFields() { return  fields; }

  /**
   * Imposta il testo dell'articolo
   * @param fields
   */
  public void setFields(final Field fields) { this.fields = fields; }

  /**
   * toString della classe Article
   * @return stringa composta da id, webTitle, bodyText
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
