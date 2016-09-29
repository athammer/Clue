package code.player;

public class Player {
	String _playerName;
	String[] _playerCards;
	Object[][] _playerLocation;
	int _startPosition;
	boolean _loserPlayer = false;
	
	public Player(){

	}
	public void setPlayer(String name, String[] playerCards, Object[][] startLocation, int startPosition){
		_playerName = name;
		_playerCards = playerCards;
		_playerLocation = startLocation;
		_startPosition = startPosition;
		
	}
	public String getPlayerName(){
		return _playerName;
	}
	public String[] getPlayerCards(){
		return _playerCards;
	}
	public Object[][] getPlayerLocation(){
		return _playerLocation;
	}
	public boolean getDidPlayerLose(){
		return _loserPlayer;
	}
	
	public boolean setLoserPlayer(boolean b){
		_loserPlayer = b;
		return b;
	}
	
}
