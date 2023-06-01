package Control;

import Model.Article;
import Model.Word;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import Control.txtManager;


public class ArticleList {

    public static int ARTICLE_SIZE = 50;

    public static ArrayList<Word> mappingArticles(Article[] articles)  {

        ArrayList<Word> al = new ArrayList<Word>(ARTICLE_SIZE);

        StringTokenizer st;
        String key;
        String fullText;
        Map<String, Integer> map = new HashMap<String, Integer>();

        int j = 0;
        ArrayList<String> bannedWords=null;
        try {
            bannedWords = new txtManager<String>("Resources/stopList.txt").readFile(String.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        long l = System.currentTimeMillis();
        for (int i = 0; i < articles.length; i++) {

            fullText = articles[i].getWebTitle() + " " + articles[i].getFields().getBodyText();
            st = new StringTokenizer(fullText);
            Map<String, Integer> map1 = new HashMap<String, Integer>(st.countTokens());

            while (st.hasMoreTokens()) {

                key = st.nextToken();

                key = key.replaceAll("[,.;:?!(){}^'’\n\"“” ]", "");
                key = key.replace("[", "");
                key = key.replace("]", "");

                key = key.toLowerCase();

                if(key.length()!=0 && key.compareTo("–")!=0 &&!bannedWords.contains(key)) {
                    map1.put(key, map.getOrDefault(key, 1));
                }

            }
            if(!map1.containsKey("france")){
                System.out.println("france non presente in "+i+" tit "+articles[i].getWebTitle());
            }
            for (String k : map1.keySet()) {
                map.put(k, map.getOrDefault(k, 0) + 1);

            }

        }

        for (String k : map.keySet()) {

            al.add(new Word(k, map.get(k)));

        }

        Collections.sort(al, new Word());
        System.out.println("valore al termine del ciclo" + (System.currentTimeMillis() - l));

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