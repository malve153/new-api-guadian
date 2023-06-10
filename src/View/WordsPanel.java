package View;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Model.Word;

public class WordsPanel extends JPanel {

	/**
	 * Etichetta
	 */
	private JLabel lbl;

	/**
	 * JScrollPane per la tabella con le parole
	 */
	private JScrollPane scrollPane;

	/**
	 * Tabella con le parole e le rispettive occorrenze
	 */
	private JTable table;

	/**
	 * Bottone per tornare al pannello con le scelte
	 */
	private JButton btnIndietro;

	/**
	 * Costruttore del pannello per la stampa della tabella con le parole e le rispettive occorrenze trovate
	 */
	public WordsPanel() {

		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		this.setBounds(100, 100, 600, 320);

		lbl = new JLabel("Parole trovate");
		lbl.setBounds(260, 15, 100, 30);
		this.add(lbl);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 49, 537, 188);
		this.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowHeight(30);
		table.setEnabled(false);

		btnIndietro = new JButton("Indietro");
		btnIndietro.setBounds(250, 248, 89, 23);
		this.add(btnIndietro);

	}

	/**
	 * Metodo che torna il bottone per tornare al pannello per la scelta dell'azione
	 * @return btnIndietro
	 */
	public JButton getBtnIndietro() { return btnIndietro; }

	/**
	 * Metodo che torna la tabella delle parole e delle occorrenze
	 * @return table tabella delle parole e delle occorrenze
	 */
	public JTable getTable() { return table; }

	/**
	 * Metodo che cambia la tabella centrando i campi nelle varie celle
	 */
	public void setTable() {

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for(int i=0; i<2; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		//table.getColumn("N°").setPreferredWidth(10);
	}

	/**
	 * Metodo che crea la tabella con i campi
	 * @param word di tipo ArrayList<Word>
	 * @return modello
	 */
	public DefaultTableModel setTable(ArrayList<Word> word) {

		DefaultTableModel modello = new DefaultTableModel();
		//modello.addColumn("N°");
		modello.addColumn("Parola");
		modello.addColumn("Occorrenze");

		for(int i=0; i<word.size(); i++) {
			modello.addRow(new String[] {/*String.valueOf(i+1),*/ String.valueOf(word.get(i).getWord()), String.valueOf(word.get(i).getValue())});
		}

		return modello;
	}
}
