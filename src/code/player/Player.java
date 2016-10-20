package code.player;

import java.util.ArrayList;

public class Player {
	String _playerName; //player's name
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
	public String getPlayerName(){
		return _playerName;
	}
	//TODO Fill out Java doc
	public ArrayList<String> getPlayerCards(){
		return _playerCards;
	}
	//TODO Fill out Java doc
	public boolean addPlayerCards(String card){
		_playerCards.add(card);
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
	public boolean setName(String name){
		if(name != null){
			_playerName = name;
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
	//TODO Fill out Java doc
	public boolean checkCards(ArrayList<String> ansPlayer){ 
		boolean cardFound = false;
		for(String otherCard : ansPlayer){
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
	
	/**
	 * Checks the player's cards against the cards in the parameter. 
	 * <p>
	 * If two identical cards are found adds them to an array.
	 * 
	 * @return      Cards that the player and the array have in common, if none returns null.
	 */	
	public String[] returnCommonCards(String[] cards){ 
		int i = 0;
		String[] cardsFound = new String[cards.length + 1 /*for good measure*/];
		for(String otherCard : cards){
			for(String playerCard : _playerCards){
				if(otherCard == playerCard){
					//give the player the card so he knows that he was wrong(?)
					cardsFound[i] = playerCard;
					i++;
				}
			}
		}
		if(i == 0){
			return null;
		}
		return cardsFound;
	}
	
	//TODO Fill out Java doc
	public boolean hasMovesLeft(){
		if(_movesLeft > 0){
			return true;
		}
		return false;

	}
	
	public int getMovesLeft(){
		return _movesLeft;

	}
	
}
