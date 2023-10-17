
import java.util.*;

import networking.*;

public class Boomerang {
    public static void main(String[] args) {
        if (args.length == 1) {
            Server server = new Server(Integer.parseInt(args[0]));
            server.listenToClients(2);
            server.broadcastMessage("Hello");
            ArrayList<String> messages = server.waitForClientMessages();
            for (String message : messages) {
                System.out.println(message);
            }
        } else if (args.length == 2) {
            Client client = new Client(args[0], Integer.parseInt(args[1]));
            String message = client.awaitMessageFromServer();
            System.out.println(message);
            client.sendMessage("i like puppies");
        } else {
            System.out.println("Usage: java Boomerang <port> or java Boomerang <ip> <port>");
        }
    }
}