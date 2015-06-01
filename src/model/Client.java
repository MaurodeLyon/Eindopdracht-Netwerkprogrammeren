package model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import view.ClientPanel;
import view.Frame;
import view.Menu;

public class Client {

	private ClientPanel clientPanel;
	private Socket socket;
	private NetworkDataManager dataManager;

	public Client(Frame frame, Menu menu) {
		clientPanel = new ClientPanel();
		frame.remove(menu);
		frame.setContentPane(clientPanel);
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
