package model;

import view.Frame;
import view.HostPanel;

public class Host {

	private Frame frame;
	private HostPanel hostPanel;

	public Host(Frame frame) {
		this.frame = frame;
		hostPanel = new HostPanel();
	}
}
