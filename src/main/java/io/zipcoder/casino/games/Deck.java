package io.zipcoder.casino.games;


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

    /**
     * check for a specific card in the deck (mainly for testing pull/remove)
     * @param card the card to search for
     * @return true if the card is still in the deck
     */
    protected boolean searchForCard(Card card) {
        return deckInPlay.contains(card);
    }

    /**
     * remove a card from the deck, abstracted from pull()
     * @param card the card to remove
     */
    private void removeFromDeck(Card card) {
        deckInPlay.remove(card);
    }

    /**
     * draw and return a single card. use Random to simulate a shuffled deck.
     * If trying to pull a card from an empty deck, returns null
     * TODO: discuss
     * @return a card from a pseudo-randomly chosen index
     */
    public Card pull() {
        if (isEmpty())
           return null;

        Card c = deckInPlay.get(new Random().nextInt(getCardsLeft()));
        removeFromDeck(c);
        return c;
    }

    /**
     * Attempt to remove numberOfCards from the deck, if there aren't that many left, get them all
     * TODO: discuss
     * @param numberOfCards how many cards to remove
     * @return an array containing the pulled cards
     */
    public Card[] pull(int numberOfCards) {
       numberOfCards = (numberOfCards > getCardsLeft()) ? getCardsLeft() : numberOfCards;

        Card[] ret = new Card[numberOfCards];
        for (int i=0;i<numberOfCards;i++)
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

    /**
     * Build the fresh deck from enums inside Card.java
     */
    private void buildDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                fullDeck.add(new Card(rank, suit));
            }
        }
    }
}
