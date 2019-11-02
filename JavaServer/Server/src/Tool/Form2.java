package Tool;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import java.awt.Font;

public class Form2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form2 frame = new Form2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Form2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 633, 651);
		contentPane.add(scrollPane);
		
		JTextArea txtrHelloNewWorld = new JTextArea();
		txtrHelloNewWorld.setText("Hello New World...");
		txtrHelloNewWorld.setEditable(false);
		txtrHelloNewWorld.setLineWrap(true);
		scrollPane.setViewportView(txtrHelloNewWorld);
		
		JButton btnNewButton = new JButton("Server Start");
		btnNewButton.setBounds(643, 10, 229, 64);
		contentPane.add(btnNewButton);
		
		JButton btnServerStop = new JButton("Server Stop");
		btnServerStop.setBounds(643, 84, 229, 23);
		contentPane.add(btnServerStop);
		
		JButton btnHelp = new JButton("help");
		btnHelp.setBounds(643, 628, 229, 23);
		contentPane.add(btnHelp);
	}
}
