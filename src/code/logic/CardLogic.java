package code.logic;

import java.util.ArrayList;

import code.Main;
import code.player.Player;

public class CardLogic {

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
		
		return "Mismatch Error: card does not correspond to cards in deck.";
	}
	
	public ArrayList<String> findAllPlayersCards(ArrayList<String> cards, Player guessingPlayer /*player that is asking */){
		ArrayList<String> cardsFound = new ArrayList<String>();
		for(int i = 0; Main._playerArray.size() -1 > i; i++){
			if(guessingPlayer.getPlayerName().equals(Main._playerArray.get(i).getPlayerName())){
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
	
	
	
	
	

