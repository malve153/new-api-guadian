package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import javax.swing.*;

import Model.Article;
import Model.Word;
import View.Frame;

public class Control implements WindowListener, ActionListener {

	Frame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Control control = new Control();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

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
		uscita();
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
		int opz=1;
		AtomicInteger opz2= new AtomicInteger(1);
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
					frame.changePanelToLoadPanel();
					frame.getLoadPanel().setLbl("sto scaricando gli articoli...");
					String finalTerm1 = term;
					new Thread(() -> {
						try {
							Article a[] = res.getContent(finalTerm1);
							if (a == null) {
								JOptionPane.showMessageDialog(frame,
										"Parola inserita non presente in alcun articolo", "Richiesta fallita", JOptionPane.ERROR_MESSAGE);
							} else {
								frame.getLoadPanel().setLbl("salvataggio articoli in corso...");
								new Serializzatore("Resources/Word.txt").writeObj(a);
								frame.changeLoadPanelToPanel();
								JOptionPane.showMessageDialog(frame, "Download avvenuto con successo!", "Download articoli", JOptionPane.INFORMATION_MESSAGE, null);

							}
						}
						catch (Exception exc){
							exc.printStackTrace();
						}
					}).start();
				} catch (Exception e1) {
					e1.printStackTrace();
				}


			}
			else if(frame.getPanel().getRdbtnDownloadTermini().isSelected()) {
				//entrambe

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


					String finalTerm = term;
					new Thread(() -> {
						try{
							ArrayList<Word> words=null;
							Article a[] = res.getContent(finalTerm);
							if(a==null){
								JOptionPane.showMessageDialog(frame,
										"Parola inserita non presente in alcun articolo", "Richiesta fallita", JOptionPane.ERROR_MESSAGE);
							}
							else {
								frame.getLoadPanel().setLbl("calcolo occorrenze delle parole...");
								words=ArticleList.mappingArticlesAmount(a);
								frame.getLoadPanel().setLbl("salvataggio articoli in corso...");

								new Serializzatore("Resources/Word.txt").writeObj(a);
								new txtManager<Word>("Word.txt").saveWords(words);
								frame.getLoadPanel().setLbl("salvataggio terminato...");
								opz2.set(JOptionPane.showConfirmDialog(frame, "Vuoi stampare i termini a video?", "Termini", JOptionPane.YES_NO_OPTION));

								if (opz2.get() == 0) {
									frame.changeLoadPanelToWordsPanel();
									printWords(words);
								} else {
									frame.changeLoadPanelToPanel();
								}
							}
						} catch (Exception ex) {

						}


					}).start();

					frame.changePanelToLoadPanel();
					frame.getLoadPanel().setLbl("sto scaricando gli articoli...");


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
					opz2.set(JOptionPane.showConfirmDialog(frame, "Vuoi stampare i termini a video?", "Termini", JOptionPane.YES_NO_OPTION));

					if(opz2.get() ==0) {
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

		frame.getWordsPanel().getTable().setModel(frame.getWordsPanel().setTable(words));
		frame.getWordsPanel().setTable();

		/*String value="";
		for (Word w:words) {
			value+=w+"\n";
		}

		frame.getWordsPanel().setTextArea(value);*/

	}

	private void uscita() {

		int u = JOptionPane.showConfirmDialog(frame, "Sicuro di voler uscire?", "Uscita", JOptionPane.YES_NO_OPTION);

		if(u == JOptionPane.OK_OPTION) System.exit(0);
	}

}
