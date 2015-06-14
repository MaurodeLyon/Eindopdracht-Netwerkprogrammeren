package recusiveDrawing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Panel extends JPanel {

	private static final long serialVersionUID = -5882555850377639905L;

	public Panel() {
		setPreferredSize(new Dimension(500, 500));

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		drawGrid(200, g2, 0, 0, 0, 1000);
	}

	private Graphics2D drawGrid(int i, Graphics2D g2, int X1, int Y1, int X2,int Y2) {
		if (i == 0) {
			return g2;
		} else {
			g2.drawLine(X1, Y1, X2, Y2);
			return drawGrid(i -= 1, g2, X1 + 10, Y1, X2 + 10, Y2);
		}

	}
}
