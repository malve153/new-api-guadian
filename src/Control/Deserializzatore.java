package Control;

import apiguardian.Article;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;


public class Deserializzatore {
    /**
     * Costante con numero di articoli massimo
     */
    private final static int NUMERO_ARTICOLI=1000;
    /**
     * Nome del file in cui salvare gli articoli
     */
    private String fileName;

    /**
     * Costruttore della classe
     * @param fileName Il nome del file da leggere
     */
    public Deserializzatore(String fileName){
        this.fileName=fileName;
    }

    /**
     * Metodo per leggere il tipo di file e chiamare il deserializzatore corretto
     * @return Arraylist di articoli
     * @throws IOException
     */
    public ArrayList<Article> deserialize() throws IOException {
        if(fileName.substring(fileName.length()-3).compareTo("csv")==0){
            return deserializeCSV();
        }
        else if (fileName.substring(fileName.length()-3).compareTo("txt")==0){
            return deserializeTxt();
        }
        throw new InvalidParameterException();
    }

    /**
     * Metodo per leggere i file .txt
     * @return Arraylist di articoli
     * @throws IOException
     */
    public ArrayList<Article> deserializeTxt() throws IOException {
        ArrayList<Article> art=new ArrayList(NUMERO_ARTICOLI);
        ObjectMapper objectMapper = new ObjectMapper();

        art = objectMapper.readValue(new File(fileName), new TypeReference<ArrayList<Article>>(){});



        return art;
    }

    /**
     * Metodo per leggere i file .csv
     * @return Arraylist di articoli
     * @throws IOException
     */
    public ArrayList<Article> deserializeCSV() throws IOException {

        ArrayList<Article> beans = (ArrayList<Article>) new CsvToBeanBuilder(new FileReader(fileName))
                .withType(Article.class)
                .build()
                .parse();

        return beans;
    }
}
