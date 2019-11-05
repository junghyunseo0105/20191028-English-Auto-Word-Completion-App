package Server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.xml.crypto.Data;

import DataFile.WordFile;
import Gui.Gui;
import Storage.DataHandler;

public class Server {
	private ServerSocket serverSocket;
	private Gui gui;
	private WordFile wordFile;
	private DataHandler dataHandler;
	
	private int port;
	private boolean isOpen = false;
	
	public Server(Gui gui, WordFile wordFile, int port, DataHandler dataHandler) {
		this.gui = gui;
		this.wordFile = wordFile;
		this.port = port;
		this.dataHandler = dataHandler;
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
			inviteThread.stop();
			isOpen = false;
			System.out.println("Class server.stop");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private InviteThread inviteThread;
	
	public void invite() {
		inviteThread = new InviteThread(serverSocket, wordFile, gui, dataHandler, true);
		inviteThread.start();
		
	}
	
	public boolean getOpen() {
		return false;
	}
	
	public void asdf() {
		System.out.println("asfd");
	}
	
}
