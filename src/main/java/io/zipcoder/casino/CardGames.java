package io.zipcoder.casino;

public abstract class CardGames implements Games{
    protected Deck deck;

    abstract buildAHand();

}
