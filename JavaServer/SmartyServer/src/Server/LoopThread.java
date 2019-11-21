package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

import Box.Box;
import Enposta.Enposta;
import UserWord.UserWord;

public class LoopThread extends Thread{

	private Socket socket;
	private Box box;
	private Enposta enposta;
	private UserWord userWord;
	
	private DataInputStream in;
	private DataOutputStream out;

	private boolean flag = true;
	
	public LoopThread(Socket socket, Box box) {
		this.socket = socket;
		this.box = box;
	}
	
	public void init() {
		String name = reciveMsg("reciveNickname :");
		userWord = new UserWord(name);
	}
	
	public void run() {
		
		init();
		
		while(flag) {
			
			String mod = reciveMsg("Mode number:");
			
			String name = userWord.getName();
			System.out.println("[" + name + "]");
			
			chooseMod(mod);
		}
	}
	
	public void chooseMod(String mod) {
		try {
			switch (mod) {
			case "posts":
				recivePosta();
				break;

			default:
				System.out.println("감지된 명령어가 없습니다.");
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void recivePosta() {
		String posts = reciveMsg("recivePosta :");
		enposta = new Enposta(box);
		String str = enposta.getCalculList(posts);
		System.out.println(str);
		
		sendMsg(str);
		userWord.setData(str);
	}
	
	public void sendMsg(String msg) {
		try {
			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String reciveMsg(String feedback) {
		try {
			in = new DataInputStream(socket.getInputStream());
			String readMsg = in.readUTF();
			System.out.println(feedback + readMsg);
			return readMsg;
			
		} catch (SocketException e) {
			closeSocket();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void closeSocket() {
		userWord.saveData();
		System.out.println(userWord.getName() + " 접속 종료됨...");
		try {
			flag = false;
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveData() {
		enposta.saveData();
	}

}
