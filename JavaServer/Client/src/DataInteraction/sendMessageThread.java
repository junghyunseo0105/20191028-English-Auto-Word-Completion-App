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
			
			String str = "Three-year-olds don’t have to deal with the same rules and realities adults do. Because\r\n" + 
					"of that, children tend to be more imaginative and creative with their ideas. They see\r\n" + 
					"possibilities where the rest of us see rules, boundaries, or impossibilities. That’s why\r\n" + 
					"they’re famous for writing on walls — you see a perfectly painted living room that\r\n" + 
					"shouldn’t be touched; they see a blank canvas. Even if it’s just for 30 minutes, seeing\r\n" + 
					"life from the angle of a semi-careless child can give you a new perspective on how you\r\n" + 
					"spend your time and deal with household problems or work challenges. For that reason\r\n" + 
					"alone, it’s valuable to imagine yourself acting as you would if you were just a child: freespirited, boundless, uncontrollably creative, and unafraid to try new things.";
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
