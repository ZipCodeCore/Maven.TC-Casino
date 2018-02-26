package io.zipcoder.casino.PlayerTest;

import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Rank;
import io.zipcoder.casino.GameTools.Deck.Suit;
import io.zipcoder.casino.Players.GoFishHumanPlayer;
import io.zipcoder.casino.Players.GoFishPlayer;
import io.zipcoder.casino.Players.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GoFishHumanPlayerTest {


    @Test
    public void showCardsTest() {
        Player player1 = new Player("Sue", 89);
        GoFishHumanPlayer goFishPlayer1 = new GoFishHumanPlayer(player1);

        Card temp1 = new Card(Rank.ACE, Suit.HEARTS);
        goFishPlayer1.addCardToHand(temp1);

        String expected = "\n1: ACE of HEARTS\n";
        String actual = goFishPlayer1.showCards();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void showOpponentsTest() {
        List<GoFishPlayer> opponents = new ArrayList<>();

        Player player1 = new Player("Sue", 89);
        GoFishHumanPlayer goFishPlayer1 = new GoFishHumanPlayer(player1);

        GoFishPlayer goFishPlayer2 = new GoFishHumanPlayer(new Player("Bob", 45));

        opponents.add(goFishPlayer1);
        opponents.add(goFishPlayer2);

        String expected = "1: Sue\n2: Bob\n";
        String actual = goFishPlayer1.showOpponents(opponents);

        Assert.assertEquals(expected, actual);
    }

}
