package eiar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;

public class Dostupni_ticketi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Dostupni_ticketi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel lblImeTicketa = new JLabel("Ime ticketa");
		contentPane.add(lblImeTicketa);
		
		JLabel lblOpis = new JLabel("Opis");
		contentPane.add(lblOpis);
		
		JLabel lblRijesen = new JLabel("Rijesen");
		contentPane.add(lblRijesen);
		
		JLabel label_2 = new JLabel("");
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		contentPane.add(label_3);
		
		JLabel lblIme = new JLabel("ime1");
		contentPane.add(lblIme);
		
		JLabel lblOpis_1 = new JLabel("opis1");
		contentPane.add(lblOpis_1);
		
		JButton btnNewButton = new JButton("New button");
		contentPane.add(btnNewButton);
		
		JLabel label_4 = new JLabel("");
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("");
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("");
		contentPane.add(label_6);
		
		JLabel label = new JLabel("");
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		contentPane.add(label_1);
	}
}
