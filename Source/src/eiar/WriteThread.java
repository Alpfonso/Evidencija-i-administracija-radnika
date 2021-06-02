package eiar;

import java.io.*;
import java.net.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import eiar.GUI_modules.*;

public class WriteThread extends Thread {
    private PrintWriter writer;
    private Socket socket;
    private ChatClient client;
    private Chat_GUI chatClient;
 
    public WriteThread(Socket socket, ChatClient client, Chat_GUI chatClient) {
        this.socket = socket;
        this.client = client;
        this.chatClient = chatClient;
 
        try {
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);
        } catch (IOException ex) {
            System.out.println("Error getting output stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
 
    public void run() {
    	
        //Console console = System.console();
        String ime = new String();
        try {
	        DB_Connect db_object = new DB_Connect();
			
			ResultSet rs = db_object.Fetch_table_data("zaposlenici", 11, "id");//rs variable saves the whole line that the sql querry returns, and needs to parse in in the method below
			
			while (rs.next()) {
				ime = rs.getString("ime") + " " + rs.getString("prezime");// fetches basic data from db to display
			}
        }
		catch(SQLException e){
        	
        }
        

        client.setUserName(ime);
        writer.println(ime);
 
        String text;
 
        do {
            text = chatClient.GetMessage();
            writer.println(text);
 
        } while (!text.equals("bye"));
 
        try {
            socket.close();
        } catch (IOException ex) {
 
            System.out.println("Error writing to server: " + ex.getMessage());
        }
    }
}
