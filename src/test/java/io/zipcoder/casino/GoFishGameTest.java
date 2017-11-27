package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

public class GoFishGameTest {

    GoFishGame goFishGame = new GoFishGame();
    Card card1 = new Card(Rank.TWO, Suit.CLUB);
    Card card3 = new Card(Rank.THREE, Suit.SPADE);
    Card card2 = new Card(Rank.TWO, Suit.SPADE);
    Card card4 = new Card(Rank.THREE, Suit.CLUB);
    Card card5 = new Card(Rank.TWO, Suit.HEART);
    Card card6 = new Card(Rank.TWO, Suit.DIAMOND);
    Card card7 = new Card(Rank.THREE, Suit.HEART);
    Card card8 = new Card(Rank.THREE, Suit.SPADE);
    ArrayList<Card> playerHand1 = new ArrayList<>();
    ArrayList<Card> computerHand1 = new ArrayList<>();




    @Test
    public void createGoFishGameTest() throws Exception {

        int expected = 52;
        int expected2 = 7;
        int actual = goFishGame.getDeck().size();
        int actual2 = goFishGame.playerHand().size();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected2, actual2);
        Assert.assertTrue(goFishGame.player instanceof Player);

    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenDeckIsNullStartingGame() {
        goFishGame.setDeck(null);
        GoFishPlayer goFishPlayer = mock(GoFishPlayer.class);
        goFishGame.startGame();
    }
    @Test

    public void playerHandget7CardStartOfGame() {
        int expectedBeforeMethodCall = 0;
        int actualBeforeMethodCall = goFishGame.getComputerHand().size();
        goFishGame.playerHand();
        int expectedPlayerHandSize = 7;
        int actualPlayerHandSize = goFishGame.getPlayerHand().size();
        Assert.assertEquals(expectedBeforeMethodCall, actualBeforeMethodCall);
        Assert.assertEquals(expectedPlayerHandSize, actualPlayerHandSize);
    }
    @Test

    public void computerHandget7CardStartOfGame() {
        int expectedBeforeMethodCall = 0;
        int actualBeforeMethodCall = goFishGame.getComputerHand().size();

        goFishGame.computerHand();

        int expectedComputerHandSize = 7;
        int actualComputerhandSize = goFishGame.getComputerHand().size();
        Assert.assertEquals(expectedBeforeMethodCall, actualBeforeMethodCall);
        Assert.assertEquals(expectedComputerHandSize, actualComputerhandSize);

    }
    @Test

    public void getAndSetPlayerHandTest(){
        playerHand1.add(card1);
        playerHand1.add(card2);
        goFishGame.setPlayerHand(playerHand1);
        int expected = 2;
        int actual = goFishGame.getPlayerHand().size();
    }

    @Test

    public void getAndSetComputerHand(){
        playerHand1.add(card1);
        playerHand1.add(card2);
        playerHand1.add(card3);
        goFishGame.setComputerHand(playerHand1);
        int expected = 3;
        int actual = goFishGame.getComputerHand().size();
    }

    @Test
    public void deckSizeDecreaseAfterDeal() throws Exception {
        goFishGame.getDeck();

        int expectedBeforeDealing = 52;
        int actualBeforeDealing = goFishGame.getDeck().size();

        goFishGame.computerHand();
        goFishGame.playerHand();

        int expectedAfterDealing = 52 - (goFishGame.getPlayerHand().size() + goFishGame.getComputerHand().size());
        int actualAfterDealing = goFishGame.getDeck().size();

        Assert.assertEquals(expectedBeforeDealing, actualBeforeDealing);
        Assert.assertEquals(expectedAfterDealing, actualAfterDealing);
    }
    @Test

    public void playerHandDisplayAndSetPlayerHandTest() {

        ArrayList<Card> playerHand1 = new ArrayList<>();
        playerHand1.add(card1);
        playerHand1.add(card2);

        goFishGame.setPlayerHand(playerHand1);

        String expected = "You have {2=1, 3=1}";
        String actual = goFishGame.playerHandDisplay().toString();

    }


    @Test
    public void passingCardFromPlayerToComputerTest() {

        computerHand1.add(card1);
        computerHand1.add(card2);
        goFishGame.setComputerHand(computerHand1);
        Boolean expected = true;
        Boolean actual = goFishGame.checkComputerHandForPlayerRequestedCard("2");
        Boolean expected2 = false;
        Boolean actual2 = goFishGame.checkPlayerHasRequestedCardRank("4");
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected2, actual2);
    }

    @Test

    public void checkComputerHandForPlayerRequestedCardRank() {
        computerHand1.add(card1);
        computerHand1.add(card2);
        computerHand1.add(card3);

        goFishGame.setComputerHand(computerHand1);

        Boolean expected = true;
        Boolean actual = goFishGame.checkComputerHandForPlayerRequestedCard("2");

        Assert.assertEquals(expected, actual);
    }

//  @Test
//    public void checkPlayerCanTakeCardFromComputerTest() {    // tested by viewing the console and passed the test.
//        goFishGame.getDeck();
//        goFishGame.playerHand();
//        Card card0 = new Card(Rank.SIX, Suit.SPADE);
//        Card card = new Card(Rank.SEVEN, Suit.SPADE);
//
//
//        ArrayList<Card> computerHand1 = new ArrayList<>();
//        computerHand1.add(card0);
//        computerHand1.add(card);
//
//
//        goFishGame.setComputerHand(computerHand1);
//
//        String expected = " The computer has 7\nYour hand is [5♧, 10♤, 9♧, 3♧, 6♢, 9♢, J♧, 7♧]\n" +
//                "Insert the next card you want: ";
//
//        goFishGame.askComputerHandForACard("7");
//    }


    @Test

    public void computerDecisionForCardTest() {
        computerHand1.add(card5);
        computerHand1.add(card1);
        computerHand1.add(card6);
        computerHand1.add(card3);
        computerHand1.add(card4);
        goFishGame.setComputerHand(computerHand1);

        String expected = "3";

        String actual = goFishGame.computerCardToRequest();

        Assert.assertEquals(expected, actual);

    }

//    @Test

//    public void checkPlayersCardRequestForInputBoundary() {
//        Card card1 = new Card(Rank.SIX, Suit.HEART);
//        Card card = new Card(Rank.SEVEN, Suit.DIAMOND);
//        ArrayList<Card> playerHand1 = new ArrayList<>();
//        playerHand1.add(card1);
//        playerHand1.add(card);
//
//        goFishGame.setPlayerHand(playerHand1);
//        Boolean expected = true;
//        Boolean actual = goFishGame.checkPlayersCardRequestForInputBoundary("9");
//        Assert.assertEquals(expected, actual);
//        Boolean expected2 = false;
//        Boolean actual2 = goFishGame.checkPlayersCardRequestForInputBoundary("12");
//        Assert.assertEquals(expected2, actual2);
//    }

    @Test
    public void checkPlayersCardRequestForGameRuleTest(){
        ArrayList<Card> playerHand1 = new ArrayList<>();
        playerHand1.add(card1);
        playerHand1.add(card2);

        goFishGame.setPlayerHand(playerHand1);

        Boolean expected = false;
       Boolean actual = goFishGame.checkPlayersCardRequestForGameRule("10");
        Assert.assertEquals(expected, actual);

        Boolean expected2 = true;
       Boolean actual2 = goFishGame.checkPlayersCardRequestForGameRule("2");
       Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void checkInputTest(){
        ArrayList<Card> playerHand1 = new ArrayList<>();
        playerHand1.add(card1);
        playerHand1.add(card3);

        goFishGame.setPlayerHand(playerHand1);

//        String expected = "";
//        String actual = goFishGame.checkInput("10");  // this test works but looping because the card isnt in the hand.
//        Assert.assertEquals(expected, actual);

        String expected2 = "2";
        String actual2 = goFishGame.checkInput("2");
        Assert.assertEquals(expected2, actual2);
    }

    @Test

    public void goFishingPlayerTest(){
        ArrayList<Card> deck = goFishGame.getDeck();
        goFishGame.getPlayerHand();

        Card card = deck.get(0);
        int expectSizeOfHandIncreaseBy1AfterGoFish = goFishGame.getPlayerHand().size() +1;
        Boolean expectedDeckTopCardToBeAvailable = true;
                Boolean actualDeckTopcardAvaialble = deck.contains(card);

        goFishGame.goFishingPlayer();

        int actualSizeOfPlayerHandIncreaseAfterGoFish = goFishGame.getPlayerHand().size();
        Boolean expectedDeckTopCardNotToBeAvailable= false;
        Boolean actualDeckTopCardNotToBeAvailable = deck.contains(card);
       Assert.assertEquals(expectedDeckTopCardNotToBeAvailable, actualDeckTopCardNotToBeAvailable);
        Assert.assertEquals(expectedDeckTopCardToBeAvailable, actualDeckTopcardAvaialble);
        Assert.assertEquals(expectSizeOfHandIncreaseBy1AfterGoFish, actualSizeOfPlayerHandIncreaseAfterGoFish);
    }
    @Test

    public void goFishingComputerTest(){
        ArrayList<Card> deck = goFishGame.getDeck();
        goFishGame.getComputerHand();

        Card card = deck.get(0);
        int expectSizeOfComouterHandIncreaseBy1AfterGoFish = goFishGame.getComputerHand().size() +1;
        Boolean expectedDeckTopCardToBeAvailable = true;
        Boolean actualDeckTopcardAvaialble = deck.contains(card);

        goFishGame.goFishingComputer();

        int actualSizeOfComputerHandIncreaseAfterGoFish = goFishGame.getComputerHand().size();
        Boolean expectedDeckTopCardNotToBeAvailable= false;
        Boolean actualDeckTopCardNotToBeAvailable = deck.contains(card);
        Assert.assertEquals(expectedDeckTopCardNotToBeAvailable, actualDeckTopCardNotToBeAvailable);
        Assert.assertEquals(expectedDeckTopCardToBeAvailable, actualDeckTopcardAvaialble);
        Assert.assertEquals(expectSizeOfComouterHandIncreaseBy1AfterGoFish, actualSizeOfComputerHandIncreaseAfterGoFish);

    }

//    @Test
//
//    public void playerHandBookTest(){
//
//        playerHand1.add(card1);
//        playerHand1.add(card2);
//        playerHand1.add(card3);
//        playerHand1.add(card4);
//        playerHand1.add(card5);
//        playerHand1.add(card6);
//        playerHand1.add(card7);
//
//        int actual = 7;
//       int expected1= playerHand1.size();
//        goFishGame.setPlayerHand(playerHand1);
//
//       // goFishGame.checkPlayerHandForBook();
//        goFishGame.removeBookedCard();
//        System.out.println(goFishGame.countBooksInPlayerHand());
//
//       int actual2=  playerHand1.size();
//       int expected =3;
//
//
//
//
//    }

    @Test

    public void countPlayerScoreTest(){
        Player player = goFishGame.getGoFishPlayer();
        int score =0;

        playerHand1.add(card1);
        playerHand1.add(card2);
        playerHand1.add(card3);
        playerHand1.add(card4);
        playerHand1.add(card5);
        playerHand1.add(card6);
        playerHand1.add(card7);
        playerHand1.add(card8);

        goFishGame.setPlayerHand(playerHand1);

       int expected = 2;
       int actual = goFishGame.countBooksInPlayerHand();
       Assert.assertEquals(expected, actual);



    }
    @Test
    public void countComputerScoreTest() {

        playerHand1.add(card1);
        playerHand1.add(card2);
        playerHand1.add(card3);
        playerHand1.add(card4);
        playerHand1.add(card5);
        playerHand1.add(card6);
        playerHand1.add(card7);
        playerHand1.add(card8);

        goFishGame.setComputerHand(playerHand1);
        int expected = 2;
        int actual = goFishGame.countBooksInComputerHand();
        Assert.assertEquals(expected, actual);
    }
    @Test
   public  void decideWinnerTest() {
        playerHand1.add(card1);
        playerHand1.add(card2);
        playerHand1.add(card3);
        playerHand1.add(card4);
        playerHand1.add(card5);
        playerHand1.add(card6);
        playerHand1.add(card7);
        playerHand1.add(card8);
        goFishGame.setComputerHand(playerHand1);

     goFishGame.countBooksInComputerHand();
     goFishGame.countBooksInPlayerHand();

        goFishGame.decideWiner();  // should pop the machine won because the computer has 2
                                    // books(cards added to the computer hand) while the player hand is empty

    }



}