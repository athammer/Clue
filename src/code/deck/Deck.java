package code.deck;

import java.lang.Math; 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import code.Main;

public class Deck {
	
	
	
	/** The deck of cards that will be given out */
	ArrayList<String> _deck = new ArrayList<String>();
	
	/** The deck of cards in full */
	ArrayList<String> _deckCopy = new ArrayList<String>();

	/** ArrayList of string that contain all the "crime" cards */
	ArrayList<String> _crimeCards =  new ArrayList<String>();
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
		Random r = new Random();
		while(true){
			//minimum + rn.nextInt(maxValue - minvalue + 1)
			int Low = 0;
			int High = 5;
			String murderer = _deck.get(r.nextInt(High-Low) + Low);
			Low = 6;
			High = 11;
			String weapon = _deck.get(r.nextInt(High-Low) + Low);
			Low = 12;
			High = 20;
			String place = _deck.get(r.nextInt(High-Low) + Low);
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
		System.out.println(_deck.size());
		System.out.println(_murderer);
		System.out.println(_weapon);
		System.out.println(_sceneOfCrime);
		int rotate = 0;
		while(!_deck.isEmpty()){
			Main._activePlayers.get(rotate).addPlayerCards(_deck.get(0));
			_deck.remove(0);
			
			if(rotate + 1 == playerCount){
				rotate = -1;
			}
			rotate += 1;
		}
	}
	
	
	
	
	
	
	
	
}
