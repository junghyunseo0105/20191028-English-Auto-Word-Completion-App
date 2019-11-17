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
			sendMsg("posts");
			String str = "There is a misconception that older people belong to a special tribe, all with the same\r\n" + 
					"problems, opinions and attitudes. Yet older people are just as different from each other\r\n" + 
					"as are members of younger generational groups. How can it be otherwise in view of the\r\n" + 
					"wide range of different experiences everyone has as their life progresses from childhood\r\n" + 
					"to old age? There are differences formed by family backgrounds, education, careers\r\n" + 
					"and relationships. All these help shape a person’s character and outlook on life. This\r\n" + 
					"does not confer superior virtues on the elderly. They may have wisdom, good humour\r\n" + 
					"and tolerance, but are just as likely to be cantankerous, boring and narrow-minded.\r\n" + 
					"Like everyone else, the old are a mixed bunch, but each is an individual with their own\r\n" + 
					"particular interests and personality. ";
			sendMsg(str);
			
			
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
