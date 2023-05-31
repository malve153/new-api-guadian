package View;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class Panel extends JPanel {

	JLabel lblNewLabel;
	private final ButtonGroup buttonGroup;
	JRadioButton rdbtnDownload, rdbtnTermini, rdbtnDownloadTermini;
	JButton btnInvio, btnStart;

	/**
	 * Create the panel.
	 */
	public Panel() {
		//setContentPane(contentPane);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		this.setBounds(100, 100, 600, 320);

		//contentPane.setLayout(new BorderLayout(0, 0));

		buttonGroup = new ButtonGroup();

		lblNewLabel = new JLabel("Scegliere una delle possibili azioni e premere 'INVIO': ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(34, 58, 400, 14);
		this.add(lblNewLabel);

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

	public JRadioButton getRdbtnDownload() {
		return rdbtnDownload;
	}

	public JRadioButton getRdbtnTermini() {
		return rdbtnTermini;
	}

	public JRadioButton getRdbtnDownloadTermini() {
		return rdbtnDownloadTermini;
	}

	public JButton getBtnInvio() {
		return btnInvio;
	}

}
