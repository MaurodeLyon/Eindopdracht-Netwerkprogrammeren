package controller;

public class Controller {

	private Keyboard keyboard;

	public Controller() {
		keyboard = new Keyboard(this);
	}

	public Keyboard getKeyboard() {
		return keyboard;
	}

	public void Up() {
		System.out.println("Up");
	}

	public void Down() {
		System.out.println("Down");
	}

	public void Released() {
		System.out.println("Released");
	}
}
