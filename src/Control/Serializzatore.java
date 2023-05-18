package Control;

import Model.Article;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.FileOutputStream;
import java.io.IOException;

public class Serializzatore {
	FileOutputStream out;
	ObjectMapper oos;
	String nomeFile;

	public Serializzatore(String nomeFile){
		this.nomeFile = nomeFile;
	}
	public void writeObj(Article[] article){
		try {
			out = new FileOutputStream(nomeFile);
			oos = new ObjectMapper();
			oos.configure(SerializationFeature.INDENT_OUTPUT, true);
			oos.writeValue(out, article);
		}catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
}
