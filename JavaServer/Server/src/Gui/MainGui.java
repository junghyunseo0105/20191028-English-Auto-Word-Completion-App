package Gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Server.Server;

public class MainGui extends JFrame{
	private boolean flag;
	
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea textView;
	private JButton strBtn;  // startButton
	private JButton stpBtn; // stop Button
	private JButton btnHelp;
	
	private Server server;
	
	public MainGui(Server server) {
		this.server = server;
		
		init();
		settingGui();
	}
	
	public void init() {
		flag = true;
	}
	
	public void settingGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 633, 651);
		contentPane.add(scrollPane);
		
		textView = new JTextArea();
		textView.setText("Hello New World...");
		textView.setEditable(false);
		textView.setLineWrap(true);
		scrollPane.setViewportView(textView);
		
		strBtn = new JButton("Server Start"); //1
		strBtn.setBounds(643, 10, 229, 64);
		contentPane.add(strBtn);
		
		stpBtn = new JButton("Server Stop"); //2
		stpBtn.setBounds(643, 84, 229, 23);
		contentPane.add(stpBtn);
		
		btnHelp = new JButton("help"); //3
		btnHelp.setBounds(643, 628, 229, 23); 
		contentPane.add(btnHelp);
		
		strBtn.addMouseListener(new ButtonHandler(server, 0));
		stpBtn.addMouseListener(new ButtonHandler(server, 1));
		btnHelp.addMouseListener(new ButtonHandler(server, 2));
		
		
		setVisible(flag);
	}
	
	public void setText(String msg) {
		textView.setText(msg);
	}
	
}
