package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;

import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.awt.Font;

public class Frame extends JFrame {

	private InitialPanel initialPane;
	private Panel contentPane;
	private WordsPanel wordsPane;
	private LoadPanel loadPane;

	/**
	 * Create the frame.
	 */
	public Frame() {
		/*try {
			UIManager.setLookAndFeel( new FlatLightLaf() );
		} catch( Exception ex ) {
			System.err.println( "Failed to initialize LaF" );
		}*/
		this.setTitle("The Guardian Articles");

		this.setBounds(100, 100, 600, 320);
		this.setResizable(false);

		initialPane = new InitialPanel();
		this.setContentPane(initialPane);

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
	}

	public InitialPanel getInitialPane() {
		return initialPane;
	}

	public Panel getPanel() {
		return contentPane;
	}

	public WordsPanel getWordsPanel() {
		return wordsPane;
	}

	public LoadPanel getLoadPanel() { return loadPane; }

	public void changeInitialPanel() {
		this.remove(initialPane);
		this.invalidate();
		contentPane = new Panel();
		this.setContentPane(contentPane);
		this.setResizable(true);
		this.revalidate();

	}

	public void changePanel() {
		this.remove(contentPane);
		this.invalidate();
		wordsPane = new WordsPanel();
		this.setContentPane(wordsPane);
		this.setResizable(true);
		this.revalidate();

	}

	public void changeWordsPanel() {
		this.remove(wordsPane);
		this.invalidate();
		this.setContentPane(contentPane);
		this.setResizable(true);
		this.revalidate();
	}

	public void changePanelToLoadPanel() {
		this.remove(contentPane);
		this.invalidate();
		this.setContentPane(loadPane);
		this.setResizable(true);
		this.revalidate();
	}

	public void changeLoadPanelToWordsPanel() {
		this.remove(loadPane);
		this.invalidate();
		this.setContentPane(wordsPane);
		this.setResizable(true);
		this.revalidate();
	}

	public void changeLoadPanelToPanel() {
		this.remove(loadPane);
		this.invalidate();
		this.setContentPane(contentPane);
		this.setResizable(true);
		this.revalidate();
	}

}
