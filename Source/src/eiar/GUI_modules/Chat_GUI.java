package eiar.GUI_modules;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat_GUI extends JFrame{
	private JPanel contentPane;
	private String writeText = new String();

	public Chat_GUI() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSend = new JButton("Send");
		btnSend.setBounds(139, 227, 156, 23);
		contentPane.add(btnSend);
		
		JTextArea txtrYourMessageHere = new JTextArea();
		txtrYourMessageHere.setText("");
		txtrYourMessageHere.setBounds(10, 189, 414, 23);
		contentPane.add(txtrYourMessageHere);
		
		JTextArea txtrChat = new JTextArea();
		txtrChat.setText("");
		txtrChat.setBounds(10, 11, 414, 161);
		txtrChat.setEditable(false);
		contentPane.add(txtrChat);
		
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			writeText = txtrYourMessageHere.getText();
			txtrYourMessageHere.setText(null);
			}
		});
	}
	public String GetMessage() {
		return writeText;
	}
	
}
