//package io.zipcoder.casino;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class GoFishTest {
//    @Test
//    public void getGameDeck() throws Exception {
//    }
//
//    @Test
//    public void checkForPairsTest() throws Exception{
//        GoFish gameOn = new GoFish();
//
//        GoFishPlayer player1 = new GoFishPlayer();
//
//        Card someSeven = new Card(Rank.SEVEN, Suit.CLUB);
//        Card anotherSeven = new Card(Rank.SIX, Suit.HEART);
//
//        player1.addCardToHand(someSeven);
//        player1.addCardToHand(anotherSeven);
//        player1.addCardToHand(new Card(Rank.FIVE, Suit.HEART));
//        player1.addCardToHand(new Card(Rank.FOUR, Suit.HEART));
//        player1.addCardToHand(new Card(Rank.THREE, Suit.HEART));
//       // player1.drawCard(gameOn.getGameDeck());
//       // player1.drawCard(gameOn.getGameDeck());
//
//        Assert.assertTrue(gameOn.hasPair(player1));
//
//    }
//
//    @Test
//    public void endGameDeclareWinner() throws Exception {
//        GoFish gameOn = new GoFish();
//        GoFishPlayer player1 = new GoFishPlayer();
//        GoFishPlayer player2 = new GoFishPlayer();
//
//        gameOn.addPlayer(player1);
//        gameOn.addPlayer(player2);
//
//        player1.drawFiveCards(gameOn.getGameDeck());
//        player2.drawFiveCards(gameOn.getGameDeck());
//
//    }
//
//}