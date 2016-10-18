package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.player.Player;

/*

* Suggestion would be answered by the next player because they have the Player card;

* Suggestion would be answered by the next player because they have the Room card;

* Suggestion would be answered by the next player because they have the Weapon card;

* Suggestion would be answered by the next player because they have 2 matching cards;

* Suggestion would be answered by the player after the next player because they have 1 or more matching cards;

* Suggestion would be answered by the player immediately before player making suggestion because they have 1 or more matching cards;

* Suggestion cannot be answered by any player but the player making the suggestion has 1 or more matching cards;

* Suggestion cannot be answered by any player and the player making the suggestion does not have any matching cards.

*/


public class SuggestionProofTest {
	
	@Test
	public void suggestionGuess(){
		Player suggestPlayer = new Player();
		Player answerPlayer = new Player(); 
//		String[] sgPlayer = suggestPlayer.getPlayerCards();
		String[] ansPlayer = answerPlayer.getPlayerCards(); 
		boolean suggestion = suggestPlayer.checkCards(ansPlayer);
		assertTrue(suggestion);
	}
	
//	@Test
//	public void 

}
