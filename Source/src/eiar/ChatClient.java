package eiar;

import java.net.*;
import java.io.*;
import eiar.GUI_modules.*;
 
public class ChatClient {
    private String hostname;
    private int port;
    private String userName;
    private Chat_GUI chatClient;
 
    public ChatClient(String hostname, int port, Chat_GUI chatClient) {
        this.hostname = hostname;
        this.port = port;
        this.chatClient = chatClient;
    }
 
    public void execute() {
        try {
            Socket socket = new Socket(hostname, port);
 
            System.out.println("Connected to the chat server");
 
            new ReadThread(socket, this, chatClient).start();
            new WriteThread(socket, this, chatClient).start();
 
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        }
 
    }
 
    void setUserName(String userName) { 
        this.userName = userName;
    }
 
    String getUserName() {
        return this.userName;
    }
}
