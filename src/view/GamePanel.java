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
	private Rectangle2D Ball;
	private Rectangle2D map;
	
	private boolean isHeadingR=true;
	private boolean isHeadingU=true;
	private int angle=0;

	public GamePanel() {
		new Timer(1000 / 60, this).start();
		setSize(new Dimension(1080, 720));
		setPreferredSize(new Dimension(1080, 720));
		setBackground(Color.BLACK);
		Player1 = new Rectangle2D.Double(30, getHeight() / 2, 10, 50);
		Player2 = new Rectangle2D.Double(getWidth() - 40, getHeight() / 2, 10,50);
		Ball = new Rectangle2D.Double(getWidth() / 2, getHeight() / 2, 20, 20);
		map = new Rectangle2D.Float(20f, 20f, 1040f, 680f);
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
		g2.setColor(Color.WHITE);
		
		g2.fill(Ball);
		
	}

	private void drawMap(Graphics2D g2) {
		
		g2.setColor(Color.WHITE);
		g2.setStroke(new BasicStroke(9, BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL, 0));
		g2.draw((Shape) map);
		g2.setStroke(new BasicStroke(9, BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL, 0, new float[] { 9 }, 0));
		g2.drawLine(1080 / 2, 20, 1080 / 2, 700);
	}

	public void setPlayer1(Rectangle2D player1) {
		Player1 = player1;
	}

	public void setPlayer2(Rectangle2D player2) {
		Player2 = player2;
	}

	public void setBall(Rectangle2D ball) {
		Ball = ball;
	}

	public Rectangle2D getBall() {
		return Ball;
	}

	public Rectangle2D getPlayer1() {
		return Player1;
	}

	public Rectangle2D getPlayer2() {
		return Player2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		if(isHeadingR)
		{
			if(Player2.intersects(Ball) ||!map.contains(Ball))
			{
				isHeadingR=false;
				isHeadingU=!isHeadingU;
			}
			if(isHeadingU)
			{
				Ball.setRect(Ball.getX()+1, Ball.getY()+1,Ball.getWidth(), Ball.getHeight());
			}
			else
			{
				Ball.setRect(Ball.getX()+1, Ball.getY()-1,Ball.getWidth(), Ball.getHeight());
			}
			
		}
		else
		{
			if(Player1.intersects(Ball) || !map.contains(Ball))
			{
				isHeadingR=true;
				isHeadingU=!isHeadingU;
			}
			
			if(isHeadingU)
			{
				Ball.setRect(Ball.getX()-1, Ball.getY()+1,Ball.getWidth(), Ball.getHeight());
			}
			else
			{
				Ball.setRect(Ball.getX()-1, Ball.getY()-1,Ball.getWidth(), Ball.getHeight());
			}
		}
		
	}

}
