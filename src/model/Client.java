package model;

import view.ClientPanel;
import view.Frame;
import view.Menu;

public class Client {

	private Frame frame;
	private ClientPanel clientPanel;

	public Client(Frame frame, Menu menu) {
		this.frame = frame;
		clientPanel = new ClientPanel();
		frame.getContentPane().remove(menu);
		frame.getContentPane().add(clientPanel);
	}
}
