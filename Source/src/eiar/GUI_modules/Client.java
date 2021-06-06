package eiar.GUI_modules;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingUtilities;
public class Client
{
    private static final String TERMINATE = "Exit";
    static String name;
    static volatile boolean finished = false;
    private static Chat_GUI chat_gui_obj = null;
    public Client(Chat_GUI chat_gui_obj, String[] args, String ime) {
    	this.chat_gui_obj= chat_gui_obj;
    	main(args, ime);
	}
	public static void main(String[] args, String ime)
    {
        if (args.length != 2)
            System.out.println("Two arguments required: <multicast-host> <port-number>");
        else
        {
            try
            {
                InetAddress group = InetAddress.getByName(args[0]);
                int port = Integer.parseInt(args[1]);
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter your name: ");
                name = ime;
                MulticastSocket socket = new MulticastSocket(port);
              
                // Since we are deploying
                socket.setTimeToLive(0);
                //this on localhost only (For a subnet set it as 1)
                  
                socket.joinGroup(group);
                Thread t = new Thread(new
                ReadThread(socket,group,port, chat_gui_obj));
                // Spawn a thread for reading messages
                t.start();
                // sent to the current group
                System.out.println("Start typing messages...\n");
                new Thread(new Runnable() {
	    		      public void run() {
			                while(true)
			                {
			                    String message;
			                    String chat_msg = "";
			                    while(true) {
			                    	chat_msg = chat_gui_obj.getMessage();
			                    	if(!chat_msg.equals("")) {
			                    		break;
			                    	}
			                    	try {
				    		              java.lang.Thread.sleep(100);
				    		            }
				    		            catch(Exception e) { }
			                    }
			                    message = chat_msg;
			                    
			                    if(message.equalsIgnoreCase(Client.TERMINATE))
			                    {
			                        finished = true;
			                        try {
										socket.leaveGroup(group);
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
			                        socket.close();
			                        break;
			                    }
			                    
			                    //System.out.println(chat_msg);
			                    message = name + ": " + chat_msg;
			                    byte[] buffer = message.getBytes();
			
			                    DatagramPacket datagram = new
			                    DatagramPacket(buffer,buffer.length,group,port);
			                    try {
									socket.send(datagram);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
			                }
	    		      }
    		    }).start();
            }
            catch(SocketException se)
            {
                System.out.println("Error creating socket");
                se.printStackTrace();
            }
            catch(IOException ie)
            {
                System.out.println("Error reading/writing from/to socket");
                ie.printStackTrace();
            }
        }
    }
}
class ReadThread implements Runnable
{
    private MulticastSocket socket;
    private InetAddress group;
    private int port;
    private static final int MAX_LEN = 1000;
    private static Chat_GUI chat_gui_obj = null;
    ReadThread(MulticastSocket socket,InetAddress group,int port, Chat_GUI chat_gui_obj)
    {
        this.socket = socket;
        this.group = group;
        this.port = port;
        this.chat_gui_obj = chat_gui_obj;
    }
      
    @Override
    public void run()
    {
        while(!Client.finished)
        {
                byte[] buffer = new byte[ReadThread.MAX_LEN];
                DatagramPacket datagram = new
                DatagramPacket(buffer,buffer.length,group,port);
                String message;
            try
            {
                socket.receive(datagram);
                message = new
                String(buffer,0,datagram.getLength(),"UTF-8");
                if(!message.startsWith(Client.name))
                    System.out.println(message);
                	
                	chat_gui_obj.setMessage(message);
                	
            }
            catch(IOException e)
            {
                System.out.println("Socket closed!");
            }
        }
    }
}