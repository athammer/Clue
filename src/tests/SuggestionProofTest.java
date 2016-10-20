package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import code.board.Board;
import code.player.Player;

/*
 * 
 * 

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
	public void playerPlayerGuess(){
		Player suggestionPlayer = new Player();
		Player answerPlayer  = new Player();
		suggestionPlayer.addPlayerCards(card) //room

	}
	
	@Test
	public void playerRoomGuess(){
		Player suggestionPlayer = new Player();
		Player answerPlayer  = new Player();
		suggestionPlayer.addPlayerCards(card) //room

	}
	
	@Test
	public void playerWeaponGuess(){
		Player suggestionPlayer = new Player();
		Player answerPlayer  = new Player();
		suggestionPlayer.addPlayerCards(card) //room

	}
	
	@Test
	public void playerGuessTwoCards(){
		Player suggestionPlayer = new Player();
		Player answerPlayer  = new Player();
		suggestionPlayer.addPlayerCards(card) //room

	}
	
	@Test
	public void playerGuessTwoCards(){
		Player suggestionPlayer = new Player();
		Player answerPlayer  = new Player();
		suggestionPlayer.addPlayerCards(card) //room

	}
	
	
	
	@Test
	public void suggestionPlayerGuess(){
		Player suggestPlayer = new Player();
		Player answerPlayer = new Player(); 
		ArrayList<String> sgPlayer = suggestPlayer.getPlayerCards();
		ArrayList<String> ansPlayer = answerPlayer.getPlayerCards(); 
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
		Player suggestPlayer = new Player();
		Player answerPlayer = new Player(); 
		ArrayList<String> sgPlayer = suggestPlayer.getPlayerCards();
		ArrayList<String> ansPlayer = answerPlayer.getPlayerCards(); 
		boolean suggestion = suggestPlayer.checkCards(ansPlayer);
		int counter = 0; 
		while(suggestPlayer.checkCards(ansPlayer)){
			if(suggestion == true){
				counter++;
			}
		}
		assertEquals(2,counter);
	}
	
	@Test
	public void matchingCardAnswer(){
		Player suggestPlayer = new Player();
		Player seconPlayer = new Player(); 
		Player thirdPlayer = new Player(); 
		ArrayList<String> sgPlayer = suggestPlayer.getPlayerCards();
		ArrayList<String> secPlayer = seconPlayer.getPlayerCards();
		ArrayList<String> thiPlayer = thirdPlayer.getPlayerCards();
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
		
		suggestPlayer.makeAccusation(string a, string b, string c){
			
		}
				
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
		
//		
		
	}
}

