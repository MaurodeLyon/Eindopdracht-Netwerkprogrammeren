package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Client;
import model.Host;

@SuppressWarnings("serial")
public class Menu extends JPanel {

	private Frame frame;

	public Menu(Frame frame) {
		this.frame = frame;
		setPreferredSize(new Dimension(1080, 720));
		setLayout(new GridLayout(2, 1));

		JButton client = new JButton("Join");
		client.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setClient();
			}
		});
		add(client);

		JButton host = new JButton("Host");
		host.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setHost();
			}
		});
		add(host);
	}

	protected void setHost() {
		new Host(frame, this);
	}

	protected void setClient() {
		new Client(frame, this);
	}
}
