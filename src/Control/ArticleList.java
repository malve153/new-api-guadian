package Control;

import Model.Article;
import Model.Word;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ArticleList {

    public static int ARTICLE_SIZE = 50;

    public static ArrayList<Word> mappingArticles(Article[] articles) {

        Scanner sc = null;
        String bannedWords = "";

        ArrayList<Word> al = new ArrayList<Word>();

        StringTokenizer st;
        String key;
        String fullText;

        String keyCopy;
        //boolean alreadyfound;
        HashMap<String,Integer> map = new HashMap<String,Integer>();

        int j = 0;

        try{
            sc = new Scanner(new File("Resources/stopList.txt"));
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }

        while(sc.hasNextLine())
            bannedWords=bannedWords+" "+sc.nextLine();

        for (int i = 0; i < articles.length; i++) {
            fullText = articles[i].getWebTitle() + " " + articles[i].getFields().getBodyText();
            st = new StringTokenizer(fullText);
            keyCopy = "";

            while (st.hasMoreTokens()) {
                //alreadyfound = false;
                key = st.nextToken();

                key = key.replaceAll("[,.;:?!(){}^'\n\"“”…♦¶]", "");
                key = key.replace(" ","");
                key = key.replace("[", "");
                key = key.replace("]", "");

                key = key.toLowerCase();

                if(key.compareTo("")!=0 && key.compareTo(" ")!=0 && key.compareTo("—")!=0 && !bannedWords.contains(key) && !keyCopy.contains(key)) {
                    map.put(key, map.getOrDefault(key, 0) + 1);
                    keyCopy = keyCopy + " " + key;
                }
            }
        }

        for(String k : map.keySet())
            al.add(new Word(k,map.get(k)));

        Collections.sort(al, new Word());
        return al;

    }

    public static ArrayList<Word> mappingArticlesAmount(Article[] articles) {
        ArrayList<Word> a1 = new ArrayList<Word>();
        ArrayList<Word> a2 = mappingArticles(articles);
        if(a2.size()<ARTICLE_SIZE)
            for(int i=0;i<a2.size();i++)
                a1.add(a2.get(i));
        else
            for(int i=0;i<ARTICLE_SIZE;i++)
                a1.add(a2.get(i));
        return a1;
    }

    public static String mapToString(ArrayList<Word> al) {
        String s = "\nParole Mappa/Array:\n";
        for (int i = 0; i < al.size(); i++)
            s = s + "\nParola: " + al.get(i).getWord() + " Presenza: " + al.get(i).getValue();
        s = s + "\nGrandezza Array: " + al.size();
        return s;
    }

}