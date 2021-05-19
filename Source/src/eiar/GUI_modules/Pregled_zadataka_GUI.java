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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JLayeredPane;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 * Serves as GUI for adding workers
 * 
 *
 */
public class Pregled_zadataka_GUI extends JFrame {
	private JTextField imeZadatka;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Pregled_zadataka_GUI(int zaposlenik_id) throws SQLException {
		setTitle("Pregledaj zadatke");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		getContentPane().setLayout(null);
		
		JComboBox<String> zadaciSelect = new JComboBox<String>();

		zadaciSelect.setBounds(10, 10, 366, 21);
		getContentPane().add(zadaciSelect);
		
		JLabel lblNewLabel = new JLabel("Zadatak:");
		lblNewLabel.setBounds(10, 41, 58, 21);
		getContentPane().add(lblNewLabel);
		
		imeZadatka = new JTextField();
		imeZadatka.setEditable(false);
		imeZadatka.setBounds(78, 41, 298, 21);
		getContentPane().add(imeZadatka);
		imeZadatka.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 72, 366, 281);
		getContentPane().add(scrollPane);
		
		JTextPane opisZadatka = new JTextPane();
		scrollPane.setViewportView(opisZadatka);
		
		DB_Connect db_object = new DB_Connect();
		ResultSet set_zadaci = db_object.Fetch_table_data("zadaci", 11, "zadano_zaposleniku");
		while (set_zadaci.next()) {
				imeZadatka.setText(set_zadaci.getString("ime"));
				opisZadatka.setText(set_zadaci.getString("opis"));
				zadaciSelect.addItem(set_zadaci.getString("ime"));
		}
		
		zadaciSelect.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				ResultSet set_zadaci = db_object.Fetch_table_data("zadaci", 11, "zadano_zaposleniku");
				try {
					while (set_zadaci.next()) {
						System.out.println("Okay");
						System.out.println(set_zadaci.getString("ime"));
						System.out.println(zadaciSelect.getSelectedItem().toString());
						if(set_zadaci.getString("ime").equals(zadaciSelect.getSelectedItem().toString())) {
							System.out.print("Okay22");
							imeZadatka.setText(set_zadaci.getString("ime"));
							opisZadatka.setText(set_zadaci.getString("opis"));
						}
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

	}
}
