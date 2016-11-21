package code.logic;

import java.util.ArrayList;

import code.board.Board;
import code.gui.GUI;
import code.player.Player;


//how a players turn should go
public class TurnLogic {


	public void completeTurn(Player player, Board board, GUI gui){
		
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
		
	}
	

}
