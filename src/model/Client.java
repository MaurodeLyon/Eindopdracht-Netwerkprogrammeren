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

	public Client(Frame frame, Menu menu) {
		clientPanel = new GamePanel();
		frame.remove(menu);
		frame.setContentPane(clientPanel);
		frame.addKeyListener(new Controller().getKeyboard());
		frame.revalidate();
		Init();
	}
	
	public void Init()
	{
		
		try {
			socket = new Socket("localhost",8888);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dataManager = new NetworkDataManager(socket);
		dataManager.start();
		
	}
}
