package io.zipcoder.casino;

import java.util.ArrayList;

public class BlackJack extends CardGames {

    private ArrayList<BlackjackPlayer> blackjackPlayers = new ArrayList<>();
    private Player activePlayer;
    //This constant can be used in console/actual game-play if a player/dealer gets blackjack
    private static final int BLACKJACK = 21;
    private Deck deck;

    public BlackJack() {
        start();
    }

    protected void start() {
        BlackjackPlayer dealer = new BlackjackPlayer("dealer", 500.0);
        BlackjackPlayer josh = new BlackjackPlayer("Josh", 500.0);
        blackjackPlayers.add(dealer);
        blackjackPlayers.add(josh);
        activePlayer = dealer;
        deck = new Deck();
        deck.populate();
        deck.shuffle();
        giveCardToPlayer();
    }

    public void giveCardToPlayer() {
        Card card = this.deck.dealOneRandomCard();
        this.activePlayer.addCardToHand(card);
    }

    public void endTurn() {
        for (BlackjackPlayer blackjackPlayer : blackjackPlayers) {
            if (!activePlayer.equals(blackjackPlayer))
                this.activePlayer = blackjackPlayer;
        }
    }

    //Below methods used primarily in testing and will be useful in implementation of actual gameplay via console

    public ArrayList<BlackjackPlayer> getPlayers() {
        return blackjackPlayers;
    }

    public BlackjackPlayer getPlayerAtIndex(int index) {
        return blackjackPlayers.get(index);
    }

    public void setActivePlayer(BlackjackPlayer blackjackPlayer) {
        this.activePlayer = blackjackPlayer;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

}