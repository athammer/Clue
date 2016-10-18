package code.logic;

import code.board.Board;
import code.player.Player;
import code.Main;

public class PlayerLogic {
	//global player logic anything in here should be applicable for all players and not specific to one
	
	/**
	 * Starts the game and creates the player and board instances for the game.
	 * <p>
	 * The main function of the game it controls most of the core logic in the game.
	 * @param  name name of the player in the Player class.
	 * @return      the first player found with that name or if none found, false.
	 */
	public Player findPlayer(String name){
		for(Player player : Main._playerArray){
			if(player.getPlayerName() == name){
				//yay
				return player;
			}
		}
		
		return null;	
	}
	
	//TODO Fill out Java doc
	public boolean movePlayer(Board board, Player player, int x, int y){
		if(board.isValidLocation(x, y) && board.moveCorrectly(x, y, player) && player.hasMovesLeft()){ 
			//checks if user moved diag and if user is in a non null spot.
			board.setBoard(player.getPlayerName(), x, y); //puts player's name in that spot
			board.setBoard("empty", player.getPlayerXCord(), player.getPlayerYCord());
			player.setXYCord(x, y);
			player.setMovesLeft(player.movesLeft() - 1);
		}else{
			return false;
		}
		
		return true;	
	}

	

}
