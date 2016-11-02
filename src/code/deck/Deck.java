package code.deck;

import java.lang.Math; 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import code.Main;

public class Deck {
	
	
	
	/** The deck of cards that will be given out */
	ArrayList<String> _deck;
	
	/** The deck of cards in full */
	ArrayList<String> _deckCopy;

	/** ArrayList of string that contain all the "crime" cards */
	ArrayList<String> _crimeCards;
	/** The murder who committed the crime */
	String _murderer;
	/** The weapon used in the crime */
	String _weapon;
	/** The place where the crime took place */
	String _sceneOfCrime;
	
	@SuppressWarnings("unchecked")
	public Deck(){
		//characters
		_deck.add("Prof. Plum");
		_deck.add("Colonel Mustard");
		_deck.add("Mr. Green");
		_deck.add("Mrs. Peacock");
		_deck.add("Ms. Scarlet");
		_deck.add("Mrs. White");
		//weapon
		_deck.add("Rope");
		_deck.add("Lead Pipe");
		_deck.add("Knife");
		_deck.add("Wrench");
		_deck.add("Candlestick");
		_deck.add("Pistol");
		//rooms
		_deck.add("Ballroom");
		_deck.add("Conservatory");
		_deck.add("Billiard Room");
		_deck.add("Library");
		_deck.add("Study");
		_deck.add("Hall");
		_deck.add("Lounge");
		_deck.add("Dining Room");
		_deck.add("Kitchen");
		_deckCopy = (ArrayList<String>) _deck.clone(); //should work but doubt we'll test it
	}
	
	
	
	public ArrayList<String> getDeck(){
		return _deck;
	}
	
	public ArrayList<String> getCrimeCards(){
		return _crimeCards;
	}
	
	public String getMurderer(){
		return _murderer;
	}
	
	public String getWeapon(){
		return _weapon;
	}
	
	public String getSceneOfCrime(){
		return _sceneOfCrime;
	}
	
	/**
	 * Shuffles the cards and selects a card from each 3 card categories(weapon, place, person)
	 */
	public void createCrime(){
		Random rand = new Random();
		while(true){
			//minimum + rn.nextInt(maxValue - minvalue + 1)
			String murderer = _deck.get(rand.nextInt(5 - 0) + 1) + 0; //random 0-5
			String weapon = _deck.get(rand.nextInt(11 - 6) + 1) + 6; 
			String place = _deck.get(rand.nextInt(20 - 12) + 1) + 12; 
			_crimeCards.add(murderer);
			_crimeCards.add(weapon);
			_crimeCards.add(place);
			_murderer = murderer;
			_weapon = weapon;
			_sceneOfCrime = place;
			_deck.remove(murderer);
			_deck.remove(weapon);
			_deck.remove(place);
			break; //not so fast while loop
		}
		
	}
	
	/**
	 * Gives the cards out to the players
	 */
	public void giveCards() throws Exception{
		//21 cards
		//18 cards in play
		Collections.shuffle(_deck); //shuffles the cards
		int playerCount = Main._activePlayers.size();
		int cardCountPerPlayer = (int) Math.floor(18 / playerCount); //don't think we need this as int, but need it to round down always
		for(int i = 0; i < playerCount; i++){
			for(int j = 0; j < cardCountPerPlayer; j++){
				Main._activePlayers.get(i).addPlayerCards(_deck.get(j));
				
			}
		} //might be a remainder of cards left, such as 18/5 = floor(3.6) = 3, 18-(3*5) = 3 remainder,
		
		for(int i = 0; i < cardCountPerPlayer * playerCount; i++){ //cant delete in while loop as it will mess up for loop(?)
			//cardCountPerPlayer * playerCount = how many cards given out
			_deck.remove(i);
		}
		
		for(int i = 0; i < _deck.size(); i++){
			Main._activePlayers.get(i).addPlayerCards(_deck.get(i));
			//_deck.size() has to be less then players so we can safely add starting by zero on each end
		}
		for(int i = 0; i < _deck.size(); i++){
			_deck.remove(i); //should make empty deck
		}
		if(!_deck.isEmpty()){
			throw new Exception(); //fix if broken
		}
		//there prob is a better way but meh
		
	}
}
