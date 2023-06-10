package apiguardian;

import com.opencsv.bean.CsvBindByPosition;

import java.io.Serializable;

public class Field implements Serializable {

    /**
     * Testo dell'articolo
     */
    @CsvBindByPosition(position = 3)
    private String bodyText;

    /**
     * costruttore della classe
     * @param bodyText testo dell'articolo
     */
    public Field(final String bodyText){
        this.bodyText=bodyText;
    }

    /**
     * Costruttore di default
     */
    public Field(){
    }

    /**
     * Imposta il testo dell'articolo
     * @param bodyText
     */
    public void setBodyText(final String bodyText){
        this.bodyText=bodyText;
    }

    /**
     * Ritorna il testo dell'articolo
     * @return testo articolo
     */
    public String getBodyText() {
        return bodyText;
    }

    /**
     * toString di Field
     * @return testo dell'articolo
     */
    @Override
    public String toString() {
        return bodyText;
    }

}
