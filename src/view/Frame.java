package view;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Frame extends JFrame {

	public Frame(){
		super("Pung");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().add(new Menu(this));
		
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
