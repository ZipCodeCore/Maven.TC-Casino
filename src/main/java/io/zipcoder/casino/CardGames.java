package io.zipcoder.casino;

import java.util.ArrayList;

public abstract class CardGames<T extends CardPlayer> implements Games<T> {
    private ArrayList<T> players = new ArrayList<T>();
    private Deck deck;

    public abstract void addAIPlayers(int playersToAdd);
    public abstract void gameSetUp(T user);

    public void dealCards(int cardsToDeal) {
        while (cardsToDeal > 0) {

            for (T player : players) {
                Card card = deck.getCard();
                player.addCardToHand(card);
            }
            cardsToDeal--;
        }
    }

    public void addPlayer(T player) {
        players.add(player);
    }

    public void loadDecks(int numberOfDecks) {
        deck = new Deck(numberOfDecks);
        deck.shuffleDeck();
    }

    public int getRemainingDeckCards() {
        return deck.getRemainingCards();
    }

    public T getPlayer(int index) {
        try{
        return players.get(index);}
        catch (IndexOutOfBoundsException e){
            System.out.println("Invalid Player Choice");
        }
        return null;
    }

    public ArrayList<T> getPlayers() {
        return players;
    }

    public Card getDeckCard() {
        return deck.getCard();
    }

    public void removePlayer(T player) {
        players.remove(player);
    }

}
