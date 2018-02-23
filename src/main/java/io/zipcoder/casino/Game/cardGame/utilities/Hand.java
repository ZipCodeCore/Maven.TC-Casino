package io.zipcoder.casino.Game.cardGame.utilities;

import javax.smartcardio.Card;
import java.util.ArrayList;

public class Hand {
    private ArrayList<Card>cards;


    public Hand(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card){
        cards.add(card);

    }
    public void removeCard(Card card){
        cards.remove(card);
    }

    public void clear(){
        cards.clear();

    }

    public boolean hasCard(Card card){
        return true;
    }
}
