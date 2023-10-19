
import java.util.*;

import models.card.cardLogic.*;

import networking.*;

import models.players.*;

public class Boomerang {
    private static List<Card> cards;

    public static void initializeDeck() {
        cards = Deck.loadCardsFromJSON("resources/australia/cards.json");
    }

    public static void initializePlayers() {        

    }
    public static List<Card> draftCards() {
        initializeDeck();
        List<Card> draftedCards = new LinkedList<>();
        Collections.shuffle(cards);
        for (int i = 0; i < 7; i++) {
            draftedCards.add(cards.remove(0));
        }
        return draftedCards;
    }
        
    public static void main(String[] args) {
        if (args.length == 1) {
            Server.getInstance().startServer(Integer.parseInt(args[0]));
            Server.getInstance().listenToClients(2);
            Server.getInstance().broadcastMessage("Hello");
            


            abdul.setHand(draftCards());
            josh.setHand(draftCards());

            ArrayList<String> messages = Server.getInstance().waitForClientMessages();
            for (String message : messages) {
                System.out.println(message);
            }
        } else if (args.length == 2) {
            Client client = new Client(args[0], Integer.parseInt(args[1]));
            


            Server.getInstance().broadcastMessage(abdul.getHandToString());
            Server.getInstance().broadcastMessage(josh.getHandToString());
            String message = client.awaitMessageFromServer();
            System.out.println(message);
            
            client.sendMessage("Cards are drafted");
          
        } else {
            System.out.println("Usage: java Boomerang <port> or java Boomerang <ip> <port>");
        }
    }
}

