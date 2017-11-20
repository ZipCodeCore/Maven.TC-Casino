package io.zipcoder.casino;

import java.util.ArrayList;

public abstract class CardGame<T extends Game> implements Game {

    private ArrayList<Player<T>> players = new ArrayList<Player<T>>();

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

    public ArrayList<Player<T>> getPlayers() {
        return players;
    }

    public int getNumPlayers() {
        return players.size();
    }

    public void addPlayers(ArrayList<Player<T>> players) {
        this.players = players;
    }

    public boolean play() {
        return false;
    }

    public void shuffleDiscardPileBackToStock() {

    }

    public CardPile getStockPile() {
        return stockPile;
    }

    public Card drawFromStock() {
        Card topCard = stockPile.getCard(0);
        stockPile.removeCard(topCard);
        return topCard;
    }

    public abstract void setPointValues();
}
