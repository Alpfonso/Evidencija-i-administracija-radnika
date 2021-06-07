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
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Chat_GUI extends JFrame {

	private JPanel contentPane;
	private String message_update = "";
	private String message_send = "";
	static int i = 0;
	private JTextField chatInput;
	/**
	 * Create the frame.
	 */
	
	public void setMessage (String message) {
		this.message_update += message + "\n";
		System.out.println(message);
	}
	
	
	public Chat_GUI(String message) {
		setVisible(true);
	    		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    		setBounds(100, 100, 450, 300);
	    		contentPane = new JPanel();
	    		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    		setContentPane(contentPane);
	    		contentPane.setLayout(null);
	    		
	    		JButton btnNewButton = new JButton("Send(prevedi)");
	    		btnNewButton.setBounds(319, 220, 107, 33);
	    		contentPane.add(btnNewButton);
	    		
	    		JScrollPane scrollPane = new JScrollPane();
	    		scrollPane.setBounds(10, 10, 416, 204);
	    		contentPane.add(scrollPane);
	    		
	    		JTextPane textPane = new JTextPane();
	    		scrollPane.setViewportView(textPane);
	    		
	    		chatInput = new JTextField();
	    		chatInput.setBounds(10, 220, 304, 33);
	    		contentPane.add(chatInput);
	    		chatInput.setColumns(10);
	    		System.out.println("NOkay");
	    		new Thread(new Runnable() {
	    		      public void run() {
	    		    	  btnNewButton.addMouseListener(new MouseAdapter() {
	    		    			@Override
	    		    			public void mouseClicked(MouseEvent e) {
	    		    				message_send = chatInput.getText();
	    		    				chatInput.setText("");
	    		    			}
	    		    		});
	    		    	  chatInput.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								message_send = chatInput.getText();
    		    				chatInput.setText("");
							}
						});
	    		    	  while(true) {
		    		          // Runs inside of the Swing UI thread
		    		          SwingUtilities.invokeLater(new Runnable() {
		    		            public void run() {
		    		            	textPane.setText(message_update);
		    		            }
		    		          });
		    		          try {
		    		              java.lang.Thread.sleep(100);
		    		            }
		    		            catch(Exception e) { }
	    		    	  }

	    		      }
	    		    }).start();
	    		System.out.println("Okay");
	}


	public String getMessage() {
		String msg = message_send;
		message_send = "";
		return msg;
	}
}
