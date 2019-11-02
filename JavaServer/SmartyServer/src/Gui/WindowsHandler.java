package Gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import Server.Server;
import Storage.DataHandler;

public class WindowsHandler implements WindowListener{

	private Server server;
	private DataHandler dataHandler;
	private Gui gui;
	
	public WindowsHandler(Server server, DataHandler dataHandler, Gui gui) {
		this.server = server;
		this.dataHandler = dataHandler;
		this.gui = gui;
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
	
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		loadData();
	}
	
	public void loadData() {
		int requestNum = dataHandler.readRequest();
		int wordsNum = dataHandler.readWords();
		
		gui.setRequest(requestNum);
		gui.setWords(wordsNum);
	}
}
