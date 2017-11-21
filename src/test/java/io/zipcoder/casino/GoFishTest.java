package io.zipcoder.casino;

import io.zipcoder.casino.Deck.Card;
import org.junit.Assert;
import org.junit.Test;

public class GoFishTest extends CardGame {

    Player player = new Player("Graham", 5, 3000);
    Player dealer = new Player("Graham", 5, 5);

    CardPlayer dealer1 = new CardPlayer();
    GoFish test = new GoFish(player);



    @Test
    public void isCardInHandTest(){
        test.deal(test.player,test.dealer,26);
        System.out.println(test.dealer.getStringDisplayHand());
        boolean expected = true;
        boolean actual = test.isCardInHand("ACE", test.dealer.getHand());

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void checkForBooksTest(){
        test.testDeal(test.player,40);

        int expected = 1;
        test.checkForBooks(test.player);
        int actual = test.player.getBookCounter();

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void removeBooksTest(){
        test.testDeal(test.player,40);

        int expected = 36;
        test.checkForBooks(test.player);
        int actual = test.player.getHand().size();

        Assert.assertEquals(expected,actual);
    }

}
