

import Control.Control;
import Control.Deserializzatore;
import Model.Field;

import java.awt.EventQueue;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        /*Control.Deserializzatore d=new Deserializzatore("Resources/nytimes_articles_v2.csv");
		ArrayList<Model.Article> a= d.deserializeCSV();*/
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Control control = new Control();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
