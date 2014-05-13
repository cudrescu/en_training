
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * clasa client a ramas nemodificata
 * @author cudrescu
 *
 */
public class Client {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1", 20000);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner scanner = new Scanner(System.in);
            
            
            while (true) {

                String msg = scanner.nextLine();
                out.println(msg);

                String serverMessage = in.readLine();
                System.out.println(serverMessage);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
