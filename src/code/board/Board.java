package code.board;

import code.player.Player;

public class Board {
	//http://flockofnerds.com/wp-content/uploads/2014/11/clue-board.jpg Board game
	//https://s-media-cache-ak0.pinimg.com/originals/8d/4a/95/8d4a95cfddea78bcee58a7eb243ceb93.jpg
	
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
		
		//Conservatory
		String cty = "conservatory";
		board[19][4] = cty;
		
		//Ball Room
		String BlR = "ball room";
		board[19][8] = BlR;
		board[19][15] = BlR;
		board[17][9] = BlR;
		board[17][14] = BlR;
		
		//Kitchen
		String ktchn = "kitchen";
		board[18][19] = ktchn;
		
		//Staircase
		//this value is "inside" of the staircase so you can only be moved there by guessing and not by moving normaly
		board[9][10] = "stair case";
		
		//StartLocations
		//TODO finish this
		
		//TODO finish up the rooms and add nulls to everwhere but the doors for the rooms
		//TODO put in the "staircase".
		
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
	public String getPlayerBoardValue(Player player){
		return board[player.getPlayerXCord()][player.getPlayerYCord()];
	}
	
	//TODO Fill out Java doc
	public boolean isValidLocation(int x, int y){ //will probably get called a lot.
		if(isSpecialRoom(x, y)){
			//it's a special room so more then one user can be here.
			return true;
			
		}
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
		
		//kitchen->study, conservatory->lounge, study->kitchen, lounge->conservatory
		int oldXPosition = player.getPlayerXCord();
		int oldYPosition = player.getPlayerYCord();
		if(oldXPosition == x && oldYPosition == y){
			//can't move in the same spot.
			return false;
		}
		int moveCount = 0;
		if(oldXPosition < x) { moveCount += 1; } //should work
		if(oldYPosition < y) { moveCount += 1; }
		String room = getSpecialRoom(player.getPlayerXCord(),player.getPlayerYCord());
		if(room != null && (room.equals("kitchen") || room.equals("study") || room.equals("conservatory") || room.equalsIgnoreCase("lounge"))){
			//the above if statement checks if user is currently in a room they can teleport
			//the stuff below allows people to tp using secret rooms
			if(room.equals("kitchen") && getSpecialRoom(x,y).equals("study")){
				player.setMovesLeft(1); //set to one so users cant keep moving once tping
				return true;
			}
			if(room.equals("study") && getSpecialRoom(x,y).equals("kitchen")){
				player.setMovesLeft(1);
				return true;
			}
			if(room.equals("conservatory") && getSpecialRoom(x,y).equals("lounge")){
				player.setMovesLeft(1);
				return true;
			}
			if(room.equals("lounge") && getSpecialRoom(x,y).equals("conservatory")){
				player.setMovesLeft(1);
				return true;
			}
			
		}
		if(moveCount >= 2) { 
			return false;
		}
		return true;	
	}
	
	//TODO Fill out Java doc
	//used for finding if the room is special and if so allowing the user to move through secret passages
	//or allowing two users to be on the same spot
	public boolean isSpecialRoom(int x, int y){
		//do sanity checking?
		if(x == 3 && y == 6){
			return true;
		}
		if((x == 4 && y == 9) || (x == 6 && y == 11) || (x == 6 && y == 12)){
			return true;
		}
		if((x == 5 && y == 17)){
			return true;
		}
		if((x == 8 && y == 6) || (x == 10 && y == 3)){
			return true;
		}		
		if((x == 9 && y == 17) || (x == 12 && y == 16)){
			return true;
		}
		if((x == 12 && y == 1) || (x == 15 && y == 5)){
			return true;
		}
		if((x == 19 && y == 4)){
			return true;
		}
		if((x == 19 && y == 8) || (x == 19 && y == 15) || (x == 17 && y == 9) || (x == 17 && y == 14)){
			return true;
		}
		if((x == 18 && y == 19)){
			return true;
		}
		return false;
	}
	
	public String getSpecialRoom(int x, int y){
		//do sanity checking?
		if(x == 3 && y == 6){
			return "study";
		}
		if((x == 4 && y == 9) || (x == 6 && y == 11) || (x == 6 && y == 12)){
			return "hall";
		}
		if((x == 5 && y == 17)){
			return "lounge";
		}
		if((x == 8 && y == 6) || (x == 10 && y == 3)){
			return "libary";
		}		
		if((x == 9 && y == 17) || (x == 12 && y == 16)){
			return "dining room";
		}
		if((x == 12 && y == 1) || (x == 15 && y == 5)){
			return "billard room";
		}
		if((x == 19 && y == 4)){
			return "conservatory";
		}
		if((x == 19 && y == 8) || (x == 19 && y == 15) || (x == 17 && y == 9) || (x == 17 && y == 14)){
			return "ball room";
		}
		if((x == 18 && y == 19)){
			return "kitchen";
		}
		return null;
	}
}
