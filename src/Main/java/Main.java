

import Control.Control;

import java.awt.EventQueue;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
	/**
	 * Metodo eseguibile
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
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
