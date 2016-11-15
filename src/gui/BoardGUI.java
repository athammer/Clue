package gui;
import java.awt.Color;
//import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder; 

import code.Main;
public class BoardGUI {

	JFrame boardFrame = new JFrame();
//	 boardframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	private JPanel boardDisplay = new JPanel();
	
	public void basicJFrameFeatures(JFrame boardFrame) {
		boardFrame = new JFrame();
		boardFrame.setVisible(true);
		boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boardFrame.setLayout(new BoxLayout(boardFrame.getContentPane(), (BoxLayout.Y_AXIS)));
//		boardFrame.add(_displays);
//		boardFrame.add(_guesses);
//		boardFrame.add(_controls);
//		_displays.setVisible(true);
//		_displays.setLayout(new BoxLayout(_displays, (BoxLayout.X_AXIS)));
//		_guesses.setLayout(new BoxLayout(_guesses, (BoxLayout.X_AXIS)));
//		_controls.setLayout(new BoxLayout(_controls, (BoxLayout.X_AXIS)));
		boardFrame.setSize(500, 500);
	}
	
}
