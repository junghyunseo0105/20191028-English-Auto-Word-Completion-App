package Main;

import java.net.ServerSocket;

import Box.Box;
import DataFile.WordFile;
import Gui.Gui;
import Server.Server;
import Storage.DataHandler;
import UserWord.UserWord;

public class Main {

	private Gui gui;
	private Server server;
	private ServerSocket serverSocket;
	private UserWord userWord;
	private DataHandler dataHandler;
	private WordFile wordFile;
	
	private Box box;
	
	public Main(int port) {
		dataHandler = new DataHandler();
		wordFile = new WordFile();
		
		box = new Box(gui, server, serverSocket, dataHandler, wordFile);
		
		Gui gui = new Gui(box);
		box.setGui(gui);
		box.getGui().setting();
		
		Server server = new Server(box, port);
		box.setServer(server);
		box.getServer().start();
		
	}
	
	public static void main(String[] args) {
		new Main(3111);
	}

	
}
