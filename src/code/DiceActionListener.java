package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import code.logic.DiceRoll;

public class DiceActionListener implements ActionListener {

	public void actionPerformed(ActionEvent arg0) {
		DiceRoll rand = new DiceRoll();
		rand.rollOneDice();
		}
	

}
