package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	public Controller controller;

	public Keyboard(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			controller.setMag(0.5f);
			controller.Up();
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			controller.setMag(0.5f);
			controller.Down();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
