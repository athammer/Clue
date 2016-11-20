package code.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import code.DiceActionListener;
import code.DiceActionListener2;
import code.player.Player;
import code.gui.actionListener.onClickActionListener;
import javax.swing.border.LineBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GUI implements ActionListener {

	public GUI(String[][] board) {
		JFrame gameFrame = new JFrame("Clue - Aaron H, Zee, Adam S, Garret");
		gameFrame.setForeground(Color.GREEN);
		gameFrame.setSize(1422, 907);
		gameFrame.getContentPane().setLayout(null);
		gameFrame.setVisible(true);
		gameFrame.getContentPane().setBackground(Color.DARK_GRAY);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 81, 776, 776);
		gameFrame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(801, 81, 592, 455);
		gameFrame.getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton btnGet = new JButton("Get Player Cards");
		btnGet.setFont(new Font("Tahoma", Font.PLAIN, 23));
		panel_1.add(btnGet, BorderLayout.CENTER);
		
		JButton btnGet_1 = new JButton("Get \r\nKnown \r\nCards");
		btnGet_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		panel_1.add(btnGet_1, BorderLayout.WEST);
		
		JButton btnNewButton = new JButton("Get All Cards");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		panel_1.add(btnNewButton, BorderLayout.EAST);
		
		JButton btnGuessCards = new JButton("Guess Cards");
		btnGuessCards.setFont(new Font("Tahoma", Font.PLAIN, 45));
		panel_1.add(btnGuessCards, BorderLayout.NORTH);
		
		JButton btnFinalGuess = new JButton("Final Guess");
		btnFinalGuess.setFont(new Font("Tahoma", Font.PLAIN, 45));
		panel_1.add(btnFinalGuess, BorderLayout.SOUTH);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(12, 9, 1381, 63);
		gameFrame.getContentPane().add(panel_2);

		JLabel lblNewLabel = new JLabel(
				"New label test tNew label test tNew label test tNew label test tNew label test tNew label test t");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Comic Sans MS" /* enjoy */, Font.PLAIN, 22));
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(1157, 547, 239, 148);
		gameFrame.getContentPane().add(panel_3);
		
		JLabel lblMovesLeft = new JLabel("Moves Left");
		lblMovesLeft.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovesLeft.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblNewLabel_2 = new JLabel("6");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Sitka Banner", Font.PLAIN, 99));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblMovesLeft, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(5)
					.addComponent(lblMovesLeft)
					.addGap(18)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 87, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(796, 706, 597, 151);
		gameFrame.getContentPane().add(panel_4);
		
		JLabel lblPlayersTurn = new JLabel("Players Turn");
		lblPlayersTurn.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayersTurn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblNewLabel_1 = new JLabel("player here");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(10)
					.addComponent(lblPlayersTurn, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPlayersTurn)
					.addGap(11)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(43))
		);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(796, 547, 351, 148);
		gameFrame.getContentPane().add(panel_5);
		
		JButton btnEndTurn = new JButton("End Turn");
		btnEndTurn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton btnResign = new JButton("Resign");
		btnResign.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEndTurn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
						.addComponent(btnResign, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_5.createSequentialGroup()
					.addGap(5)
					.addComponent(btnEndTurn, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnResign, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_5.setLayout(gl_panel_5);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
