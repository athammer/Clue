package code.logic;

import java.util.ArrayList;

import code.board.Board;
import code.gui.GUI;
import code.player.Player;


//how a players turn should go
public class TurnLogic {


	public void completeTurn(Player player, Board board, GUI gui){
		System.out.println("asdfsd");
		DiceRoll dice = new DiceRoll();
		PlayerLogic playerLogic = new PlayerLogic();
		int diceRoll = dice.rollOneDice();
		player.setMovesLeft(diceRoll);
		gui.getNumberMovesLeft().setText("" + diceRoll);
		gui.getNumberMovesLeft().repaint();
		gui.getPlayerName().setText("" + player.getCharacterName());
		gui.getPlayerName().repaint();
		String roomName = board.getSpecialRoom(player.getPlayerXCord(), player.getPlayerYCord()); 
		
		//get user input of where they want to go
		
		int playerMoves = player.getMovesLeft();
		while(playerMoves != 0){
			//wait for them to click and update
			playerMoves = player.getMovesLeft();
			gui.getNumberMovesLeft().setText(playerMoves +"");
			gui.getNumberMovesLeft().repaint();
		}
		//player is out of moves left
		//put in a pop up asking if player wants to final guess or normal guess
		//let player guess here
		if(board.isSpecialRoom(player.getMovesLeft(), player.getPlayerYCord())){
			GuessLogic guessLogic = new GuessLogic();
			ArrayList<String> cards = null; //get information from gui
			//should be a pop up
			//figure out which one player wants to do on gui
			guessLogic.makeAGuess(cards, player, roomName);
			guessLogic.makeAFinalGuess(cards, player, roomName, board);
		}
		
	}
	

}
