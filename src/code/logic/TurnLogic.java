package code.logic;

import java.util.ArrayList;

import code.board.Board;
import code.player.Player;


//how a players turn should go
public class TurnLogic {
	
	public void completeTurn(Player player, Board board){
		DiceRoll dice = new DiceRoll();
		PlayerLogic playerLogic = new PlayerLogic();
		int diceRoll = dice.rollOneDice();
		player.setMovesLeft(diceRoll);
		String roomName = board.getSpecialRoom(player.getPlayerXCord(), player.getPlayerYCord()); 
		if(roomName.equals("kitchen") || roomName.equals("study") || roomName.equals("conservatory") || roomName.equals("lounge")){
			//lets users have a special part of their turn where they can pick to go through a special tunnel here
		}
		
		//get user input of where they want to go
		
		int playerMoves = player.getMovesLeft();
		for(int i = 0; i < playerMoves; i++){
			playerLogic.movePlayer(board, player, 1, 1); //get user input from gui or something
		}
		//player is out of moves left
		//let player guess here
		if(board.isSpecialRoom(player.getMovesLeft(), player.getPlayerYCord())){
			GuessLogic guessLogic = new GuessLogic();
			ArrayList<String> cards = null; //get information from gui
			
			//figure out which one player wants to do on gui
			guessLogic.makeAGuess(cards, player, roomName);
			guessLogic.makeAFinalGuess(cards, player, roomName, board);
		}
		
	}
	

}
