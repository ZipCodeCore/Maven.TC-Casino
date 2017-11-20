package io.zipcoder.casino;

public class GoFishPlayer extends CardPlayer {

    private int bookCounter;

    public GoFishPlayer(Player player){
        super();
    }

    public int getBookCounter() {
        return bookCounter;
    }

    public void setBookCounter(int bookCounter) {
        this.bookCounter += bookCounter;
    }
}
