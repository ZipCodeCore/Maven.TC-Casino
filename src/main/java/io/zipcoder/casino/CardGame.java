package io.zipcoder.casino;

public abstract class CardGame implements Game{
    protected Deck deck;

    abstract void buildAHand();

}
