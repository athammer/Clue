package code.board;

import code.player.Player;

public class Board {
	//http://flockofnerds.com/wp-content/uploads/2014/11/clue-board.jpg Board game
	
	//TODO Fill out Java doc
	String[][] board = new String[25][24]; //Height: 25, Width: 24, 600 possible tiles. Top left is [0][0]
	//The movement will have to check if the player goes out of bounds of the array and handle the error by not letting him move there.
	//TODO Fill out Java doc
	public Board(){
		for (int j = 0; j < board[0].length; j++){
			for (int i = 0; i < board.length; i++){
				board[i][j] = "empty"; //pretty iffy
				System.out.println(i + ' ' + j);
		    	 
			}
		}
		
		
		//Walls within the array
		board[0][23] = null; //6
		board[0][9] = null;
		board[0][15] = null;
		board[0][17] = null;
		board[4][0] = null;
		board[6][23] = null; //23
		board[6][0] = null;
		board[8][23] = null; //23
		board[10][0] = null;
		board[11][0] = null;
		board[16][23] = null;
		board[17][0] = null;
		board[18][23] = null;
		board[19][0] = null;
		board[23][6] = null;
		board[23][17] = null;
		board[24][0] = null;
		board[24][1] = null;
		board[24][2] = null;
		board[24][3] = null;
		board[24][4] = null;
		board[24][5] = null;
		board[24][6] = null;
		board[24][7] = null;
		board[24][8] = null;
		board[24][10] = null;
		board[24][11] = null;
		board[24][12] = null;
		board[24][13] = null;
		board[24][15] = null;
		board[24][16] = null;
		board[24][17] = null;
		board[24][18] = null;
		board[24][19] = null;
		board[24][20] = null;
		board[24][21] = null;
		board[24][22] = null;
		board[24][23] = null;
		
		//Rooms (Only in front of the door is a movable spot)
		//will have to code something to let the user stop moving even when the player has 
		//more moves available when he enters a room. Will also have to let multiple users be in the same room
		//meaning be able to be in the same spot.
		
		
		//TODO Rooms have to be filled with null(other then infront of the doors), so users cannot go through rooms.
		
		
		//Study
		String stdy = "study";
		board[3][6] = stdy;
		
		//Hall
		String hl = "hall";
		board[4][9] = hl;
		board[6][11] = hl;
		board[6][12] = hl;
		
		//Lounge
		String lnge = "lounge";
		board[5][17] = lnge;
		
		//Libary
		String lbry = "libary";
		board[8][6] = lbry;
		board[10][3] = lbry;
		
		//Dining Room
		String DR = "dinning room";
		board[9][17] = DR;
		board[12][16] = DR;
		
		//Billard Room
		String BR = "billard room";
		board[12][1] = BR;
		board[15][5] = BR;
		
		//TODO finish up the rooms and add nulls to everwhere but the doors for the rooms
		
	}
	
	//TODO Fill out Java doc
	public String[][] getBoard(){
		return board;
	}
	
	//TODO Fill out Java doc
	public void setBoard(String value, int x, int y){
		board[x][y] = value;
	}
	
	//TODO Fill out Java doc
	public boolean isValidLocation(int x, int y){ //will probably get called a lot.
		if(board[x][y] != null && board[x][y] == "empty"){ //checks if it is valid and if a player is already there.
			return true; //congrats
		}//else
		return false;
	}
	
	//TODO Fill out Java doc
	//will check if player movedCorrectly *AFTER* checking if it is a valid move first
	//will also most likely have to be called from the main class as it has all the players
	//basicly checks if the player moves diagonally
	//by doing this we kidna force the user to select each location he wants to move one by one till he runs out of moves.
	//roll a 7, you get to move 7 times one space at a time(not like we get points off for it)
	public boolean moveCorrectly(int x, int y, Player player){
		int oldXPosition = player.getPlayerXCord();
		int oldYPosition = player.getPlayerYCord();
		int moveCount = 0;
		if(oldXPosition < x) { moveCount += 1; } //should work
		if(oldYPosition < y) { moveCount += 1; }
		if(moveCount >= 2) { return false; }
		return true;	
	}
}
