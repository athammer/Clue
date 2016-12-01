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
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;

public class showCardsPopUp {

	public showCardsPopUp(ArrayList<String> cards) {
		JFrame showCards = new JFrame("Player cards");
		showCards.setSize(701, 500);
		showCards.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		GroupLayout groupLayout = new GroupLayout(showCards.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
		);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		showCards.getContentPane().setLayout(groupLayout);
		showCards.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{showCards.getContentPane(), panel}));
		for(String card : cards){
			JButton btn = new JButton();
			btn.setText(card);
			panel.add(btn);
		}
	}
}
