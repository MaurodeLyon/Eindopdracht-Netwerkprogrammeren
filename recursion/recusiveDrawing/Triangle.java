package recusiveDrawing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class Triangle extends JPanel {

	private static final long serialVersionUID = -5882555850377639905L;

	private int order;

	public Triangle() {
		setPreferredSize(new Dimension(500, 500));
		order = 6;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Point p1 = new Point(getWidth() / 2, 10);
		Point p2 = new Point(10, getHeight() - 10);
		Point p3 = new Point(getWidth() - 10, getHeight() - 10);

		displayTriangles(g, order, p1, p2, p3);
	}

	private void displayTriangles(Graphics g, int order, Point p1, Point p2,
			Point p3) {
		if (order >= 0) {
			g.drawLine(p1.x, p1.y, p2.x, p2.y);
			g.drawLine(p1.x, p1.y, p3.x, p3.y);
			g.drawLine(p2.x, p2.y, p3.x, p3.y);
			Point p12 = getMidPoint(p1, p2);
			Point p23 = getMidPoint(p2, p3);
			Point p31 = getMidPoint(p3, p1);
			displayTriangles(g, order - 1, p1, p12, p31);
			displayTriangles(g, order - 1, p12, p2, p23);
			displayTriangles(g, order - 1, p31, p23, p3);
		}
	}

	private Point getMidPoint(Point p1, Point p2) {
		return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
	}
}
