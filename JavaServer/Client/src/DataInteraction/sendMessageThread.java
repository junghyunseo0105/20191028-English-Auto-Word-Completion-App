package DataInteraction;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class sendMessageThread extends Thread{

	private Socket socket;
	private boolean flag;
	private Scanner scanner;
	
	private String nickName;
	
	public sendMessageThread(Socket socket, boolean flag) {
		this.socket = socket;
		this.flag = flag;
		
	}
	
	public void run() {
		while(flag) {
			
			String msg = inputText("input :");
			sendMsg(msg);
		}
	}
	
	public String inputText(String feedback) {
		System.out.println(feedback);
		scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	public void sendMsg(String msg) {
		try {
			DataOutputStream out;
			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void infoSend() {
		String nickName = inputText("nickName :");
		
		this.nickName = nickName;
		sendMsg(nickName);
	}
}
