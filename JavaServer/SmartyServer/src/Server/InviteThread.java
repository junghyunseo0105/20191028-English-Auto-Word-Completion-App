package Server;

import java.io.IOException;
import java.net.Socket;

import Box.Box;

public class InviteThread extends Thread{
	private Box box;

	public InviteThread(Box box) {
		this.box = box;
	}
	
	public void run() {
		while(true) {
			try {
				System.out.println("�����...");
				Socket socket = box.getServerSocket().accept();
				System.out.println(socket.getInetAddress() + "�� �����Ͽ����ϴ�.");
				
				LoopThread loopThread = new LoopThread(socket, box);
				loopThread.start();
			} catch(IOException e) {e.printStackTrace();}
		}
	}
	
}
