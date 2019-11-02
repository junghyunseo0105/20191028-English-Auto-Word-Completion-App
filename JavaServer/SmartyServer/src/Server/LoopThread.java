package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class LoopThread extends Thread{

	private boolean flag;
	
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	
	public LoopThread(Socket socket, boolean flag) {
		this.socket = socket;
		this.flag = flag;
	}
	
	public void run() {
		
		while(flag) {
			String text = reciveMsg("recivemsg :");
			
		}
	}
	
	public String reciveMsg(String feedback) {
		try {
			in = new DataInputStream(socket.getInputStream());
			String readMsg = in.readUTF();
			System.out.println(feedback + readMsg);
			return readMsg;
			
		} catch (IOException e) {
			clientClose();
			e.printStackTrace();
		}
		return null;
	}
	
	public void clientClose() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
