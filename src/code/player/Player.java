package code.player;

import java.util.ArrayList;

public class Player {
	//TODO clean up methods 
	
	
	String _characterName; //player's character name ie Plum, or whatever
	ArrayList<String> _playerCards = new ArrayList<String>(); //player's cards
	ArrayList<String> _knownCards = new ArrayList<String>(); //all cards you know(not including your own cards
	ArrayList<String> _totalCards = new ArrayList<String>(); //all cards you know and your own cards
	int _playerXCords;
	int _playerYCords;
	int _startPosition; //who goes first
	int _movesLeft; //how many times a player can move his/her character one space
	boolean _loserPlayer = false; //has the player lost
	
	
	
	public Player(){

	}
	//TODO Fill out Java doc
	public String getCharacterName(){
		return _characterName;
	}
	//TODO Fill out Java doc
	public ArrayList<String> getPlayerCards(){
		return _playerCards;
	}
	
	/**
	 * Adds cards to players "hands", also adds to _totalCards using addAllCards(String card) <- link this 
	 * @return Returns true because why not
	 */	
	public boolean addPlayerCards(String card){
		_playerCards.add(card);
		addAllCards(card); //is this good oop/d?
		return true;
	}
	//TODO Fill out Java doc
	public int getPlayerXCord(){
		return _playerXCords;
	}
	//TODO Fill out Java doc
	public int getPlayerYCord(){
		return _playerYCords;
	}
	//TODO Fill out Java doc
	public boolean getDidPlayerLose(){
		return _loserPlayer;
	}
	//TODO Fill out Java doc
	public int movesLeft(){
		return _movesLeft;
	}
	//TODO Fill out Java doc
	public ArrayList<String> getKnownCards(){
		return _knownCards;
	}
	//TODO Fill out Java doc
	public ArrayList<String> getAllCards(){
		return _totalCards;
	}
	//TODO Fill out Java doc
	public boolean addKnownCards(String card){
		_knownCards.add(card);
		return true;
	}
	//TODO Fill out Java doc
	public boolean addAllCards(String card){
		_totalCards.add(card);
		return true;
	}
	
	
	//TODO Fill out Java doc
	public boolean setCharacterName(String name){
		if(name != null){
			_characterName = name;
			return true;
		}
		return false;

	}
	//TODO Fill out Java doc
	public boolean setLoserPlayer(boolean b){
		_loserPlayer = b;
		return b;
	}
	//TODO Fill out Java doc
	public boolean setMovesLeft(int movesLeft){
		//TODO Import NullRefExcption or do this sanity checking another way.
		/*
		if(x == null){
			throw new NullReferenceException;
		}
		*/
		_movesLeft = movesLeft;
		return true;
	}
	//TODO Fill out Java doc
	public boolean setXYCord(int x, int y){
		//TODO Import NullRefExcption or do this sanity checking another way.
		/*
		if(y == null){
			throw new NullReferenceException;
		}
		*/
		_playerXCords = x;
		_playerYCords = y;
		return true;
	}
	
	/**
	 * Gets the remaining moves left for a user.
	 * @return Returns and int value of how many moves left.
	 */	
	public boolean checkCards(ArrayList<String> cards){ 
		boolean cardFound = false;
		for(String otherCard : cards){
			for(String playerCard : _playerCards){
				if(otherCard == playerCard){
					cardFound = true;
					//give the player the card so he knows that he was wrong(?)
					return cardFound;
				}
			}
		}
		return cardFound;
	}
	
	//TODO Fill out Java doc
	public ArrayList<String> returnCommonCards(ArrayList<String> cards){ 
		int i = 0;
		ArrayList<String> cardsFound = new ArrayList<String>();
		for(String otherCard : cards){
			for(String playerCard : _playerCards){
				if(otherCard == playerCard){
					//give the player the card so he knows that he was wrong(?)
					cardsFound.add(otherCard);
					i++;
				}
			}
		}
		if(i == 0){
			return null;
		}
		return cardsFound;
	}
	
	/**
	 * Checks the player has moves left. 
	 * @return Returns true or false depending if the player has moves left.
	 */	
	public boolean hasMovesLeft(){
		if(_movesLeft > 0){
			return true;
		}
		return false;

	}
	
	/**
	 * Gets the remaining moves left for a user.
	 * @return Returns and int value of how many moves left.
	 */	
	public int getMovesLeft(){
		return _movesLeft;

	}
	
}
