package Control;

import Model.Article;

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

        art = objectMapper.readValue(new File(fileName), new TypeReference <ArrayList<Article>>(){});



        return art;
    }

    public ArrayList<Article> deserializeCSV(String fileName) throws IOException, ClassNotFoundException {
        ArrayList<Article> art=new ArrayList<Article>(1000);

        ArrayList<Article> beans = (ArrayList<Article>) new CsvToBeanBuilder(new FileReader(fileName))
                .withType(Article.class)
                .build()
                .parse();

        beans.forEach(System.out::println);


        return art;
    }
}
