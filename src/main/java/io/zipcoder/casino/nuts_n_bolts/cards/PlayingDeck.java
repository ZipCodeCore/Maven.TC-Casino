package io.zipcoder.casino.nuts_n_bolts.cards;

import java.util.ArrayList;
import java.util.Collections;

public class PlayingDeck {

    private ArrayList<PlayingCard> cards;

    public PlayingDeck(){
        populate();
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public ArrayList<PlayingCard> getAllCards(){
        return cards;
    }

    public Integer countLeft(){
        return cards.size();
    }

    public PlayingCard getAndRemoveCard(){
        if(cards.size() == 0) {
            populate();
            shuffle();
        }
        PlayingCard card = cards.get(0);
        cards.remove(0);
        return card;
    }

    private void populate() {
        cards = new ArrayList<>();
        for (PlayingSuit suit : PlayingSuit.values()) {
            for (PlayingValue value: PlayingValue.values()) {
                cards.add(new PlayingCard(suit, value));
            }
        }
    }
}