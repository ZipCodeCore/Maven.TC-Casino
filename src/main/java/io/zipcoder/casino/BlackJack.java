package io.zipcoder.casino;

import java.util.ArrayList;

public class BlackJack extends CardGames {

    static ArrayList<BlackjackPlayer> blackjackPlayers = new ArrayList<>();
    private static Player activePlayer;
    //This constant can be used in console/actual game-play if a player/dealer gets blackjack
    private static final int BLACKJACK = 21;
    private static Deck deck;

    public BlackJack() {
        start();
    }

    public static void createOnePlayer(String name, Double money) {
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(name, money);
        blackjackPlayers.add(blackjackPlayer);
    }

    static void start() {

        BlackjackPlayer dealer = new BlackjackPlayer("dealer", 500.0);
        blackjackPlayers.add(dealer);
        activePlayer = dealer;
        deck = new Deck();
        deck.populate();
        deck.shuffle();
        giveCardToPlayer();
    }

    static void giveCardToPlayer() {
        Card card = deck.dealOneRandomCard();
        activePlayer.addCardToHand(card);
    }

    static void endTurn() {
        for (BlackjackPlayer blackjackPlayer : blackjackPlayers) {
            if (!activePlayer.equals(blackjackPlayer))
                activePlayer = blackjackPlayer;
        }
    }

    //Below methods used primarily in testing and will be useful in implementation of actual game-play via console

    static ArrayList<BlackjackPlayer> getPlayers() {
        return blackjackPlayers;
    }

    BlackjackPlayer getPlayerAtIndex(int index) {
        return blackjackPlayers.get(index);
    }

    void setActivePlayer(BlackjackPlayer blackjackPlayer) {
        activePlayer = blackjackPlayer;
    }

    Player getActivePlayer() {
        return activePlayer;
    }

}
