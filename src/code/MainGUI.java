package code;
import java.awt.Color;
//import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder; 
import javax.swing.border.EmptyBorder;

import code.Main;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import code.board.Board;
import code.gui.GUI;
import code.player.Player;

public class MainGUI {
	JFrame boardFrame = new JFrame();
//	 boardframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	ArrayList<Player> clueCharacters;
	private JButton[][] clueBoardSquares = new JButton[24][25];
	JPanel boardDisplay = new JPanel();
	JPanel cards = new JPanel(); 
	JPanel cardKnown = new JPanel();
	JPanel Dice = new JPanel(); 
	ArrayList<Player> _characters = new ArrayList<Player>();
	ArrayList<String> _knowncards = new ArrayList<String>();
	ArrayList<String> _allcards = new ArrayList<String>();
	
	MainGUI(){
		initializeClueGui();
	}
	public void getcharaters(){
		
	}
	public void getknowncards(Player x){
		_knowncards = x.getKnownCards();
	}
	public void getallcards(Player x){
		_allcards = x.getAllCards();
	}
	
	public void initializeClueGui() {
		boardDisplay.setBorder(new EmptyBorder(5, 5, 5, 5));
		
	}
	
	public void basicJFrameFeatures(JFrame boardFrame) {
		boardFrame = new JFrame();
		boardFrame.setVisible(true);
		boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boardFrame.setLayout(new BoxLayout(boardFrame.getContentPane(), (BoxLayout.Y_AXIS)));
		boardFrame.add(boardDisplay);
		boardFrame.add(cardKnown);
		boardFrame.add(Dice);  
		boardDisplay.setVisible(true);
		cardKnown.setVisible(true);
		Dice.setVisible(true);
		boardDisplay.setLayout(new BoxLayout(boardDisplay, (BoxLayout.X_AXIS)));
		cardKnown.setLayout(new BoxLayout(cardKnown, (BoxLayout.X_AXIS)));
		Dice.setLayout(new BoxLayout(Dice, (BoxLayout.X_AXIS)));
		boardFrame.setSize(500, 500);
		
		}
	public void addingButtons(JPanel _display){
		JButton b = new JButton("Roll 1 Dice");
		ActionListener e = new DiceActionListener();
		b.addActionListener(e);
		JButton b2 = new JButton("Roll 2 Dice");
		ActionListener e2 = (ActionListener) new DiceActionListener2();
		b2.addActionListener(e2);
//		JButton b2 = new JButton ("Clear");
//		ActionListener e1 = new EventHandler();
//		b2.addActionListener(e1);
//		JButton b3 = new JButton ("Submit");
//		ActionListener e2 = new EventHandler();
//		b3.addActionListener(e2);
		Dice.add(b);
//		_controls.add(b2);
//		_controls.add(b3);
	}
	
	public void setButtonProperties(JButton button){
		button.setFont(new Font("Courier",Font.BOLD, 44));
		button.setBackground(Color.WHITE);
		button.setForeground(Color.BLACK);
		button.setOpaque(true);
		button.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.DARK_GRAY,Color.LIGHT_GRAY));		
	}
	
	//only for testing gui
	public static void main(String[] args) throws Exception{
		Board board = new Board();
		GUI gui = new GUI(board.getBoard());
		gui.popUpExampleString();
		gui.popUpExampleBoolean();
		
	}

}
