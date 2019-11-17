package Gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import Box.Box;

public class WindowsHandler implements WindowListener{

	private Box box;
	
	public WindowsHandler(Box box) {
		this.box = box;
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
		box.getDataHandler().saveData();
		box.getWordFile().save();
		
		System.out.println("서버가 종료됩니다...");
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
		int requestNum = box.getDataHandler().readRequest();
		int wordsNum = box.getDataHandler().readWords();
		
		box.getGui().setRequest(requestNum);
		box.getGui().setWords(wordsNum);
	}
}
