package Main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import DataInteraction.ReadMessageThread;
import DataInteraction.sendMessageThread;

public class Main {
	
	private Socket socket;
	private int port;
	
	private sendMessageThread sendMessageThread_;
	private ReadMessageThread readMessageThread;
	
	public Main(int port) {
		try {
			this.port = port;
			socket = new Socket("127.0.0.1", port);
			
			System.out.println("접속 완료!");
			
			boolean flag = true;
			
			sendMessageThread_ = new sendMessageThread(socket, flag);
			readMessageThread = new ReadMessageThread(socket, flag);
			
			sendMessageThread_.infoSend();
			
			sendMessageThread_.start();
			readMessageThread.start();
			while(true);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new Main(1000);
	}
	
}
