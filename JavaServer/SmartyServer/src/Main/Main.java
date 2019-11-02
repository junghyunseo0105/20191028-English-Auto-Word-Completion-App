package Main;

import Gui.Gui;
import Server.Server;
import Storage.DataHandler;

public class Main {

	private Gui gui;
	private Server server;
	
	private DataHandler dataHandler;
	
	public Main(int port) {
		dataHandler = new DataHandler();
		
		gui = new Gui(server, dataHandler);
		gui.setting();
		server = new Server(gui, port);
		server.start();
		
	}
	
	public static void main(String[] args) {
		new Main(1010);
	}

	
}
