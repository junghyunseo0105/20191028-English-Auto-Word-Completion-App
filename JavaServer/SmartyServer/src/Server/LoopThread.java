package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import DataFile.WordFile;
import Enposta.Enposta;
import Gui.Gui;
import Storage.DataHandler;

public class LoopThread extends Thread{

	private boolean flag;
	
	private Socket socket;
	private WordFile wordFile;
	private Gui gui;
	private DataHandler dataHandler;
	
	private DataInputStream in;
	private DataOutputStream out;
	private String name;
	
	public LoopThread(Socket socket, WordFile wordFile, boolean flag, Gui gui, DataHandler dataHandler) {
		this.socket = socket;
		this.wordFile = wordFile;
		this.gui = gui;
		this.dataHandler = dataHandler;
		this.flag = flag;
	}
	
	public void run() {
		
		while(flag) {
			name = reciveMsg("reciveNickname :");
			String posts = reciveMsg("recivePosta :");
			Enposta enposta = new Enposta(wordFile, gui, dataHandler);
			String str = enposta.getCalculList(posts);
			System.out.println(str);
			
			sendMsg(str);
		}
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
