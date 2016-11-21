package code;

import code.gui.GUI;
import code.gui.winnerGUI;

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
	
	/*time constraints will lead to global varaibles....*/
	public static Board board;
	public static GUI gui;
	
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
		int playerCount = scan.nextInt();
		while(true){
			if(playerCount > 1){
				if(playerCount < 7){
					break;
				}
			}
			System.out.println("How many players are playing (no more then 6)? ");
			scan = new Scanner(System.in);
			playerCount = scan.nextInt();
		}
		ArrayList<String> characters = new ArrayList<String>();
		characters.add("Ms. Scarlet");
		characters.add("Prof. Plum");
		characters.add("Mr. Green");
		characters.add("Mrs. White");
		characters.add("Mrs. Peacock");
		characters.add("Colonel Mustard");
		board = new Board();
		for(int i = 0; i<playerCount; i++){
			Player player = new Player();
			player.setCharacterName(characters.get(i));
			_activePlayers.add(player);
			_playerArray.add(player);
		}
		for(int i = 0; i<_playerArray.size(); i++){
			PlayerLogic plogic = new PlayerLogic();
			int[] positon = plogic.findStartingPosition(_playerArray.get(i).getCharacterName()); //finds players start position based on name
			_playerArray.get(i).setXYCord(positon[0], positon[1]); //puts players in that position locally
			board.setBoard(_playerArray.get(i).getCharacterName(), positon[0], positon[1]); //puts players in that for all players to see
		}
		Deck deck = new Deck();
		deck.createCrime();
		deck.giveCards(); //gives players cards
		_currentPlayerTurn = "Ms. Scarlet"; //who starts
		//load the gui here after everyone loads
		gui = new GUI(board);
		PlayerLogic pLogic = new PlayerLogic();
		TurnLogic tL = new TurnLogic();
		while(_activePlayers.size() != 1 && _activePlayers.contains(pLogic.findPlayer(_currentPlayerTurn))){
			Player currentPlayer = pLogic.findPlayer(_currentPlayerTurn);
			gui.getPlayerName().setText(currentPlayer.getCharacterName());
			tL.completeTurn(currentPlayer, board, gui);
			_currentPlayerTurn = pLogic.whosNextTurn(_currentPlayerTurn);
			gui.getConsoleLabel().setText("Current players turn: " + _currentPlayerTurn);
		}
		winnerGUI annoying = new winnerGUI(_activePlayers.get(0));
		
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
	
	
	/**
	 * @return Returns the current players turn.
	 */
	public String getPlayerTurn(){ 
		return _currentPlayerTurn;
	}
	
	
	
	
	
	
}
