package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HostPanel extends JPanel {

	public HostPanel() {
		setPreferredSize(new Dimension(1080, 720));
		setBackground(Color.BLUE);
	}
}
