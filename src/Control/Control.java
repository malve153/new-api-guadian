package Control;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import Control.txtManager;
import Control.Serializzatore;
import Control.Deserializzatore;
import Model.Article;
import Control.ArticleList;
import Control.GuardianContentApi;
import Model.Word;
import Model.Article;
import Model.Response;
import View.Frame;
import View.WordsPanel;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Control implements WindowListener, ActionListener {

	Frame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	public Control() {
		frame = new Frame();
		frame.getInitialPane().getBtnStart().addActionListener(this);
		frame.addWindowListener(this);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showConfirmDialog(frame, "Sicuro di voler uscire?", "Uscita", JOptionPane.YES_NO_OPTION);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int opz=1, opz2=1;
		String term=null;

		if(e.getSource() == frame.getInitialPane().getBtnStart()) {
			frame.changeInitialPanel();
			frame.getPanel().getBtnInvio().addActionListener(this);
		}
		else if(e.getSource() == frame.getPanel().getBtnInvio()) {

			GuardianContentApi res=new GuardianContentApi("f26c6407-afa1-47c4-8eb3-a671a18f628c");

			if(frame.getPanel().getRdbtnDownload().isSelected()) {
				//solo download
				opz = JOptionPane.showConfirmDialog(frame, "Vuoi cercare articoli con una parola in particolare?", "Ricerca termini", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (opz == 0) {
					term = JOptionPane.showInputDialog(frame, "Che termine vuoi cercare?");

				} else if (opz == 1) {
					term = "nuclear power";

				}
				else {
					return;
				}
				try {
					Article a[] = res.getContent(term);
					if(a==null){
						JOptionPane.showMessageDialog(frame,
								"Parola inserita non presente in alcun articolo", "Richiesta fallita", JOptionPane.ERROR_MESSAGE);
					}
					else{
						new Serializzatore("Resources/Word.txt").writeObj(a);
						JOptionPane.showMessageDialog(frame, "Download avvenuto con successo!", "Download articoli", JOptionPane.INFORMATION_MESSAGE, null);
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
				

			}
			else if(frame.getPanel().getRdbtnDownloadTermini().isSelected()) {
				//entrambe
				ArrayList<Word> words=null;

				opz = JOptionPane.showConfirmDialog(frame, "Vuoi cercare articoli con una parola in particolare?", "Ricerca termini", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);


				if(opz==0) {
					term = JOptionPane.showInputDialog(frame, "Che termine vuoi cercare?");

				} else if(opz==1) {
					//continua con solo estrazione termini
					term="nuclear power";
				}
				else {
					return;
				}

				try {
					Article a[] = res.getContent(term);
					if(a==null){
						JOptionPane.showMessageDialog(frame,
								"Parola inserita non presente in alcun articolo", "Richiesta fallita", JOptionPane.ERROR_MESSAGE);
					}
					else {
						words = ArticleList.mappingArticlesAmount(a);
						new Serializzatore("Resources/Word.txt").writeObj(a);
						new txtManager<Word>("Word.txt").saveWords(words);
						opz2 = JOptionPane.showConfirmDialog(frame, "Vuoi stampare i termini a video?", "Termini", JOptionPane.YES_NO_OPTION);

						if (opz2 == 0) {
							printWords(words);
						}
					}
				} catch (Exception e1){
					e1.printStackTrace();
				}


			} else {

				try {
					String[] options = { "NYTimes", "The Guardian"};
					int selezione = JOptionPane.showOptionDialog(frame, "Da quale sorgente vuoi estrarre i termini", "Seleziona sorgente:",
							0, 3, null, options, options[0]);

					String fileName="";

					if (selezione == 0) {
						fileName="Resources/nytimes_articles_v2.csv";
					} else if (selezione == 1) {
						fileName="Resources/Word.txt";
					}

					Deserializzatore des=new Deserializzatore(fileName);
					ArrayList<Article> art= des.deserialize();
					Article[] a= art.toArray(new Article[art.size()]);
					ArrayList<Word> words=ArticleList.mappingArticlesAmount(a);

					txtManager file=new txtManager("Resources/Word.txt");
					file.saveWords(words);
					opz2 = JOptionPane.showConfirmDialog(frame, "Vuoi stampare i termini a video?", "Termini", JOptionPane.YES_NO_OPTION);

					if(opz2==0) {
						printWords(words);
					}

				} catch (Exception e1){
					e1.printStackTrace();
				}


			}
		} else if(e.getSource() == frame.getWordsPanel().getBtnIndietro()) {

			frame.changeWordsPanel();
		}

	}

	private void printWords(ArrayList<Word> words){
		frame.changePanel();
		frame.getWordsPanel().getBtnIndietro().addActionListener(this);

		String value="";
		for (Word w:words) {
			value+=w+"\n";
		}

		frame.getWordsPanel().setTextArea(value);

	}



}
