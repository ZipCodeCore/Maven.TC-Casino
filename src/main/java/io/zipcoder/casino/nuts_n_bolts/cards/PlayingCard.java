package io.zipcoder.casino.nuts_n_bolts.cards;

public class PlayingCard {

    private PlayingSuit suit;
    private PlayingValue value;

    public PlayingCard(PlayingSuit suit, PlayingValue value){
        this.suit = suit;
        this.value = value;
    }

    public PlayingSuit getSuit() {
        return suit;
    }

    public PlayingValue getValue() {
        return value;
    }

}
