package Gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Server.Server;

public class ButtonHandler implements MouseListener {
	
	private Server server; 
	
	public ButtonHandler(Server server, int mod) {
		this.mod = mod;
		this.server = server;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private int mod;
	
	@Override
	public void mousePressed(MouseEvent e) {
		switch (mod) {
		case 0:
			System.out.println("strBtn 버튼 클릭!");
			
			System.out.println(server.getOpen());
			boolean getOpen = server.getOpen();
			
			if(getOpen) return;
			
			server.start();
			break;
		case 1:
			System.out.println("stpBtn 버튼 클릭!");
			
			System.out.println(server.getOpen());
			boolean getOpen1 = server.getOpen();
			
			if(!getOpen1) return;
			
			server.stop();
			
			break;
		case 2:
			System.out.println("btnHelp 버튼 클릭!");
			
			break;

		default:
			break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
