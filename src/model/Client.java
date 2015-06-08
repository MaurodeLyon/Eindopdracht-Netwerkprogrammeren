package model;

import java.io.IOException;
import java.net.Socket;

import view.Frame;
import view.GamePanel;
import view.Menu;
import wiiusej.WiiUseApiManager;
import wiiusej.Wiimote;
import controller.Controller;

public class Client {

	private GamePanel clientPanel;
	private Socket socket;
	private NetworkDataManager dataManager;
	private Controller controller;
	private Frame frame;
	private Wiimote wiimote;

	public Client(Frame frame, Menu menu) {
		this.frame = frame;
		clientPanel = new GamePanel();
		controller =new Controller(clientPanel,false); 
		this.frame.remove(menu);
		this.frame.setContentPane(clientPanel);
		connectWiimote();
		wiimote.addWiiMoteEventListeners(controller.getWiimote());
		this.frame.addKeyListener(controller.getKeyboard());
		this.frame.revalidate();
		Init();
		this.frame.requestFocus();
	}
	
	private void connectWiimote() {
		Wiimote[] wiimotes = WiiUseApiManager.getWiimotes(1, true);
		if (wiimotes.length != 0) {
			wiimote = wiimotes[0];
			wiimote.setLeds(true, true, true, true);
			wiimote.activateMotionSensing();
		}
	}

	public void Init() {
		try {
			socket = new Socket("localhost", 8888);
		} catch (IOException e) {
			e.printStackTrace();
		}
		dataManager = new NetworkDataManager(socket,false,clientPanel);
		dataManager.start();
		
	}
}
