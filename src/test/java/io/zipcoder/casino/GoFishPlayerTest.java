package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class GoFishPlayerTest {



    GoFishPlayer joe = new GoFishPlayer(new Player("Joe", 1000, false));
    GoFishPlayer player = new GoFishPlayer(joe);


    Card threeHeart = new Card(Card.Rank.THREE, Card.Suit.HEARTS);
    Card threeClub = new Card(Card.Rank.THREE, Card.Suit.CLUBS);
    Card threeSpade = new Card(Card.Rank.THREE, Card.Suit.SPADES);
    Card fiveHeart = new Card(Card.Rank.FIVE, Card.Suit.HEARTS);
    Card QueenHeart = new Card(Card.Rank.QUEEN, Card.Suit.HEARTS);

    {
        player.addCardToHand(threeHeart);
        player.addCardToHand(threeClub);
        player.addCardToHand(threeSpade);
        player.addCardToHand(fiveHeart);
        player.addCardToHand(QueenHeart);
        CompPlay.setUpPlayerCards(player);
    }

    @Test
    public void giveCardsTest() throws Exception {
        String expected = " " + threeHeart + " " + threeClub + " " + threeSpade;
        String actual = "";

        String remainingExpected = "" + fiveHeart + QueenHeart;
        String remainingActual = "";

        ArrayList<Card> cards = player.giveCards(Card.Rank.THREE);

        for (Card card : cards)
            actual += " " + card;

        for (Card card : player.getHand())
            remainingActual += card.toString();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(remainingExpected, remainingActual);

    }


    @Test
    public void checkForCardTest1() throws Exception {
        boolean expected =false;

        boolean actual=player.checkForCard(Card.Rank.KING);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkForCardTest2() throws Exception {
        boolean expected =true;
        boolean actual=player.checkForCard(Card.Rank.QUEEN);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void removeBooksTest() throws Exception {
        Card threeDiamond = new Card(Card.Rank.THREE, Card.Suit.DIAMONDS);
        player.addCardToHand(threeDiamond);
        System.out.println(player.handToString());
        int expected=1;
        player.removeBooks();
        int actual =player.getBookCount();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBookCountTest() throws Exception{
        Card threeDiamond = new Card(Card.Rank.THREE, Card.Suit.DIAMONDS);
        player.addCardToHand(threeDiamond);
        player.removeBooks();
        int expected=1;
        int actual=player.getBookCount();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void completedBooksToStringTest() throws Exception {
        Card threeDiamond = new Card(Card.Rank.THREE, Card.Suit.DIAMONDS);
        String expected="| {THREE} |";
        player.addCardToHand(threeDiamond);
        player.removeBooks();
        String actual =player.completedBooksToString();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void handToStringTest() throws Exception{
        System.out.println(player.handToString());
    }

    @Test
    public void getPointTotalTest() throws Exception {
        int expected=3;
        Card threeDiamond = new Card(Card.Rank.THREE, Card.Suit.DIAMONDS);
        player.addCardToHand(threeDiamond);
        player.removeBooks();
        int actual=player.getPointTotal();

        Assert.assertEquals(expected,actual);
    }
}