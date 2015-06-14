package recusiveDrawing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class Square extends JPanel {

	private static final long serialVersionUID = -5882555850377639905L;

	private int order;

	public Square() {
		setPreferredSize(new Dimension(500, 500));
		order = 10;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Point p1 = new Point(getWidth() / 4, getHeight() / 4);
		Point p2 = new Point(getWidth() / 4 + getWidth() / 2, getHeight() / 4);
		Point p3 = new Point(getWidth() / 4 + getWidth() / 2, getHeight() - getHeight() / 4);
		Point p4 = new Point(getWidth() / 4, getHeight() - getHeight() / 4);

		displaySquares(g, order, p1, p2, p3, p4);
	}

	private void displaySquares(Graphics g, int order, Point p1, Point p2, Point p3, Point p4) {
		if (order >= 0) {
			g.drawLine(p1.x, p1.y, p2.x, p2.y);
			g.drawLine(p2.x, p2.y, p3.x, p3.y);
			g.drawLine(p3.x, p3.y, p4.x, p4.y);
			g.drawLine(p4.x, p4.y, p1.x, p1.y);
			Point p12 = getMidPoint(p1, p2);
			Point p23 = getMidPoint(p2, p3);
			Point p34 = getMidPoint(p3, p4);
			Point p41 = getMidPoint(p4, p1);
			displaySquares(g, order - 1 , p12, p23, p34, p41);
		}
	}

	private Point getMidPoint(Point p1, Point p2) {
		return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
	}
}
