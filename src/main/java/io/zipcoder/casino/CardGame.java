package io.zipcoder.casino;

import java.util.ArrayList;

public abstract class CardGame<T extends Game> extends Game {

    private int numStandardDecks;
    private CardPile setOfAllCards = new CardPile();

    private CardPile stockPile = new CardPile();
    private CardPile discardPile = new CardPile();


    public CardGame(int numStandardDecks) {
        this.numStandardDecks = numStandardDecks;
        for(int i = 0; i < numStandardDecks; i++) {
            StandardDeck deck = new StandardDeck();
            setOfAllCards.addCardsToPile(deck);
        }
        stockPile.addCardsToPile(setOfAllCards);
        stockPile.shuffle();
    }

    public void shuffleDiscardPileBackToStock() {
        discardPile.shuffle();
        stockPile.addCardsToPile(discardPile);
        clearDiscardPile();
    }

    private void clearDiscardPile() {
        discardPile.getCards().clear();
    }

    public CardPile getStockPile() {
        return stockPile;
    }

    public Card drawFromStock() {
        Card topCard = stockPile.getCard(0);
        stockPile.removeCard(topCard);
        return topCard;
    }

    public void discardCards(CardPile cards) {
        discardPile.addCardsToPile(cards);
        cards.getCards().clear();
    }

    public CardPile getDiscardPile() {
        return discardPile;
    }

    public abstract void setPointValues();
}
