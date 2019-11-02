package Server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;

import javax.xml.crypto.Data;

import Gui.Gui;
import Storage.DataHandler;

public class Server {
	private ServerSocket serverSocket;
	private int port;
	private boolean isOpen = false;
	private Gui gui;
	
	public Server(Gui gui, int port) {
		this.gui = gui;
		this.port = port;
		
	}
	
	public void start() {
		if(port == 0) return;
		
		try {
			serverSocket = new ServerSocket(port);
			
			invite();
			
			isOpen = true;
			System.out.println("Class server.start!");
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void stop() {
		try {
			serverSocket.close();
			
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
		return false;
	}
	
	public void asdf() {
		System.out.println("asfd");
	}
	
}
