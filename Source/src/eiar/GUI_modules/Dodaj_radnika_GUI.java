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
public class Dodaj_radnika_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField imeZaposlenika;
	private JTextField prezimeZaposlenika;
	private JTextField emailZaposlenika;
	private JTextField telefonZaposlenika;
	private JTextField gradStanovanjaZaposlenika;
	private JTextField ulicaBrojZaposlenika;
	private JTextField oibZaposlenika;
	private JTextField obrazovanjeZaposlenika;
	private JTextField razinaOvlastiZaposlenika;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dodaj_radnika_GUI frame = new Dodaj_radnika_GUI();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 */
	/**
	 * Create the frame.
	 */
	public Dodaj_radnika_GUI() {
		setTitle("Unesi radnika");
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
		lblime.setBounds(0, 3, 45, 13);
		panel_2.add(lblime);
		lblime.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		imeZaposlenika = new JTextField();
		imeZaposlenika.setBounds(55, 0, 96, 19);
		panel_2.add(imeZaposlenika);
		imeZaposlenika.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime");
		lblPrezime.setBounds(0, 29, 45, 13);
		panel_2.add(lblPrezime);
		lblPrezime.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		prezimeZaposlenika = new JTextField();
		prezimeZaposlenika.setBounds(55, 26, 96, 19);
		panel_2.add(prezimeZaposlenika);
		prezimeZaposlenika.setColumns(10);
		
		JLabel lblime_1_1 = new JLabel("Datum rodenja");
		lblime_1_1.setBounds(161, 3, 85, 13);
		panel_2.add(lblime_1_1);
		lblime_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblime_1_2_3 = new JLabel("email");
		lblime_1_2_3.setBounds(0, 162, 45, 13);
		panel_2.add(lblime_1_2_3);
		lblime_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		emailZaposlenika = new JTextField();
		emailZaposlenika.setBounds(55, 159, 96, 19);
		panel_2.add(emailZaposlenika);
		emailZaposlenika.setColumns(10);
		
		JLabel lblime_1_2_4 = new JLabel("telefon");
		lblime_1_2_4.setBounds(0, 188, 45, 13);
		panel_2.add(lblime_1_2_4);
		lblime_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		telefonZaposlenika = new JTextField();
		telefonZaposlenika.setBounds(55, 185, 96, 19);
		panel_2.add(telefonZaposlenika);
		telefonZaposlenika.setColumns(10);
		
		JLabel lblime_1_2 = new JLabel("Grad stanovanja");
		lblime_1_2.setBounds(161, 191, 100, 13);
		panel_2.add(lblime_1_2);
		lblime_1_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		gradStanovanjaZaposlenika = new JTextField();
		gradStanovanjaZaposlenika.setBounds(271, 188, 96, 19);
		panel_2.add(gradStanovanjaZaposlenika);
		gradStanovanjaZaposlenika.setColumns(10);
		
		ulicaBrojZaposlenika = new JTextField();
		ulicaBrojZaposlenika.setBounds(271, 211, 96, 19);
		panel_2.add(ulicaBrojZaposlenika);
		ulicaBrojZaposlenika.setColumns(10);
		
		JLabel lblime_1_2_1 = new JLabel("Ulica i broj");
		lblime_1_2_1.setBounds(161, 214, 100, 13);
		panel_2.add(lblime_1_2_1);
		lblime_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		oibZaposlenika = new JTextField();
		oibZaposlenika.setBounds(55, 52, 96, 19);
		panel_2.add(oibZaposlenika);
		oibZaposlenika.setColumns(10);
		
		JLabel lblime_1_2_2 = new JLabel("OIB");
		lblime_1_2_2.setForeground(Color.RED);
		lblime_1_2_2.setBounds(0, 55, 45, 13);
		panel_2.add(lblime_1_2_2);
		lblime_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblime_1_2_5 = new JLabel("Obrazovanje");
		lblime_1_2_5.setBounds(0, 110, 62, 14);
		panel_2.add(lblime_1_2_5);
		lblime_1_2_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		obrazovanjeZaposlenika = new JTextField();
		obrazovanjeZaposlenika.setBounds(0, 130, 151, 19);
		panel_2.add(obrazovanjeZaposlenika);
		obrazovanjeZaposlenika.setColumns(10);
		
		razinaOvlastiZaposlenika = new JTextField();
		razinaOvlastiZaposlenika.setBounds(271, 263, 96, 19);
		panel_2.add(razinaOvlastiZaposlenika);
		razinaOvlastiZaposlenika.setColumns(10);
		
		JLabel lblime_1_2_6 = new JLabel("Razina ovlasti");
		lblime_1_2_6.setBounds(161, 266, 85, 13);
		panel_2.add(lblime_1_2_6);
		lblime_1_2_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblime_1_2_7 = new JLabel("Radno vrijeme");
		lblime_1_2_7.setBounds(0, 214, 151, 13);
		panel_2.add(lblime_1_2_7);
		lblime_1_2_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblime_1_2_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblime_1_2_9 = new JLabel("Kraj");
		lblime_1_2_9.setBounds(0, 266, 45, 13);
		panel_2.add(lblime_1_2_9);
		lblime_1_2_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblime_1_2_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblime_1_2_8 = new JLabel("Pocetak");
		lblime_1_2_8.setBounds(0, 240, 45, 13);
		panel_2.add(lblime_1_2_8);
		lblime_1_2_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblime_1_2_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(161, 23, 206, 152);
		panel_2.add(calendar);
		
		JPanel panel = new JPanel();
		panel.setBounds(55, 237, 100, 19);
		panel_2.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JSpinner startH = new JSpinner();
		startH.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		panel.add(startH);
		
		JSpinner startM = new JSpinner();
		startM.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		panel.add(startM);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(55, 263, 100, 19);
		panel_2.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JSpinner endH = new JSpinner();
		endH.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		panel_1.add(endH);
		
		JSpinner endM = new JSpinner();
		endM.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		panel_1.add(endM);
		
		JLabel lozinka = new JLabel("Lozinka");
		lozinka.setForeground(Color.RED);
		lozinka.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lozinka.setBounds(0, 84, 45, 13);
		panel_2.add(lozinka);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(55, 81, 96, 19);
		panel_2.add(textField);
		
		JButton btnSubmit = new JButton("Unesi radnika");
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
		

		
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(Component component : panel_2.getComponents())
					component.setEnabled(false);
				for(Component component : panel.getComponents())
					component.setEnabled(false);
				for(Component component : panel_1.getComponents())
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
				for(Component component : panel.getComponents())
					component.setEnabled(true);
				for(Component component : panel_1.getComponents())
					component.setEnabled(true);
				btnSubmit.setVisible(true);
				btnPotvrdiUnos.setVisible(false);
				btnPonisti.setVisible(false);
			}
		});
		
		btnPotvrdiUnos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(imeZaposlenika.getText());
				String[] attributes = {"ime","prezime","datum_rodenja","grad_stanovanja","ulica_i_broj","email",
						"OIB","telefon","obrazovanje","radno_vrijeme_start","radno_vrijeme_end","slobodni_dani", "lozinka"};
				int year = calendar.getYearChooser().getYear() - 1900;	
				int month = calendar.getMonthChooser().getMonth();
				int day = calendar.getDayChooser().getDay();
				Date datum_rodenja = new Date(year, month, day);
				//startTime = startTime.
				
				Time start = new Time((Integer) startH.getValue(),(Integer) startM.getValue(),0);
				Time end = new Time((Integer) endH.getValue(),(Integer) endM.getValue(),0);
						
				Object[] data = {imeZaposlenika.getText(),prezimeZaposlenika.getText(), datum_rodenja, gradStanovanjaZaposlenika.getText(),
						ulicaBrojZaposlenika.getText(), emailZaposlenika.getText(), oibZaposlenika.getText(), telefonZaposlenika.getText(),
						obrazovanjeZaposlenika.getText(), start, end, 0, lozinka.getText()};
				DB_Connect conn = new DB_Connect();
				conn.Insert_table_data(attributes, data, "zaposlenici");
				
			}
		});
		

	}
}
