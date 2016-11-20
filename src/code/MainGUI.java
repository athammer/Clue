package code;
import java.awt.Color;
//import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder; 
import javax.swing.border.EmptyBorder;

import code.Main;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import code.board.Board;
import code.gui.GUI;
import code.player.Player;

public class MainGUI {
	//players should be guess all his cards for a normal guess but not for a final
	

	
	//only for testing gui
	public static void main(String[] args) throws Exception{
		Board board = new Board();
		GUI gui = new GUI(board.getBoard());

		
	}

}
