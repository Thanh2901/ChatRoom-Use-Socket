package practice.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientListener implements Runnable{

    private Socket socket;
    private InputStream input;
    private OutputStream output;

    public ClientListener(Socket socket) {
        this.socket = socket;
        try {
            this.input = socket.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while((bytesRead = input.read(buffer)) != -1) {
                String message = new String(buffer, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
