
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * server - asteapta conexiuni ale clientilor si porneste un nou thread pentru fiecare conexiune 
 * care se va ocupa de trimiterea mesajelor
 * @author cudrescu
 */
public class Server {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(20000);
            ArrayList<ManageConnection> connections = new ArrayList<ManageConnection>();
            
            while(true) {
            	
            	Socket client = serverSocket.accept();
            	System.out.println("Clientul s-a conectat.");
            	
            	ManageConnection connection = new ManageConnection(client); 
            	connections.add(connection);
            	connection.start();
            }
            

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
