package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BlackJackTest {

    BlackJack blackjack = new BlackJack();

    @Test
    public void startTest() {

        int expected = 2;
        int actual = blackjack.getPlayers().size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void giveCardToPlayerTest() {

        blackjack.start();
        Player dealer = blackjack.getPlayerAtIndex(0);
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
