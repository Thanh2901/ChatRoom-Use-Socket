package practice.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private static final int PORT = 5000;
    private List<ClientHandler> clients = new ArrayList<>();

    public void startServer() throws IOException {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started, listening on port: " + PORT + "...");

            // clients connect to server
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Process when receive message from client
                ClientHandler clientHandler = new ClientHandler(clientSocket, System.currentTimeMillis()+"", this);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void broadcastMessage(String message) {
        for(ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }
}
