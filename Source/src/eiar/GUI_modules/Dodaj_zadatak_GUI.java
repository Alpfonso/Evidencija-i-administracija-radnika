package eiar.GUI_modules;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JLocaleChooser;

import eiar.DB_Connect;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.Time;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JLayeredPane;
import java.awt.Color;

/**
 * Serves as GUI for adding workers
 * 
 *
 */
public class Dodaj_zadatak_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField ime;
	private JTextField zadano_zaposleniku_field;
	private JTextField projekt_field;
	private JTextField opis_field;

	/**
	 * Launch the application.
	 */
	/*
	 */
	/**
	 * Create the frame.
	

public static void main(String[] args) {
	Dodaj_zadatak_GUI dr = new Dodaj_zadatak_GUI();
	dr.setVisible(true);

} */
	public Dodaj_zadatak_GUI() {
		this.setVisible(true);
		setTitle("Unesi zadatak");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 7, 367, 282);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblime = new JLabel("Ime");
		lblime.setBounds(10, 140, 45, 13);
		panel_2.add(lblime);
		lblime.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		ime = new JTextField();
		ime.setBounds(155, 136, 96, 19);
		panel_2.add(ime);
		ime.setColumns(10);
		
		JLabel zadano_zaposleniku = new JLabel("Zadano zaposleniku");
		zadano_zaposleniku.setBounds(10, 164, 110, 13);
		panel_2.add(zadano_zaposleniku);
		zadano_zaposleniku.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		zadano_zaposleniku_field = new JTextField();
		zadano_zaposleniku_field.setBounds(155, 160, 96, 19);
		panel_2.add(zadano_zaposleniku_field);
		zadano_zaposleniku_field.setColumns(10);
		
		projekt_field = new JTextField();
		projekt_field.setBounds(155, 184, 96, 19);
		panel_2.add(projekt_field);
		projekt_field.setColumns(10);
		
		JLabel projekt = new JLabel("Projekt");
		projekt.setForeground(Color.BLACK);
		projekt.setBounds(10, 188, 45, 13);
		panel_2.add(projekt);
		projekt.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel opis = new JLabel("Opis");
		opis.setForeground(Color.BLACK);
		opis.setFont(new Font("Tahoma", Font.PLAIN, 11));
		opis.setBounds(10, 212, 45, 13);
		panel_2.add(opis);
		
		opis_field = new JTextField();
		opis_field.setColumns(10);
		opis_field.setBounds(155, 208, 96, 19);
		panel_2.add(opis_field);
		
		JButton btnSubmit = new JButton("Dodaj zadatak");
		btnSubmit.setBounds(171, 312, 206, 21);
		contentPane.add(btnSubmit);
		
		JButton btnPotvrdiUnos = new JButton("Potvrdi unos");
		btnPotvrdiUnos.setBounds(266, 312, 111, 21);
		contentPane.add(btnPotvrdiUnos);
		btnPotvrdiUnos.setVisible(false);
		
		JButton btnPonisti = new JButton("Ponisti");
		btnPonisti.setBounds(171, 312, 96, 21);
		contentPane.add(btnPonisti);
		btnPonisti.setVisible(false);
		this.setVisible(true);

		
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(Component component : panel_2.getComponents())
					component.setEnabled(false);
				btnSubmit.setVisible(false);
				btnPotvrdiUnos.setVisible(true);
				btnPonisti.setVisible(true);
			}
		});
		
		btnPonisti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(Component component : panel_2.getComponents())
					component.setEnabled(true);
				btnSubmit.setVisible(true);
				btnPotvrdiUnos.setVisible(false);
				btnPonisti.setVisible(false);
			}
		});
		
		btnPotvrdiUnos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(ime.getText());
				String[] attributes = {"ime","zadano_zaposleniku","projekt","opis", "status"};	
				Object[] data = {ime.getText(), zadano_zaposleniku_field.getText(), projekt_field.getText(), opis_field.getText(), true};
				DB_Connect conn = new DB_Connect();
				conn.Insert_table_data(attributes, data, "zadaci");
			}
		});
		

	}
}
