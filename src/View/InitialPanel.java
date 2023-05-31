package View;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextField;

public class InitialPanel extends JPanel {

	JLabel lblBenvenuto, lblInserisci;
	JButton btnStart;
	private JTextField textField;

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

		lblInserisci = new JLabel("Inserire la chiave");
		lblInserisci.setBounds(248, 127, 120, 14);
		this.add(lblInserisci);

		textField = new JTextField();
		textField.setBounds(150, 152, 279, 20);
		textField.setText("f26c6407-afa1-47c4-8eb3-a671a18f628c");

		this.add(textField);
		textField.setColumns(36);

		btnStart = new JButton("INIZIA");
		btnStart.setBounds(232, 220, 116, 44);
		this.add(btnStart);

	}

	public JButton getBtnStart() {
		return btnStart;
	}

	public JTextField getTextField() {
		return textField;
	}
}
