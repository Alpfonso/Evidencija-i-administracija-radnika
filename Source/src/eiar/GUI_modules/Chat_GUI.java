package eiar.GUI_modules;

import java.awt.EventQueue;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Chat_GUI extends JFrame implements Runnable {

	private JPanel contentPane;
	private JTextField textField;
	private String message;
	/**
	 * Create the frame.
	 */
	public Chat_GUI(String message) {
		setVisible(true);
		run();
	}

	@Override
	public void run() {
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	    		
	    		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    		setBounds(100, 100, 450, 300);
	    		contentPane = new JPanel();
	    		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    		setContentPane(contentPane);
	    		contentPane.setLayout(null);
	    		
	    		JLabel lblNewLabel = new JLabel("New label");
	    		lblNewLabel.setBounds(83, 44, 300, 149);
	    		contentPane.add(lblNewLabel);
	    		lblNewLabel.setText(message);
	    		
	    		textField = new JTextField();
	    		textField.setBounds(0, 10, 232, 25);
	    		contentPane.add(textField);
	    		textField.setColumns(10);
	    		
	    		JButton btnNewButton = new JButton("New button");
	    		btnNewButton.setBounds(107, 189, 107, 33);
	    		contentPane.add(btnNewButton);
	        }
	     });
		
	}
}
