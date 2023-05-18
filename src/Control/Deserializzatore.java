package Control;

import Model.Article;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.util.ArrayList;


public class Deserializzatore {

    private String fileName;

    public Deserializzatore(String fileName){
        this.fileName=fileName;
    }

    public ArrayList<Article> deserialize() throws IOException, ClassNotFoundException {
        ArrayList<Article> art=new ArrayList<Article>(1000);
        ObjectMapper objectMapper = new ObjectMapper();

        art = objectMapper.readValue(new File(fileName), new TypeReference<ArrayList<Article>>(){});



        return art;
    }

    public ArrayList<Article> deserializeCSV() throws IOException, ClassNotFoundException {

        ArrayList<Article> beans = (ArrayList<Article>) new CsvToBeanBuilder(new FileReader(fileName))
                .withType(Article.class)
                .build()
                .parse();

        return beans;
    }
}
