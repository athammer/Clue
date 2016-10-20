package code.logic;

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
			
		
}
	
	
	
	
	

