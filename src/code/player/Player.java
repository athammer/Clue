package code.player;

public class Player {
	String _playerName; //player's name
	String[] _playerCards; //player's cards
	int _playerXCords;
	int _playerYCords;
	int _startPosition; //who goes first
	int _movesLeft; //how many times a player can move his/her character one space
	boolean _loserPlayer = false; //has the player lost
	
	
	
	public Player(){

	}
	//TODO Fill out Java doc
	public void setPlayer(String name, String[] playerCards, int x, int y, int startPosition){
		_playerName = name;
		_playerCards = playerCards;
		_playerXCords = x;
		_playerYCords = y;
		_startPosition = startPosition;
		
	}
	//TODO Fill out Java doc
	public String getPlayerName(){
		return _playerName;
	}
	//TODO Fill out Java doc
	public String[] getPlayerCards(){
		return _playerCards;
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
	public boolean checkCards(String[] cards){ 
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
