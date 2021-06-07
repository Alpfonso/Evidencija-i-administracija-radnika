package eiar;

import java.awt.EventQueue;
import java.sql.*;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


import eiar.GUI_modules.*;

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
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI implements ActionListener{ //basic gui implementation

	private JFrame frame;
	private String ime = new String();
	
	public int zaposlenik_id;
	private JTextField OIB;
	private JTextField lozinka;
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
		TRENUTNI_ZADATAK,
		POKRENI_CHAT_SERVER,
		DODAJ_ZADATAK
	}
	public GUI() throws SQLException{
		initialize();
	}

	private void initialize() throws SQLException{//basic frame and components, subject to change
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 348, 280);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_login = new JPanel();
		tabbedPane.addTab("Prijava", null, panel_login, null);
		panel_login.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("OIB:");
		lblNewLabel.setBounds(10, 47, 45, 13);
		panel_login.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prijava u sustav");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 10, 323, 27);
		panel_login.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Lozinka");
		lblNewLabel_2.setBounds(10, 70, 45, 13);
		panel_login.add(lblNewLabel_2);
		
		OIB = new JTextField();
		OIB.setBounds(65, 44, 268, 16);
		panel_login.add(OIB);
		OIB.setColumns(10);
		
		lozinka = new JTextField();
		lozinka.setBounds(65, 67, 268, 16);
		panel_login.add(lozinka);
		lozinka.setColumns(10);
		
		JButton prijava = new JButton("Prijavi se!");
		
		prijava.setBounds(10, 99, 323, 27);
		panel_login.add(prijava);
		
		JLabel greska_label = new JLabel("* pogre\u0161no korisni\u010Dko ime ili lozinka");
		greska_label.setForeground(Color.RED);
		greska_label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		greska_label.setBounds(10, 136, 323, 27);
		panel_login.add(greska_label);
		greska_label.setVisible(false);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Alati", null, panel, null);
		panel.setLayout(null);
		
		tabbedPane.setEnabledAt(1, false);
		
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
		
		JButton btnNoviZadatak = new JButton("Dodaj zadatak");
		btnNoviZadatak.setBounds(238, 62, 109, 23);
		panel.add(btnNoviZadatak);
		btnNoviZadatak.setActionCommand(Actions.DODAJ_ZADATAK.name());
		
		String ime_trenutnog_zadatka = new String();
		DB_Connect db_object = new DB_Connect();
		ResultSet trenutni_zadatak_set = db_object.Fetch_table_data("zadaci");
		while (trenutni_zadatak_set.next()) {
			ime_trenutnog_zadatka = trenutni_zadatak_set.getString("ime");
		}
		
		JLabel trenutniKorisnik = new JLabel(ime);
		trenutniKorisnik.setBounds(0, 11, 109, 23);
		panel.add(trenutniKorisnik);
		JLabel lblPhTrenutniZadatak = new JLabel(ime_trenutnog_zadatka);
		lblPhTrenutniZadatak.setBounds(0, 30, 109, 23);
		panel.add(lblPhTrenutniZadatak);
		btnPromjeniZadatak.addActionListener(this);
		btnDodajRadnika.addActionListener(this);
		btnDostupneAnkete.addActionListener(this);
		btnFinIzvjesca.addActionListener(this);
		btnDostupniTicketi.addActionListener(this);
		btnPrijaviTicket.addActionListener(this);
		btnOtvoriChat.addActionListener(this);
		btnRijesen.addActionListener(this);
		btnNoviZadatak.addActionListener(this);
		
		prijava.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ovlasti = "placeholder";
				DB_Connect db_obj = new DB_Connect();
				ResultSet rs = db_obj.Fetch_table_data("zaposlenici");
				boolean passed = false;
				try {
					while(rs.next()) {
						if(rs.getString("OIB").equals(OIB.getText()) && rs.getString("lozinka").equals(lozinka.getText())) {
							tabbedPane.setEnabledAt(1, true);
							passed = true;
							greska_label.setVisible(false);
							tabbedPane.setSelectedIndex(1);
							DB_Connect db_object = new DB_Connect();
							ResultSet trenutni_korisnik = db_object.Fetch_table_data("zaposlenici", OIB.getText(), "OIB");
							while (trenutni_korisnik.next()) {
								trenutniKorisnik.setText(trenutni_korisnik.getString("ime") + " " + trenutni_korisnik.getString("prezime"));
								zaposlenik_id = trenutni_korisnik.getInt("id");
								ime = trenutni_korisnik.getString("ime") + " " + trenutni_korisnik.getString("prezime");
								ovlasti = trenutni_korisnik.getString("razina_ovlasti");
							}
							db_object.close();
						}
					}
					if(!passed) {
						greska_label.setVisible(true);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				db_obj.close();
				if(!(ovlasti.equals("Vlasnik") || ovlasti.equals("Administrator"))) {
					btnDodajRadnika.setVisible(false);
				}
				if(!(ovlasti.equals("Vlasnik") || ovlasti.equals("Financije"))) {
					btnFinIzvjesca.setVisible(false);
				}
				if(!(ovlasti.equals("Vlasnik") || ovlasti.equals("HR"))) {
					btnDostupneAnkete.setVisible(false);
				}
				if(!(ovlasti.equals("Vlasnik") || ovlasti.equals("Nadredeni"))) {
					btnNoviZadatak.setVisible(false);
				}
			}
		});
		
		
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent evt){//Actions for each button press
	    if (evt.getActionCommand() == Actions.RIJESEN.name()) {
	    	try {
				DB_Connect db_object = new DB_Connect();
				ResultSet rs = db_object.Fetch_table_data("zadaci" + " where zadano_zaposleniku = " + zaposlenik_id + " AND status = 'true'");
				Zadaci trenutni_zadatak = new Zadaci(rs.getInt("id"), true);
				trenutni_zadatak.Zavrsi();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    } 
	    else if (evt.getActionCommand() == Actions.DODAJ_ZADATAK.name()) {
 	    	Dodaj_zadatak_GUI dz;
 	    	dz = new Dodaj_zadatak_GUI();
 			dz.setVisible(true);
 			dz.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	 	}
	    else if (evt.getActionCommand() == Actions.POKRENI_CHAT_SERVER.name()) {
	    	
	    }
	    else if (evt.getActionCommand() == Actions.OTVORI_CHAT.name()) {
	        SwingUtilities.invokeLater(new Runnable(){
	            public void run() {
	            	Chat_GUI chat_gui_obj = new Chat_GUI("ok");
	            	String args[] = {"239.0.0.0", "1234"};
	    	    	Client c = new Client(chat_gui_obj, args, ime);
	            }
	        });
	    	//Chat_GUI chat_gui_obj = new Chat_GUI("ok");
	    	//String args[] = {"239.0.0.0", "1234"};
	    	//Client c = new Client(chat_gui_obj, args);
	    }

	    else if (evt.getActionCommand() == Actions.PRIJAVI_TICKET.name()) {
	    	Chat_GUI i = new Chat_GUI("ok");
	    	i.setVisible(true);
	    	
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
				e.printStackTrace();
			}	
	    	
	    }
	 
	  }

}

