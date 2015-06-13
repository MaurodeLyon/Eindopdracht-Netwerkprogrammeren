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
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.Score;
import model.ScoreIndependent;



@SuppressWarnings("serial")
public class GamePanel extends JPanel implements ActionListener {

	private Rectangle2D Player1;
	private Rectangle2D Player2;
	private Ellipse2D.Double ball;
	private Rectangle2D.Double map;

	private int speedX = 2;
	private int speedY = 2;
	
	private boolean isHost;
	
	private ScoreIndependent score1,score2;
	private boolean player2Wins=false;
	private boolean player1Wins=false;
	
	private BufferedImage winScreen;

	public GamePanel(ScoreIndependent score1,ScoreIndependent score2, boolean b) {
		isHost=b;
		this.score1=score1;
		this.score2=score2;
		new Timer(1000 / 60, this).start();
		setSize(new Dimension(1080, 720));
		setPreferredSize(new Dimension(1080, 720));
		setBackground(Color.BLACK);
		Player1 = new Rectangle2D.Double(30, getHeight() / 2, 10, 50);
		Player2 = new Rectangle2D.Double(getWidth() - 40, getHeight() / 2, 10,
				50);
		ball = new Ellipse2D.Double(getWidth() / 2, getHeight() / 2, 20, 20);
		map = new Rectangle2D.Double(20f, 20f, 1040f, 680f);
		
		
		try {
			winScreen = ImageIO.read(this.getClass().getResource("/waitingScreen3.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		drawMap(g2);
		drawEntities(g2);
		drawScore(g2);
		
		g2.setFont(FontLoader.customFont.deriveFont(72f));
		if(player1Wins)
		{
			g2.setColor(Color.BLACK);
			g2.drawImage(winScreen, 0,0,1080,720,null);
			g2.drawString("P1 WON!", (1080/2) - (g2.getFontMetrics().stringWidth("P1 WON!")/2),(720/2) - g2.getFontMetrics().getHeight()/2);
		}
		if(player2Wins)
		{
			g2.drawImage(winScreen, 0,0,1080,720,null);
			g2.drawString("P2 WON!", (1080/2) - (g2.getFontMetrics().stringWidth("P2 WON!")/2),(720/2) - g2.getFontMetrics().getHeight()/2);
		}
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
	
	private void drawScore(Graphics2D g2)
	{
		g2.setColor(Color.WHITE);
		g2.setFont(FontLoader.customFont.deriveFont(22f));
		g2.drawString(String.valueOf(score1.getScore()), 540-80, 80);
		g2.drawString(String.valueOf(score2.getScore()), 540+80, 80);
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
		if(isHost)
		{
			ball.x += speedX;
			ball.y += speedY;

			// checks if ball touches left border
			if (ball.x < map.x) {
				ball = new Ellipse2D.Double(getWidth() / 2, getHeight() / 2, 20, 20);
				//point for player 2
				//if(isHost)
					score2.IncreaseScore();
			}	

			// checks if ball touches right border
			if (ball.x + ball.width > map.x + map.width) {
				ball = new Ellipse2D.Double(getWidth() / 2, getHeight() / 2, 20, 20);
				//point for player 1
				//if(isHost)
					score1.IncreaseScore();
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
		}
		
		if(score1.getScore() ==5 || score2.getScore() ==5)
		{
			switch(score1.compareTo(score2))
			{
			case -1:
				player2Wins=true;
				break;
			case 1:
				player1Wins=true;
				break;
		
			}
		}

		repaint();
		
		
	}
	
	public ScoreIndependent getScore1()
	{
		return score1;
	}
	public ScoreIndependent getScore2()
	{
		return score2;
	}
	
	public void setScore1(ScoreIndependent score)
	{
		this.score1=score;
	}
	public void setScore2(ScoreIndependent score)
	{
		this.score2=score;
	}

}
