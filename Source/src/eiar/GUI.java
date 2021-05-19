package eiar;

import java.awt.EventQueue;
import java.sql.*;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

import eiar.GUI_modules.Dodaj_radnika_GUI;
import eiar.GUI_modules.Pregled_zadataka_GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class GUI implements ActionListener{ //basic gui implementation

	private JFrame frame;
	private String ime = new String();
	private enum Actions {
		RIJESEN,
		OTVORI_CHAT,
		PRIJAVI_TICKET,
		DOSTUPNI_TICKETI,
		FIN_IZVJESCA,
		ANKETE,
		DODAJ_RADNIKA,
		SVI_ZADACI,
		IME,
		TRENUTNI_ZADATAK
	}
	public GUI() throws SQLException{
		DB_Connect db_object = new DB_Connect();
		
		ResultSet rs = db_object.Fetch_table_data("zaposlenici", 11, "id");//rs variable saves the whole line that the sql querry returns, and needs to parse in in the method below
		
		while (rs.next()) {
			ime = rs.getString("ime") + " " + rs.getString("prezime");// fetches basic data from db to display
		}
		initialize();
	}

	private void initialize() throws SQLException{//basic frame and components, subject to change
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnRijesen = new JButton("Rijesen");
		btnRijesen.setBounds(129, 41, 109, 23);
		frame.getContentPane().add(btnRijesen);
		btnRijesen.setActionCommand(Actions.RIJESEN.name());
		btnRijesen.addActionListener(this);
		
		JButton btnOtvoriChat = new JButton("Otvori chat");
		btnOtvoriChat.setBounds(10, 178, 109, 23);
		frame.getContentPane().add(btnOtvoriChat);
		btnOtvoriChat.setActionCommand(Actions.OTVORI_CHAT.name());
		btnOtvoriChat.addActionListener(this);
		
		JButton btnPrijaviTicket = new JButton("Prijavi ticket");
		btnPrijaviTicket.setBounds(10, 73, 109, 23);
		frame.getContentPane().add(btnPrijaviTicket);
		btnPrijaviTicket.setActionCommand(Actions.PRIJAVI_TICKET.name());
		btnPrijaviTicket.addActionListener(this);
		
		JButton btnDostupniTicketi = new JButton("Dostupni ticketi");
		btnDostupniTicketi.setBounds(129, 73, 109, 23);
		frame.getContentPane().add(btnDostupniTicketi);
		btnDostupniTicketi.setActionCommand(Actions.DOSTUPNI_TICKETI.name());
		btnDostupniTicketi.addActionListener(this);
		
		JButton btnFinIzvjesca = new JButton("Fin. izvjesca");
		btnFinIzvjesca.setBounds(10, 110, 109, 23);
		frame.getContentPane().add(btnFinIzvjesca);
		btnFinIzvjesca.setActionCommand(Actions.FIN_IZVJESCA.name());
		btnFinIzvjesca.addActionListener(this);
		
		JButton btnDostupneAnkete = new JButton("Ankete");
		btnDostupneAnkete.setBounds(10, 144, 109, 23);
		frame.getContentPane().add(btnDostupneAnkete);
		btnDostupneAnkete.setActionCommand(Actions.ANKETE.name());
		btnDostupneAnkete.addActionListener(this);
		
		JButton btnDodajRadnika = new JButton("Dodaj radnika");
		btnDodajRadnika.setBounds(10, 212, 109, 23);
		frame.getContentPane().add(btnDodajRadnika);
		btnDodajRadnika.setActionCommand(Actions.DODAJ_RADNIKA.name());
		btnDodajRadnika.addActionListener(this);
		
		JButton btnPromjeniZadatak = new JButton("Svi zadaci");
		btnPromjeniZadatak.setBounds(248, 41, 109, 23);
		frame.getContentPane().add(btnPromjeniZadatak);
		btnPromjeniZadatak.setActionCommand(Actions.SVI_ZADACI.name());
		btnPromjeniZadatak.addActionListener(this);
		
		
		JLabel lblPlaceholderTrenutnoPrijavljen = new JLabel(ime);
		lblPlaceholderTrenutnoPrijavljen.setBounds(10, 11, 109, 23);
		frame.getContentPane().add(lblPlaceholderTrenutnoPrijavljen);
		
	
		String ime_trenutnog_zadatka = new String();
		DB_Connect db_object = new DB_Connect();
		int id_zadatka = 1;
		ResultSet trenutni_zadatak_set = db_object.Fetch_table_data("zadaci");
		while (trenutni_zadatak_set.next()) {
			ime_trenutnog_zadatka = trenutni_zadatak_set.getString("ime");
		}
		JLabel lblPhTrenutniZadatak = new JLabel(ime_trenutnog_zadatka);
		lblPhTrenutniZadatak.setBounds(10, 41, 109, 23);
		frame.getContentPane().add(lblPhTrenutniZadatak);
		
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent evt) {//Actions for each button press
	    if (evt.getActionCommand() == Actions.RIJESEN.name()) {
	    	
	    	System.out.println("rijesen");
	    } 
	    else if (evt.getActionCommand() == Actions.OTVORI_CHAT.name()) {
	    	System.out.println("otvori chat");
	    }
	    else if (evt.getActionCommand() == Actions.PRIJAVI_TICKET.name()) {
	    	System.out.println("prijavi ticket");
	    }
	    else if (evt.getActionCommand() == Actions.DOSTUPNI_TICKETI.name()) {
	    	
	    }
	    else if (evt.getActionCommand() == Actions.FIN_IZVJESCA.name()) {
	    }
	    else if (evt.getActionCommand() == Actions.ANKETE.name()) {
	    }
	    else if (evt.getActionCommand() == Actions.DODAJ_RADNIKA.name()) {
	    	Dodaj_radnika_GUI dr = new Dodaj_radnika_GUI();	
	    	dr.setVisible(true);
	    	dr.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	    }
	    else if (evt.getActionCommand() == Actions.SVI_ZADACI.name()) {
	    	Pregled_zadataka_GUI dr;
			try {
				System.out.println("ok");
				dr = new Pregled_zadataka_GUI(11);	// TODO umjesto broja neka se salje id trenutno ulogiranog radnika
				dr.setVisible(true);
		    	dr.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	    	
	    }
	  }
}
