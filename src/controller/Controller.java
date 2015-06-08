package controller;

import java.awt.geom.Rectangle2D;

import view.GamePanel;

public class Controller {

	private Keyboard keyboard;
	private Wiimote wiimote;
	private GamePanel panel;
	private boolean isHost;
	private float magnitude;

	public Controller(GamePanel gamePanel, boolean isHost) {
		keyboard = new Keyboard(this);
		wiimote = new Wiimote(this);
		this.panel = gamePanel;
		this.isHost = isHost;
	}

	public Keyboard getKeyboard() {
		return keyboard;
	}

	public Wiimote getWiimote() {
		return wiimote;
	}

	public void Up() {
		if (isHost) {
			if (panel.getPlayer1().getY() > 0) {
				panel.setPlayer1(new Rectangle2D.Double(30, panel.getPlayer1()
						.getY() - 10 * magnitude, 10, 50));
			} else {
				panel.setPlayer1(new Rectangle2D.Double(30, 1, 10, 50));
			}
		} else {
			if (panel.getPlayer2().getY() > 0) {
				panel.setPlayer2(new Rectangle2D.Double(1080 - 40, panel.getPlayer2().getY() - 10 * magnitude, 10, 50));
			} else {
				panel.setPlayer2(new Rectangle2D.Double(1080 - 40, 1, 10, 50));
			}
		}

	}

	public void Down() {
		if (isHost) {
			if (panel.getPlayer1().getY() + panel.getPlayer1().getHeight() < 720 ) {
				panel.setPlayer1(new Rectangle2D.Double(30, panel.getPlayer1().getY() + 10 * magnitude, 10, 50));
			} else {
				panel.setPlayer1(new Rectangle2D.Double(30, 720 - 50, 10, 50));
			}
		} else {
			if (panel.getPlayer2().getY() + panel.getPlayer2().getHeight() < 720) {
				panel.setPlayer2(new Rectangle2D.Double(1080 - 40, panel.getPlayer2().getY() + 10 * magnitude, 10, 50));
			} else {
				panel.setPlayer2(new Rectangle2D.Double(1080 - 40, 720 - 50,10, 50));
			}
		}
	}

	public void setMag(float magnitude) {
		this.magnitude = magnitude;
	}
}
