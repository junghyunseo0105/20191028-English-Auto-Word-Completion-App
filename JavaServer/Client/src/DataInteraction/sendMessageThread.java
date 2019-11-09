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
			
			String str = "Writers can feel achingly alone, but I am tremendously fortunate to be part of\r\n" + 
					"wonderfully supportive scholarly, academic, and family groups. My deepest debts for this\r\n" + 
					"work are owed to those who have preceded me in establishing food studies as an accepted\r\n" + 
					"discipline. In countless ways, this work would not be possible without theirs. I have\r\n" + 
					"recommended many of their works in the suggestions for further reading that follow each\r\n" + 
					"entry and in the general suggestions that conclude the volume. But I have also benefited\r\n" + 
					"from the personal support and encouragement of many individuals— too many to name\r\n" + 
					"here — at gatherings such as the conference of the Association for the Study of Food\r\n" + 
					"and Society and the Oxford Symposium of Food and Cookery. A more welcoming and\r\n" + 
					"nurturing group of scholars cannot be imagined.";
			sendMsg(str);
			
			while(true);
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
