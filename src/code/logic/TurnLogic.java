package code.logic;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import code.Main;
import code.board.Board;
import code.gui.GUI;
import code.gui.LetGuessOnTurnEnd;
import code.player.Player;


//how a players turn should go
public class TurnLogic {


	public void completeTurn(Player player, Board board, GUI gui) throws InterruptedException{
		Main.reBounce = 0;
		DiceRoll dice = new DiceRoll();
		PlayerLogic playerLogic = new PlayerLogic();
		int diceRoll = dice.rollOneDice();
		player.setMovesLeft(diceRoll);
		gui.getNumberMovesLeft().setText("" + diceRoll);
		gui.getNumberMovesLeft().repaint();
		gui.getPlayerName().setText("" + player.getCharacterName());
		gui.getPlayerName().repaint();
		String roomName = board.getSpecialRoom(player.getPlayerXCord(), player.getPlayerYCord()); 
		
		//get user input of where they want to go
		
		int playerMoves = player.getMovesLeft();
		while(playerMoves != 0){
			//wait for them to click and update
			playerMoves = player.getMovesLeft();
			gui.getNumberMovesLeft().setText(playerMoves +"");
			gui.getNumberMovesLeft().repaint();
		}
		long i = 0;
		while(board.isSpecialRoom(player.getPlayerXCord(), player.getPlayerYCord()) && player.getMovesLeft() == 0 && Main.reBounce != 1){
			if(i == 0){
				LetGuessOnTurnEnd popUp = new LetGuessOnTurnEnd();
			}
			TimeUnit.SECONDS.sleep(1);
			System.out.println(Main.reBounce);
			i = i + 1;
		}
		
		

		
		//let players guess with no turns left
		//make sure when players enter a room they cant move anymore????
		
	}

	

}
