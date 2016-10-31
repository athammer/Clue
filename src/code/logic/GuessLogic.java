package code.logic;

import java.util.ArrayList;

import code.player.Player;

public class GuessLogic {
	
	
	/**
	 * Used for letting players guess in a room. Players must be in a room to guess.
	 * @param  guessCards An ArrayList of type String with the 3 cards(place, weapon, person) the player guesses.
	 * @return      A boolean value to whether the player has the cards.
	 */
	public boolean makeAGuess(ArrayList<String> guessCards, Player player){
		if(isValidGuess(guessCards)){
			
		}
		return false;
		
	}
	
	/**
	 * Used for letting players guess in a room.
	 * <p> 
	 * If the player answers wrong he/she loses, as set by player.setLoserPlayer()
	 * @param  guessCards An ArrayList of type String with the 3 cards(place, weapon, person) the player guesses.
	 * @return      A boolean value to whether the player has the cards.
	 */
	public boolean makeAFinalGuess(ArrayList<String> guessCards, Player player){
		if(isValidGuess(guessCards)){
			
		}
		//Check if player is in the room where the 
		return false;
		
	}
	
	/**
	 * Checks if cards player guesses are in correct format.
	 * @param  guessCards An ArrayList of type String with the 3 cards(place, weapon, person) the player guesses.
	 * @return      A boolean value to whether the player has guess correctly.
	 */
	private boolean isValidGuess(ArrayList<String> guessCards){
		//Check if player is in the room where the 
		return false;
		
	}

}
