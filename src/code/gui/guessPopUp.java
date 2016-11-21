package code.gui;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import code.Main;
import code.board.Board;
import code.logic.GuessLogic;
import code.logic.PlayerLogic;
import code.player.Player;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;

public class guessPopUp implements ActionListener {
	JFrame boolPopUp = new JFrame("Please answer!");
	JPanel panel_2 = new JPanel();

	JPanel panel = new JPanel();

	JPanel panel_1 = new JPanel();
	String guessType;
	private List<JCheckBox> checkBoxes = new ArrayList<JCheckBox>();

	public guessPopUp(String type) {
		boolPopUp.setVisible(true);
		boolPopUp.setSize(491, 450);
		guessType = type;
		boolPopUp.setAlwaysOnTop(true);

		boolPopUp.setTitle("Guess");

		JLabel lblIHaveNo = new JLabel("Select one from each catagory and hit the obnoxious \"Submit Guess\"");
		lblIHaveNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIHaveNo.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnNewButton = new JButton("Submit Guess");
		btnNewButton.addActionListener(this);
		btnNewButton.setBackground(Color.MAGENTA);
		btnNewButton.setForeground(Color.CYAN);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));

		JLabel lblNoteIfYou = new JLabel("Note if you are doing a final guess you cannot guess your own cards.");
		lblNoteIfYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoteIfYou.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(boolPopUp.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
						.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(
								Alignment.TRAILING)
								.addComponent(lblNoteIfYou, Alignment.LEADING,
										GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
								.addComponent(lblIHaveNo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 444,
										Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 144,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(panel,
														GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
										.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(panel_2,
												GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))
						.addGap(151)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup()
						.addComponent(lblIHaveNo, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(lblNoteIfYou).addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
								.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 214,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 203,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18).addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		JLabel lblWeapons = new JLabel("Weapons");
		lblWeapons.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblWeapons);

		JCheckBox weapon1 = new JCheckBox("Rope        ");
		checkBoxes.add(weapon1);
		panel.add(weapon1);

		JCheckBox weapon2 = new JCheckBox("Lead Pipe");
		checkBoxes.add(weapon2);
		panel.add(weapon2);

		JCheckBox weapon3 = new JCheckBox("Knife        ");
		checkBoxes.add(weapon3);
		panel.add(weapon3);

		JCheckBox weapon4 = new JCheckBox("Wrench     ");
		checkBoxes.add(weapon4);
		panel.add(weapon4);

		JCheckBox weapon5 = new JCheckBox("Candlestick");
		checkBoxes.add(weapon5);
		panel.add(weapon5);

		JCheckBox weapon6 = new JCheckBox("Pistol    ");
		checkBoxes.add(weapon6);
		panel.add(weapon6);

		JLabel lblRooms = new JLabel("Rooms");
		lblRooms.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblRooms);
		PlayerLogic pL = new PlayerLogic();
		Board board = new Board();
		Player player = pL.findPlayer(Main._currentPlayerTurn);
		if(board.isSpecialRoom(player.getPlayerXCord(), player.getPlayerYCord())){
			JCheckBox room1 = new JCheckBox(board.getSpecialRoom(player.getPlayerXCord(), player.getPlayerYCord()));
			checkBoxes.add(room1);
			panel_2.add(room1);
		}

		JLabel lblCharacters = new JLabel("Characters");
		lblCharacters.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblCharacters);

		JCheckBox char1 = new JCheckBox("Prof. Plum");
		checkBoxes.add(char1);
		panel_1.add(char1);

		JCheckBox char2 = new JCheckBox("Colonel Mustard");
		checkBoxes.add(char2);
		panel_1.add(char2);

		JCheckBox char3 = new JCheckBox("Mr. Green");
		checkBoxes.add(char3);
		panel_1.add(char3);

		JCheckBox char4 = new JCheckBox("Mrs. Peacock");
		checkBoxes.add(char4);
		panel_1.add(char4);

		JCheckBox char5 = new JCheckBox("Ms. Scarlet");
		checkBoxes.add(char5);
		panel_1.add(char5);

		JCheckBox char6 = new JCheckBox("Mrs. White");
		checkBoxes.add(char6);
		panel_1.add(char6);
		boolPopUp.getContentPane().setLayout(groupLayout);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<String> infos = new ArrayList<String>();
		for (JCheckBox checkBox : checkBoxes) {
			if (checkBox.isSelected()) {
				infos.add(checkBox.getText());
			}
		}
		for (String guess : infos) {
			
			Board board = new Board();
			PlayerLogic pL = new PlayerLogic();
			Player player = pL.findPlayer(Main._currentPlayerTurn);
			if (guess == board.getSpecialRoom(player.getPlayerXCord(), player.getPlayerYCord())) {
				System.out.println("in room");
				String room = board.getSpecialRoom(player.getPlayerXCord(), player.getPlayerYCord());
				GuessLogic gL = new GuessLogic();
				if (guessType == "guess") {
					System.out.println("going to logic");
					gL.makeAGuess(infos, player, room);
					boolPopUp.dispose();
				
				} else {
					gL.makeAFinalGuess(infos, player, room, Main.board);
					boolPopUp.dispose();
				}

			}
		}

		if (infos.size() != 3) {
			System.out.println("you didnt enter 3 values, dont blame me if it crashes.");
		}
	}
}
