package DataInteraction;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReadMessageThread extends Thread{

	private boolean flag;
	
	private Socket socket;
	public ReadMessageThread(Socket socket, boolean flag) {
		this.socket = socket;
		this.flag = flag;
	}
	
	public void run() {
		
		while(flag) {
			try {
				DataInputStream in;
				
				in = new DataInputStream(socket.getInputStream());
				String readMsg = in.readUTF();
				
				System.out.println(readMsg);
			} catch (IOException e) {
				clientClose();
				e.printStackTrace();
			}
			
		}
	}
	
	public void clientClose() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
