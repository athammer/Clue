package code.board;

public class Board {
	//http://flockofnerds.com/wp-content/uploads/2014/11/clue-board.jpg Board game
	
	//TODO Fill out Java doc
	String[][] board = new String[24][23]; //Height: 25 (-1), Width: 24 (-1), 600 possible tiles. Top left is [0][0]
	//The movement will have to check if the player goes out of bounds of the array and handle the error by not letting him move there.
	
	//TODO Fill out Java doc
	public Board(){
		//Walls within the array
		board[0][6] = null;
		board[0][9] = null;
		board[0][15] = null;
		board[0][17] = null;
		board[4][0] = null;
		board[6][23] = null;
		board[6][0] = null;
		board[8][23] = null;
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
		
		
		
	}
	
	//TODO Fill out Java doc
	public String[][] getBoard(){
		return board;
	}
	
	//TODO Fill out Java doc
	public boolean isValidLocation(int x, int y){ //will probably get called a lot.
		if(board[x][y] != null){
			return true; //congrats
		}//else
		return false;
	}
}
