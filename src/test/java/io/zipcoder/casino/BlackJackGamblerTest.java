package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackJackGamblerTest {

    Player person;
    BlackJackGambler player;

    @Before
    public void setupTest() {
        person = new Player("Sam", 1000, false);
        player = new BlackJackGambler(person, 1000);

        Card fiveHeart = new Card(Card.Rank.FIVE, Card.Suit.HEARTS);
        Card QueenHeart = new Card(Card.Rank.QUEEN, Card.Suit.HEARTS);

        player.addCardToHand(fiveHeart);
        player.addCardToHand(QueenHeart);

    }


    @Test
    public void getChipCount() throws Exception {
        Integer expected = 1000;
        Integer actual = player.getChipCount();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addChips() throws Exception {
        Integer expected = player.getChipCount() + 1000;
        player.addChips(1000);
        Integer actual = player.getChipCount();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void placeBet() throws Exception {
        Integer expectedBalance = player.getChipCount() - 500;
        Integer expected = 500;
        Integer actual = player.placeBet(500);
        Integer actualBalance = player.getChipCount();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void placeBet2() throws Exception {

        Integer expectedBalance = player.getChipCount() - player.getChipCount();
        Integer expected = 1000;
        Integer actual = player.placeBet(1050);
        Integer actualBalance = player.getChipCount();
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void getHandTotal() throws Exception {
        Integer expected = 15;
        Integer actual = player.getHandTotal();
    }

    @Test
    public void showHand() throws Exception {
        String expected = "Sam:  {FIVE of HEARTS} {QUEEN of HEARTS} Total: 15";
        String actual = player.showHand();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void tradeInChips() {
        Integer expected = 1000;
        Integer actual = player.tradeInChips();
        Assert.assertEquals(expected, actual);
    }
}