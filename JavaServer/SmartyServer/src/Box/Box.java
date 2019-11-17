package Box;

import java.net.ServerSocket;

import DataFile.WordFile;
import Gui.Gui;
import Server.Server;
import Storage.DataHandler;
import UserWord.UserWord;

public class Box {
	private Gui gui;
	private Server server;
	private ServerSocket serverSocket;
	private DataHandler dataHandler;
	private WordFile wordFile;
	private UserWord userWord;
	
	public Box(Gui gui, Server server, ServerSocket serverSocket, DataHandler dataHandler, WordFile wordFile) {
		super();
		this.gui = gui;
		this.server = server;
		this.serverSocket = serverSocket;
		this.dataHandler = dataHandler;
		this.wordFile = wordFile;
	}
	public Gui getGui() {
		return gui;
	}
	public void setGui(Gui gui) {
		this.gui = gui;
	}
	public Server getServer() {
		return server;
	}
	public void setServer(Server server) {
		this.server = server;
	}
	public ServerSocket getServerSocket() {
		return serverSocket;
	}
	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	public DataHandler getDataHandler() {
		return dataHandler;
	}
	public void setDataHandler(DataHandler dataHandler) {
		this.dataHandler = dataHandler;
	}
	public WordFile getWordFile() {
		return wordFile;
	}
	public void setWordFile(WordFile wordFile) {
		this.wordFile = wordFile;
	}
	
}
