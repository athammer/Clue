package code.gui;

import java.awt.*;

import javax.*;
import javax.swing.*;

public class GUI {
	public GUI(String[][] board) {
//		JFrame f = new JFrame("Clue - Aaron H, Zee, Adam S, Garret");
//		f.setSize(500, 500);
//		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		f.setLayout(null);
//		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		JPanel panel = new JPanel();
//		f.add(panel);
//		panel.setSize(400, 400);
//		panel.setVisible(true);
//		
//		JButton button = new JButton("asdf");
//		button.setSize(20, 20);
//		for (int i = 0; i < 600; i++) {
//			panel.add(button);
//			button.setVisible(true);
//		}
		
		
		

	}

	public void popUpExampleString() {
		final JFrame parent = new JFrame();
		String name = JOptionPane.showInputDialog(parent, "test", null);
		parent.pack();
		parent.setVisible(true);
		parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // if they close
																// it without
																// doing an
																// option
																// request it.
	}

	public void popUpExampleBoolean() {
		JFrame parent = new JFrame();
		JButton trueB = new JButton("true");
		JButton falseB = new JButton("false");
		parent.setSize(600, 600);
		falseB.setSize(150, 100);
		trueB.setSize(150, 100);
		parent.add(falseB);
		parent.add(trueB);
		//parent.pack();

		trueB.setVisible(true);
		falseB.setVisible(true);
		parent.setVisible(true);
		parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
