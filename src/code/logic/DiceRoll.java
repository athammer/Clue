package code.logic;

import java.util.Random;

public class DiceRoll {
	
	//TODO Fill out Java doc
	public int rollOneDice(){
		Random rand = new Random();
		int randomNum = rand.nextInt((6 - 1) + 1) + 1;
		return randomNum; //TODO should do a check to see if this is really 1-6
	}
	
	//TODO Fill out Java doc
	public int[] rollTwoDice(){
		Random rand = new Random();
		int[] dicerolls = new int[1];
		int randomNum = rand.nextInt((6 - 1) + 1) + 1;
		int randomNum1 = rand.nextInt((6 - 1) + 1) + 1;
		dicerolls[0] = randomNum;
		dicerolls[1] = randomNum1;
		return dicerolls; //TODO should do a check to see if this is really 1-6
	}

}
