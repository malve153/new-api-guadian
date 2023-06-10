package Test;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import Model.Word;
import Control.txtManager;

public class TxtManagerTest {

    @Test
    public void saveWordsTest() {
        ArrayList<Word> w1 = new ArrayList<Word>();
        w1.add(new Word("test1",1));
        w1.add(new Word("test2",2));
        TxtManager<Word> t = new TxtManager<Word>("50words.txt");

        try {
            t.saveWords(w1);
        }
        catch(Exception e){
            fail("Operation Failed: "+e.getMessage());
        }
    }

    @Test
    public void readWordsTest() {
        ArrayList<Word> w1 = new ArrayList<Word>();
        ArrayList<Word> w2 = new ArrayList<Word>();
        TxtManager<Word> t = new TxtManager<Word>("50words.txt");

        w2.add(new Word("test1",1));
        w2.add(new Word("test2",2));

        try{
            w1 = t.readFile(Word.class);
        }
        catch(Exception e){
            fail("Operation Failed: "+e.getMessage());
        }

        assertEquals(w2.size(),w1.size());

        for(int i = 0;i<w2.size();i++) {
            assertEquals(w2.get(i).getWord(),w1.get(i).getWord());
            assertEquals(w2.get(i).getValue(),w1.get(i).getValue());
        }
    }

}