
import Control.Deserializzatore;
import Model.Field;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Control.Deserializzatore d=new Deserializzatore("Resources/nytimes_articles_v2.csv");
		ArrayList<Model.Article> a= d.deserializeCSV();
	}
}
