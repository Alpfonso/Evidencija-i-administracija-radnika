package eiar;

import java.io.*;
import java.net.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import eiar.GUI_modules.*;
 
public class UserThread extends Thread {
    private Socket socket;
    private ChatServer server;
    private PrintWriter writer;
    private Chat_GUI chatClient;
 
    public UserThread(Socket socket, ChatServer server, Chat_GUI chatClient) {
        this.socket = socket;
        this.server = server;
        this.chatClient = chatClient;
    }
 
    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
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
            
 
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);
 
            printUsers();
 
            String userName = ime;
            server.addUserName(userName);
 
            String serverMessage = "New user connected: " + userName;
            server.broadcast(serverMessage, this);
 
            String clientMessage;
 
            do {
                clientMessage = chatClient.GetMessage();
                serverMessage = "[" + userName + "]: " + clientMessage;
                server.broadcast(serverMessage, this);
 
            } while (!clientMessage.equals("bye"));
 
            server.removeUser(userName, this);
            socket.close();
 
            serverMessage = userName + " has quitted.";
            server.broadcast(serverMessage, this);
 
        } catch (IOException ex) {
            System.out.println("Error in UserThread: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
 
   
    void printUsers() { //prints out the names of all connected users or none if there are no users
        if (server.hasUsers()) {
            writer.println("Connected users: " + server.getUserNames());
        } else {
            writer.println("No other users connected");
        }
    }
 
   
    void sendMessage(String message) { //sends a message to the client
        writer.println(message);
    }
}

