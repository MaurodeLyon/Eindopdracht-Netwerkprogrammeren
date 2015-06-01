package model;

import view.Frame;
import view.HostPanel;
import view.Menu;

public class Host {

	private HostPanel hostPanel;

	public Host(Frame frame, Menu menu) {
		hostPanel = new HostPanel();
		frame.remove(menu);
		frame.setContentPane(hostPanel);
		frame.revalidate();
	}
}
