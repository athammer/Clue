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
			if(player.getCharacterName() == name){
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
			board.setBoard(player.getCharacterName(), x, y); //puts player's name in that spot
			board.setBoard("empty", player.getPlayerXCord(), player.getPlayerYCord());
			player.setXYCord(x, y);
			player.setMovesLeft(player.movesLeft() - 1);
		}else{
			return false;
		}
		
		return true;	
	}
	
	
	/**
	 * Follows Clue's ordering of players and gets you who is next for a turn or guess check.
	 * @param  currentPlayerTurn A string that is the is the name of the character whos turn it is now.
	 * @return Returns the character's name that is to go next.
	 */
	public String whosNext(String currentPlayerTurn){ //all players
		for(int i = 0; i < Main._playerArray.size(); i++){
			
			if(Main._playerArray.get(i).getCharacterName().equals(currentPlayerTurn)){
				if(!(i+1 < Main._playerArray.size())){//if this is the last time if will run
					//next player will be 0 as 0->1->2...->0 its circular
					return Main._playerArray.get(0).getCharacterName();
				}
				return Main._playerArray.get(i+1).getCharacterName(); //shouldnt through an error due to if loop above
			}
		}
		
		return null;	
	}
	
	/**
	 * Follows Clue's ordering but skips people who lost or not in the game.
	 * @param  currentPlayerTurn A string that is the is the name of the character whos turn it is now.
	 * @return Returns the character's name that is to go next (that is still in the game.)
	 */
	public String whosNextTurn(String currentPlayerTurn){ //only players playing(no losers)
		for(int i = 0; i < Main._activePlayers.size(); i++){
			
			if(Main._activePlayers.get(i).getCharacterName().equals(currentPlayerTurn)){
				if(!(i+1 < Main._activePlayers.size())){//if this is the last time if will run
					//next player will be 0 as 0->1->2...->0 its circular
					return Main._activePlayers.get(0).getCharacterName();
				}
				return Main._activePlayers.get(i+1).getCharacterName(); //shouldnt through an error due to if loop above
			}
		}
		return null;
	}
	
	/**
	 * Finds the player's starting position based on the name.
	 * @param  name 	String of the name of the character
	 * @return Returns 	an int array with index 0 being x, and index 1 being y
	 */
	public int[] findStartingPosition(String name){
		return null;
	}

	

}
