package Test;

import org.junit.Test;
import static org.junit.Assert.*;
import Model.Word;

public class WordTest {

    @Test
    public void compareEqualStringsTest() {
        Word w = new Word("test");
        assertEquals(0,new Word().compare(w,w));
    }

    @Test
    public void compareBiggerValueStringTest() {
        //Letter A comes before letter B, so A has bigger value than B.
        Word w1 = new Word("A");
        Word w2 = new Word("B");
        assertEquals(-1,new Word().compare(w1,w2));
    }

    @Test
    public void compareLowerValueStringTest() {
        //Letter C comes after letter B, so C has lower value than B.
        Word w1 = new Word("C");
        Word w2 = new Word("B");
        assertEquals(1,new Word().compare(w1,w2));
    }

    @Test
    public void biggerWordOccurrenceTest() {
        Word w1 = new Word("test1",10);
        Word w2 = new Word("test2",5);
        assertEquals(-1,new Word().compare(w1,w2));
    }

    @Test
    public void lowerWordOccurrenceTest() {
        Word w1 = new Word("test1",5);
        Word w2 = new Word("test2",10);
        assertEquals(1,new Word().compare(w1,w2));
    }

}