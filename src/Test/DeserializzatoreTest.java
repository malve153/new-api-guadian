package Test;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import apiguardian.Field;
import apiguardian.Article;
import Control.Deserializzatore;

public class DeserializzatoreTest {

    @Test
    public void deserializeTest() {
        ArrayList<Article> a1 = new ArrayList<Article>();
        ArrayList<Article> a2 = new ArrayList<Article>();
        Deserializzatore d = new Deserializzatore("Test.txt");

        a1.add(new Article("0","Test",new Field("This is a test.")));

        try{
            a2=d.deserialize();
        }
        catch (Exception e){
            fail("Operation Failed: "+e.getMessage());
        }

        assertEquals(a1.size(),a2.size());
        assertEquals(a1.get(0).getId(),a2.get(0).getId());
        assertEquals(a1.get(0).getWebTitle(),a2.get(0).getWebTitle());
        assertEquals(a1.get(0).getFields().getBodyText(),a2.get(0).getFields().getBodyText());
    }

    @Test
    public void deserializeCSVTest() {
        ArrayList<Article> a1 = new ArrayList<Article>();
        ArrayList<Article> a2 = new ArrayList<Article>();
        Deserializzatore d = new Deserializzatore("Test.csv");

        a1.add(new Article("0","Test",new Field("This is a test.")));

        try{
            a2=d.deserialize();
        }
        catch (Exception e){
            fail("Operation Failed: "+e.getMessage());
        }

        assertEquals(a1.size(),a2.size());
        assertEquals(a1.get(0).getId(),a2.get(0).getId());
        assertEquals(a1.get(0).getWebTitle(),a2.get(0).getWebTitle());
        assertEquals(a1.get(0).getFields().getBodyText(),a2.get(0).getFields().getBodyText());
    }

}