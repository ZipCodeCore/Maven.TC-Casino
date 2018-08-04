package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static io.zipcoder.casino.Card.FaceValue.*;
import static io.zipcoder.casino.Card.Suit.*;

public class BlackJackPlayerTest {

    @Test
    public void hasAceInHandTest() {
        BlackJack game = new BlackJack(4);

        ArrayList<BlackJackPlayer> players = new ArrayList<>();
        BlackJackPlayer player1 = new BlackJackPlayer("Apple");
        BlackJackPlayer player2 = new BlackJackPlayer("Banana");
        players.add(player1);
        players.add(player2);
        game.addPlayers(players);

        Card aceOfSpades = new Card(ACE, SPADES);
        Card jackOfDiamonds = new Card(JACK, DIAMONDS);

        player1.addCardToHand(aceOfSpades);
        player1.addCardToHand(jackOfDiamonds);

        Assert.assertTrue(player1.hasAceInHand());
        Assert.assertFalse(player2.hasAceInHand());
    }
}
