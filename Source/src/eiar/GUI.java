package eiar;

import java.awt.EventQueue;
import java.sql.*;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

import eiar.GUI_modules.Dodaj_radnika_GUI;
import eiar.GUI_modules.Izvjesce_GUI;
import eiar.GUI_modules.Pregled_zadataka_GUI;
import eiar.GUI_modules.Ticket_GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class GUI implements ActionListener{ //basic gui implementation

	private JFrame frame;
	private String ime = new String();
	public int zaposlenik_id;
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 347, 224);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_login = new JPanel();
		tabbedPane.addTab("Prijava", null, panel_login, null);
		panel_login.setLayout(null);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Alati", null, panel, null);
		panel.setLayout(null);
		
		for(Component x:panel.getComponents()) {
			x.setVisible(false);
		}
		
		JButton btnRijesen = new JButton("Rijesen");
		btnRijesen.setBounds(119, 30, 109, 23);
		panel.add(btnRijesen);
		btnRijesen.setActionCommand(Actions.RIJESEN.name());
		
		JButton btnOtvoriChat = new JButton("Otvori chat");
		btnOtvoriChat.setBounds(0, 167, 109, 23);
		panel.add(btnOtvoriChat);
		btnOtvoriChat.setActionCommand(Actions.OTVORI_CHAT.name());
		
		JButton btnPrijaviTicket = new JButton("Prijavi ticket");
		btnPrijaviTicket.setBounds(0, 62, 109, 23);
		panel.add(btnPrijaviTicket);
		btnPrijaviTicket.setActionCommand(Actions.PRIJAVI_TICKET.name());
		
		JButton btnDostupniTicketi = new JButton("Dostupni ticketi");
		btnDostupniTicketi.setBounds(119, 62, 109, 23);
		panel.add(btnDostupniTicketi);
		btnDostupniTicketi.setActionCommand(Actions.DOSTUPNI_TICKETI.name());
		
		JButton btnFinIzvjesca = new JButton("Fin. izvjesca");
		btnFinIzvjesca.setBounds(0, 99, 109, 23);
		panel.add(btnFinIzvjesca);
		btnFinIzvjesca.setActionCommand(Actions.FIN_IZVJESCA.name());
		
		JButton btnDostupneAnkete = new JButton("Ankete");
		btnDostupneAnkete.setBounds(0, 133, 109, 23);
		panel.add(btnDostupneAnkete);
		btnDostupneAnkete.setActionCommand(Actions.ANKETE.name());
		
		JButton btnDodajRadnika = new JButton("Dodaj radnika");
		btnDodajRadnika.setBounds(0, 201, 109, 23);
		panel.add(btnDodajRadnika);
		btnDodajRadnika.setActionCommand(Actions.DODAJ_RADNIKA.name());
		
		JButton btnPromjeniZadatak = new JButton("Svi zadaci");
		btnPromjeniZadatak.setBounds(238, 30, 109, 23);
		panel.add(btnPromjeniZadatak);
		btnPromjeniZadatak.setActionCommand(Actions.SVI_ZADACI.name());
		
		
		JLabel lblPlaceholderTrenutnoPrijavljen = new JLabel(ime);
		lblPlaceholderTrenutnoPrijavljen.setBounds(0, 0, 109, 23);
		panel.add(lblPlaceholderTrenutnoPrijavljen);
		btnPromjeniZadatak.addActionListener(this);
		btnDodajRadnika.addActionListener(this);
		btnDostupneAnkete.addActionListener(this);
		btnFinIzvjesca.addActionListener(this);
		btnDostupniTicketi.addActionListener(this);
		btnPrijaviTicket.addActionListener(this);
		btnOtvoriChat.addActionListener(this);
		btnRijesen.addActionListener(this);
		
	
		String ime_trenutnog_zadatka = new String();
		DB_Connect db_object = new DB_Connect();
		int id_zadatka = 1;
		ResultSet trenutni_zadatak_set = db_object.Fetch_table_data("zadaci");
		while (trenutni_zadatak_set.next()) {
			ime_trenutnog_zadatka = trenutni_zadatak_set.getString("ime");
		}
		
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent evt) {//Actions for each button press
	    if (evt.getActionCommand() == Actions.RIJESEN.name()) {
	    	
	    	System.out.println("rijesen");
	    } 
	    else if (evt.getActionCommand() == Actions.OTVORI_CHAT.name()) {
	    }
	    else if (evt.getActionCommand() == Actions.PRIJAVI_TICKET.name()) {
	    	System.out.println("prijavi ticket");
	    }
	    else if (evt.getActionCommand() == Actions.DOSTUPNI_TICKETI.name()) {
	    	Ticket_GUI dr = new Ticket_GUI(11);	
	    	dr.setVisible(true);
	    	dr.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	    }
	    else if (evt.getActionCommand() == Actions.FIN_IZVJESCA.name()) {
	    	Izvjesce_GUI dr;
			try {
				dr = new Izvjesce_GUI(11);
		    	dr.setVisible(true);
		    	dr.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
