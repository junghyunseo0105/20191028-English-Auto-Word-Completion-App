package Main;

import DataFile.WordFile;
import Gui.Gui;
import Server.Server;
import Storage.DataHandler;

public class Main {

	private Gui gui;
	private Server server;
	
	private DataHandler dataHandler;
	private WordFile wordFile;
	
	public Main(int port) {
		dataHandler = new DataHandler();
		wordFile = new WordFile();
		
		gui = new Gui(server, dataHandler, wordFile);
		gui.setting();
		server = new Server(gui, wordFile, port, dataHandler);
		server.start();
		
	}
	
	public static void main(String[] args) {
		new Main(3111);
	}

	
}
