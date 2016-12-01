package code.gui;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import code.Main;
import code.logic.PlayerLogic;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class LetGuessOnTurnEnd implements ActionListener{
	JFrame frame = new JFrame();
	private JTextField txtDontHitThe;
	public LetGuessOnTurnEnd(){
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setSize(600, 500);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("Choose Guess Option or Close");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setForeground(Color.WHITE);
		
		JButton btnNewButton_1 = new JButton("Guess");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setActionCommand("guess");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 34));
		
		JButton btnFinalGuess = new JButton("Final Guess");
		btnFinalGuess.setActionCommand("final");
		btnFinalGuess.addActionListener(this);
		btnFinalGuess.setFont(new Font("Tahoma", Font.PLAIN, 34));
		
		JButton btnNewButton = new JButton("No Guess");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setActionCommand("none");
		btnNewButton.addActionListener(this);
		btnNewButton.setOpaque(true);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 54));
		
		txtDontHitThe = new JTextField();
		txtDontHitThe.setFont(new Font("Impact", Font.PLAIN, 16));
		txtDontHitThe.setText("dont hit the x in the corner unless you want to restart this, its a feature");
		txtDontHitThe.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnFinalGuess, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(63)
							.addComponent(txtDontHitThe, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(71)
					.addComponent(txtDontHitThe, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(72)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnFinalGuess, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
					.addGap(34))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(actionCommand == "none"){
			frame.dispose();
			Main.reBounce = 1; //as intended :)
			return;
		}
		guessPopUp popUp = new guessPopUp(actionCommand);
		frame.dispose();
	}
}
