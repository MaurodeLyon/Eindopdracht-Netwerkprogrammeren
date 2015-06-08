package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements ActionListener {

	private Rectangle2D Player1;
	private Rectangle2D Player2;
	private Ellipse2D.Double ball;
	private Rectangle2D.Double map;

	private int speedX = 2;
	private int speedY = 2;

	public GamePanel() {
		new Timer(1000 / 60, this).start();
		setSize(new Dimension(1080, 720));
		setPreferredSize(new Dimension(1080, 720));
		setBackground(Color.BLACK);
		Player1 = new Rectangle2D.Double(30, getHeight() / 2, 10, 50);
		Player2 = new Rectangle2D.Double(getWidth() - 40, getHeight() / 2, 10,
				50);
		ball = new Ellipse2D.Double(getWidth() / 2, getHeight() / 2, 20, 20);
		map = new Rectangle2D.Double(20f, 20f, 1040f, 680f);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		drawMap(g2);
		drawEntities(g2);
	}

	private void drawEntities(Graphics2D g2) {
		g2.setColor(Color.RED);
		g2.fill(Player1);
		g2.setColor(Color.BLUE);
		g2.fill(Player2);
		g2.setColor(Color.ORANGE);
		g2.fill(ball);

	}

	private void drawMap(Graphics2D g2) {
		g2.setColor(Color.WHITE);
		g2.setStroke(new BasicStroke(9, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_BEVEL, 0));
		g2.draw((Shape) map);
		g2.setStroke(new BasicStroke(9, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_BEVEL, 0, new float[] { 9 }, 0));
		g2.drawLine(1080 / 2, 20, 1080 / 2, 700);
	}

	public void setPlayer1(Rectangle2D player1) {
		Player1 = player1;
	}

	public void setPlayer2(Rectangle2D player2) {
		Player2 = player2;
	}

	public void setBall(Ellipse2D.Double ball) {
		this.ball = ball;
	}

	public Ellipse2D.Double getBall() {
		return ball;
	}

	public Rectangle2D getPlayer1() {
		return Player1;
	}

	public Rectangle2D getPlayer2() {
		return Player2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ball.x += speedX;
		ball.y += speedY;

		// checks if ball touches left border
		if (ball.x < map.x) {
			ball = new Ellipse2D.Double(getWidth() / 2, getHeight() / 2, 20, 20);
			//point for player 2
		}

		// checks if ball touches right border
		if (ball.x + ball.width > map.x + map.width) {
			ball = new Ellipse2D.Double(getWidth() / 2, getHeight() / 2, 20, 20);
			//point for player 1
		}

		// check if ball touches top border
		if (ball.y < map.y) {
			speedY = -speedY;
			//speedX = -5 + (int) (Math.random() * 10);
		}

		// checks if ball touches bottem border
		if (ball.y + ball.width > map.y + map.height) {
			speedY = -speedY;
			//speedX = -5 + (int) (Math.random() * 10);
		}

		// checks if ball touches left player
		if (Player1.getY() < ball.y
		 && Player1.getY() + Player1.getHeight() > ball.y
		 && Player1.getX() + Player1.getWidth() > ball.x) {
			speedX = -speedX;
			//speedY = -5 + (int) (Math.random() * 10);
		}
		
		if (Player2.getY() < ball.y
		 && Player2.getY() + Player1.getHeight() > ball.y
		 && Player2.getX() < ball.x + ball.width) {
			speedX = -speedX;
			//speedY = -5 + (int) (Math.random() * 10);
		}

		repaint();
	}

}
