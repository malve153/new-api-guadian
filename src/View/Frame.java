package View;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;


public class Frame extends JFrame {

	/**
	 * Pannello iniziale
	 */
	private InitialPanel initialPane;

	/**
	 * Pannello principale dove vengono richieste le azioni da svolgere
	 */
	private Panel contentPane;

	/**
	 * Pannello per mostrare a video la tabella con la stampa delle parole e delle loro rispettive occorrenze
	 */
	private WordsPanel wordsPane;

	/**
	 * Pannello di caricamento
	 */
	private LoadPanel loadPane;

	/**
	 * Costruttore della finestra
	 */
	public Frame() {
		try {
			UIManager.setLookAndFeel( new FlatLightLaf() );
		} catch( Exception ex ) {
			System.err.println( "Failed to initialize LaF" );
		}
		this.setTitle("The Guardian Articles");

		this.setBounds(100, 100, 600, 320);
		this.setResizable(false);

		initialPane = new InitialPanel();
		this.setContentPane(initialPane);

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
		wordsPane=new WordsPanel();
		loadPane=new LoadPanel();

	}

	/**
	 * Metodo che ritorna il pannello iniziale
	 * @return initialPane pannello iniziale
	 */
	public InitialPanel getInitialPane() {
		return initialPane;
	}

	/**
	 * Metodo che ritorna il pannello principale
	 * @return contentPane pannello principale
	 */
	public Panel getPanel() {
		return contentPane;
	}

	/**
	 * Metodo che ritorna il pannello di stampa parole e occorrenze
	 * @return wordsPane pannello stampa parole e occorrenze
	 */
	public WordsPanel getWordsPanel() {
		return wordsPane;
	}

	/**
	 * Metodo che ritorna il pannello di caricamento
	 * @return loadPane pannello di caricamento
	 */
	public LoadPanel getLoadPanel() {
		return loadPane;
	}

	/**
	 * Metodo che cambia il pannello iniziale nel pannello principale
	 */
	public void changeInitialPanel() {
		this.remove(initialPane);
		this.invalidate();
		contentPane = new Panel();
		this.setContentPane(contentPane);
		this.setResizable(true);
		this.revalidate();

	}

	/**
	 * Metodo che cambia il pannello principale nel pannello di stampa parole e occorrenze
	 */
	public void changePanel() {
		this.remove(contentPane);
		this.invalidate();
		//wordsPane = new WordsPanel();
		this.setContentPane(wordsPane);
		this.setResizable(true);
		this.revalidate();

	}

	/**
	 * Metodo che cambia il pannello di stampa parole e occorrenze nel pannello principale
	 */
	public void changeWordsPanel() {
		this.remove(wordsPane);
		this.invalidate();
		this.setContentPane(contentPane);
		this.setResizable(true);
		this.revalidate();
	}

	/**
	 * Metodo che cambia il pannello principale nel pannello di caricamento
	 */
	public void changePanelToLoadPanel() {
		this.remove(contentPane);
		this.invalidate();
		this.setContentPane(loadPane);
		this.setResizable(true);
		this.revalidate();
	}

	/**
	 * Metodo che cambia il pannello di caricamento nel pannello di stampa parole e occorrenze
	 */
	public void changeLoadPanelToWordsPanel() {
		this.remove(loadPane);
		this.invalidate();
		this.setContentPane(wordsPane);
		this.setResizable(true);
		this.revalidate();
	}

	/**
	 * Metodo che cambia il pannello di caricamento nel pannello principale
	 */
	public void changeLoadPanelToPanel() {
		this.remove(loadPane);
		this.invalidate();
		this.setContentPane(contentPane);
		this.setResizable(true);
		this.revalidate();
	}

}
