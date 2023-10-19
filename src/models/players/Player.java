package models.players;

import models.card.cardLogic.Card;

import java.util.List;
import java.util.ArrayList;

public abstract class Player {
    public int id;
    protected List<Card> hand = new ArrayList<Card>();
    protected int score = 0;
    protected List<Card> chonkedCards = new ArrayList<Card>();

    // Constructors, getters, setters, and any other common methods

    public Player(int id) {
        this.id = id;
    }

    public abstract int getScore();

    public abstract void setScore(int score);

    public void setHand(List<Card> cards) {
        this.hand = cards;
    }

    public List<Card> getHand() {
        return this.hand;
    }

    public String getHandToString() {
        String handString = "";
        for (Card card : this.hand) {
            handString += card.displayCard() + "\n";
        }
        return handString;
    }
    
}
