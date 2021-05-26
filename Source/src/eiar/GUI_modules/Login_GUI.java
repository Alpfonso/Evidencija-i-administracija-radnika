package eiar.GUI_modules;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class Login_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField Username;
	private JTextField Password;


	/**
	 * Create the frame.
	 */
	public Login_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Username = new JTextField();
		Username.setBounds(170, 104, 86, 20);
		contentPane.add(Username);
		Username.setColumns(10);
		
		Password = new JTextField();
		Password.setBounds(170, 157, 86, 20);
		contentPane.add(Password);
		Password.setColumns(10);
		
		JButton Submit = new JButton("Submit");
		Submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//TO-DO add login form
				
			}
		});
		Submit.setBounds(170, 205, 89, 23);
		contentPane.add(Submit);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(93, 107, 67, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(93, 160, 67, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setBounds(194, 46, 74, 33);
		contentPane.add(lblNewLabel_2);
	}
}
