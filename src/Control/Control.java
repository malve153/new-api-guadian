package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import apiguardian.GuardianContentApi;
import javax.swing.*;

import apiguardian.Article;
import Model.Word;
import View.Frame;

public class Control implements WindowListener, ActionListener {

	/**
	 * Finestra
	 */
	private Frame frame;

	/**
	 * Oggetto per inviare la richiesta al The Guardian
	 */
	private GuardianContentApi guardianResponse;

	/**
	 * Costruttore di Control
	 */
	public Control() {
		frame = new Frame();
		frame.getInitialPane().getBtnStart().addActionListener(this);
		frame.addWindowListener(this);
	}

	/**
	 * Richiamato la prima volta che una finestra viene resa visibile.
	 * @param e l'evento che deve essere processato
	 */
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Richiamato quando l'utente tenta di chiudere la finestra dal menu' di sistema della finestra
	 * @param e l'evento che deve essere processato
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		uscita();
	}

	/**
	 * Richiamato quando una finestra e' stata chiusa come risultato della chiamata sulla finestra.
	 * @param e l'evento che deve essere processato
	 */
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Richiamato quando una finestra viene modificata da uno stato normale a uno stato ridotto.
	 * @param e l'evento che deve essere processato
	 */
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Richiamato quando una finestra viene modificata da uno stato ridotto a icona a uno stato normale.
	 * @param e l'evento che deve essere processato
	 */
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Richiamato quando la finestra e' impostata come finestra attiva.
	 * Solo un Frame o un Dialog può essere la Finestra attiva.
	 * @param e l'evento che deve essere processato
	 */
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Richiamato quando una finestra non e' più la finestra attiva.
	 * Solo un Frame o unDialog può essere la Finestra attiva.
	 * @param e l'evento che deve essere processato
	 */
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Richiamato quando si verifica un'azione sui bottoni dei vari pannelli
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int opz=1;
		AtomicInteger opz2= new AtomicInteger(1);
		String term=null;

		if(e.getSource() == frame.getInitialPane().getBtnStart()) {
			guardianResponse=new GuardianContentApi(frame.getInitialPane().getTextField().getText());
			frame.changeInitialPanel();
			frame.getPanel().getBtnInvio().addActionListener(this);
		}
		else if(e.getSource() == frame.getPanel().getBtnInvio()) {

			if(frame.getPanel().getRdbtnDownload().isSelected()) {
				//solo download

				opz = JOptionPane.showConfirmDialog(frame, "Vuoi cercare articoli con una parola in particolare? Se si preme no verranno scaricati gli artioli riguardanti l'energia nucleare", "Ricerca termini", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (opz == 0) {
					term = JOptionPane.showInputDialog(frame, "Che termine vuoi cercare?");

				} else if (opz == 1) {
					term = "nuclear power";

				}
				else {
					return;
				}
				try {

					String finalTerm1 = term;
					new Thread(() -> {
						try {
							frame.changePanelToLoadPanel();
							frame.getLoadPanel().setLbl("Sto scaricando gli articoli...");
							Article a[] = guardianResponse.getContent(finalTerm1);
							if (a == null) {
								JOptionPane.showMessageDialog(frame,
										"Parola inserita non presente in alcun articolo", "Richiesta fallita", JOptionPane.ERROR_MESSAGE);
								frame.changeLoadPanelToPanel();

							} else {
								frame.getLoadPanel().setLbl("Salvataggio articoli in corso...");
								new Serializzatore("Resources/Word.txt").writeObj(a);
								frame.changeLoadPanelToPanel();
								JOptionPane.showMessageDialog(frame, "Download avvenuto con successo!", "Download articoli", JOptionPane.INFORMATION_MESSAGE, null);

							}
						}
						catch (Exception e1){
							JOptionPane.showMessageDialog(frame,
									"Errore durante l'esecuzione! Verificare di aver inserito la chiave corretta e di essere connessi alla rete", "Operazione fallita", JOptionPane.ERROR_MESSAGE);
							frame.changeLoadPanelToPanel();
						}
					}).start();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame,
							"Errore durante l'esecuzione! Verificare di aver inserito la chiave corretta e di essere connessi alla rete", "Operazione fallita", JOptionPane.ERROR_MESSAGE);
				}


			}
			else if(frame.getPanel().getRdbtnDownloadTermini().isSelected()) {
				//entrambe

				opz = JOptionPane.showConfirmDialog(frame, "Vuoi cercare articoli con una parola in particolare? Se si preme no verranno scaricati gli artioli riguardanti l'energia nucleare", "Ricerca termini", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);


				if(opz==0) {
					term = JOptionPane.showInputDialog(frame, "Che termine vuoi cercare?");

				} else if(opz==1) {
					term="nuclear power";
				}
				else {
					return;
				}

				try {


					String finalTerm = term;
					new Thread(() -> {
						try{
							frame.changePanelToLoadPanel();
							frame.getLoadPanel().setLbl("Sto scaricando gli articoli...");
							ArrayList<Word> words=null;
							Article a[] = guardianResponse.getContent(finalTerm);
							if(a==null){
								JOptionPane.showMessageDialog(frame,
										"Parola inserita non presente in alcun articolo", "Richiesta fallita", JOptionPane.ERROR_MESSAGE);
								frame.changeLoadPanelToPanel();
							}
							else {
								frame.getLoadPanel().setLbl("Calcolo occorrenze delle parole...");
								words=ArticleList.mappingArticlesAmount(a);
								frame.getLoadPanel().setLbl("Salvataggio in corso...");

								new Serializzatore("Resources/Word.txt").writeObj(a);
								new TxtManager<Word>("Word.txt").saveWords(words);
								frame.getLoadPanel().setLbl("Salvataggio terminato...");
								opz2.set(JOptionPane.showConfirmDialog(frame, "Vuoi stampare i termini a video?", "Termini", JOptionPane.YES_NO_OPTION));

								if (opz2.get() == 0) {
									frame.changeLoadPanelToWordsPanel();
									printWords(words);
								} else {
									frame.changeLoadPanelToPanel();
								}
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(frame,
									"Errore durante l'esecuzione! Verificare di aver inserito la chiave corretta e di essere connessi alla rete", "Operazione fallita", JOptionPane.ERROR_MESSAGE);
							frame.changeLoadPanelToPanel();
						}


					}).start();




				} catch (Exception e1){
					JOptionPane.showMessageDialog(frame,
							"Errore durante l'esecuzione! Verificare di aver inserito la chiave corretta e di essere connessi alla rete", "Operazione fallita", JOptionPane.ERROR_MESSAGE);
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
					frame.changePanelToLoadPanel();
					frame.getLoadPanel().setLbl("Sto caricando gli articoli...");
					String finalTerm1 = term;
					String finalFileName = fileName;
					new Thread(() -> {
						try {

							ArrayList<Article> art = new Deserializzatore(finalFileName).deserialize();
							Article[] a = art.toArray(new Article[art.size()]);
							frame.getLoadPanel().setLbl("Calcolo occorrenze delle parole...");
							ArrayList<Word> words = ArticleList.mappingArticlesAmount(a);
							frame.getLoadPanel().setLbl("Salvataggio dei dati in corso...");
							new TxtManager("Resources/Word.txt").saveWords(words);
							frame.getLoadPanel().setLbl("Salvataggio terminato...");
							opz2.set(JOptionPane.showConfirmDialog(frame, "Vuoi stampare i termini a video?", "Termini", JOptionPane.YES_NO_OPTION));

							if(opz2.get() ==0) {
								printWords(words);
							}
							else{
								frame.changeLoadPanelToPanel();
							}
						}
						catch (Exception e1){
							JOptionPane.showMessageDialog(frame,
									"Errore durante l'esecuzione", "Operazione fallita", JOptionPane.ERROR_MESSAGE);
							frame.changeLoadPanelToPanel();
						}
					}).start();

				} catch (Exception e1){
					JOptionPane.showMessageDialog(frame,
							"Errore durante l'esecuzione", "Operazione fallita", JOptionPane.ERROR_MESSAGE);
					frame.changeLoadPanelToPanel();
				}


			}
		} else if(e.getSource() == frame.getWordsPanel().getBtnIndietro()) {

			frame.changeWordsPanel();
		}

	}

	/**
	 * Metodo che cambia il pannello per stampare le parole e il corrispondente numero di occorrenze in una tabella
	 * @param ArrayList di Word
	 *
	 */
	private void printWords(ArrayList<Word> words){
		frame.changePanel();
		frame.getWordsPanel().getBtnIndietro().addActionListener(this);

		frame.getWordsPanel().getTable().setModel(frame.getWordsPanel().setTable(words));
		frame.getWordsPanel().setTable();

	}

	/**
	 * Metodo per chiedere la conferma di uscita quando si invoca la chiusura della finestra
	 */
	private void uscita() {

		int u = JOptionPane.showConfirmDialog(frame, "Sicuro di voler uscire?", "Uscita", JOptionPane.YES_NO_OPTION);

		if(u == JOptionPane.OK_OPTION) System.exit(0);
	}

}
