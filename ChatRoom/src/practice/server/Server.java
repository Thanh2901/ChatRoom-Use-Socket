package practice.server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ChatServer chatServer = new ChatServer();
            chatServer.startServer();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Conversation is ended");
        }
    }
}
