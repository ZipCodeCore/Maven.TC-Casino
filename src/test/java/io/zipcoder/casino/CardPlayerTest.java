package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class CardPlayerTest {

    @Test
    public void takeCardTest(){
        CardPlayer chewy = new CardPlayer("Chewy", 100.00);

        Deck deck = new Deck();
        deck.createFullDeck();

        Card cardToTake = deck.deal();

        chewy.takeCard(cardToTake);

        int expected = 9;
        int actual = chewy.getHand().size();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void givePlayerCardTest(){
        GoFish goFish = new GoFish();
        CardPlayer chewy = new CardPlayer("Chewy", 2.00);
        goFish.startGame(chewy, 3);

        // check for card being returned
//        Card expected = new Card(Suit.SPADE, Value.FIVE);
//        Card actual = chewy.givePlayerCard(chewy.getHand().get(0));

        // check if card is removed from hand
        chewy.givePlayerCard(chewy.getHand().get(0));
        int expected = 9;
        int actual = chewy.getHand().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void takePlayerCardTest(){
        GoFish goFish = new GoFish();
        CardPlayer chewy = new CardPlayer("Chewy", 2.00);
        goFish.startGame(chewy, 3);

        CardPlayer playerToAsk = goFish.players.get(1);
        Card cardToAskFor = playerToAsk.getHand().get(2);

        chewy.takeCard(playerToAsk.givePlayerCard(cardToAskFor));

        String expected = "";
        String actual = playerToAsk.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testHandSize(){
        CardPlayer chewy = new CardPlayer("Chewy", 100.00);

        int expected = 9;
        int actual = chewy.getHand().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test(){
        GoFish goFish = new GoFish();
        CardPlayer chewy = new CardPlayer("Chewy", 100.00);
        goFish.startGame(chewy, 3);

        double expected = 300.00;
        double actual = goFish.players.get(0).getMoney();

        Assert.assertEquals(expected, actual, 0);


    }



}