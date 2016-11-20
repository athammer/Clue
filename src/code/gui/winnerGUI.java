package code.gui;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class winnerGUI {

	public winnerGUI() {
		JFrame winner = new JFrame("Winner winner!");
		winner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		winner.getContentPane().setBackground(Color.ORANGE);
		
		JLabel lblCongratulationsplayer = new JLabel("congratulations [player]!!!!");
		lblCongratulationsplayer.setForeground(Color.MAGENTA);
		lblCongratulationsplayer.setFont(new Font("Tahoma", Font.PLAIN, 47));
		GroupLayout groupLayout = new GroupLayout(winner.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCongratulationsplayer)
					.addContainerGap(182, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(98)
					.addComponent(lblCongratulationsplayer)
					.addContainerGap(285, Short.MAX_VALUE))
		);
		winner.getContentPane().setLayout(groupLayout);
	}

}
