package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.board.Board;
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
	public void suggestionPlayerGuess(){
		Player suggestPlayer = new Player();
		Player answerPlayer = new Player(); 
		String[] sgPlayer = suggestPlayer.getPlayerCards();
		String[] ansPlayer = answerPlayer.getPlayerCards(); 
		boolean suggestion = suggestPlayer.checkCards(ansPlayer);
		assertTrue(suggestion);
	}
	
	@Test
	public void suggestionPlayerRoom(){
		Player roomPlayer = new Player(); 
		Board roomTestBoard = new Board();
		
		
	}
	
	@Test 
	public void suggestionPlayerWeapon(){
		
	}
	
	@Test
	public void twoMatchingCards(){
		
	}
	
	@Test
	public void matchingCardAnswer(){
		
	}

	
	@Test //Garrett
	//* Suggestion would be answered by the player immediately before player making suggestion because they have 1 or more matching cards;
	public void answerBeforeMove(){
		//iterate through the group of players, first, forward down the array of players to the end,
		//then from the beginning of the array to the suggesting player's location
		
		Player suggestPlayer = new Player();
		Player secondPlayer = new Player();
		Player thirdPlayer = new Player();
		Player fourthPlayer = new Player();
		Player fifthPlayer = new Player();
		Player sixthPlayer = new Player();
		
		String[] suggPlayer  = suggestPlayer.getPlayerCards();
		String[] twoPlayer = secondPlayer.getPlayerCards(); 
		String[] threePlayer = thirdPlayer.getPlayerCards();
		String[] fourPlayer  = fourthPlayer.getPlayerCards(); 
		String[] fivePlayer  = fifthPlayer.getPlayerCards();
		String[] sixPlayer = sixthPlayer.getPlayerCards(); 
		
		boolean suggestion2 = suggestPlayer.checkCards(twoPlayer);
		boolean suggestion3 = suggestPlayer.checkCards(threePlayer);
		boolean suggestion4 = suggestPlayer.checkCards(fourPlayer);
		boolean suggestion5 = suggestPlayer.checkCards(fivePlayer);
		boolean suggestion6 = suggestPlayer.checkCards(sixPlayer);
				
		assertFalse(suggestion2);
		assertFalse(suggestion3);
		assertFalse(suggestion4);
		assertFalse(suggestion5);
		assertTrue(suggestion6);

	}
	
	@Test  //Garrett
	//* Suggestion cannot be answered by any player but the player making the suggestion has 1 or more matching cards;
	public void unansweredButMatching(){
		//No matches are found in other hands, but player has 1 or more cards;
		Player suggestPlayer = new Player();
		Player secondPlayer = new Player();
		Player thirdPlayer = new Player();
		Player fourthPlayer = new Player();
		Player fifthPlayer = new Player();
		Player sixthPlayer = new Player();
		
		String[] suggPlayer  = suggestPlayer.getPlayerCards();
		String[] twoPlayer = secondPlayer.getPlayerCards(); 
		String[] threePlayer = thirdPlayer.getPlayerCards();
		String[] fourPlayer  = fourthPlayer.getPlayerCards(); 
		String[] fivePlayer  = fifthPlayer.getPlayerCards();
		String[] sixPlayer = sixthPlayer.getPlayerCards(); 
		
		boolean suggestion2 = suggestPlayer.checkCards(twoPlayer);
		boolean suggestion3 = suggestPlayer.checkCards(threePlayer);
		boolean suggestion4 = suggestPlayer.checkCards(fourPlayer);
		boolean suggestion5 = suggestPlayer.checkCards(fivePlayer);
		boolean suggestion6 = suggestPlayer.checkCards(sixPlayer);
		boolean doIHaveIt = suggestPlayer.checkCards(suggPlayer);
		
		assertFalse(suggestion2);
		assertFalse(suggestion3);
		assertFalse(suggestion4);
		assertFalse(suggestion5);
		assertFalse(suggestion6);
		assertTrue(doIHaveIt);
				
	}
	
	@Test  //Garrett
	//* Suggestion cannot be answered by any player and the player making the suggestion does not have any matching cards.
	public void unansweredAndNoMatching(){
		//Suggestion cannot be matched by any other player
		//AND suggesting player has none of the suggested cards.
		Player suggestPlayer = new Player();
		Player secondPlayer = new Player();
		Player thirdPlayer = new Player();
		Player fourthPlayer = new Player();
		Player fifthPlayer = new Player();
		Player sixthPlayer = new Player();
		
		String[] suggPlayer  = suggestPlayer.getPlayerCards();
		String[] twoPlayer = secondPlayer.getPlayerCards(); 
		String[] threePlayer = thirdPlayer.getPlayerCards();
		String[] fourPlayer  = fourthPlayer.getPlayerCards(); 
		String[] fivePlayer  = fifthPlayer.getPlayerCards();
		String[] sixPlayer = sixthPlayer.getPlayerCards(); 
		
		boolean suggestion2 = suggestPlayer.checkCards(twoPlayer);
		boolean suggestion3 = suggestPlayer.checkCards(threePlayer);
		boolean suggestion4 = suggestPlayer.checkCards(fourPlayer);
		boolean suggestion5 = suggestPlayer.checkCards(fivePlayer);
		boolean suggestion6 = suggestPlayer.checkCards(sixPlayer);
		boolean doIHaveIt = suggestPlayer.checkCards(suggPlayer);
		
		assertFalse(suggestion2);
		assertFalse(suggestion3);
		assertFalse(suggestion4);
		assertFalse(suggestion5);
		assertFalse(suggestion6);
		assertFalse(doIHaveIt);
		
	}
}

