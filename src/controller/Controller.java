package controller;

import java.awt.geom.Rectangle2D;

import view.GamePanel;

public class Controller {

	private Keyboard keyboard;
	private GamePanel panel;
	private boolean isHost;

	public Controller(GamePanel gamePanel,boolean isHost) {
		keyboard = new Keyboard(this);
		this.panel=gamePanel;
		this.isHost = isHost;
	}

	public Keyboard getKeyboard() {
		return keyboard;
	}

	public void Up() {
		System.out.println("Up");
		if(isHost)
		{
			panel.setPlayer1(new Rectangle2D.Double(30, panel.getPlayer1().getY()+1, 10, 50));
		}
		else
		{
			panel.setPlayer2( new Rectangle2D.Double(1080 - 40, panel.getPlayer2().getY()+1, 10,50));
		}
		
	}

	public void Down() {
		System.out.println("Down");
		if(isHost)
		{
			panel.setPlayer1(new Rectangle2D.Double(30, panel.getPlayer1().getY()-1, 10, 50));
		}
		else
		{
			panel.setPlayer2( new Rectangle2D.Double(1080 - 40, panel.getPlayer2().getY()-1, 10,50));
		}
	}

	public void Released() {
		//System.out.println("Released");
	}
}
