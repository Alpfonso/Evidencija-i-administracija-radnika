package eiar;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
	JFrame okvir = new JFrame("EIAR");
	public GUI() { 
		
	}
	public static void basic_display() {  
		JFrame okvir = new JFrame("EIAR");
	    okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JLabel emptyLabel = new JLabel("");
	    emptyLabel.setPreferredSize(new Dimension(175, 100));
	    okvir.getContentPane().add(emptyLabel, BorderLayout.CENTER);
	
	    //Display the window.
	    okvir.pack();
	    okvir.setVisible(true);
	    JButton osvjezi = new JButton("Osvježi");
	    //osvjezi.setBounds(130,100,100, 40);
	    osvjezi.setSize(100, 50);          
	    okvir.add(osvjezi);
	              
	    okvir.setSize(1000,1000);
	    
	}
	
}
