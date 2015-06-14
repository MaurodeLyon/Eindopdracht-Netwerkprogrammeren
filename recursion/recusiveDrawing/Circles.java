package recusiveDrawing;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Circles extends JPanel {

	private static final long serialVersionUID = -5882555850377639905L;

	private int order;

	public Circles() {
		setPreferredSize(new Dimension(500, 500));
		order = 4;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int size = 200;
		int x = getWidth() / 2;
		int y = getHeight() / 2;
		displayOval(g, order, x, y, size);
	}

	private void displayOval(Graphics g, int order, int x, int y, int size) {
		if (order >= 0) {
			g.drawOval(x - size / 2, y - size / 2, size, size);
			g.drawOval(x - size / 4 - size, y - size / 4, size / 2, size / 2);
			g.drawOval(x - size / 4 + size, y - size / 4, size / 2, size / 2);
			displayOval(g, order - 1, x, y, size / 2);
		}
	}
}
