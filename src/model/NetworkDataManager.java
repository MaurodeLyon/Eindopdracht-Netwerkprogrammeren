package model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class NetworkDataManager implements Runnable {

	private boolean running;
	private Thread thread;
	private Socket socket;
	
	private DataInputStream in;
	private DataOutputStream out;
	
	public NetworkDataManager(Socket socket)
	{
		this.socket=socket;
	}
	
	
	@Override
	public void run() {
		double fps = 60;
		double timePerTick = 1000000000/ fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running)
		{
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			if(delta >= 1)
			{
				
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000)
			{
			
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			
			}
		}
		
		stop();
	}
	
	public synchronized void start()
	{
		if(running)
		{
			return;
			
		}
		running = true;
		thread = new Thread(this);
		thread.start();
		System.out.println("it started");
		
	}
	
	public synchronized void stop()
	{
		if(!running)
		{
			return;
			
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}

}
