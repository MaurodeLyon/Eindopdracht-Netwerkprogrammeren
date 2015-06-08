package model;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import view.GamePanel;

public class NetworkDataManager implements Runnable {

	private boolean running;
	private Thread thread;
	private Socket socket;

	private boolean isHost;
	private GamePanel panel;

	private DataInputStream in;
	private DataOutputStream out;

	public NetworkDataManager(Socket socket, boolean isHost, GamePanel panel) {
		this.socket = socket;
		this.isHost = isHost;
		this.panel = panel;
		try {
			in = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		double fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			if (delta >= 1) {
				if (isHost) {
					try {
						updateHost();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					try {
						updateClient();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}

		stop();
	}

	private void updateClient() throws IOException {
		out.writeDouble(panel.getPlayer2().getY());
		
		if (in.available() > 0) {
			double ballX = in.readDouble();
			double ballY = in.readDouble();

			panel.setBall(new Ellipse2D.Double(ballX, ballY, 20, 20));

			double player1y = in.readDouble();
			panel.setPlayer1(new Rectangle2D.Double(30, player1y, 10, 50));
		}

	}

	private void updateHost() throws IOException {
		// send position ball
		out.writeDouble(panel.getBall().getX());
		out.writeDouble(panel.getBall().getY());
		// send own position
		out.writeDouble(panel.getPlayer1().getY());
		// receive position player2
		if (in.available() > 0) {
			double player2y = in.readDouble();
			panel.getPlayer2().setRect(1080 - 40, player2y, 10, 50);
		}
	}

	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
		System.out.println("it started");

	}

	public synchronized void stop() {
		if (!running) {
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
