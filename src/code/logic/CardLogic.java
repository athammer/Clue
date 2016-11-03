package code.logic;

import java.util.ArrayList;

import code.Main;
import code.player.Player;

public class CardLogic {

	
	/**
	 * Used for getting the type of the card(person, place, weapon).
	 * @param  card The card in question you want to determine its' type.
	 * @return      Suspect, Weapon, Location, or null if none of the above.
	 */
	public String whatCardType(String card){
		if ((card == "Prof. Plum") || (card == "Colonel Mustard") || (card == "Mr. Green") || (card == "Mrs. Peacock") 
				|| (card == "Ms. Scarlet") || (card == "Mrs. White"))
			{ return "Suspect"; }
		
		else if ((card == "Rope") == (card == "Lead pipe") || (card == "Knife") || (card == "Wrench") || (card == "Candlestick")
				|| (card == "Pistol"))
			{ return "Weapon"; } 
		
		else if ((card == "Ballroom") || (card == "Conservatory") || (card == "Billiard Room") || (card == "Library") || 
				(card == "Study") || (card == "Hall") || (card == "Lounge") || (card == "Dining Room") || (card == "Kitchen"))
			{ return "Location"; }
		
		return null; //can return null on a string
	}
	
	
	/**
	 * Checks all players, other then the guesser, to see if someone has a card.
	 * @param  cards ArrayList of type string of the cards the player is guessing.
	 * @param  guessingPlayer The player that is guessing.
	 * @return An ArrayList of type string with the cards found, even if none where found.
	 */
	public ArrayList<String> findAllPlayersCards(ArrayList<String> cards, Player guessingPlayer /*player that is asking */){
		ArrayList<String> cardsFound = new ArrayList<String>();
		for(int i = 0; Main._playerArray.size() -1 > i; i++){
			if(guessingPlayer.getCharacterName().equals(Main._playerArray.get(i).getCharacterName())){
				//do nothing
			}else{
				for(String checkCard : cards){
					for(String playerCard : Main._playerArray.get(i).getPlayerCards()){
						if(checkCard.equals(playerCard)){
							cardsFound.add(checkCard);
							
						}
					}
					
				}
			}
			
		}
		return cardsFound;
	}	
}
	
	
	
	
	

