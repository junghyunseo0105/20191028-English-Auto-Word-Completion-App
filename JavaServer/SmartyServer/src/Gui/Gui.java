package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.xml.crypto.Data;

import DataFile.Word;
import DataFile.WordFile;
import Server.Server;
import Storage.DataHandler;

public class Gui extends JFrame{

	private JFrame frame;
	private JPanel contentPane;
	private JLabel request;
	private JLabel words;
	
	private Server server;
	private DataHandler dataHandler;
	private WordFile wordFile;
	
	public Gui(Server server, DataHandler dataHandler, WordFile wordFile) {
		this.server = server;
		this.dataHandler = dataHandler;
		this.wordFile = wordFile;
		
	}
	
	public void setting() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.addWindowListener(new WindowsHandler(server, dataHandler, this, wordFile));

		request = new JLabel("0 request");
		request.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 37));
		request.setBackground(Color.WHITE);
		request.setHorizontalAlignment(SwingConstants.CENTER);
		request.setBounds(0, 86, 434, 51);
		contentPane.add(request);
		
		words = new JLabel("0 words");
		words.setFont(new Font("Bodoni MT", Font.PLAIN, 18));
		words.setHorizontalAlignment(SwingConstants.CENTER);
		words.setBounds(0, 142, 434, 15);
		contentPane.add(words);
		
		frame.setVisible(true);
		
	}	
		
	public void setWords(int num) {
		String text = num + " words";
		words.setText(text);
	}
	public void setRequest(int num) {
		String text = num + " request";
		request.setText(text);
	}
	
}
