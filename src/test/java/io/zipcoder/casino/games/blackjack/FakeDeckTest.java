package io.zipcoder.casino.games.blackjack;

import io.zipcoder.casino.games.Card;
import io.zipcoder.casino.games.Deck;

public class FakeDeckTest extends Deck {
    private Card[] cards;
    private int cardsIndex = 0;

    public FakeDeckTest(Card[] cards) {
        this.cards = cards;
    }

    @Override
    public Card pull() {
        Card card = cards[cardsIndex];
        cardsIndex++;
        return card;
    }
}
