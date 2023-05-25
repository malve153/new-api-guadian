package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.awt.Font;

public class Frame extends JFrame {

	private InitialPanel initialPane;
	private Panel contentPane;
	private WordsPanel wordsPane;

	/**
	 * Create the frame.
	 */
	public Frame() {
		try {
			UIManager.setLookAndFeel( new FlatLightLaf() );
		} catch( Exception ex ) {
			System.err.println( "Failed to initialize LaF" );
		}

		setTitle("The Guadian Articles");

		this.setBounds(100, 100, 600, 320);

		initialPane = new InitialPanel();
		this.setContentPane(initialPane);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

}
