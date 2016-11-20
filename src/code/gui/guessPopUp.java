package code.gui;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;

public class guessPopUp {

	public guessPopUp() {
		JFrame boolPopUp = new JFrame("Please answer!");
		boolPopUp.setTitle("Guess");
		
		JPanel panel_2 = new JPanel();
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JLabel lblIHaveNo = new JLabel("Select one from each catagory and hit the obnoxious \"Submit Guess\"");
		lblIHaveNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIHaveNo.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton = new JButton("Submit Guess");
		btnNewButton.setBackground(Color.MAGENTA);
		btnNewButton.setForeground(Color.CYAN);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		GroupLayout groupLayout = new GroupLayout(boolPopUp.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblIHaveNo, GroupLayout.PREFERRED_SIZE, 444, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIHaveNo, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JLabel lblWeapons = new JLabel("Weapons");
		lblWeapons.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblWeapons);
		
		JCheckBox chckbxRope = new JCheckBox("Rope        ");
		panel.add(chckbxRope);
		
		JCheckBox chckbxLeadPipe = new JCheckBox("Lead Pipe");
		panel.add(chckbxLeadPipe);
		
		JCheckBox chckbxKnife = new JCheckBox("Knife        ");
		panel.add(chckbxKnife);
		
		JCheckBox chckbxWrench = new JCheckBox("Wrench     ");
		panel.add(chckbxWrench);
		
		JCheckBox chckbxCandlestick = new JCheckBox("Candlestick");
		panel.add(chckbxCandlestick);
		
		JCheckBox chckbxPistol = new JCheckBox("Pistol    ");
		panel.add(chckbxPistol);
		
		JLabel lblRooms = new JLabel("Rooms and Stuff");
		lblRooms.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblRooms);
		
		JCheckBox chckbxBallroom = new JCheckBox("Ballroom");
		panel_2.add(chckbxBallroom);
		
		JCheckBox chckbxConservatory = new JCheckBox("Conservatory");
		panel_2.add(chckbxConservatory);
		
		JCheckBox chckbxBilliardRoom = new JCheckBox("Billiard Room");
		panel_2.add(chckbxBilliardRoom);
		
		JCheckBox chckbxLibrary = new JCheckBox("Library                 ");
		panel_2.add(chckbxLibrary);
		
		JCheckBox chckbxStudy = new JCheckBox("Study                            ");
		panel_2.add(chckbxStudy);
		
		JCheckBox chckbxHall = new JCheckBox("Hall                           ");
		panel_2.add(chckbxHall);
		
		JCheckBox chckbxLounge = new JCheckBox("Lounge                 ");
		panel_2.add(chckbxLounge);
		
		JCheckBox chckbxDiningRoom = new JCheckBox("Dining Room              ");
		panel_2.add(chckbxDiningRoom);
		
		JCheckBox chckbxKitchen = new JCheckBox("Kitchen                    ");
		panel_2.add(chckbxKitchen);
		
		JLabel lblCharacters = new JLabel("Characters");
		lblCharacters.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblCharacters);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Prof. Plum");
		panel_1.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Colonel Mustard");
		panel_1.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Mr. Green");
		panel_1.add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Mrs. Peacock");
		panel_1.add(chckbxNewCheckBox_4);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("Ms. Scarlet");
		panel_1.add(chckbxNewCheckBox_5);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Mrs. White");
		panel_1.add(chckbxNewCheckBox);
		boolPopUp.getContentPane().setLayout(groupLayout);
	}
}
