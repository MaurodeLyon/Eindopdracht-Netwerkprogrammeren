package model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import view.Frame;
import view.HostPanel;
import view.Menu;

public class Host {

	private HostPanel hostPanel;
	private ServerSocket server;
	private Socket socket;
	private NetworkDataManager dataManager;
	

	public Host(Frame frame, Menu menu) {
		hostPanel = new HostPanel();
		frame.remove(menu);
		frame.setContentPane(hostPanel);
		frame.revalidate();
		Init();
	}
	
	public void Init()
	{
		try {
			server= new ServerSocket(8888);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			socket = server.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dataManager = new NetworkDataManager(socket);
		dataManager.start();
		
	}
}
