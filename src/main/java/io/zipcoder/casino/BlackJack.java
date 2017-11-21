package io.zipcoder.casino;

import java.util.ArrayList;

public class BlackJack extends CardGames {

    ArrayList<BlackjackPlayer> blackjackPlayers;

    public void start() {

        Deck blackJackDeck = new Deck();
        BlackjackPlayer josh = new BlackjackPlayer("Josh", 100.00);
        blackjackPlayers.add(josh);


    }
}
