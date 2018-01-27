package main;

import javax.swing.SwingUtilities;

import gui.MainWindow;
import invertedindex.InvertedIndex;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MainWindow ex = new MainWindow(new InvertedIndex());
				ex.setVisible(true);
			}
		});

	}
}
