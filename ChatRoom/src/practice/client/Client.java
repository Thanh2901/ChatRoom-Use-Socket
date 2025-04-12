package practice.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
        chatClient.startClient();
    }
}
