package networking;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class Server {
    private int port;
    public ServerSocket aSocket;
    public ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();

    public static class ClientHandler {
        private int id;
        private Socket socket;
        private ObjectOutputStream outToClient;
        private ObjectInputStream inFromClient;
        static int nextId = 0;

        public ClientHandler(Socket socket) {
            try {
                this.socket = socket;
                this.outToClient = new ObjectOutputStream(socket.getOutputStream());
                this.inFromClient = new ObjectInputStream(socket.getInputStream());
                this.id = nextId;
                nextId++;
            } catch (Exception e) {
                // handle exception
            }
        }

        public void sendMessage(Object message) {
            try {
                outToClient.writeObject(message);
            } catch (Exception e) {
                // handle exception
            }
        }

        public String readMessage() {
            try {
                return (String) inFromClient.readObject();
            } catch (Exception e) {
                // handle exception
                return null;
            }
        }
    }

    public Server(int port) {
        try {
            this.port = port;
            this.aSocket = new ServerSocket(port);
        } catch (Exception e) {
            // handle exception
        }
    }

    public boolean acceptClient() {
        try {
            Socket connection = aSocket.accept();
            ClientHandler handler = new ClientHandler(connection);
            clients.add(handler);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void listenToClients(int amountOfPlayers) {
        while (clients.size() < amountOfPlayers) {
            if (acceptClient()) {
                System.out.println("Client connected");
            }
        }
    }

    public void broadcastMessage(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    public String readMessageFromClient(int id) {
        return clients.get(id).readMessage();
    }

    public ArrayList<String> waitForClientMessages() {
        ThreadPool<String> pool = new ThreadPool<String>(clients.size());
        for (int i = 0; i < clients.size(); i++) {
            int id = i;
            pool.submit_task(() -> readMessageFromClient(id));
        }
        return pool.run_tasks();
    }
}