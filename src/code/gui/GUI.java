package code.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import code.Main;
import code.board.Board;
import code.player.Player;
import code.logic.PlayerLogic;

import javax.swing.border.LineBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


/*
 * 	at code.board.Board.moveCorrectly(Board.java:365)
	at code.logic.PlayerLogic.movePlayer(PlayerLogic.java:51)
	at code.gui.GUI.actionPerformed(GUI.java:383)
 */

public class GUI implements ActionListener {
	JFrame gameFrame = new JFrame("Clue - Aaron H, Zee, Adam S, Garret");
	JLabel numberMovesLeft = new JLabel("6");
	JLabel playerName = new JLabel("player here");
	JLabel consoleLabel = new JLabel("...loading");
	JButton[][] jButtonArray = new JButton[25][24];
	
	public GUI(final Board boardObj) {
		String[][] board = boardObj.getBoard();
		gameFrame.setForeground(Color.GREEN);
		gameFrame.setSize(1422, 907);
		gameFrame.getContentPane().setLayout(null);
		gameFrame.setVisible(true);
		gameFrame.getContentPane().setBackground(Color.DARK_GRAY);


		JPanel boardPanel = new JPanel();
		boardPanel.setBackground(Color.LIGHT_GRAY);
		boardPanel.setBounds(10, 81, 776, 776);
		gameFrame.getContentPane().add(boardPanel);
		boardPanel.setLayout(new GridLayout(25, 24, 0, 0));
		for(int x = 0; x < board.length; x++){
			for(int y = 0; y < board[x].length; y++){
			    JButton btn = new JButton();
			    btn.setSize(25,25);
			    btn.setActionCommand(x + "      " + y + "    ");
			    btn.addActionListener(this);
			    if(board[x][y] == null){
			    	btn.setBorderPainted(false);
			    	btn.setEnabled(false);
			    	btn.setBackground(Color.BLACK);
				    btn.setForeground(Color.BLACK);
			    }
			    if(board[x][y] == "empty"){
			    	btn.setBackground(Color.lightGray);
				    btn.setForeground(Color.lightGray);
				    //btn.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			    }
			    if(board[x][y] == "emptyRoom"){
			    	btn.setBackground(Color.DARK_GRAY);
				    btn.setForeground(Color.DARK_GRAY);
			    }
			    if(board[x][y] == "stair case"){
			    	btn.setBorderPainted(false);
			    	btn.setEnabled(false);
			    	btn.setBackground(Color.BLACK);
				    btn.setForeground(Color.BLACK);
			    }
			    Board boardLogic = new Board();
			    if(boardLogic.isSpecialRoom(x, y)){
			    	btn.setBackground(Color.pink);
				    btn.setForeground(Color.pink);
			    }
			    if(board[x][y] != null && board[x][y].startsWith("secret")){
			    	//when clicked should open a message askign if you want to move to the other corner room
			    	btn.setBackground(Color.gray);
				    btn.setForeground(Color.gray);
				    btn.setActionCommand("tunnel");
				    btn.addActionListener(new ActionListener() { 
				    	public void actionPerformed(ActionEvent e) { 
				    		PlayerLogic pL = new PlayerLogic();
				    		Main.gui.getConsoleLabel().setText(Main._currentPlayerTurn + "used a secret passage.");
				    		pL.useSecretPassage(pL.findPlayer(Main._currentPlayerTurn), boardObj);
				    	} 
				    });
				    
			    }
			    if(board[x][y] == "room"){
			    	//when clicked should open a message askign if you want to move to the other corner room
			    	btn.setBackground(Color.CYAN);
				    btn.setForeground(Color.CYAN);
				    btn.setBorderPainted(false);
			    	btn.setEnabled(false);
			    }
				if(board[x][y] == ("Ms. Scarlet")){
					btn.setBackground(new Color(255, 36, 0));
				    btn.setForeground(new Color(255, 36, 0));
				}
				if(board[x][y] == ("Prof. Plum")){
					btn.setBackground(new Color(221,160,221));
				    btn.setForeground(new Color(221,160,221));
				}
				if(board[x][y] == ("Mr. Green")){
					btn.setBackground(Color.green);
				    btn.setForeground(Color.green);
				}
				if(board[x][y] == ("Mrs. White")){
					btn.setBackground(Color.white);
				    btn.setForeground(Color.white);
				}
				if(board[x][y] == ("Mrs. Peacock")){
					btn.setBackground(new Color(9, 84, 190));
				    btn.setForeground(new Color(9, 84, 190));
				}
				if(board[x][y] == ("Colonel Mustard")){
					btn.setBackground(new Color(227, 190, 66));
				    btn.setForeground(new Color(227, 190, 66));
				}
			    jButtonArray[x][y] = btn;
			    boardPanel.add(btn);
			}
		}

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(796, 81, 597, 455);
		gameFrame.getContentPane().add(buttonPanel);
		buttonPanel.setLayout(new BorderLayout(0, 0));
		
		JButton playerCards = new JButton("Get Player Cards");
		playerCards.setActionCommand("playerCards");
		playerCards.addActionListener(this);
		playerCards.setFont(new Font("Tahoma", Font.PLAIN, 23));
		buttonPanel.add(playerCards, BorderLayout.CENTER);
		
		JButton knownCards = new JButton("Get \r\nKnown \r\nCards");
		knownCards.setActionCommand("knownCards");
		knownCards.addActionListener(this);
		knownCards.setFont(new Font("Tahoma", Font.PLAIN, 23));
		buttonPanel.add(knownCards, BorderLayout.WEST);
		
		JButton allCards = new JButton("Get All Cards");
		allCards.setActionCommand("allCards");
		allCards.addActionListener(this);
		allCards.setFont(new Font("Tahoma", Font.PLAIN, 23));
		buttonPanel.add(allCards, BorderLayout.EAST);
		
		JButton guessCards = new JButton("Guess Cards");
		guessCards.setActionCommand("guess");
		guessCards.addActionListener(this);
		guessCards.setFont(new Font("Tahoma", Font.PLAIN, 45));
		buttonPanel.add(guessCards, BorderLayout.NORTH);
		
		JButton finalGuess = new JButton("Final Guess");
		finalGuess.setActionCommand("finalGuess");
		finalGuess.addActionListener(this);
		finalGuess.setFont(new Font("Tahoma", Font.PLAIN, 45));
		buttonPanel.add(finalGuess, BorderLayout.SOUTH);

		JPanel console = new JPanel();
		console.setBackground(Color.BLACK);
		console.setBounds(12, 9, 1381, 61);
		gameFrame.getContentPane().add(console);
		consoleLabel.setHorizontalAlignment(SwingConstants.LEFT);

		
		consoleLabel.setForeground(Color.GREEN);
		consoleLabel.setFont(new Font("Comic Sans MS" /* enjoy */, Font.PLAIN, 22));
		
		JButton helpButton = new JButton("Press for Help");
		helpButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GroupLayout gl_console = new GroupLayout(console);
		gl_console.setHorizontalGroup(
			gl_console.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_console.createSequentialGroup()
					.addContainerGap()
					.addComponent(consoleLabel, GroupLayout.DEFAULT_SIZE, 1141, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(helpButton, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
		);
		gl_console.setVerticalGroup(
			gl_console.createParallelGroup(Alignment.LEADING)
				.addComponent(helpButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
				.addGroup(gl_console.createSequentialGroup()
					.addGap(5)
					.addComponent(consoleLabel)
					.addGap(24))
		);
		console.setLayout(gl_console);
		
		JPanel moves = new JPanel();
		moves.setBounds(1157, 547, 239, 148);
		gameFrame.getContentPane().add(moves);
		
		JLabel movesLeftLabel = new JLabel("Moves Left");
		movesLeftLabel.setHorizontalAlignment(SwingConstants.CENTER);
		movesLeftLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		
		numberMovesLeft.setHorizontalAlignment(SwingConstants.CENTER);
		numberMovesLeft.setForeground(Color.RED);
		numberMovesLeft.setFont(new Font("Sitka Banner", Font.PLAIN, 99));
		GroupLayout gl_moves = new GroupLayout(moves);
		gl_moves.setHorizontalGroup(
			gl_moves.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_moves.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_moves.createParallelGroup(Alignment.LEADING)
						.addComponent(movesLeftLabel, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
						.addComponent(numberMovesLeft, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_moves.setVerticalGroup(
			gl_moves.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_moves.createSequentialGroup()
					.addGap(5)
					.addComponent(movesLeftLabel)
					.addGap(18)
					.addComponent(numberMovesLeft, GroupLayout.PREFERRED_SIZE, 87, Short.MAX_VALUE)
					.addGap(29))
		);
		moves.setLayout(gl_moves);
		
		JPanel currentTurn = new JPanel();
		currentTurn.setBounds(796, 706, 597, 151);
		gameFrame.getContentPane().add(currentTurn);
		
		JLabel PlayerTurnLabel = new JLabel("Current Players Turn");
		PlayerTurnLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PlayerTurnLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		
		
		playerName.setHorizontalAlignment(SwingConstants.CENTER);
		playerName.setFont(new Font("Tahoma", Font.PLAIN, 40));
		GroupLayout gl_currentTurn = new GroupLayout(currentTurn);
		gl_currentTurn.setHorizontalGroup(
			gl_currentTurn.createParallelGroup(Alignment.LEADING)
				.addComponent(playerName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
				.addGroup(gl_currentTurn.createSequentialGroup()
					.addGap(10)
					.addComponent(PlayerTurnLabel, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_currentTurn.setVerticalGroup(
			gl_currentTurn.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_currentTurn.createSequentialGroup()
					.addContainerGap()
					.addComponent(PlayerTurnLabel)
					.addGap(11)
					.addComponent(playerName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(43))
		);
		currentTurn.setLayout(gl_currentTurn);
		
		JPanel endResign = new JPanel();
		
		endResign.setBounds(796, 547, 351, 148);
		gameFrame.getContentPane().add(endResign);
		
		JButton endTurnButton = new JButton("End Turn");
		endTurnButton.addActionListener(this);
		endTurnButton.setActionCommand("end");
		endTurnButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton resignButton = new JButton("Resign");
		resignButton.setActionCommand("resign");
		resignButton.addActionListener(this);
		resignButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout gl_endResign = new GroupLayout(endResign);
		gl_endResign.setHorizontalGroup(
			gl_endResign.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_endResign.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_endResign.createParallelGroup(Alignment.LEADING)
						.addComponent(endTurnButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
						.addComponent(resignButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_endResign.setVerticalGroup(
			gl_endResign.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_endResign.createSequentialGroup()
					.addGap(5)
					.addComponent(endTurnButton, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(resignButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		endResign.setLayout(gl_endResign);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
//	JFrame gameFrame = new JFrame("Clue - Aaron H, Zee, Adam S, Garret");
//	JLabel numberMovesLeft = new JLabel("6");
//	JLabel playerName = new JLabel("player here");
//	JLabel consoleLabel = new JLabel("test");
//	JButton[][] jButtonArray = new JButton[25][24];
	
	public JFrame getGameFrame() {
		return gameFrame;
	}
	public JLabel getNumberMovesLeft() {
		return numberMovesLeft;
	}
	public JLabel getPlayerName() {
		return playerName;
	}
	public JLabel getConsoleLabel() {
		return consoleLabel;
	}
	public JButton[][] getJButtonArray() {
		return jButtonArray;
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String actionCommand = arg0.getActionCommand();
		PlayerLogic pL = new PlayerLogic();
		if(actionCommand == "knownCards"){
			showCardsPopUp popUp = new showCardsPopUp(pL.findPlayer(Main._currentPlayerTurn).getKnownCards());
			return;
		}
		else if(actionCommand == "playerCards"){
			showCardsPopUp popUp = new showCardsPopUp(pL.findPlayer(Main._currentPlayerTurn).getPlayerCards());
			return;
		}
		else if(actionCommand == "allCards"){
			showCardsPopUp popUp = new showCardsPopUp(pL.findPlayer(Main._currentPlayerTurn).getAllCards());
			return;
		}
		else if(actionCommand == "guess"){
			Board board = new Board();
			Player player = pL.findPlayer(Main._currentPlayerTurn);
			if(board.isSpecialRoom(player.getPlayerXCord(), player.getPlayerYCord())){
				guessPopUp popUp = new guessPopUp("guess");
			}else{
				System.out.println("must be in a room to guess.");
			}
			return;
		}
		else if(actionCommand == "finalGuess"){
			Board board = new Board();
			Player player = pL.findPlayer(Main._currentPlayerTurn);
			if(board.isSpecialRoom(player.getPlayerXCord(), player.getPlayerYCord())){
				guessPopUp popUp = new guessPopUp("final");
			}else{
				System.out.println("must be in a room to guess.");
			}
			return;
		}
		else if(actionCommand == "end"){
			numberMovesLeft.setText("0");
			pL.findPlayer(Main._currentPlayerTurn).setMovesLeft(0);
			return;
			
		}
		else if(actionCommand == "resign"){
			Player player = pL.findPlayer(Main._currentPlayerTurn);
			String nextPlayer = pL.whosNext(Main._currentPlayerTurn);
			Main._currentPlayerTurn = nextPlayer;
			player.setMovesLeft(0);
			numberMovesLeft.setText("RIP");
			player.setLoserPlayer(true);
			Main._activePlayers.remove(player);
			return;
		}
		else if(actionCommand == "help"){
			HelpUGUI helpPLS = new HelpUGUI();
			return;
		}
		else if(actionCommand == "tunnel"){
			return;
		}else{
			String x = actionCommand.substring(0, 3);
			x = x.trim();
			String y = actionCommand.substring(3);
			y = y.trim();
			int xInt = Integer.parseInt(x);
			int yInt = Integer.parseInt(y);
			System.out.println(x +" " + y);
			pL.movePlayer(Main.board, pL.findPlayer(Main._currentPlayerTurn), xInt, yInt, (JButton) arg0.getSource());
		}

	}
	
	
	
}
