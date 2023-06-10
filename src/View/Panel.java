package View;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class Panel extends JPanel {

	/**
	 * Etichetta delle scelte
	 */
	private JLabel lbl;

	/**
	 * Raggruppa i 3 JRadioButton
	 */
	private final ButtonGroup buttonGroup;

	/**
	 * JRadioButton per il download degli articoli
	 */
	private JRadioButton rdbtnDownload;

	/**
	 * JRadioButton per l'estrazione dei termini
	 */
	private JRadioButton rdbtnTermini;

	/**
	 * JRadioButton per il download degli articoli e l'estrazione dei termini
	 */
	private JRadioButton rdbtnDownloadTermini;

	/**
	 * Bottone per eseguire l'azione scelta
	 */
	private JButton btnInvio;

	/**
	 * Costruttore del pannello principale
	 */
	public Panel() {
		//setContentPane(contentPane);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		this.setBounds(100, 100, 600, 320);

		//contentPane.setLayout(new BorderLayout(0, 0));

		buttonGroup = new ButtonGroup();

		lbl = new JLabel("Scegliere una delle possibili azioni e premere 'INVIO': ");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl.setBounds(34, 58, 400, 14);
		this.add(lbl);

		rdbtnDownload = new JRadioButton("Download articoli");
		rdbtnDownload.setBounds(44, 90, 300, 23);
		buttonGroup.add(rdbtnDownload);
		rdbtnDownload.setSelected(true);
		this.add(rdbtnDownload);

		rdbtnTermini = new JRadioButton("Estrazione termini");
		buttonGroup.add(rdbtnTermini);
		rdbtnTermini.setBounds(44, 116, 300, 23);
		this.add(rdbtnTermini);

		rdbtnDownloadTermini = new JRadioButton("Download articoli ed estrazione termini");
		buttonGroup.add(rdbtnDownloadTermini);
		rdbtnDownloadTermini.setBounds(44, 142, 400, 23);
		this.add(rdbtnDownloadTermini);

		btnInvio = new JButton("INVIO");
		btnInvio.setBounds(34, 200, 89, 23);
		this.add(btnInvio);

	}

	/**
	 * Meotodo che torna il JRadioButton per i download
	 * @return rdbtnDownload
	 */
	public JRadioButton getRdbtnDownload() {
		return rdbtnDownload;
	}

	/**
	 * Meotodo che torna il JRadioButton per l'estrazione termini
	 * @return rdbtnTermini
	 */
	public JRadioButton getRdbtnTermini() {
		return rdbtnTermini;
	}

	/**
	 * Meotodo che torna il JRadioButton per i download e l'estrazione termini
	 * @return rdbtnDownloadTermini
	 */
	public JRadioButton getRdbtnDownloadTermini() {
		return rdbtnDownloadTermini;
	}

	/**
	 * Meotodo che torna il bottono per eseguire l'azione scelta
	 * @return btnInvio
	 */
	public JButton getBtnInvio() {
		return btnInvio;
	}

}
