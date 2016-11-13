package code;

import code.board.Board;
import code.gui.GUI;

public class MainGUI {
	//only for testing gui
	public static void main(String[] args) throws Exception{
		Board board = new Board();
		GUI gui = new GUI(board.getBoard());
		gui.popUpExampleString();
		gui.popUpExampleBoolean();
	}

}
