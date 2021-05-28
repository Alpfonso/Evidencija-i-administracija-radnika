package eiar.GUI_modules;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import eiar.DB_Connect;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;

public class Login_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField OIB;
	private JTextField Username;


	/**
	 * Create the frame.
	 * @param zaposlenik_id 
	 */
	public int Login_GUI(int zaposlenik_id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		OIB = new JTextField();
		OIB.setBounds(170, 104, 86, 20);
		contentPane.add(OIB);
		OIB.setColumns(10);
		
		Username = new JTextField();
		Username.setBounds(170, 157, 86, 20);
		contentPane.add(Username);
		Username.setColumns(10);
		
		int login_ID;
		
		JButton Submit = new JButton("Submit");
		Submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)  {
				
				String OIB_string = new String();
				String Username_string = new String();
				
				
				OIB_string = OIB.getText();
				Username_string = Username.getText();
				
				
				DB_Connect db_object = new DB_Connect();
				ResultSet rs = db_object.Fetch_table_data("Radnik", OIB_string, "OIB" + " Ime = " + Username_string);
				
				if(rs != null) {
					
					try {
						login_ID = rs.getInt("ID");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					setVisible(false);
					dispose();
				}
			}
		});
		
		int Return_ID () {
			
			return null;
		}
		
		
		Submit.setBounds(170, 205, 89, 23);
		contentPane.add(Submit);
		
		JLabel lblNewLabel = new JLabel("OIB:");
		lblNewLabel.setBounds(93, 107, 67, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setBounds(93, 160, 67, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setBounds(194, 46, 74, 33);
		contentPane.add(lblNewLabel_2);
	}
}
