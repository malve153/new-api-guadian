package Control;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class TxtManager <T>{

    /**
     * Numero di parole da stampare/visualizzare
     */
    private static final int NUMERO_PAROLE=50;

    /**
     * Nome del file in cui salvare o leggere i dati
     */
    private String fileName;

    /**
     * Costruttore della classe
     * @param fileName nome del file
     */
    public TxtManager(String fileName){
        this.fileName=fileName;
    }

    /**
     * Metodo per salvare le parole nel file
     * @param word ArrayList contenente le parole da salvare
     * @throws IOException
     */
    public void saveWords(ArrayList<T> word) throws IOException {

        int i=0;
        String file="";

        while(i<word.size() && i<NUMERO_PAROLE) {
            file += word.get(i);

            if(i!=NUMERO_PAROLE-1) file += "\n";
            i++;
        }

        try(FileOutputStream fo = new FileOutputStream(fileName)){
            fo.write(file.getBytes());
        }
        catch(FileNotFoundException e) {}

    }

    /**
     * Metodo per leggere le parole dal file
     * @param c class literal
     * @return ArrayList riempito con le parole contenute nel file
     * @throws ClassNotFoundException
     * @throws FileNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
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
