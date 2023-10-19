package models.players;


public class Human extends Player {

    public Human(int id) {
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
