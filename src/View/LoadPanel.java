package View;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class LoadPanel extends JPanel {

	JLabel lbl;
	
	/**
	 * Create the panel.
	 */
	public LoadPanel() {

		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		this.setBounds(100, 100, 600, 320);
		
		lbl = new JLabel("");
		lbl.setBounds(50, 153, 312, 14);
		this.add(lbl);
		
	}

	public void setLbl(String txt) {
		this.lbl.setText(txt);
	}

}
