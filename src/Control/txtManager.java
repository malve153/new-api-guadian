package Control;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import Model.Word;

public class txtManager <T>{
    /**
     * Nome del file in cui salvare o leggere i dati
     */
    private String fileName;

    private static final int NUMERO_PAROLE=50;

    public txtManager(String fileName){
        this.fileName=fileName;
    }
    public void saveWords(ArrayList<T> word) throws IOException {

        int i=0;
        String file="";

        while(i<word.size() && i<50) {
            file += word.get(i)/*.getWord() + " " + word.get(i).getValue()*/;

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

    public ArrayList<T> readFile(Class c) throws ClassNotFoundException, FileNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        File file=new File(fileName);
        Scanner sc=new Scanner(file);

        ArrayList<T> word=new ArrayList<T>(NUMERO_PAROLE);

        while (sc.hasNext()) {

            T obj= (T) Class.forName(c.getName()).getConstructor(String.class).newInstance(sc.nextLine());

            word.add(obj);
        }

        sc.close();

        return word;
    }
}
