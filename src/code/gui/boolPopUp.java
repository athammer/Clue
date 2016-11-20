package code.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class boolPopUp implements ActionListener{
	public boolPopUp() {
		//ugly jframe
		JFrame boolPopUp = new JFrame("Please answer!");
		boolPopUp.getContentPane().setBackground(Color.MAGENTA);
		
		JLabel lblQuestionHere = new JLabel("Question Here");
		lblQuestionHere.setForeground(Color.YELLOW);
		lblQuestionHere.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestionHere.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("Yes");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setForeground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_1 = new JButton("No");
		btnNewButton_1.setForeground(Color.CYAN);
		btnNewButton_1.setBackground(Color.GREEN);
		GroupLayout groupLayout = new GroupLayout(boolPopUp.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(66)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addGap(42))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblQuestionHere, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(lblQuestionHere, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		boolPopUp.getContentPane().setLayout(groupLayout);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
