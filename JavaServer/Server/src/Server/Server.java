package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import Gui.MainGui;

public class Server {
	private ServerSocket serverSocket;
	private int port = 0;
	private boolean isOpen = false;
	private MainGui mainGui;
	
	public Server(MainGui mainGui, int port) {
		this.mainGui = mainGui;
		this.port = port;
	}
	
	public void start() {
		if(port == 0) return;
		
		try {
			serverSocket = new ServerSocket(port);
			
			invite();
			
			isOpen = true;
			System.out.println("Class server.start!");
			setText("Class server.start!");
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void stop() {
		try {
			serverSocket.close();
			
			inviteThread.stop();
			
			isOpen = false;
			System.out.println("Class server.stop");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private InviteThread inviteThread;
	
	public void invite() {
		inviteThread = new InviteThread(serverSocket, true);
		inviteThread.start();
	}
	
	public boolean getOpen() {
		return isOpen;
	}
	
	public void setText(String msg) {
		mainGui.setText(msg);
	}
}
