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

	public Client(Frame frame, Menu menu) {
		clientPanel = new GamePanel();
		controller =new Controller(clientPanel,false); 
		frame.remove(menu);
		frame.setContentPane(clientPanel);
		frame.addKeyListener(controller.getKeyboard());
		frame.revalidate();
		Init();
	}

	public void Init() {
		try {
			socket = new Socket("145.102.72.143", 8888);
		} catch (IOException e) {
			e.printStackTrace();
		}
		dataManager = new NetworkDataManager(socket,false,clientPanel);
		dataManager.start();
	}
}
