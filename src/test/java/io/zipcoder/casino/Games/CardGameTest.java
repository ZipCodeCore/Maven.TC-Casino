package io.zipcoder.casino.Games;

import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Rank;
import io.zipcoder.casino.GameTools.Deck.Suit;
import io.zipcoder.casino.GameToolsTests.Deck.DummyCardGame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CardGameTest {

    DummyCardGame dummy;

    @Before
    public void setup(){
        dummy = new DummyCardGame();
    }

    @Test
    public void getNumberOfPlayersTest(){
        dummy.setNumberOfPlayers(3);
        Integer expected = 3;
        Integer actual = dummy.getNumberOfPlayers();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMaxNumberOfPlayersTest(){
        dummy.setMaxNumberOfPlayers(3);
        Integer expected = 3;
        Integer actual = dummy.getMaxNumberOfPlayers();
        Assert.assertEquals(expected, actual);
    }

}
