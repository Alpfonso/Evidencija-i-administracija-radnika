package eiar;

import java.awt.BorderLayout;
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
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JTextField radnoVrijemeStart;
	private JTextField radnoVrijemeEnd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dodaj_radnika_GUI frame = new Dodaj_radnika_GUI();
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
	public Dodaj_radnika_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblime = new JLabel("Ime");
		lblime.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblime.setBounds(10, 10, 45, 13);
		contentPane.add(lblime);
		
		imeZaposlenika = new JTextField();
		imeZaposlenika.setBounds(65, 7, 96, 19);
		contentPane.add(imeZaposlenika);
		imeZaposlenika.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime");
		lblPrezime.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrezime.setBounds(10, 36, 45, 13);
		contentPane.add(lblPrezime);
		
		prezimeZaposlenika = new JTextField();
		prezimeZaposlenika.setColumns(10);
		prezimeZaposlenika.setBounds(65, 33, 96, 19);
		contentPane.add(prezimeZaposlenika);
		
		JLabel lblime_1_1 = new JLabel("Datum rodenja");
		lblime_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblime_1_1.setBounds(171, 10, 85, 13);
		contentPane.add(lblime_1_1);
		
		JCalendar datumRodenjaZaposlenika = new JCalendar();
		datumRodenjaZaposlenika.setBounds(171, 33, 206, 152);
		contentPane.add(datumRodenjaZaposlenika);
		
		JLabel lblime_1_2_3 = new JLabel("email");
		lblime_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblime_1_2_3.setBounds(10, 140, 45, 13);
		contentPane.add(lblime_1_2_3);
		
		emailZaposlenika = new JTextField();
		emailZaposlenika.setColumns(10);
		emailZaposlenika.setBounds(65, 137, 96, 19);
		contentPane.add(emailZaposlenika);
		
		JLabel lblime_1_2_4 = new JLabel("telefon");
		lblime_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblime_1_2_4.setBounds(10, 166, 45, 13);
		contentPane.add(lblime_1_2_4);
		
		telefonZaposlenika = new JTextField();
		telefonZaposlenika.setColumns(10);
		telefonZaposlenika.setBounds(65, 163, 96, 19);
		contentPane.add(telefonZaposlenika);
		
		JLabel lblime_1_2 = new JLabel("Grad stanovanja");
		lblime_1_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblime_1_2.setBounds(171, 198, 100, 13);
		contentPane.add(lblime_1_2);
		
		gradStanovanjaZaposlenika = new JTextField();
		gradStanovanjaZaposlenika.setColumns(10);
		gradStanovanjaZaposlenika.setBounds(281, 195, 96, 19);
		contentPane.add(gradStanovanjaZaposlenika);
		
		ulicaBrojZaposlenika = new JTextField();
		ulicaBrojZaposlenika.setColumns(10);
		ulicaBrojZaposlenika.setBounds(281, 218, 96, 19);
		contentPane.add(ulicaBrojZaposlenika);
		
		JLabel lblime_1_2_1 = new JLabel("Ulica i broj");
		lblime_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblime_1_2_1.setBounds(171, 221, 100, 13);
		contentPane.add(lblime_1_2_1);
		
		oibZaposlenika = new JTextField();
		oibZaposlenika.setColumns(10);
		oibZaposlenika.setBounds(65, 59, 96, 19);
		contentPane.add(oibZaposlenika);
		
		JLabel lblime_1_2_2 = new JLabel("OIB");
		lblime_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblime_1_2_2.setBounds(10, 62, 45, 13);
		contentPane.add(lblime_1_2_2);
		
		JLabel lblime_1_2_5 = new JLabel("Obrazovanje");
		lblime_1_2_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblime_1_2_5.setBounds(10, 88, 62, 14);
		contentPane.add(lblime_1_2_5);
		
		obrazovanjeZaposlenika = new JTextField();
		obrazovanjeZaposlenika.setColumns(10);
		obrazovanjeZaposlenika.setBounds(10, 108, 151, 19);
		contentPane.add(obrazovanjeZaposlenika);
		
		razinaOvlastiZaposlenika = new JTextField();
		razinaOvlastiZaposlenika.setColumns(10);
		razinaOvlastiZaposlenika.setBounds(281, 270, 96, 19);
		contentPane.add(razinaOvlastiZaposlenika);
		
		JLabel lblime_1_2_6 = new JLabel("Razina ovlasti");
		lblime_1_2_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblime_1_2_6.setBounds(171, 273, 85, 13);
		contentPane.add(lblime_1_2_6);
		
		JLabel lblime_1_2_7 = new JLabel("Radno vrijeme");
		lblime_1_2_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblime_1_2_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblime_1_2_7.setBounds(10, 221, 151, 13);
		contentPane.add(lblime_1_2_7);
		
		radnoVrijemeStart = new JTextField();
		radnoVrijemeStart.setColumns(10);
		radnoVrijemeStart.setBounds(65, 244, 96, 19);
		contentPane.add(radnoVrijemeStart);
		
		radnoVrijemeEnd = new JTextField();
		radnoVrijemeEnd.setColumns(10);
		radnoVrijemeEnd.setBounds(65, 270, 96, 19);
		contentPane.add(radnoVrijemeEnd);
		
		JLabel lblime_1_2_9 = new JLabel("Kraj");
		lblime_1_2_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblime_1_2_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblime_1_2_9.setBounds(10, 273, 45, 13);
		contentPane.add(lblime_1_2_9);
		
		JLabel lblime_1_2_8 = new JLabel("Pocetak");
		lblime_1_2_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblime_1_2_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblime_1_2_8.setBounds(10, 247, 45, 13);
		contentPane.add(lblime_1_2_8);
		
		JButton btnSubmit = new JButton("Unesi radnika");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(imeZaposlenika.getText());
			}
		});
		btnSubmit.setBounds(171, 312, 206, 21);
		contentPane.add(btnSubmit);
	}
}
