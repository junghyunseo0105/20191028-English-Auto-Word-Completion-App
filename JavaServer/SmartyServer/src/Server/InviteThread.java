package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class InviteThread extends Thread{
	private Socket socket;
	private ServerSocket serverSocket;
	
	private boolean flag;
	
	public InviteThread(ServerSocket serverSocket, boolean flag) {
		this.serverSocket = serverSocket;
		this.flag = flag;
	}
	
	public void run() {
		while(flag) {
			try {
				System.out.println("대기중...");
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress() + "에 접속하였습니다.");
				
				LoopThread loopThread = new LoopThread(socket, flag);
				loopThread.start();
			} catch(IOException e) {e.printStackTrace();}
		}
	}
	
}
