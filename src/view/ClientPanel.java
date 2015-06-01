package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ClientPanel extends JPanel{

	public ClientPanel(){
		setPreferredSize(new Dimension(1080, 720));
		setBackground(Color.RED);
	}
}
