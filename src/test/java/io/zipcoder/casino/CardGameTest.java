package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CardGameTest {

    Player player = new Player();
    ArrayList<Card> handTest;
    CardGame game = new CardGame();
    @Before
    public void setUp() {
        handTest = new ArrayList<Card>;
    }

    @Test
    public void showHand() throws Exception {
        ArrayList<Card> expected = handTest;
        ArrayList<Card> actual = game.showHand();
        Assert.assert;

    }

    @Test
    public void isHandEmpty() throws Exception {
    }

}