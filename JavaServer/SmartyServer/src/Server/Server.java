package Server;

import java.io.IOException;
import java.net.ServerSocket;

import Box.Box;

public class Server {
	private Box box;
	
	private int port;
	
	public Server(Box box, int port) {
		this.box = box;
		this.port = port;
	}
	
	public void start() {
		if(port == 0) return;
		
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			box.setServerSocket(serverSocket); 
			
			invite();
			
			System.out.println("Class server.start!");
		} catch (IOException e) {e.printStackTrace();}
	}
	
	
	private InviteThread inviteThread;
	
	public void invite() {
		inviteThread = new InviteThread(box);
		inviteThread.start();
		
	}
	
	public void asdf() {
		System.out.println("asfd");
	}
	
}
