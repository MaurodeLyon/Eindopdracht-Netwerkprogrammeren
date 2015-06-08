package model;

import java.io.IOException;
import java.net.Socket;

import view.GamePanel;
import view.Frame;
import view.Menu;
import controller.Controller;

public class Client {

	private GamePanel clientPanel;
	private Socket socket;
	private NetworkDataManager dataManager;
	private Controller controller;
	private Frame frame;

	public Client(Frame frame, Menu menu) {
		this.frame = frame;
		clientPanel = new GamePanel();
		controller =new Controller(clientPanel,false); 
		this.frame.remove(menu);
		this.frame.setContentPane(clientPanel);
		this.frame.addKeyListener(controller.getKeyboard());
		this.frame.revalidate();
		Init();
		this.frame.requestFocus();
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
