package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

import code.player.Player;

public class Main {
	private HashSet<String> _currentPlayers = new HashSet<String>(); //array to see who is currently playing and hasn't lost
	public static ArrayList<Player> _playerArray = new ArrayList<Player>(); //forced to make this public so others can access easily
	
	/**
	 * Starts the game and creates the player and board instances for the game.
	 * <p>
	 * The main function of the game it controls most of the core logic in the game.
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args){
		System.out.println("How many players are playing (no more then 6)? ");
		Scanner scan = new Scanner(System.in); 
		int players = scan.nextInt(); //gets quantity of players
		ArrayList<String> characters = new ArrayList<String>();
		characters.add("Prof. Plum");
		characters.add();
		characters.add();
		characters.add();
		characters.add();
		characters.add();
		characters.add();

	}
	
	
	
	public void createPlayers(){ //currently useless as the player class handles if the player lost
		int i = 0;
		while(_currentPlayers.iterator().hasNext()){
			String playerName = _currentPlayers.iterator().next();
			Player player = new Player(); 
			player.setName(playerName);
			_playerArray.add(player);
			i++;
		}
	}
	
	//TODO Fill out Java doc
	public ArrayList<Player> getPlayers(){ //currently useless as the player class handles if the player lost
		return _playerArray;
	}
	
	//TODO Fill out Java doc
	public HashSet<String> getCurrentPlayers(){ //currently useless as the player class handles if the player lost
		return _currentPlayers;
	}
	
	public void addPlayer(Player player){ //currently useless as the player class handles if the player lost
		_playerArray.add(player);
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
	
	
	
	
	
	
	
	
	
	
}
