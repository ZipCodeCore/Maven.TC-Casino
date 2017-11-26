package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BlackJackTest {

    BlackJack blackjack = new BlackJack();

    @Test
    public void startTest() {
        //Have to expect 1 player (dealer) because other player is created at runtime via user-inputted name/money
        int expected = 1;
        int actual = blackjack.getPlayers().size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void giveCardToPlayerTest() {

        blackjack.start();
        BlackjackPlayer dealer = blackjack.getPlayerAtIndex(0);
        blackjack.giveCardToPlayer();
        ArrayList cards = dealer.getHandList();

        int expected = 1;

        int actual = cards.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setActivePlayerTest() {

        blackjack.start();
        ArrayList<BlackjackPlayer> blackjackPlayers = blackjack.getPlayers();
        blackjack.setActivePlayer(blackjackPlayers.get(1));

        Player expected = blackjackPlayers.get(1);

        Player actual = blackjack.getActivePlayer();

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void endTurnTest() {

        blackjack.start();
        blackjack.endTurn();

    }

}
