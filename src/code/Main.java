package code;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

import code.player.Player;

public class Main {
	private HashSet<String> _currentPlayers = new HashSet<String>(); //array to see who is currently playing and hasn't lost
	public static Player[] _playerArray; //forced to make this public so others can access easily
	
	/**
	 * Starts the game and creates the player and board instances for the game.
	 * <p>
	 * The main function of the game it controls most of the core logic in the game.
	 */
	@SuppressWarnings("resource")
	public Main(){
		System.out.println("How many players are playing (no more then 6)? ");
		Scanner scan = new Scanner(System.in); 
		int players = scan.nextInt(); //gets quantity of players
		_playerArray = new Player[players - 1]; //starts at 0
		for(int i = 0; players -1 > i; i++){
			System.out.println("Enter your player names on at a time."); //each name has to be unique
			Scanner scan1 = new Scanner(System.in); 
			String playerName = scan1.nextLine();
			_currentPlayers.add(playerName); //adding players to hashset
			Player player = new Player();
			player.setName(playerName);
			_playerArray[i] = player;
			
		}
		shufflePlayers(); //for now this just shuffles players randomly without a dice roll
		//add a random number generator to see who goes first
	}
	
	
	
	public void createPlayers(){ //currently useless as the player class handles if the player lost
		int i = 0;
		while(_currentPlayers.iterator().hasNext()){
			String playerName = _currentPlayers.iterator().next();
			Player player = new Player(); 
			player.setName(playerName);
			_playerArray[i] = player;
			i++;
		}
	}
	
	//TODO Fill out Java doc
	public Player[] getPlayers(){ //currently useless as the player class handles if the player lost
		return _playerArray;
	}
	
	//TODO Fill out Java doc
	public HashSet<String> getCurrentPlayers(){ //currently useless as the player class handles if the player lost
		return _currentPlayers;
	}
	
	
	
	
	
	/**
	 * Returns the current players in the game, can be used to tell who has lost the game.
	 * <p>
	 *
	 * @return      the current players in the game in HashSet form.
	 */
	public HashSet<String> currentPlayers(){ //currently useless as the player class handles if the player lost
		
		return _currentPlayers;
	}
	
	private void shufflePlayers(){
	    int index;
	    Player temp;
	    Random random = new Random();
	    for (int i = _playerArray.length - 1; i > 0; i--){
	        index = random.nextInt(i + 1);
	        temp = _playerArray[index];
	        _playerArray[index] = _playerArray[i];
	        _playerArray[i] = temp;
	    }
	}
}
