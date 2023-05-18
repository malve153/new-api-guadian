package Control;

import Model.Article;
import Model.Word;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;

public class ArticleList {

    public static ArrayList<Word> mappingArticles(Article[] articles) {

        ArrayList<Word> al = new ArrayList<Word>();

        StringTokenizer st;
        String key;
        String fullText;

        String keyCopy;
        int j = 0;
        boolean alreadyfound;

        for (int i = 0; i < articles.length; i++) {
            fullText = articles[i].getWebTitle() + articles[i].getFields().getBodyText();
            st = new StringTokenizer(fullText);
            keyCopy = "";

            while (st.hasMoreTokens()) {
                alreadyfound = false;
                key = st.nextToken();

                key = key.replaceAll("[,.;:?!(){}^'\n\"“” ]", "");
                key = key.replace("[", "");
                key = key.replace("]", "");

                key = key.toLowerCase();

                if (al.size() != 0) {
                    j = 0;
                    while (j < al.size() && !alreadyfound) {
                        if (al.get(j).getWord().compareTo(key) == 0)
                            alreadyfound = true;
                        else
                            j++;
                    }
                }
                if (!alreadyfound)
                    al.add(new Word(key));
                else if (alreadyfound && !keyCopy.contains(key))
                    al.get(j).setValue(al.get(j).getValue() + 1);

                keyCopy = keyCopy + " " + key;
            }

        }
        Collections.sort(al, new Word());
        return al;

    }

    public static String mapToString(ArrayList<Word> al) {
        String s = "\nParole Mappa/Array:\n";
        for (int i = 0; i < al.size(); i++)
            s = s + "\nParola: " + al.get(i).getWord() + " Presenza: " + al.get(i).getValue();
        s = s + "\nGrandezza Array: " + al.size();
        return s;
    }
}