package code.deck;

import java.lang.Math; 
import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	/** The complete deck of cards as an ArrayList */
	ArrayList<String> _deck;

	/** ArrayList of string that contain all the "crime" cards */
	ArrayList<String> _crimeCards;
	/** The murder who committed the crime */
	String _murderer;
	/** The weapon used in the crime */
	String _weapon;
	/** The place where the crime took place */
	String _sceneOfCrime;
	
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
			String murderer = _deck.get(rand.nextInt(5 - 0) + 0); //random 0-5
			String weapon = _deck.get(rand.nextInt(11 - 6) + 6); //random 0-5
			String place = _deck.get(rand.nextInt(20 - 12) + 12); //random 0-5
			_crimeCards.add(murderer);
			_crimeCards.add(weapon);
			_crimeCards.add(place);
			_murderer = murderer;
			_weapon = weapon;
			_sceneOfCrime = place;
			break; //not so fast while loop
		}
		
	}
}
