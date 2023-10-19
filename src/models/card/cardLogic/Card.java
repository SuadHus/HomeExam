package models.card.cardLogic;

public abstract class Card {
    protected String siteName;
    protected String siteLetter; 
    protected String region;
    protected int number;

    // Constructors, getters, setters, and any other common methods

    public Card(String siteName, String siteLetter, String region, int number) {
        this.siteName = siteName;
        this.siteLetter = siteLetter;
        this.region = region;
        this.number = number;
    }

    public abstract String getCardName();

    public abstract String getCardLetter();

    public abstract String getCardRegion();

    public abstract int getCardNumber();

    public abstract String displayCard();



}
