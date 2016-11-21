package code.board;

import code.player.Player;

public class Board {
	//http://flockofnerds.com/wp-content/uploads/2014/11/clue-board.jpg Board game
	//https://s-media-cache-ak0.pinimg.com/originals/8d/4a/95/8d4a95cfddea78bcee58a7eb243ceb93.jpg
	
	
	//for gui if players are in the same room assign their image,color, name to predefined spots in the room that were prev null
	//then when they move out it is back to null
	
	//TODO Fill out Java doc
	private String[][] board = new String[25][24]; //Height: 25, Width: 24, 600 possible tiles. Top left is [0][0]
	//The movement will have to check if the player goes out of bounds of the array and handle the error by not letting him move there.
	//TODO Fill out Java doc
	public Board(){
		for (int j = 0; j < board[0].length; j++){
			for (int i = 0; i < board.length; i++){
				board[i][j] = "empty"; //pretty iffy
				//System.out.println(i + ' ' + j);
		    	 
			}
		}
		
		
		//Walls within the array
		board[0][6] = null; //6
		board[0][8] = null;
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
		//I could of used for loops for most of this =/
		String room = "room";
		
		//Study
		String stdy = "study";
		board[0][0] = "secretStudy";
		board[0][1] = room;
		board[0][2] = room;
		board[0][3] = room;
		board[0][4] = room;
		board[0][5] = room;
		board[1][0] = room;
		board[1][1] = room;
		board[1][2] = room;
		board[1][3] = room;
		board[1][4] = room;
		board[1][5] = room;
		board[1][6] = room;
		board[2][0] = room;
		board[2][1] = room;
		board[2][2] = room;
		board[2][3] = room;
		board[2][4] = room;
		board[2][5] = room;
		board[2][6] = room;
		board[3][0] = room;
		board[3][1] = room;
		board[3][2] = room;
		board[3][3] = room;
		board[3][4] = room;
		board[3][5] = room;
		board[3][6] = stdy;
		
		
		
		//Hall
		String hl = "hall";
		/*CONSTRAINTS */
		board[0][9] = room;
		board[6][14] = room;
		for(int h = 0; h < 7; h++){
			for(int w = 9; w < 15; w++){
				board[h][w] = room;
			}
		}
		board[4][9] = hl;
		board[6][11] = hl;
		board[6][12] = hl;

		
		//Lounge
		String lnge = "lounge";
		/*CONSTRAINTS */
		board[0][17] = room;
		board[6][14] = room;
		for(int h = 0; h < 6; h++){
			for(int w = 17; w < 24; w++){
				board[h][w] = room;
			}
		}
		board[0][23] = "secretLounge";
		board[5][17] = lnge;
		
		//Libary
		String lbry = "libary";
		/*CONSTRAINTS */
		board[6][0] = room;
		board[10][6] = room;
		for(int h = 6; h < 11; h++){
			for(int w = 0; w < 7; w++){
				if(!(h == 10 && w == 6)){
					board[h][w] = room;
				}
				
			}
		}
		/*Over written*/
		board[10][6] = "empty";
		board[10][0] = null;
		board[6][0] = null;
		/*------------------*/
		board[8][6] = lbry;
		board[10][3] = lbry;
		
		//Dining Room
		String DR = "dinning room";
		/*CONSTRAINTS */
		board[9][16] = room;
		board[15][23] = room;
		for(int h = 9; h < 16; h++){
			for(int w = 16; w < 24; w++){
				board[h][w] = room;
				
			}
		}
		/*Over written*/
		board[15][16] = "empty";
		board[15][17] = "empty";
		board[15][18] = "empty";
		/*------------------*/
		board[9][17] = DR;
		board[12][16] = DR;
		
		//Billard Room
		String BR = "billard room";
		/*CONSTRAINTS */
		board[12][0] = room;
		board[16][5] = room;
		for(int h = 12; h < 17; h++){
			for(int w = 0; w < 6; w++){
				board[h][w] = room;
				
			}
		}
		/*Over written*/
		/*------------------*/
		board[12][1] = BR;
		board[15][5] = BR;
		
		//Conservatory
		String cty = "conservatory";
		/*CONSTRAINTS */
		board[19][0] = room;
		board[23][5] = room;
		for(int h = 19; h < 24; h++){
			for(int w = 0; w < 6; w++){
				board[h][w] = room;
				
			}
		}
		/*Over written*/
		board[19][0] = null;
		board[19][5] = "empty";
		/*------------------*/
		board[23][0] = "secretConservatory";
		board[19][4] = cty;
		
		//Ball Room
		String BlR = "ball room";
		/*CONSTRAINTS */
		board[17][8] = room;
		board[22][15] = room;
		for(int h = 17; h < 23; h++){
			for(int w = 8; w < 16; w++){
				board[h][w] = room;
				
			}
		}
		/*Over written*/
		board[23][10] = room;
		board[23][11] = room;
		board[23][12] = room;
		board[23][13] = room;
		board[24][10] = room;
		board[24][11] = room;
		board[24][12] = room;
		board[24][13] = room;
		/*------------------*/
		board[19][8] = BlR;
		board[19][15] = BlR;
		board[17][9] = BlR;
		board[17][14] = BlR;
		
		//Kitchen
		String ktchn = "kitchen";
		/*CONSTRAINTS */
		board[18][18] = room;
		board[23][23] = room;
		for(int h = 18; h < 24; h++){
			for(int w = 18; w < 24; w++){
				board[h][w] = room;
				
			}
		}
		/*Over written*/
		board[18][23] = null;
		/*------------------*/
		board[23][23] = "secretKitchen";
		board[18][19] = ktchn;
		
		//Staircase
		//this value is "inside" of the staircase so you can only be moved there by guessing and not by moving normaly
		board[8][9] = "stair case";
		board[8][10] = "stair case";
		board[8][11] = "stair case";
		board[8][12] = "stair case";
		board[8][13] = "stair case";
		board[9][9] = "stair case";
		board[9][10] = "stair case";
		board[9][11] = "stair case";
		board[9][12] = "stair case";
		board[9][13] = "stair case";
		board[10][9] = "stair case";
		board[10][10] = "stair case";
		board[10][11] = "stair case";
		board[10][12] = "stair case";
		board[10][13] = "stair case";
		board[11][9] = "stair case";
		board[11][10] = "stair case";
		board[11][11] = "stair case";
		board[11][12] = "stair case";
		board[11][13] = "stair case";
		board[12][9] = "stair case";
		board[12][10] = "stair case";
		board[12][11] = "stair case";
		board[12][12] = "stair case";
		board[12][13] = "stair case";
		board[13][9] = "stair case";
		board[13][10] = "stair case";
		board[13][11] = "stair case";
		board[13][12] = "stair case";
		board[13][13] = "stair case";
		board[14][9] = "stair case";
		board[14][10] = "stair case";
		board[14][11] = "stair case";
		board[14][12] = "stair case";
		board[14][13] = "stair case";


		
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
		System.out.println(player.getPlayerXCord() + "  " + player.getPlayerYCord());
		//kitchen->study, conservatory->lounge, study->kitchen, lounge->conservatory
		int oldXPosition = player.getPlayerXCord();
		int oldYPosition = player.getPlayerYCord();
		if(oldXPosition == x && oldYPosition == y){
			//can't move in the same spot.
			return false;
		}
		int moveCount = 0;
		moveCount = (oldXPosition - x);
		moveCount = Math.abs(moveCount);
		//suprisenly complicated
		int yMoveCount = (oldYPosition - y);
		
		moveCount = Math.abs(yMoveCount) + moveCount;
		String room = getSpecialRoom(player.getPlayerXCord(),player.getPlayerYCord());
		boolean hasPassage = isSecretRoom(player.getPlayerXCord(),player.getPlayerYCord());
		System.out.println("X: " + x + "Y: " + y );
		String newRoom = getSpecialRoom(x, y);
		System.out.println(newRoom);
		if(room != null && hasPassage && newRoom != null){ //you are in a room and it has a secret passage
			System.out.println("moving to special room");
			//the above if statement checks if user is currently in a room they can teleport
			//the stuff below allows people to tp using secret rooms
			if(room.equals("kitchen") && newRoom.equals("study")){
				player.setMovesLeft(1); //set to one so users cant keep moving once tping
				System.out.println("kitchen -> Study");
				return true;
			}
			if(room.equals("study") && newRoom.equals("kitchen")){
				System.out.println("study -> kitchen");
				player.setMovesLeft(1);
				return true;
			}
			if(room.equals("conservatory") && newRoom.equals("lounge")){
				System.out.println("conservatory -> lounge");
				player.setMovesLeft(1);
				return true;
			}
			if(room.equals("lounge") && newRoom.equals("conservatory")){
				System.out.println("lounge -> conservatory");
				player.setMovesLeft(1);
				return true;
			}
			System.out.println("bad move");
			return false;
		}
		if(moveCount >= 2) { 
			System.out.println("move count not less then two");
			return false;
		}else{
			System.out.println("move count less then two");
			return true;
		}
	}
	
	//TODO Fill out Java doc
	//used for finding if the room is special and if so allowing the user to move through secret passages
	//or allowing two users to be on the same spot
	

	public boolean isSpecialRoom(int x, int y){
		//do sanity checking?
		if((x == 3 && y == 6) || (x == 0 && y == 0)){
			return true;
		}
		if((x == 4 && y == 9) || (x == 6 && y == 11) || (x == 6 && y == 12)){
			return true;
		}
		if((x == 5 && y == 17) || (x == 0 && y == 23)){
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
		if((x == 19 && y == 4) || (x == 23 && y == 0)){ //
			return true;
		}
		if((x == 19 && y == 8) || (x == 19 && y == 15) || (x == 17 && y == 9) || (x == 17 && y == 14)){
			return true;
		}
		if((x == 18 && y == 19) || (x == 23 && y == 23)){ //
			return true;
		}
		return false;
	}
	
	public String getSpecialRoom(int x, int y){
		//do sanity checking?
		if((x == 3 && y == 6) || (x == 0 && y == 0)){
			return "study";
		}
		if((x == 4 && y == 9) || (x == 6 && y == 11) || (x == 6 && y == 12)){
			return "hall";
		}
		if((x == 5 && y == 17) || (x == 0 && y == 23)){
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
		if((x == 19 && y == 4) || (x == 23 && y == 0)){ //
			return "conservatory";
		}
		if((x == 19 && y == 8) || (x == 19 && y == 15) || (x == 17 && y == 9) || (x == 17 && y == 14)){
			return "ball room";
		}
		if((x == 18 && y == 19) || (x == 23 && y == 23)){ //
			return "kitchen";
		}
		return null;
	}
	
	public String getSecretRoom(int x, int y){
		//do sanity checking?
		if((x == 3 && y == 6) || (x == 0 && y == 0)){
			return "study";
		}
		if((x == 5 && y == 17) || (x == 0 && y == 23)){
			return "lounge";
		}
		if((x == 19 && y == 4) || (x == 23 && y == 0)){ //
			return "conservatory";
		}
		if((x == 18 && y == 19) || (x == 23 && y == 23)){ //
			return "kitchen";
		}
		return null;
	}
	
	public boolean isSecretRoom(int x, int y){
		//do sanity checking?
		if((x == 3 && y == 6) || (x == 0 && y == 0)){
			return true;
		}
		if((x == 5 && y == 17) || (x == 0 && y == 23)){
			return true;
		}
		if((x == 19 && y == 4) || (x == 23 && y == 0)){ //
			return true;
		}
		if((x == 18 && y == 19) || (x == 23 && y == 23)){ 
			return true;
		}
		return false;
	}
}
