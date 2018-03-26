package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {

//    @Test
//    public void getPot() {
//        BlackJackGame game = new BlackJackGame();
//        Player player = game.getPlayer();
//        Double expectedPot = 50.0;
//        player.makeBet(50.0);
//        game.addToPot(50.0);
//        Double actualPot = game.getPot();
//        Assert.assertEquals(expectedPot, actualPot);
//    }
//
//    @Test
//    public void startTest() {
//        Game game = new BlackJackGame();
//        game.play();
//        int expectedNumberOfPlayerCards = 2;
//        int expectedNumberOfDealerCards = 2;
//
//        Player player = game.getPlayer();
//        Player dealer = game.getDealer();
//
//        int actualNumberOfPlayerCards = player.getHand().size();
//        int actualNumberOfDealerCards = dealer.getHand().size();
//
//        Assert.assertEquals(expectedNumberOfPlayerCards, actualNumberOfPlayerCards);
//        Assert.assertEquals(expectedNumberOfDealerCards, actualNumberOfDealerCards);
//    }
//
//    @Test
//    public void playerWinsTest_True1() {
//        Game game = new Game();
//
//        Player player = game.getPlayer();
//        Player dealer = game.getDealer();
//
//        Card ace = new Card(Suit.HEARTS, 1);
//        Card nine = new Card(Suit.CLUBS, 9);
//        Card ten = new Card(Suit.HEARTS, 10);
//
//        player.addToHand(ace);
//        player.addToHand(nine);
//        player.addToHand(ten);
//
//        dealer.addToHand(ten);
//        dealer.addToHand(nine);
//
//        boolean expected = true;
//
//        boolean actual = game.playerWins();
//
//        Assert.assertEquals(expected, actual);
//
//        System.out.println(player.getScore());
//        System.out.println(dealer.getScore());
//    }
//
//    @Test
//    public void playerWinsTest_True2() {
//        Game game = new Game();
//
//        Player player = game.getPlayer();
//        Player dealer = game.getDealer();
//
//        Card ace = new Card(Suit.HEARTS, 1);
//        Card nine = new Card(Suit.CLUBS, 9);
//        Card ten = new Card(Suit.HEARTS, 10);
//
//        player.addToHand(ace);
//        player.addToHand(nine);
//        player.addToHand(ten);
//
//        dealer.addToHand(ten);
//        dealer.addToHand(nine);
//        dealer.addToHand(nine);
//
//        boolean expected = true;
//
//        boolean actual = game.playerWins();
//
//        Assert.assertEquals(expected, actual);
//
//        System.out.println(player.getScore());
//        System.out.println(dealer.getScore());
//    }
//
//    @Test
//    public void playerWinsTest_True3() {
//        Game game = new Game();
//
//        Player player = game.getPlayer();
//        Player dealer = game.getDealer();
//
//        Card ace = new Card(Suit.HEARTS, 1);
//        Card nine = new Card(Suit.CLUBS, 9);
//        Card ten = new Card(Suit.HEARTS, 10);
//
//        player.addToHand(ace);
//        player.addToHand(ten);
//
//        dealer.addToHand(ten);
//        dealer.addToHand(nine);
//
//        boolean expected = true;
//
//        boolean actual = game.playerWins();
//
//        System.out.println(player.getScore());
//        System.out.println(dealer.getScore());
//
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void playerWinsTest_False() {
//        Game game = new Game();
//
//        Player player = game.getPlayer();
//        Player dealer = game.getDealer();
//
//        Card ace = new Card(Suit.HEARTS, 1);
//        Card nine = new Card(Suit.CLUBS, 9);
//        Card ten = new Card(Suit.HEARTS, 10);
//
//        player.addToHand(ace);
//        player.addToHand(ten);
//
//        dealer.addToHand(ten);
//        dealer.addToHand(ace);
//
//        boolean expected = false;
//
//        boolean actual = game.playerWins();
//
//        System.out.println(player.getScore());
//        System.out.println(dealer.getScore());
//
//        Assert.assertEquals(expected, actual);
//    }
//
////
////    @Test
////    public void hitPlayer() {
////        Game game = new Game();
////        Player player = game.getPlayer();
////        int expectedHandSize = 1;
////        game.askPlayerForHit(player);
////        int actualHandSize = player.getHandSize();
////        Assert.assertEquals(expectedHandSize, actualHandSize);
////
////    }
//
//    @Test
//    public void dealerHitUntilFinished() {
//        Game game = new Game();
//        Player dealer = game.getDealer();
//
//        boolean expected = true;
//
//        game.dealerHitUntilFinished();
//        boolean actual = (dealer.getHand().size() >= 2);
//
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void returnBet() {
//        Game game = new Game();
//
//        Player player = game.getPlayer();
//        Player dealer = game.getDealer();
//
//        Card ace = new Card(Suit.HEARTS, 1);
//        Card nine = new Card(Suit.CLUBS, 9);
//        Card ten = new Card(Suit.HEARTS, 10);
//
//        player.addToHand(ace);
//        player.addToHand(ten);
//
//        dealer.addToHand(ten);
//        dealer.addToHand(nine);
//
//        Double expected = 550.0;
//        player.makeBet(50.0);
//        game.addToPot(50.0);
//        game.returnBet();
//        Double actual = player.getMoney();
//        Assert.assertEquals(expected, actual, .001);
//    }
}
