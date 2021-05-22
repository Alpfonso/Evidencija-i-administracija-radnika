package eiar;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private int port;
    private Set<String> userNames = new HashSet<>(); //Set is used because it doesn't allow duplicates & the order is irrelevant
    private Set<UserThread> userThreads = new HashSet<>();
 
    public ChatServer(int port) {
        this.port = port;
    }
    
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Syntax: java ChatServer <port-number>");
            System.exit(0);
        }
 
        int port = Integer.parseInt(args[0]);
 
        ChatServer server = new ChatServer(port);
        server.execute();
    }
 
    public void execute() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
 
            System.out.println("Chat Server is listening on port " + port);
 
            while (true) { 
                Socket socket = serverSocket.accept(); 
                System.out.println("New user connected"); //successfully connected to port
 
                UserThread newUser = new UserThread(socket, this);
                userThreads.add(newUser);
                newUser.start();
 
            }
 
        } catch (IOException ex) { //error while connecting
            System.out.println("Error in the server: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
 
   
    void broadcast(String message, UserThread excludeUser) { //method used to deliver message from one user to another
        for (UserThread aUser : userThreads) {
            if (aUser != excludeUser) {
                aUser.sendMessage(message);
            }
        }
    }
 
   
    void addUserName(String userName) { //stores newly added username 
        userNames.add(userName);
    }
 
 
    void removeUser(String userName, UserThread aUser) { //when a client disconnects this method removes his username and UserThread
        boolean removed = userNames.remove(userName);
        if (removed) {
            userThreads.remove(aUser);
            System.out.println("The user " + userName + " quitted");
        }
    }
 
    Set<String> getUserNames() {
        return this.userNames;
    }
 
    
    boolean hasUsers() { //returns true if there are other users connected
        return !this.userNames.isEmpty();
    }
}
