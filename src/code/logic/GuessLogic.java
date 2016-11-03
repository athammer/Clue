package code.logic;

import java.util.ArrayList;

import code.Main;
import code.board.Board;
import code.player.Player;

public class GuessLogic {
	
	/*
	 * Winning the game: 
If the Accusation is completely correct, that is, if you find in the envelope, all 3 cards that you just named, lay the cards face up on the table and you are the winner.

If the Accusation is incorrect 
Secretly return the three cards to the envelope replace it on the board. 

You may make no further moves in the game.

You remain as a player to contradict Suggestions made by other players.

If your token is blocking a door, move it into Room so that other players may enter.

Your opponents may continue to move your token into the various Rooms where they make Suggestions. 
  
	 */
	
	
	/**
	 * Used for letting players guess in a room. Players must be in a room to guess.
	 * @param  guessCards 	An ArrayList of type String with the 3 cards(place, weapon, person) the player guesses.
	 * @param  player 		Player of type player that is making a guess
	 * @param  roomName 	The current room the player is in(must guess this card).
	 * @return      A boolean value to whether the player has the cards.
	 * @throws Exception 
	 */
	public boolean makeAGuess(ArrayList<String> guessCards, Player player, String roomName){
		if(isValidGuess(guessCards, roomName)){
			PlayerLogic pLogic = new PlayerLogic();
			String next = pLogic.whosNext(player.getCharacterName());
			while(!next.equals(player.getCharacterName())){ //while player is not him/herself
				Player playerNext = pLogic.findPlayer(next);
				for(String card : playerNext.getPlayerCards()){
					for(String guessedCards : guessCards){
						if(card.equals(guessedCards)){
							//card found
							player.addKnownCards(guessedCards);
							player.addAllCards(guessedCards);
							//alert user that card was found and what it is
							return true;
						}
					}
				}
			}
			
		}
		return false;
		
	}
	
	/**
	 * Used for letting players guess in a room.
	 * <p> 
	 * If the player answers wrong he/she loses, as set by player.setLoserPlayer()
	 * @param  guessCards 	An ArrayList of type String with the 3 cards(place, weapon, person) the player guesses.
	 * @param  player 		Player of type player that is making a guess
	 * @param  roomName 	Used to make sure the player who guesses in a room guesses that room also.
	 * @return      A boolean value to whether the player has the cards.
	 * @throws Exception 
	 */
	public boolean makeAFinalGuess(ArrayList<String> guessCards, Player player, String roomName, Board board){
		if(makeAGuess(guessCards, player, roomName)){
			//player wins
			ArrayList<Player> winnerPlayer = new ArrayList<Player>();
			for(Player player1 : Main._activePlayers){
				if(player.equals(player1)){
					winnerPlayer.add(player1); //winner
				}
			}
			Main._activePlayers = winnerPlayer; //size should be one and game should end
		}else{
			//player loses
			player.setLoserPlayer(true);
			Main._activePlayers.remove(player);
			board.setBoard("empty", player.getPlayerXCord(), player.getPlayerYCord());//so user doesnt block any doors
			//rip
			
		}
		//Check if player is in the room where the 
		return false;
		
	}
	
	/**
	 * Checks if cards player guesses are in correct format.
	 * @param  guessCards 	An ArrayList of type String with the 3 cards(place, weapon, person) the player guesses.
	 * @param  roomName 	Used to make sure the player who guesses in a room guesses that room also.
	 * @return      A boolean value to whether the player has guess correctly.
	 * @throws Exception 
	 * 
	 */
	private boolean isValidGuess(ArrayList<String> guessCards, String roomName){
		//Check if player is in the room where the 
		int counter = 0;
		boolean cardFound = false;
		for(String card : guessCards){
			CardLogic cardLogic = new CardLogic();
			String cardType = cardLogic.whatCardType(card);
			if(cardType.equals("Suspect")){
				counter += 1;
			} else if(cardType.equals("Weapon")){
				counter += 1;
			} else if(cardType.equals("Location")){
				counter += 1;
			} else{
				return false;
				//card not found did user enter a bad card? this should not be allowed in the gui
			}
			
			if(roomName.equals(card)){
				cardFound = true;
			}
		}
		if(counter == 3 && cardFound == true){
			return true;
		}
		return false;
		
	}

}
