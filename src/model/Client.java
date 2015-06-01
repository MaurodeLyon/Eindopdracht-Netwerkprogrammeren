package model;

import view.ClientPanel;
import view.Frame;
import view.Menu;

public class Client {

	private ClientPanel clientPanel;

	public Client(Frame frame, Menu menu) {
		clientPanel = new ClientPanel();
		frame.remove(menu);
		frame.setContentPane(clientPanel);
		frame.revalidate();
	}
}
