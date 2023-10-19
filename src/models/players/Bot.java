package models.players;


public class Bot extends Player {
    
    public Bot(int id) {
        super(id);
    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    

    
}
