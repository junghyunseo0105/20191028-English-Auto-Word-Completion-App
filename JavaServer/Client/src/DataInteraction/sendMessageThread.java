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
			
			String str = "Dear Sir or Madam:\r\n" + 
					"I am writing in response to your advertisement in the Columbia Journal Classifieds\r\n" + 
					"for a copywriter. I am a copywriter with 8 years¡¯ experience of conceptualizing and\r\n" + 
					"producing engaging copy for catalogs, annual reports, brochures and all types of\r\n" + 
					"collateral material. In addition, my writing abilities have helped me create original works\r\n" + 
					"of art for clients like Mead Coated Papers and Oxford Healthcare. I am knowledgeable\r\n" + 
					"about MS Word and WordPerfect, as well as both Macintosh and PC platforms. Much of\r\n" + 
					"my work has been crafted for the following clients: Macmillan Reference Library, Watson\r\n" + 
					"Guptill Publications, Hawaii University Press, and Arcade Fashion & Lifestyle Magazine.\r\n" + 
					"I have confidence in my ability to produce powerful, gripping copy for your organization.\r\n" + 
					"My experience allows me to complete any project from concept to the final stages at a\r\n" + 
					"fast pace to meet deadlines, and to package it for the Web. I look forward to hearing from\r\n" + 
					"you. Thank you for your time and consideration.\r\n" + 
					"Yours sincerely,\r\n" + 
					"Raleigh Collins";
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
