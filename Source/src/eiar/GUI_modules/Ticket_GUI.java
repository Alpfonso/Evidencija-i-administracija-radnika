package eiar.GUI_modules;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Document;

import eiar.DB_Connect;

import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class Ticket_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField imeZaposlenika;
	private JTextField imeTicketa;
	/**
	 * Create the frame.
	 * @param zaposlenik_id 
	 */
	public Ticket_GUI(int zaposlenik_id) {
		setTitle("Ticketi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelPregled = new JPanel();
		tabbedPane.addTab("Pregled", null, panelPregled, null);
		panelPregled.setLayout(null);
		
		JComboBox pregledZadataka = new JComboBox();
		pregledZadataka.setBounds(10, 10, 200, 21);
		panelPregled.add(pregledZadataka);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(114, 68, 297, 148);
		panelPregled.add(scrollPane);
		
		JTextPane pregledOpis = new JTextPane();
		scrollPane.setViewportView(pregledOpis);
		pregledOpis.setEditable(false);
		
		JCheckBox checkSelfTicket = new JCheckBox("Prikazi samo moje zadatke");

		checkSelfTicket.setBounds(216, 10, 195, 21);
		panelPregled.add(checkSelfTicket);
		
		JPanel panelIzrada = new JPanel();
		tabbedPane.addTab("Izrada", null, panelIzrada, null);
		
		DB_Connect db_object = new DB_Connect();
		
		ResultSet rs = db_object.Fetch_table_data("ticketi WHERE zadatak IN "
				+ "(SELECT id FROM zadaci WHERE zadano_zaposleniku = "+ zaposlenik_id +")");
		
		JLabel lblNewLabel = new JLabel("Dodijeljeni radnik:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 37, 96, 21);
		panelPregled.add(lblNewLabel);
		
		imeTicketa = new JTextField();
		imeTicketa.setEditable(false);
		imeTicketa.setColumns(10);
		imeTicketa.setBounds(10, 68, 94, 19);
		panelPregled.add(imeTicketa);
		imeZaposlenika = new JTextField();
		imeZaposlenika.setEditable(false);
		imeZaposlenika.setBounds(114, 38, 297, 19);
		panelPregled.add(imeZaposlenika);
		imeZaposlenika.setColumns(10);
		
		JButton prihvatiTicket = new JButton("Prihvati ticket");
		prihvatiTicket.setBounds(10, 175, 94, 41);
		panelPregled.add(prihvatiTicket);
		
		try {	
			pregledOpis.setText(rs.getString("opis"));
			imeTicketa.setText(rs.getString("ime"));
			while(rs.next()) {
				pregledZadataka.addItem(rs.getInt("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		prihvatiTicket.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] attributes = {"dodijeljeno"};
				Object[] data = { zaposlenik_id };
				try {
					db_object.Update_table_data(attributes, data, "ticketi", Integer.parseInt(pregledZadataka.getSelectedItem().toString()));
				}
				catch (Exception ex) {
					System.out.println(ex);
					// TODO: handle exception
				}
		
			}
		});
		
		pregledZadataka.addItemListener(new ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					ResultSet rs = db_object.Fetch_table_data("ticketi WHERE zadatak IN "
							+ "(SELECT id FROM zadaci WHERE projekt IN"
							+ "(SELECT id FROM projekti WHERE nadlezni_zaposlenik = " + zaposlenik_id + "))");
					try {
						while(rs.next()) {
							if(rs.getInt("id") == Integer.parseInt(pregledZadataka.getSelectedItem().toString())) {
								pregledOpis.setText(rs.getString("opis"));
								imeTicketa.setText(rs.getString("ime"));
								if(rs.getInt("dodijeljeno") == zaposlenik_id) {
									ResultSet name = db_object.Fetch_table_data("zaposlenici", rs.getInt("dodijeljeno"), "id");
									imeZaposlenika.setText(name.getString("ime") + " " + name.getString("prezime"));
								}
								else {
									imeZaposlenika.setText("");
								}
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		
		
		checkSelfTicket.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(checkSelfTicket.isSelected()) {
						
					
					ResultSet rs = db_object.Fetch_table_data("ticketi WHERE dodijeljeno = "+ zaposlenik_id);
					
					
					pregledZadataka.removeAllItems();
					pregledOpis.setText("");
	
					try {
						while(rs.next()) {
							if(rs.getInt("dodijeljeno") == zaposlenik_id) {
								pregledZadataka.addItem(rs.getInt("id"));
							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					
					System.out.println("Okay");
					
					ResultSet rs = db_object.Fetch_table_data("ticketi WHERE zadatak IN "
							+ "(SELECT id FROM zadaci WHERE zadano_zaposleniku = "+ zaposlenik_id +")");
					
					
					pregledZadataka.removeAllItems();
					pregledOpis.setText("");
	
					try {
						while(rs.next()) {
							pregledZadataka.addItem(rs.getInt("id"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	}
}
