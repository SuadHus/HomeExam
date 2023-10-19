package models.card.cardLogic;


import java.util.*;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Deck {


    public static List<Card> loadCardsFromJSON(String file){ /* Creates the deck form JSON  */
        List<Card> deck = new ArrayList<Card>();
        JSONParser parser = new JSONParser();
    

        try {
            Object obj = parser.parse(new FileReader(file));
            JSONArray cards = (JSONArray) obj;

            for(Object i: cards){
                
                JSONObject cardObj = (JSONObject) i;

                String siteName = (String) cardObj.get("name");
                String siteLetter = (String) cardObj.get("letter");
                String region = (String) cardObj.get("region");
                int number = Math.toIntExact((Long) cardObj.get("number"));
                String collection = (String) cardObj.get("collection");
                String animal = (String) cardObj.get("animal");
                String activity = (String) cardObj.get("activity");

                deck.add( new CardAustralia(siteName, siteLetter, region, number, collection, animal, activity) );


            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return deck;

    }
    
    
}
