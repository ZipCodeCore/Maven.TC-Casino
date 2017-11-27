package io.zipcoder.casino.nuts_n_bolts.cards;

import java.util.ArrayList;
import java.util.Comparator;

public class Hand {

    private ArrayList<PlayingCard> cards = new ArrayList<>();

    public Hand(){}

    @Override
    public String toString(){
        if(isHandEmpty()){
            return "If there's nothing in your hand, is it a hand?";
        } else {
            String output = "";
            cards.sort(Comparator.comparing(PlayingCard::getValue));
            for (PlayingCard card :
                    cards) {
                output += " ["+card+"] ";
            }
            return output;
        }
    }

    public ArrayList<PlayingCard> getAllCards() {
        return cards;
    }

    public Boolean isHandEmpty(){
        return this.cards.size() == 0;
    }

    public void addCard(PlayingCard card){
        this.cards.add(card);
    }

    public void removeCard(PlayingCard card){
        this.cards.remove(card);
    }

    public PlayingCard getCard(PlayingCard card) {
        removeCard(card);
        return card;
    }

    public void clear() {
        cards = new ArrayList<>();
    }
}
