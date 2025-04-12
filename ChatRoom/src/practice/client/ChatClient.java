package practice.client;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private static final String URL = "localhost";
    private static final int PORT = 5000;

    public void startClient() {
        try {
            // Create a socket
            Socket socket = new Socket(URL, PORT);
            System.out.println("Connected to server");

            // Always read data from server
            ClientListener clientListener = new ClientListener(socket);
            new Thread(clientListener).start();

            // Get output stream
            OutputStream socketOutput = socket.getOutputStream();
            Scanner scanner = new Scanner(System.in);

            // Always read data from sc
            while(true) {
                String message = scanner.nextLine();
                socketOutput.write(message.getBytes());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
