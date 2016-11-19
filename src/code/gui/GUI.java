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

public class GUI implements ActionListener{
	JFrame gameFrame = new JFrame("Clue - Aaron H, Zee, Adam S, Garret");

	public GUI(String[][] board) {
		gameFrame.setSize(500, 500);
		gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		gameFrame.setLayout(null);
		gameFrame.setVisible(true);
		gameFrame.getContentPane().setBackground(Color.yellow); //enjoy
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setLayout(new GridLayout());
		createBoard(board);
		
	}
	
	public void createBoard(String[][] board) {
		JPanel mapDisplay = new JPanel();
		mapDisplay.setSize(gameFrame.getHeight(), gameFrame.getHeight()); 
		mapDisplay.setPreferredSize(new Dimension(gameFrame.getHeight(), gameFrame.getHeight()));
		mapDisplay.setLayout(null);
		mapDisplay.setBorder(BorderFactory.createEtchedBorder());
		mapDisplay.setBackground(Color.GREEN); //enjoy
		mapDisplay.setVisible(true);
		gameFrame.add(mapDisplay);
		createContentBoard(board);
	}
	public void createContentBoard(String[][] board) {
		JPanel contentBoard = new JPanel();
		contentBoard.setSize(50, gameFrame.getHeight()); 
		contentBoard.setLayout(null);
		contentBoard.setBorder(BorderFactory.createEtchedBorder());
		contentBoard.setBackground(Color.pink); //enjoy
		contentBoard.setVisible(true);
		gameFrame.add(contentBoard);
	}
	public void getCardsButton(){
		JButton getCards = new JButton("Click to get cards");
		ActionListener event = (ActionListener) new onClickActionListener();
		getCards.addActionListener(event);
		getCards.setVisible(true);
		gameFrame.add(getCards);
	}
	public void cardPopUp() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
//	
//	
//	JFrame boardFrame = new JFrame("Clue - Aaron H, Zee, Adam S, Garret");
////	 boardframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	ArrayList<Player> clueCharacters;
//	private JButton[][] clueBoardSquares = new JButton[24][25];
//	JPanel boardDisplay = new JPanel();
//	JPanel cards = new JPanel(); 
//	JPanel cardKnown = new JPanel();
//	JPanel Dice = new JPanel(); 
//	
//	
//	
//	public GUI(String[][] board) {
//		boardFrame = new JFrame();
//		boardFrame.setVisible(true);
//		boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		boardFrame.setLayout(new BoxLayout(boardFrame.getContentPane(), (BoxLayout.Y_AXIS)));
//		boardFrame.add(boardDisplay);
//		boardFrame.add(cardKnown);
//		boardFrame.add(Dice);  
//		boardDisplay.setVisible(true);
//		cardKnown.setVisible(true);
//		Dice.setVisible(true);
//		boardDisplay.setLayout(new BoxLayout(boardDisplay, (BoxLayout.X_AXIS)));
//		cardKnown.setLayout(new BoxLayout(cardKnown, (BoxLayout.X_AXIS)));
//		Dice.setLayout(new BoxLayout(Dice, (BoxLayout.X_AXIS)));
//		boardFrame.setSize(500, 500);
//
//	}
//
//	public void popUpExampleString() {
//		final JFrame parent = new JFrame();
//		String name = JOptionPane.showInputDialog(parent, "test", null);
//		parent.pack();
//		parent.setVisible(true);
//		parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // if they close
//																// it without
//																// doing an
//																// option
//																// request it.
//	}
//
//	public void popUpExampleBoolean() {
//		JFrame parent = new JFrame();
//		JButton trueB = new JButton("true");
//		JButton falseB = new JButton("false");
//		parent.setSize(600, 600);
//		falseB.setSize(150, 100);
//		trueB.setSize(150, 100);
//		parent.add(falseB);
//		parent.add(trueB);
//		//parent.pack();
//
//		trueB.setVisible(true);
//		falseB.setVisible(true);
//		parent.setVisible(true);
//		parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
//	
//
//	
	
	
	
	
	
	

	
//	MainGUI(){
//		initializeClueGui();
//	}
//	
//	public void initializeClueGui() {
//		boardDisplay.setBorder(new EmptyBorder(5, 5, 5, 5));
//		
//	}
//	
//	public void basicJFrameFeatures(JFrame boardFrame) {
//		boardFrame = new JFrame();
//		boardFrame.setVisible(true);
//		boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		boardFrame.setLayout(new BoxLayout(boardFrame.getContentPane(), (BoxLayout.Y_AXIS)));
//		boardFrame.add(boardDisplay);
//		boardFrame.add(cardKnown);
//		boardFrame.add(Dice);  
//		boardDisplay.setVisible(true);
//		cardKnown.setVisible(true);
//		Dice.setVisible(true);
//		boardDisplay.setLayout(new BoxLayout(boardDisplay, (BoxLayout.X_AXIS)));
//		cardKnown.setLayout(new BoxLayout(cardKnown, (BoxLayout.X_AXIS)));
//		Dice.setLayout(new BoxLayout(Dice, (BoxLayout.X_AXIS)));
//		boardFrame.setSize(500, 500);
//		
//		}
//	public void addingButtons(JPanel _display){
//		JButton b = new JButton("Roll 1 Dice");
//		ActionListener e = new DiceActionListener();
//		b.addActionListener(e);
//		JButton b2 = new JButton("Roll 2 Dice");
//		ActionListener e2 = (ActionListener) new DiceActionListener2();
//		b2.addActionListener(e2);
////		JButton b2 = new JButton ("Clear");
////		ActionListener e1 = new EventHandler();
////		b2.addActionListener(e1);
////		JButton b3 = new JButton ("Submit");
////		ActionListener e2 = new EventHandler();
////		b3.addActionListener(e2);
//		Dice.add(b);
////		_controls.add(b2);
////		_controls.add(b3);
//	}
//
//	public void setButtonProperties(JButton button){
//		button.setFont(new Font("Courier",Font.BOLD, 44));
//		button.setBackground(Color.WHITE);
//		button.setForeground(Color.BLACK);
//		button.setOpaque(true);
//		button.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.DARK_GRAY,Color.LIGHT_GRAY));		
//	}
	
	
	
	
	
	

}
