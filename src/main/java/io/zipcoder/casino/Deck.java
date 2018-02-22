package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * filename:
 * project: casino
 * author: https://github.com/vvmk
 * date: 2/21/18
 */
public class Deck {
    private List<Card> fullDeck;
    private List<Card> deckInPlay;

    public Deck() {
        fullDeck = new ArrayList<Card>(52);
        buildDeck();

        deckInPlay = new ArrayList<Card>(fullDeck);
    }

    protected boolean searchForCard(Card card) {
        return deckInPlay.contains(card);
    }

    private void removeFromDeck(Card card) {
        deckInPlay.remove(card);
    }

    public Card pull() {
        Card c = deckInPlay.get(new Random().nextInt(getCardsLeft()));
        removeFromDeck(c);
        return c;
    }

    public Card[] pull(int desiredCards) {
       desiredCards = (desiredCards > getCardsLeft()) ? getCardsLeft() : desiredCards;

        Card[] ret = new Card[desiredCards];
        for (int i=0;i<desiredCards;i++)
            ret[i] = pull();
        return ret;
    }

    public Card[] pullFromFreshDeck(int cards) {
        shuffle();
        return pull(cards);
    }

    public int getCardsLeft() {
        return deckInPlay.size();
    }

    public void shuffle() {
        deckInPlay = fullDeck;
    }

    protected boolean isEmpty() {
        return getCardsLeft() == 0;
    }

    private void buildDeck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                fullDeck.add(new Card(rank, suit));
            }
        }
    }
}
