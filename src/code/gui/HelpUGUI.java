package code.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class HelpUGUI {
	JFrame gameFrame = new JFrame("You need help.");
	private JTextField txtIfYouAre;
	public HelpUGUI(){
		gameFrame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setVisible(true);
		GroupLayout groupLayout = new GroupLayout(gameFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
		);
		
		txtIfYouAre = new JTextField();
		txtIfYouAre.setText("if you are having trouble ");
		txtIfYouAre.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(150)
					.addComponent(txtIfYouAre, GroupLayout.PREFERRED_SIZE, 453, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(49, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(141)
					.addComponent(txtIfYouAre, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(102, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		gameFrame.getContentPane().setLayout(groupLayout);
		
	}
}
