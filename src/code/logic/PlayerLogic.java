package code.logic;

import code.player.Player;
import code.Main;

public class PlayerLogic {
	
	
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
}
