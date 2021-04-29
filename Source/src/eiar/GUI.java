package eiar;

import java.awt.EventQueue;
import java.sql.*;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class GUI /*implements ActionListener*/{

	private JFrame frame;
	private String ime = new String();
	
	/**
	 * Create the application.
	 */
	public GUI() throws SQLException{
		DB_Connect db_object = new DB_Connect();
		ResultSet rs = db_object.Fetch_Table_Data("zaposlenici", 7);
		
		while (rs.next()) {
			ime = rs.getString("ime") + " " + rs.getString("prezime");
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnRijesen = new JButton("Rijesen");
		btnRijesen.setBounds(129, 41, 109, 23);
		frame.getContentPane().add(btnRijesen);
		
		JButton btnOtvoriChat = new JButton("Otvori chat");
		btnOtvoriChat.setBounds(10, 178, 109, 23);
		frame.getContentPane().add(btnOtvoriChat);
		
		JButton btnPrijaviTicket = new JButton("Prijavi ticket");
		btnPrijaviTicket.setBounds(10, 73, 109, 23);
		frame.getContentPane().add(btnPrijaviTicket);
		
		JButton btnDostupniTicketi = new JButton("Dostupni ticketi");
		btnDostupniTicketi.setBounds(129, 73, 109, 23);
		frame.getContentPane().add(btnDostupniTicketi);
		
		JButton btnFinIzvjesca = new JButton("Fin. izvjesca");
		btnFinIzvjesca.setBounds(10, 110, 109, 23);
		frame.getContentPane().add(btnFinIzvjesca);
		
		JButton btnDostupneAnkete = new JButton("Ankete");
		btnDostupneAnkete.setBounds(10, 144, 109, 23);
		frame.getContentPane().add(btnDostupneAnkete);
		
		JButton btnDodajRadnika = new JButton("Dodaj radnika");
		btnDodajRadnika.setBounds(10, 212, 109, 23);
		frame.getContentPane().add(btnDodajRadnika);
		
		JButton btnPromjeniZadatak = new JButton("Svi zadaci");
		btnPromjeniZadatak.setBounds(248, 41, 109, 23);
		frame.getContentPane().add(btnPromjeniZadatak);
		
		JLabel lblPlaceholderTrenutnoPrijavljen = new JLabel(ime);
		lblPlaceholderTrenutnoPrijavljen.setBounds(10, 11, 109, 23);
		frame.getContentPane().add(lblPlaceholderTrenutnoPrijavljen);
		
		JLabel lblPhTrenutniZadatak = new JLabel("ph trenutni zadatak");
		lblPhTrenutniZadatak.setBounds(10, 41, 109, 23);
		frame.getContentPane().add(lblPhTrenutniZadatak);
		
		frame.setVisible(true);
	}
}
