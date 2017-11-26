package io.zipcoder.casino;

import java.util.ArrayList;

public class BlackJack extends CardGames {

    private static ArrayList<BlackjackPlayer> blackjackPlayers = new ArrayList<>();
    private static Player activePlayer;
    //This constant can be used in console/actual game-play if a player/dealer gets blackjack
    private static final int BLACKJACK = 21;
    private static Deck deck;

    public BlackJack() {
        start();
    }

    protected static void start() {

        BlackjackPlayer dealer = new BlackjackPlayer("dealer", 500.0);
        blackjackPlayers.add(dealer);
        activePlayer = dealer;
        deck = new Deck();
        deck.populate();
        deck.shuffle();
        giveCardToPlayer();
    }

    public static void giveCardToPlayer() {
        Card card = deck.dealOneRandomCard();
        activePlayer.addCardToHand(card);
    }

    public void endTurn() {
        for (BlackjackPlayer blackjackPlayer : blackjackPlayers) {
            if (!activePlayer.equals(blackjackPlayer))
                activePlayer = blackjackPlayer;
        }
    }

    //Below methods used primarily in testing and will be useful in implementation of actual game-play via console

    public static ArrayList<BlackjackPlayer> getPlayers() {
        return blackjackPlayers;
    }

    public BlackjackPlayer getPlayerAtIndex(int index) {
        return blackjackPlayers.get(index);
    }

    public void setActivePlayer(BlackjackPlayer blackjackPlayer) {
        activePlayer = blackjackPlayer;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

}
