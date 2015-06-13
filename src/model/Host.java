package model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import view.Frame;
import view.GamePanel;
import view.Menu;
import wiiusej.WiiUseApiManager;
import wiiusej.Wiimote;
import controller.Controller;

public class Host {

	private GamePanel gamePanel;
	private ServerSocket server;
	private Socket socket;
	private NetworkDataManager dataManager;
	private Controller controller;
	private Frame frame;
	private Wiimote wiimote;
	private ScoreIndependent score1,score2;
	
	
	

	public Host(Frame frame, Menu menu) {
		this.frame = frame;
		score1 = new ScoreIndependent(0);
		score2= new ScoreIndependent(0);
		gamePanel = new GamePanel(score1,score2,true);
		controller= new Controller(gamePanel,true);
		this.frame.remove(menu);
		this.frame.setContentPane(gamePanel);
		//connectWiimote();
		//wiimote.addWiiMoteEventListeners(controller.getWiimote());
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
	
	public void Init()
	{
		try {
			server= new ServerSocket(8888);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			socket = server.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
		dataManager = new NetworkDataManager(socket,true,gamePanel);
		dataManager.start();
	}
}
