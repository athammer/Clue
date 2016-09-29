package code;

import java.util.Scanner;

public class Main {
	String[] _playerNames;
	public void Main(){
		Scanner scan = new Scanner(System.in); 
		System.out.println("How many players are playing (no more then 6)? ");
		int players = scan.nextInt();
		int i = 0;
		while(players > i){
			Scanner scan1 = new Scanner(System.in); 
			System.out.println("Enter player number " + (i+1) + ": "); 
			String playerName = scan1.nextLine();
			_playerNames[i] = playerName;
			i++;
		}
		//add a random number generator to see who goes first
	}
}
