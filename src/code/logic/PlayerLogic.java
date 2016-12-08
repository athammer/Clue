package code.logic;

import code.board.Board;
import code.player.Player;

import java.awt.Color;

import javax.swing.JButton;

import code.Main;

public class PlayerLogic {
	//global player logic anything in here should be applicable for all players and not specific to one
	
	/**
	 * Starts the game and creates the player and board instances for the game.
	 * <p>
	 * The main function of the game it controls most of the core logic in the game.
	 * @param  name name of the player in the Player class.
	 * @return      the first player found with that name or if none found, false.
	 */
	public Player findPlayer(String name){
		for(Player player : Main._playerArray){
			if(player.getCharacterName() == name){
				//yay
				return player;
			}
		}
		
		return null;	
	}
	
	

	public Player findActivePlayer(String name){
		for(Player player : Main._activePlayers){
			if(player.getCharacterName() == name){
				//yay
				return player;
			}
		}
		return null;	
	}
	
	//TODO Fill out Java doc
	public boolean movePlayer(Board board, Player player, int x, int y, JButton btn){ //moves player to x and y
		
		//when players are in a room let users leave out another door
		
		//let plays switch doors without using a turn
		//make player's new location the color they are and remove the color on the old spot
		Color color = playerColor(player.getCharacterName());
		if((board.isSpecialRoom(player.getPlayerXCord(), player.getPlayerYCord()) && board.isSpecialRoom(x, y)) && 
				board.getSpecialRoom(x, y) == board.getSpecialRoom(player.getPlayerXCord(), player.getPlayerYCord())){
			//is user moving to a room and is it the same one
			//allows users to switch between doors in the same room
			player.setXYCord(x, y);
			System.out.println("User switched doors within the same room.");
			return true;
		}
		
		
		
		if(board.isValidLocation(x, y) && board.moveCorrectly(x, y, player) && player.hasMovesLeft()){ 
			if(board.isSpecialRoom(x, y)){//player moved to a special room
				//checks if user moved diag and if user is in a non null spot.
				if(board.isSpecialRoom(player.getPlayerXCord(), player.getPlayerYCord())){//player is moving to special room from a special room
					player.setXYCord(x, y);
					player.setMovesLeft(0);
					return true;
				}
				JButton[][] JBArray = Main.gui.getJButtonArray();
				JButton oldbtn = JBArray[player.getPlayerXCord()][player.getPlayerYCord()];
				oldbtn.setBackground(Color.lightGray);
				oldbtn.setForeground(Color.lightGray);
				board.setBoard("empty", player.getPlayerXCord(), player.getPlayerYCord()); //old player location
				player.setXYCord(x, y);
				player.setMovesLeft(0);
				return true;
			}else if(board.isSpecialRoom(player.getPlayerXCord(), player.getPlayerYCord())){ 
				//player is moving to a normal spot from a special room
				//checks if user moved diag and if user is in a non null spot.
				board.setBoard(player.getCharacterName(), x, y); //puts player's name in that spot
				btn.setBackground(color);
			    btn.setForeground(color);
				player.setXYCord(x, y);
				player.setMovesLeft(player.movesLeft() - 1);
				return true;
			}else{
				//player is moving to a normal spot from a normal spot
				JButton[][] JBArray = Main.gui.getJButtonArray();
				JButton oldbtn = JBArray[player.getPlayerXCord()][player.getPlayerYCord()];
				oldbtn.setBackground(Color.lightGray);
				oldbtn.setForeground(Color.lightGray);
				board.setBoard(player.getCharacterName(), x, y); //puts player's name in that spot
				board.setBoard("empty", player.getPlayerXCord(), player.getPlayerYCord());
				btn.setBackground(color);
			    btn.setForeground(color);
				player.setXYCord(x, y);
				player.setMovesLeft(player.movesLeft() - 1);
				return true;
			}

		}else{
			Main.gui.getConsoleLabel().setText("invalid move " + Main._currentPlayerTurn + "!");
			System.out.println("invalid move " + Main._currentPlayerTurn + "!");
			return false;
		}	
	}
	
	
	/**
	 * Follows Clue's ordering of players and gets you who is next for a turn or guess check.
	 * @param  currentPlayerTurn A string that is the is the name of the character whos turn it is now.
	 * @return Returns the character's name that is to go next.
	 */
	public String whosNext(String currentPlayerTurn){ //all players
		for(int i = 0; i < Main._playerArray.size(); i++){
			
			if(Main._playerArray.get(i).getCharacterName().equals(currentPlayerTurn)){
				if(!(i+1 < Main._playerArray.size())){//if this is the last time if will run
					//next player will be 0 as 0->1->2...->0 its circular
					return Main._playerArray.get(0).getCharacterName();
				}
				return Main._playerArray.get(i+1).getCharacterName(); //shouldnt through an error due to if loop above
			}
		}
		
		return null;	
	}
	
	
	public Color playerColor(String player){ //all players
		if(player == "Ms. Scarlet"){
			return new Color(255, 36, 0);
		}
		if(player == "Prof. Plum"){
			return new Color(221,160,221);
		}
		if(player == "Mr. Green"){
			return Color.green;
		}
		if(player == "Mrs. White"){
			return Color.white;
		}
		if(player == "Mrs. Peacock"){
			return new Color(9, 84, 190);
		}
		if(player == "Colonel Mustard"){
			return new Color(227, 190, 66);
		}
		return null;
	}
	
	/**
	 * Follows Clue's ordering but skips people who lost or not in the game.
	 * @param  currentPlayerTurn A string that is the is the name of the character whos turn it is now.
	 * @return Returns the character's name that is to go next (that is still in the game.)
	 */
	public String whosNextTurn(String currentPlayerTurn){ //only players playing(no losers)
		String name = currentPlayerTurn;
		if(Main._activePlayers.size() == 1){
			return Main._activePlayers.get(0).getCharacterName();
		}
		if(findActivePlayer(currentPlayerTurn) == null){ //player prob lost on their turn and is not playing anymore
			for(int j = 0; j < Main._playerArray.size(); j++){
				name = whosNext(name);
				//System.out.println(name);
				for(Player activePlayer : Main._activePlayers){
					if(activePlayer.getCharacterName() == name){
						return name;
					}
				}
			}
			
		}
		for(int i = 0; i < Main._activePlayers.size(); i++){
			if(Main._activePlayers.get(i).getCharacterName().equals(currentPlayerTurn)){ //wont work if player lost on his turn
				if(!(i+1 < Main._activePlayers.size())){//if this is the last time if will run
					//next player will be 0 as 0->1->2...->0 its circular
					return Main._activePlayers.get(0).getCharacterName();
				}
				return Main._activePlayers.get(i+1).getCharacterName(); //shouldnt through an error due to if loop above
			}

			
		}
		System.out.println("didnt find anything");
		return null;
	}
	
	/**
	 * Finds the player's starting position based on the name.
	 * @param  name 	String of the name of the character
	 * @return Returns 	an int array with index 0 being x, and index 1 being y
	 */
	public int[] findStartingPosition(String name){
		Player player = findPlayer(name);
		int[] playerLocation = new int[2];
		if(name.equals("Ms. Scarlet")){
			playerLocation[0] = 0; //y
			playerLocation[1] = 16; //x
			return playerLocation;
		}
		if(name.equals("Prof. Plum")){
			playerLocation[0] = 5; //y
			playerLocation[1] = 0; //x
			return playerLocation;
		}
		if(name.equals("Mr. Green")){
			playerLocation[0] = 24; //y
			playerLocation[1] = 9; //x
			return playerLocation;
		}
		if(name.equals("Mrs. White")){
			playerLocation[0] = 24; //y
			playerLocation[1] = 14; //x
			return playerLocation;
		}
		if(name.equals("Mrs. Peacock")){
			playerLocation[0] = 18; //y
			playerLocation[1] = 0; //x
			return playerLocation;
		}
		if(name.equals("Colonel Mustard")){
			playerLocation[0] = 7; //y
			playerLocation[1] = 23; //x
			return playerLocation;
		}
		return null;
	}
	
	
	
	public void useSecretPassage(Player player, Board board){ 
		if(board.isSecretRoom(player.getPlayerXCord(), player.getPlayerYCord())){
			String room = board.getSecretRoom(player.getPlayerXCord(), player.getPlayerYCord());
			if(room == "conservatory"){
				movePlayer(board, player, 5, 7);
			}
			if(room == "study"){
				movePlayer(board, player, 18, 19);
			}
			if(room == "lounge"){
				movePlayer(board, player, 19, 4);
			}
			if(room == "kitchen"){
				movePlayer(board, player, 3, 6);
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean movePlayer(Board board, Player player, int x, int y){ //moves player to x and y
		
		//when players are in a room let users leave out another door
		
		//let plays switch doors without using a turn
		//make player's new location the color they are and remove the color on the old spot
		
		if((board.isSpecialRoom(player.getPlayerXCord(), player.getPlayerYCord()) && board.isSpecialRoom(x, y)) && 
				board.getSpecialRoom(x, y) == board.getSpecialRoom(player.getPlayerXCord(), player.getPlayerYCord())){
			//is user moving to a room and is it the same one
			//allows users to switch between doors
			player.setXYCord(x, y);
			return true;
		}
		
		
		
		if(board.isValidLocation(x, y) && board.moveCorrectly(x, y, player) && player.hasMovesLeft()){ 
			if(board.isSpecialRoom(x, y)){//player moved to a special room
				//checks if user moved diag and if user is in a non null spot.
				if(board.isSpecialRoom(player.getPlayerXCord(), player.getPlayerYCord())){//player is moving to special room from a special room
					player.setXYCord(x, y);
					player.setMovesLeft(player.movesLeft() - 1);
					return true;
				}
				board.setBoard("empty", player.getPlayerXCord(), player.getPlayerYCord()); //old player location
				player.setXYCord(x, y);
				player.setMovesLeft(player.movesLeft() - 1);
				return true;
			}else if(board.isSpecialRoom(player.getPlayerXCord(), player.getPlayerYCord())){ 
				//player is moving to a normal spot from a special room
				//checks if user moved diag and if user is in a non null spot.
				board.setBoard(player.getCharacterName(), x, y); //puts player's name in that spot

				player.setXYCord(x, y);
				player.setMovesLeft(player.movesLeft() - 1);
				return true;
			}else{
				//player is moving to a normal spot from a normal spot
				board.setBoard(player.getCharacterName(), x, y); //puts player's name in that spot
				board.setBoard("empty", player.getPlayerXCord(), player.getPlayerYCord());
				player.setXYCord(x, y);
				player.setMovesLeft(player.movesLeft() - 1);
				return true;
			}

		}else{
			return false;
		}	
	}
	

}
