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

	JLabel lbl;
	JScrollPane scrollPane;
	JTable table;
	//JTextArea textArea;
	JButton btnIndietro;

	/**
	 * Create the panel.
	 */
	public WordsPanel() {

		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		this.setBounds(100, 100, 600, 320);

		lbl = new JLabel();
		lbl.setBounds(250, 30, 100, 30);
		this.add(lbl);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 49, 537, 188);
		this.add(scrollPane);

		/*textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);*/

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowHeight(30);
		table.setEnabled(false);



		btnIndietro = new JButton("Indietro");
		btnIndietro.setBounds(250, 248, 89, 23);
		this.add(btnIndietro);

	}

	public JButton getBtnIndietro() {
		return btnIndietro;
	}



	/*public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(String words) {
		this.textArea.setText(words);
	}*/

	public JTable getTable() {
		return table;
	}

	public void setTable() {

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for(int i=0; i<2; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		//table.getColumn("N°").setPreferredWidth(10);
	}

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
