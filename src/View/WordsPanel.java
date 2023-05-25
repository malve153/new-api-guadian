package View;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class WordsPanel extends JPanel {

	JScrollPane scrollPane;
	JTextArea textArea;
	JButton btnIndietro;
	
	/**
	 * Create the panel.
	 */
	public WordsPanel() {

		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		this.setBounds(100, 100, 600, 320);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 49, 537, 188);
		this.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.setBounds(250, 248, 89, 23);
		this.add(btnIndietro);
		
	}

	public JButton getBtnIndietro() {
		return btnIndietro;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(String words) {
		this.textArea.setText(words);
	}
}
