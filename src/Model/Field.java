package Model;

import com.opencsv.bean.CsvBindByPosition;

import java.io.Serializable;

public class Field implements Serializable {

    private static final long serialVersionUID = 2L;
    @CsvBindByPosition(position = 3)
    String bodyText;

    public Field(final String bodyText){
        this.bodyText=bodyText;
    }

    public Field(){
    }

    public void setBodyText(final String bodyText){
        this.bodyText=bodyText;
    }

    public String getBodyText() {
        return bodyText;
    }

    @Override
    public String toString() {
        return bodyText;
    }

}
