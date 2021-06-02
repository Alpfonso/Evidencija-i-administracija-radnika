package eiar;

import java.io.*;
import java.net.*;
import eiar.GUI_modules.*;
 
public class ReadThread extends Thread {
    private BufferedReader reader;
    private Socket socket;
    private ChatClient client;
    private Chat_GUI chatClient;
 
    public ReadThread(Socket socket, ChatClient client, Chat_GUI chatClient) {
        this.socket = socket;
        this.client = client;
        this.chatClient = chatClient;
 
        try { //try to read input, if it fails print error message
            InputStream input = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));
        } catch (IOException ex) {
            System.out.println("Error getting input stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
 
    public void run() {
        while (true) {
            try { //print the inputs repeatedly to the console
                String response = reader.readLine();
                System.out.println("\n" + response);
 
                if (client.getUserName() != null) {
                    System.out.print("[" + client.getUserName() + "]: ");
                }
            } catch (IOException ex) {
                System.out.println("Error reading from server: " + ex.getMessage());
                ex.printStackTrace();
                break;
            }
        }
    }
}
