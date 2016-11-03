package tests.phase1;

import static org.junit.Assert.*;

import org.junit.Test;

import code.board.Board;
import code.logic.DiceRoll;
import code.logic.PlayerLogic;
import code.player.Player;


//http://www.cs.nmsu.edu/~kcrumpto/TAClasses/ClueRules.html
/*
* Test that your project correctly identifies as legal a move that only goes horizontally for as many squares as the die roll;
* done(kinda, not specifically tested but there isn't a reason why it shouldn't work)

* Test that your project correctly identifies as legal a move that only goes vertically for as many squares as the die roll;
* done(kinda, not specifically tested but there isn't a reason why it shouldn't work)

* Test that your project correctly identifies as legal a move that goes horizontally & vertically for as many squares as the die roll;
* done

* Test that your project correctly identifies as legal a move that goes through a door and into a room;
* not done(surround entrance with nulls)

* Test that your project correctly identifies as legal a move that just uses the a secret passageway;
* pretty much done(could be better but effectivly done as it does check what it asks)

* Test that your project correctly identifies as illegal a move that goes more squares than the die roll;
* done

* Test that your project correctly identifies as illegal a move that goes diagonally;
* done

* Test that your project correctly identifies as illegal a move that is not contiguous;
* done

* Test that your project correctly identifies as illegal a move that goes through a wall.
* done(other then need to fill out the rest of the nulls in the rooms and such.
 */

public class MoveLegalityTest {
	
	@Test
	public void moveDiagTest(){
		Board testBoard = new Board();
		Player testPlayer = new Player();
		testPlayer.setXYCord(0,0);
		boolean moveDiagTest = testBoard.moveCorrectly(1, 1, testPlayer); //should return false
		assertFalse(moveDiagTest);
	}
	
	@Test //Test push
	public void validLocation(){
		Board testBoard = new Board();
		Player testPlayer = new Player();
		assertEquals(testBoard.isValidLocation(6, 0), false); //outside map
		assertEquals(testBoard.isValidLocation(7, 0), true); //pathway
		//we already have a function/method for this so not very exciting as all the checks are already there.
	}
	@Test
	public void playerRollAndMoveTest(){
		Board testBoard = new Board();
		String[][] board = testBoard.getBoard();
		for (int j = 0; j < board[0].length; j++){ //done to remove 'walls(nulls)' for simplicity and sanity.
			for (int i = 0; i < board.length; i++){
				board[i][j] = "empty"; //pretty iffy test
			}
		}
		Player testPlayer = new Player();
		PlayerLogic playerLogic = new PlayerLogic();
		DiceRoll diceRoll = new DiceRoll();
		int playerMoves = diceRoll.rollOneDice() + 1; //just incase player rolls a 1
		//setting up player
		testPlayer.setMovesLeft(playerMoves);
		testPlayer.setXYCord(0, 0); //top left
		boolean successOrFail = playerLogic.movePlayer(testBoard, testPlayer, 1, 0);
		boolean successOrFail1 = playerLogic.movePlayer(testBoard, testPlayer, 2, 1); //should be false
		assertEquals(playerMoves, testPlayer.getMovesLeft() + 1 /*only one bc the second movePlayer should fail */, 0.001);
		assertTrue(successOrFail);
		assertFalse(successOrFail1);
	
	}
	
	@Test
	public void wallTest(){
		Board testBoard = new Board();
		String[][] board = testBoard.getBoard();
		for (int j = 0; j < board[0].length; j++){ //done to remove 'walls(nulls)' for simplicity and sanity.
			for (int i = 0; i < board.length; i++){
				board[i][j] = "empty"; //pretty iffy 
			}
		}
		//WALL├┬┴┬┴┬┴┬┴┬┴┬┤
		board[1][0] = null;
		board[0][1] = null;
		//WALL END ├┬┴┬┴┬┴┬┴┬┴┬┤
		Player testPlayer = new Player();
		PlayerLogic playerLogic = new PlayerLogic();
		DiceRoll diceRoll = new DiceRoll();
		int playerMoves = diceRoll.rollOneDice() + 1; //just incase player rolls a 1 
		testPlayer.setMovesLeft(playerMoves);		//setting up player
		testPlayer.setXYCord(0, 0); //top left
		boolean successOrFail = playerLogic.movePlayer(testBoard, testPlayer, 1, 0); //should return false as wall
		boolean successOrFail1 = playerLogic.movePlayer(testBoard, testPlayer, 0, 1); //should return false as wall
		assertFalse(successOrFail); //if both are false then move failed due to walls
		assertFalse(successOrFail1);
	}
	@Test
	public void roomTeleporting(){
		Board testBoard = new Board();
		String[][] board = testBoard.getBoard();
		Player testPlayer = new Player();
		PlayerLogic playerLogic = new PlayerLogic();
		DiceRoll diceRoll = new DiceRoll();
		int playerMoves = diceRoll.rollOneDice() + 1; //just incase player rolls a 1
		//setting up player
		testPlayer.setMovesLeft(playerMoves);
		testPlayer.setXYCord(3, 6); //the special room "study"
		boolean successOrFail = playerLogic.movePlayer(testBoard, testPlayer, 18, 19);
		/*
		 * uncomment below once we finish the paths as default value for a string array is null
		 * boolean successOrFail1 = playerLogic.movePlayer(testBoard, testPlayer, 19, 19); //should be false as moves should be run out
		 */
		assertEquals(testPlayer.getMovesLeft(), 0 /*moving to special room should reset moves */, 0.001);
		assertTrue(successOrFail);
		//assertFalse(successOrFail1);
	}
	@Test
	public void playerBlocking(){
		Board testBoard = new Board();
		String[][] board = testBoard.getBoard();
		Player testPlayer = new Player();
		Player testPlayer1 = new Player();
		PlayerLogic playerLogic = new PlayerLogic();
		DiceRoll diceRoll = new DiceRoll();
		int playerMoves = diceRoll.rollOneDice() + 1; //just incase player rolls a 1
		//setting up player
		testPlayer.setMovesLeft(playerMoves);
		testPlayer1.setMovesLeft(playerMoves);
		testPlayer.setXYCord(0, 0); //the special room "study"
		testPlayer1.setXYCord(1, 0); //the special room "study"
		boolean successOrFail = playerLogic.movePlayer(testBoard, testPlayer, 1, 0);
		/*
		 * uncomment below once we finish the paths as default value for a string array is null
		 * boolean successOrFail1 = playerLogic.movePlayer(testBoard, testPlayer, 19, 19); //should be false as moves should be run out
		 */
		assertTrue(successOrFail);
		//assertFalse(successOrFail1);
	}
	

}
