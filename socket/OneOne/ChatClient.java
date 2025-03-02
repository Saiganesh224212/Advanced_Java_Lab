import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            System.out.println("Shyam connected to Saiganesh!");
            
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            output.println("Hi Saiganesh!");
            System.out.println("Saiganesh: " + input.readLine());

            String message;
            while (true) {
                System.out.print("Shyam: ");
                message = console.readLine();
                output.println(message);
                
                if (message.equalsIgnoreCase("exit")) break;
                message = input.readLine();
                System.out.println("Saiganesh: " + message);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
