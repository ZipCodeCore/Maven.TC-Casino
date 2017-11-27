package io.zipcoder.casino;

import org.junit.*;


public class GoFishPlayerTest {

    GoFishPlayer goFishPlayer = new GoFishPlayer("josh");


    @Test
    public void addCardToHandAndViewHandTest() {

        Card card = new Card(Suit.CLUB, CardValue.Two);
        int expected = 2;

        goFishPlayer.addCardToHand(card);

        int actual = card.getCardsValue();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealGoFishHandTest(){

    }
}