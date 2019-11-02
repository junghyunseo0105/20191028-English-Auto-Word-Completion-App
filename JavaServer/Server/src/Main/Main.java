package Main;

import Gui.MainGui;
import Server.Server;

public class Main {

	private Server server;
	private MainGui mainGui;
	
	public Main() {
		init();
	}
	
	public void init() {
		server = new Server(mainGui, 1234);
		mainGui = new MainGui(server);
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
