package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import DataFile.WordFile;
import Gui.Gui;
import Storage.DataHandler;

public class InviteThread extends Thread{
	private Socket socket;
	private ServerSocket serverSocket;
	private WordFile wordFile;
	private Gui gui;
	private DataHandler dataHandler;
	
	private boolean flag;
	
	public InviteThread(ServerSocket serverSocket, WordFile wordFile, Gui gui, DataHandler dataHandler, boolean flag) {
		this.serverSocket = serverSocket;
		this.wordFile = wordFile;
		this.flag = flag;
		this.gui = gui;
		this.dataHandler = dataHandler;
	}
	
	public void run() {
		while(flag) {
			try {
				System.out.println("대기중...");
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress() + "에 접속하였습니다.");
				
				LoopThread loopThread = new LoopThread(socket, wordFile, flag, gui, dataHandler);
				loopThread.start();
			} catch(IOException e) {e.printStackTrace();}
		}
	}
	
}
