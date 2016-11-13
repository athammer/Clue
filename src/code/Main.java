package code;

import code.gui.GUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

import code.board.Board;
import code.deck.Deck;
import code.logic.PlayerLogic;
import code.logic.TurnLogic;
import code.player.Player;

public class Main {
	//if static has some special convention im ignoring it
	/**
	 * ArrayList that has all of the players, lost or not.
	 */
	public static ArrayList<Player> _playerArray = new ArrayList<Player>(); //spooky global variable with accessor method anyways
	/**
	 * ArrayList with only active playing players.
	 */
	public static ArrayList<Player> _activePlayers = new ArrayList<Player>(); //spooky global variable with accessor method anyways
	
	public static String _currentPlayerTurn; //more global variables :) last one tho
	/**
	 * Starts the game and creates the player and board instances for the game.
	 * <p>
	 * The main function of the game it controls most of the core logic in the game.
	 * @throws Exception 
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception{
		System.out.println("How many players are playing (no more then 6)? ");
		Scanner scan = new Scanner(System.in); 
		int playerCount = scan.nextInt(); //gets quantity of players
		ArrayList<String> characters = new ArrayList<String>();
		characters.add("Ms. Scarlet");
		characters.add("Prof. Plum");
		characters.add("Mr. Green");
		characters.add("Mrs. White");
		characters.add("Mrs. Peacock");
		characters.add("Colonel Mustard");
		Board board = new Board();
		for(int i = 0; i<playerCount; i++){
			Player player = new Player();
			player.setCharacterName(characters.get(i));
			PlayerLogic plogic = new PlayerLogic();
			int[] positon = plogic.findStartingPosition(characters.get(i)); //finds players start position based on name
			player.setXYCord(positon[0], positon[1]); //puts players in that position locally
			board.setBoard(characters.get(i), positon[0], positon[1]); //puts players in that for all players to see
			_activePlayers.add(player);
			_playerArray.add(player);
		}
		Deck deck = new Deck();
		deck.giveCards(); //gives players cards
		_currentPlayerTurn = "Ms. Scarlet"; //who starts
		
		//load the gui here after everyone loads
		GUI gui = new GUI(board.getBoard());
		while(_activePlayers.size() != 1){
			PlayerLogic pLogic = new PlayerLogic();
			TurnLogic tL = new TurnLogic();
			Player currentPlayer = pLogic.findPlayer(_currentPlayerTurn);
			tL.completeTurn(currentPlayer, board);
			_currentPlayerTurn = pLogic.whosNextTurn(_currentPlayerTurn);
		}
		
		//if we get here the game /should/ be done
	}
	
	/**
	 * @return Returns all of the players in an ArrayList of type Player.
	 */
	public ArrayList<Player> getPlayers(){ //currently useless as the player class handles if the player lost
		return _playerArray;
	}
	
	/**
	 * @return Returns all of the active players in an ArrayList of type Player.
	 */
	public ArrayList<Player> getActivePlayers(){ //currently useless as the player class handles if the player lost
		return _activePlayers;
	}
	
	
	
	
	
	
	
	
}
