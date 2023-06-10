package Control;

import apiguardian.Article;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.FileOutputStream;
import java.io.IOException;

public class Serializzatore {
	/**
	 * Apre un output stream per scrivere dati su file
	 */
	private FileOutputStream out;
	/**
	 * Fornisce funzionalità per la lettura e la scrittura di JSON
	 */
	private ObjectMapper oos;
	/**
	 * Nome del file su cui scrivere
	 */
	private String nomeFile;

	/**
	 * Costruttore della classe
	 * @param nomeFile nome del file su cui scrivere
	 */
	public Serializzatore(String nomeFile){
		this.nomeFile = nomeFile;
	}

	/**
	 * Metodo per scrivere su file JSON gli oggetti contenenti gli articoli
	 * @param article Array di articoli
	 */
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
