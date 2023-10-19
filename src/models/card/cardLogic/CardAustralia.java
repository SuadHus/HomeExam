package models.card.cardLogic;

public class CardAustralia  extends Card{
    /* Australia specific variables */
    protected String collection;
    protected String animal;
    protected String activity;
   
    public CardAustralia(String siteName, String siteLetter, String region, int number, String collection, String animal, String activity) {
        super(siteName, siteLetter, region, number);
        this.collection = collection;
        this.animal = animal;
        this.activity = activity;
    }

    public String getCardName() {
        return this.siteName;
    }

    public String getCardLetter() {
        return this.siteLetter;
    }

    public String getCardRegion() {
        return this.region;
    }

    public int getCardNumber() {
        return this.number;
    }

    public String getCardString() {
        return this.siteName + " " + this.siteLetter + " " + this.region + " " + this.number + " " + this.collection + " " + this.animal + " " + this.activity;
    }

    public String getCardCollection() {
        return this.collection;
    }

    public String getCardAnimal() {
        return this.animal;
    }

    public String getCardActivity() {
        return this.activity;
    }

    
    public String displayCard(){

        StringBuilder  sb = new StringBuilder();
        String separator = "+-----------------------------------------+";

        sb.append(separator).append("\n");
        sb.append("|  Name: ").append(padRight(getCardName(), 26)).append("|").append("\n");
        sb.append("|  Letter: ").append(padRight(getCardLetter(), 24)).append("|").append("\n");
        sb.append("|  Region: ").append(padRight(getCardRegion(), 24)).append("|").append("\n");
        sb.append("|  Number: ").append(padRight(String.valueOf(getCardNumber()), 24)).append("|").append("\n");
        sb.append("|  Collection: ").append(padRight(getCardCollection(), 20)).append("|").append("\n");
        sb.append("|  Animal: ").append(padRight(getCardAnimal(), 24)).append("|").append("\n");
        sb.append("|  Activity: ").append(padRight(getCardActivity(), 22)).append("|").append("\n");
        sb.append(separator).append("\n");
    
        return sb.toString();
    }
    
    // Helper method to pad a string with spaces on the right
    private String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

    @Override
    public String toString() {
        return displayCard();
    }
    
}
