package eiar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;

public class Dostupni_ticketi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Dostupni_ticketi() throws SQLException{
		DB_Connect db_object = new DB_Connect();
		ResultSet dostupni_ticketi_rs = db_object.Fetch_table_data("zadaci");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblImeTicketa = new JLabel("Ime ticketa");
		contentPane.add(lblImeTicketa);
		
		JLabel lblOpis = new JLabel("Opis");
		contentPane.add(lblOpis);
		
		JLabel lblRijesen = new JLabel("Rijesen");
		contentPane.add(lblRijesen);
		
		JLabel lblIme = new JLabel("ime1");
		contentPane.add(lblIme);
		
		JLabel lblOpis_1 = new JLabel("opis1");
		contentPane.add(lblOpis_1);
		
		JButton btnNewButton = new JButton("New button");
		contentPane.add(btnNewButton);
		
		int row_count = 0;

		while (dostupni_ticketi_rs.next()) {
		    ++row_count;
		    // Get data from the current row and use it
		}
		dostupni_ticketi_rs.beforeFirst();
		JLabel[] label_array = new JLabel[row_count];
		for(int i = 0; i < row_count; i++) {
			label_array[i] = new JLabel("");
		}
	}
}
