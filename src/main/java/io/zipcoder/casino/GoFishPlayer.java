package io.zipcoder.casino;

import io.zipcoder.casino.Deck.Card;

import java.util.ArrayList;

public class GoFishPlayer extends CardPlayer {

    private int bookCounter;
    private ArrayList booksList;

    public GoFishPlayer(Player player){
        super();
        this.booksList = new ArrayList();
    }

    public int getBookCounter() {
        return bookCounter;
    }

    public void addBookCounter(int bookCounter) {
        this.bookCounter += bookCounter;
    }

    public ArrayList getBooksList() {
        return booksList;
    }
}
