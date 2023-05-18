package Control;

import java.io.*;
import java.util.*;
import Model.Word;

public class txtManager {
    public static void saveWords(ArrayList<Word> word) throws IOException {

        int i=0;
        String file="";

        while(i<word.size() && i<50) {
            file += word.get(i).getWord() + " " + word.get(i).getValue();

            if(i!=49) file += "\n";
            i++;
        }
        System.out.println(file);
        try{
            FileOutputStream fo = new FileOutputStream("50words.txt");
            //OutputStreamWriter out = new OutputStreamWriter(fo);
            fo.write(file.getBytes());

            fo.close();
            //out.close();
        }
        catch(FileNotFoundException e) {}




    }
    public static ArrayList<Word> readWords(String fileName) throws FileNotFoundException {

        File file=new File(fileName);
        Scanner sc=new Scanner(file);

        ArrayList<Word> word=new ArrayList<Word>(50);
        try {
            int i=0;

            while (sc.hasNext() && i<50) {

                word.add(new Word(sc.next(), sc.nextInt()));
                i++;
            }
        }
        catch (InputMismatchException e){
            e.printStackTrace();
        }

        return word;
    }
}
