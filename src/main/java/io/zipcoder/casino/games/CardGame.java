package io.zipcoder.casino.games;

import io.zipcoder.casino.interfaces.Game;

public abstract class CardGame implements Game {
    protected Deck deck;

    abstract void buildAHand();

}
