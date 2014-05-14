import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * aici se realizeaza trimiterea de mesaje intre server si client
 * @author cudrescu
 */
public class ManageConnection extends Thread{

	private  PrintWriter out;
	private BufferedReader in;
	private Scanner scanner;
	
	ManageConnection(Socket socket){
		try {
			this.out = new PrintWriter(socket.getOutputStream(), true);
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
         this.scanner = new Scanner(System.in);
	}
	
	public void run(){
		
		while(true){
			String clientMessage = "";
			try {
				clientMessage = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			 System.out.println(clientMessage);
			 String msg = scanner.nextLine();
			 out.println(msg);
		}		 
	}
}
