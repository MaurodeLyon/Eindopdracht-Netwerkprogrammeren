package model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import view.Frame;
import view.GamePanel;
import view.Menu;
import controller.Controller;

public class Host {

	private GamePanel gamePanel;
	private ServerSocket server;
	private Socket socket;
	private NetworkDataManager dataManager;
	

	public Host(Frame frame, Menu menu) {
		gamePanel = new GamePanel();
		frame.remove(menu);
		frame.setContentPane(gamePanel);
		frame.addKeyListener(new Controller().getKeyboard());
		frame.revalidate();
		
		Init();
		gamePanel.repaint();
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
		
		dataManager = new NetworkDataManager(socket);
		dataManager.start();
		
	}
}
