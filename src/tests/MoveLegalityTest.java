package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.board.Board;
import code.player.Player;

/*
* Test that your project correctly identifies as legal a move that only goes horizontally for as many squares as the die roll;

* Test that your project correctly identifies as legal a move that only goes vertically for as many squares as the die roll;

* Test that your project correctly identifies as legal a move that goes horizontally & vertically for as many squares as the die roll;

* Test that your project correctly identifies as legal a move that goes through a door and into a room;

* Test that your project correctly identifies as legal a move that just uses the a secret passageway;

* Test that your project correctly identifies as illegal a move that goes more squares than the die roll;

* Test that your project correctly identifies as illegal a move that goes diagonally;

* Test that your project correctly identifies as illegal a move that is not contiguous;

* Test that your project correctly identifies as illegal a move that goes through a wall.
 */

public class MoveLegalityTest {
	
	@Test
	public void moveDiagTest(){
		Board testBoard = new Board();
		Player testPlayer = new Player();
		testPlayer.setXCord(0);
		testPlayer.setYCord(0);
		boolean moveDiagTest = testBoard.moveCorrectly(1, 1, testPlayer); //should return false
		assertFalse(moveDiagTest);
	}
	
	@Test
	public void validLocation(){
		Board testBoard = new Board();
		Player testPlayer = new Player();
		//TODO Check all rooms and some out of bound areas and see if they are null
	}
	
	

}
