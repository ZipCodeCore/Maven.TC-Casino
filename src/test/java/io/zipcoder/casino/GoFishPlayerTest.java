//package io.zipcoder.casino;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.experimental.theories.suppliers.TestedOn;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.*;
//
//public class GoFishPlayerTest {
//    @Test
//    public void checkHandForCard() throws Exception {
//        GoFishGame gameOn = new GoFishGame();
//        GoFishPlayer player1 = new GoFishPlayer();
//
//        String expected = "";
//        for(int i=0; i<5;i++){
//            Card card = player1.drawCard(gameOn.getGameDeck());
//            player1.addCardToHand(card);
//            expected += card.getRank() + " of " +card.getSuit()+"s\n";
//        }
//
//        Rank rank = player1.getHand().get(3).getRank();
//
//        System.out.println(expected);
//        Assert.assertTrue(player1.checkHandForCard(rank));
//
//    }
//
//    @Test
//    public void giveCard() throws Exception {
//        GoFishGame gameOn = new GoFishGame();
//        GoFishPlayer player1 = new GoFishPlayer();
//
//        String expected = "";
//        for(int i=0; i<5;i++){
//            Card card = player1.drawCard(gameOn.getGameDeck());
//            player1.addCardToHand(card);
//            expected += card.getRank() + " of " +card.getSuit()+"s\n";
//        }
//
//        System.out.println(expected);
//
//        Rank rank = player1.getHand().get(3).getRank();
//        Card myCard = player1.giveCard(rank);
//
//        Assert.assertEquals(myCard.getRank(), rank);
//
//    }
//
//    @Test
//    public void drawCard() throws Exception {
//        GoFishGame gameOn = new GoFishGame();
//        GoFishPlayer player1 = new GoFishPlayer();
//
//        gameOn.addPlayer(player1);
//
//        for(int i = 0; i < 52; i++){
//            Card expectedCard = gameOn.getGameDeck().getCards().get(0);
//            Card actualCard = player1.drawCard(gameOn.getGameDeck());
//            //System.out.println(gameOn.getGameDeck().getDeckSize());
//            Assert.assertEquals(expectedCard,actualCard);
//        }
//    }
//
//    @Test
//    public void checkFourOfAKindTest(){
//        Card someClub = new Card(Rank.EIGHT,Suit.CLUB);
//        GoFishPlayer somePlayer = new GoFishPlayer();
//
//        for(int i =0; i<4;i++){
//            somePlayer.addCardToHand(someClub);
//        }
//        somePlayer.addCardToHand(new Card(Rank.ACE,Suit.HEART));
//
//        Assert.assertEquals(somePlayer.checkFourOfAKind(), Suit.CLUB);
//
//    }
//
//    @Test
//    public void drawFiveCardsTest(){
//        GoFishPlayer somePlayer = new GoFishPlayer();
//        GoFishGame gameOn = new GoFishGame();
//
//        somePlayer.drawFiveCards(gameOn.getGameDeck());
//
//        ArrayList<Card> hand = somePlayer.getHand();
//
//
//        for(Card card:hand){
//            String expected = card.getRank() + " of " +card.getSuit()+"s";
//            System.out.println(expected);
//        }
//
//
//    }
//
//}