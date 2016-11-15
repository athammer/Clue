package tests.phase1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import code.board.Board;
import code.logic.CardLogic;
import code.logic.PlayerLogic;
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
	
//=======
	public void playerPlayerGuess(){
		Player suggestionPlayer = new Player();
		Player answerPlayer  = new Player();
		suggestionPlayer.addPlayerCards("Prof. Plum"); 
		answerPlayer.addPlayerCards("Prof. Plum"); 
		boolean check = suggestionPlayer.checkCards(answerPlayer.getPlayerCards());
		assertTrue(check);
		
	}
	
	@Test
	public void playerRoomGuess(){
		Player suggestionPlayer = new Player();
		Player answerPlayer  = new Player();
		suggestionPlayer.addPlayerCards("Ballroom"); 
		answerPlayer.addPlayerCards("Ballroom"); 
		boolean check = suggestionPlayer.checkCards(answerPlayer.getPlayerCards());
		assertTrue(check);

	}
	
	@Test
	public void playerWeaponGuess(){
		Player suggestionPlayer = new Player();
		Player answerPlayer  = new Player();
		suggestionPlayer.addPlayerCards("Rope"); 
		answerPlayer.addPlayerCards("Rope"); 
		boolean check = suggestionPlayer.checkCards(answerPlayer.getPlayerCards());
		assertTrue(check);

	}
	
	@Test
	public void playerGuessTwoCards(){
		Player suggestionPlayer = new Player();
		Player answerPlayer  = new Player();
		suggestionPlayer.addPlayerCards("Prof. Plum");
		suggestionPlayer.addPlayerCards("Rope");
		answerPlayer.addPlayerCards("Should not be returned");
		answerPlayer.addPlayerCards("Prof. Plum");
		answerPlayer.addPlayerCards("Rope");
		answerPlayer.addPlayerCards("Misdirection");
		ArrayList<String> cards = suggestionPlayer.returnCommonCards(suggestionPlayer.getPlayerCards());
		assertTrue(cards.equals(suggestionPlayer.getPlayerCards()));
	}
	
	@Test
	public void playerSkipGuess(){ //works for skipping player and the last player as it loops through all players
		Player suggestionPlayer = new Player();
		Player middlePlayer  = new Player();
		Player answerPlayer  = new Player();
		suggestionPlayer.addPlayerCards("Prof. Plum");
		suggestionPlayer.addPlayerCards("Rope");
		suggestionPlayer.addPlayerCards("Rope cat");
		middlePlayer.addPlayerCards("Should not be returned");
		middlePlayer.addPlayerCards("Misdirection");
		answerPlayer.addPlayerCards("Prof. Plum");
		answerPlayer.addPlayerCards("bad Rope");
		answerPlayer.addPlayerCards("Rope");
		ArrayList<String> cards = answerPlayer.returnCommonCards(suggestionPlayer.getPlayerCards());
		assertEquals(cards.get(0), "Prof. Plum");
	}
//>>>>>>> cc2a376bb383641f596127c5ea1b0788ed836206
//	}
	
	@Test
	public void noCardsFound(){ //
		Player suggestionPlayer = new Player();
		Player middlePlayer  = new Player();
		Player answerPlayer  = new Player();
		suggestionPlayer.addPlayerCards("Prof. Plum");
		suggestionPlayer.addPlayerCards("Rope");
		middlePlayer.addPlayerCards("Should not be returned");
		middlePlayer.addPlayerCards("Misdirection");
		answerPlayer.addPlayerCards("nope");
		answerPlayer.addPlayerCards("negative");
		ArrayList<String> cards = answerPlayer.returnCommonCards(suggestionPlayer.getPlayerCards());
		assertNull(cards);
	}
	
//<<<<<<< HEAD
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
		
		ArrayList<String> suggPlayer  = suggestPlayer.getPlayerCards();
		ArrayList<String> twoPlayer = secondPlayer.getPlayerCards(); 
		ArrayList<String> threePlayer = thirdPlayer.getPlayerCards();
		ArrayList<String> fourPlayer  = fourthPlayer.getPlayerCards(); 
		ArrayList<String> fivePlayer  = fifthPlayer.getPlayerCards();
		ArrayList<String> sixPlayer = sixthPlayer.getPlayerCards(); 
		
////		suggestPlayer.makeAccusation(string a, string b, string c){		
//		}
				
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
		
		ArrayList<String> suggPlayer  = suggestPlayer.getPlayerCards();
		ArrayList<String> twoPlayer = secondPlayer.getPlayerCards(); 
		ArrayList<String> threePlayer = thirdPlayer.getPlayerCards();
		ArrayList<String> fourPlayer  = fourthPlayer.getPlayerCards(); 
		ArrayList<String> fivePlayer  = fifthPlayer.getPlayerCards();
		ArrayList<String> sixPlayer = sixthPlayer.getPlayerCards(); 		
	}
//=======
//	
//
//>>>>>>> cc2a376bb383641f596127c5ea1b0788ed836206
}


