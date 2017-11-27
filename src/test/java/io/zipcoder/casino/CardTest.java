package io.zipcoder.casino;
import org.junit.Assert;
import org.junit.Test;

import static io.zipcoder.casino.Card.Rank.*;
import static io.zipcoder.casino.Card.Suit.*;

public class CardTest {

    Card card1= new Card(EIGHT, HEARTS);
    Card card2= new Card(EIGHT, DIAMONDS);
    Card card3= new Card(EIGHT, SPADES);
    Card card4= new Card(EIGHT, CLUBS);

    @Test
    public void getValueTest() throws Exception {
        int expected =8;
        int actual= card1.getValue();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getSuitTest() throws Exception {
        Card.Suit expected =HEARTS;
        Card.Suit actual=card1.getSuit();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void suitValTest(){
        System.out.println(card1);
        System.out.println(card2);
        System.out.println(card3);
        System.out.println(card4);
    }

}