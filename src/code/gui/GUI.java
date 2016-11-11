package code.gui;

import java.awt.*;

import javax.*;
import javax.swing.*;

public class GUI {
	public GUI(){
		JFrame f = new JFrame("Clue - Aaron H, Zee, Adam S, Garret");  
		f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	    f.setLayout(null);  
	    f.setVisible(true);  
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		
	}
	
	public void popUpExampleString(){
        final JFrame parent = new JFrame();
        JButton button = new JButton("name here");
        String name = JOptionPane.showInputDialog(parent, "test", null);
        parent.pack();
        parent.setVisible(true);
        parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //if they close it without doing an option request it.
	}
	
	public void popUpExampleBoolean(){
        final JFrame parent = new JFrame("name here");
        JButton button = new JButton();
        int value = JOptionPane.showConfirmDialog(null, "No", "Yes", JOptionPane.YES_NO_OPTION);
        if(value == 1){
        	//yes
        }else if(value == 0){
        	//no
        }else{
        	//welp
        }
        
        parent.pack();
        parent.setVisible(true);
        parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //if they close it without doing an option request it.
	}

}
