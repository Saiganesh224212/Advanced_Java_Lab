import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Saiganesh is waiting for Shyam...");
            Socket socket = serverSocket.accept();
            System.out.println("Shyam connected!");
            
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String message = input.readLine();
            System.out.println("Shyam: " + message);
            if ("Hi Saiganesh!".equalsIgnoreCase(message)) {
                output.println("Yes, Sairam Shyam! Yela Unnavu?");
            }
            while (true) {
                message = input.readLine();
                if (message.equalsIgnoreCase("exit")) break;
                System.out.println("Shyam: " + message);
                
                System.out.print("Saiganesh: ");
                message = console.readLine();
                output.println(message);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
