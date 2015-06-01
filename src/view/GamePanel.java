package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel{

	public GamePanel(){
		setPreferredSize(new Dimension(1080, 720));
		setBackground(Color.RED);
	}
}
