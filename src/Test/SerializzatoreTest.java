package Test;

import org.junit.Test;
import static org.junit.Assert.*;
import Model.Field;
import Model.Article;
import Control.Serializzatore;

public class SerializzatoreTest {

    @Test
    public void writeObjTest() {
        Article[] a = new Article[1];
        a[0] = new Article("0","Test",new Field("This is a test."));

        Serializzatore s = new Serializzatore("Test.txt");
        try {
            s.writeObj(a);
        }
        catch(Exception e){
            fail("Operation Failed: "+e.getMessage());
        }
    }

}