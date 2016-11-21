package code.gui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class showCardsPopUp {

	public showCardsPopUp(ArrayList<String> cards) {
		JFrame showCards = new JFrame("Player cards");
		showCards.setSize(600, 500);
		showCards.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		GroupLayout groupLayout = new GroupLayout(showCards.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
		);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		showCards.getContentPane().setLayout(groupLayout);
		showCards.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{showCards.getContentPane(), panel}));
		for(String card : cards){
			JButton btn = new JButton();
			btn.setText(card);
			panel.add(btn);
		}
	}
}
