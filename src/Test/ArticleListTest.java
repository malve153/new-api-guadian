package Test;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import Model.Word;
import Model.Field;
import Model.Article;
import Control.ArticleList;

public class ArticleListTest {

    @Test
    public void mappingArticlesTest() {
        Article[] a = new Article[1];
        a[0] = new Article("0","Test",new Field("This is a test."));

        //An array with sorted words, should be the same as array w2.
        ArrayList<Word> w1 = new ArrayList<Word>();
        ArrayList<Word> w2 = ArticleList.mappingArticles(a);

        //w1.add(new Word("a",1));
        //w1.add(new Word("is",1));
        w1.add(new Word("test",1));
        //w1.add(new Word("this",1));

        assertEquals(w1.size(),w2.size());
        for(int i = 0;i<w2.size();i++) {
            assertEquals(w1.get(i).getWord(), w2.get(i).getWord());
            assertEquals(w1.get(i).getValue(), w2.get(i).getValue());
        }
    }

    @Test
    public void mappingArticlesAmountFailTest() {
        Article[] a = new Article[1];
        a[0] = new Article("0","Test",new Field("This is a test."));
        assertEquals(1,ArticleList.mappingArticlesAmount(a).size());
    }

    @Test
    public void mappingArticlesAmountSuccessTest() {
        Article[] a = new Article[1];
        String bodyText="";
        for(int i=1;i<=ArticleList.ARTICLE_SIZE;i++)
            bodyText=bodyText+" "+"test"+i;
        a[0] = new Article("0","Test",new Field(bodyText));
        assertEquals(ArticleList.ARTICLE_SIZE,ArticleList.mappingArticlesAmount(a).size());
    }

}