package networking;

import java.io.*;
import java.net.*;

public class Client {
    private String ipAddress;
    private int port;
    private Socket socket;
    private ObjectOutputStream outToServer;
    private ObjectInputStream inFromServer;

    public Client(String ipAddress, int port) {
        try {
            this.ipAddress = ipAddress;
            this.port = port;
            this.socket = new Socket(ipAddress, port);
            this.outToServer = new ObjectOutputStream(socket.getOutputStream());
            this.inFromServer = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            // handle exception
        }
    }

    public String awaitMessageFromServer() {
        try {
            while (true) {
                String message = readMessageFromServer();
                if (message.length() > 0) {
                    return message;
                }
            }
        } catch (Exception e) {
            return "No message from server";
        }
    }

    public String readMessageFromServer() {
        try {
            return (String) inFromServer.readObject();
        } catch (Exception e) {
            return "No message from server";
        }
    }

    public void sendMessage(String message) {
        try {
            outToServer.writeObject(message);
        } catch (Exception e) {
            // handle exception
        }
    }
}