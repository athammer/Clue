package code.gui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.CardLayout;

public class showCardsPopUp {

	public showCardsPopUp(ArrayList<String> cards) {
		JFrame showCards = new JFrame("Player cards");
		showCards.getContentPane().setLayout(new CardLayout(0, 0));
		
		/*EXAMPLE CARD WILL BE CREATED WITH FOR LOOP LATER */
		JTextPane txtpnCard = new JTextPane();
		txtpnCard.setText("card");
		showCards.getContentPane().add(txtpnCard, "name_25823765907010");
	}

}
