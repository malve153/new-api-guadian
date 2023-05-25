package View;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class InitialPanel extends JPanel {

	JLabel lblBenvenuto;
	JButton btnStart;
	
	/**
	 * Create the panel.
	 */
	public InitialPanel() {
		
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		this.setBounds(100, 100, 600, 320);
		
		lblBenvenuto = new JLabel("BENVENUTO!");
		lblBenvenuto.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBenvenuto.setBounds(242, 62, 153, 26);
		this.add(lblBenvenuto);
		
		btnStart = new JButton("INIZIA");
		btnStart.setBounds(232, 160, 116, 44);
		this.add(btnStart);

	}

	public JButton getBtnStart() {
		return btnStart;
	}
	
	

}
