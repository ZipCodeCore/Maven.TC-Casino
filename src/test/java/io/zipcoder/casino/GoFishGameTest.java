package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
/*-



-As a gofish player I would like to score a point when I have a book to lay down.
        test for the number of cards of the same rank in the player hand
      test I have 4 cards of the same Rank, I remove the cards from my hand
      test my score incremented one point.


-As a gofish player I would like to see the final score when the deck is empty.
        test which player has the biggest amount of points


*/

public class GoFishGameTest {

    GoFishGame goFishGame = new GoFishGame();

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

    public void playerHandDisplayTest() {
//        Card card = new Card(Rank.EIGHT, Suit.SPADE);
//        Card card1 = new Card(Rank.SEVEN, Suit.CLUB);
//        Card card3 = new Card(Rank.SEVEN, Suit.HEART);
//        Card card2 = new Card(Rank.ACE, Suit.CLUB);
//        ArrayList<Card> playerHand1 = new ArrayList<>();
//        playerHand1.add(card);
//        playerHand1.add(card1);
//        playerHand1.add(card2);
//        playerHand1.add(card3);
//
//        goFishGame.setPlayerHand(playerHand1);
//
//        String expected = "You have {7=1, 8=1}";
//
//        String actual = goFishGame.playerHandDisplay().toString();
//
//        //  Map<String, Long> playerMap = goFishGame.playerHandDisplay();
//        ArrayList<Card> cards = goFishGame.playerHand();
//        // System.out.println(playerMap.values());
//        System.out.println(cards.size());

      // String[] rank = {"7", "8","9", "10", "J"};

      //  for (int i = 0; i < goFishGame.getPlayerHand().size()-1; i++) {
           // String rank = goFishGame.getComputerHand().get(i).getRank().getSymbol();
          //  for (Iterator<Card> iter = cards.iterator(); iter.hasNext(); ){
               // Rank rank = iter.next().getRank();
      //  for(int i =0; i<goFishGame.getPlayerHand().size(); i++){
          //  String rank = goFishGame.getPlayerHand().get(i).getRank().getSymbol();
            int z =0;
        int count = 0;
        int score = 0;
        ArrayList<Card> cards = goFishGame.playerHand();
            while(z<goFishGame.getPlayerHand().size()){
                String rank = goFishGame.getPlayerHand().get(z).getRank().getSymbol();
                for (Iterator<Card> it = cards.iterator(); it.hasNext(); ) {

                if (it.next().getRank().getSymbol().equalsIgnoreCase(rank)) {
                    count++;
                    if (count == 3)
                        score++;
                        it.remove();

                }
            }
            z++;
       }
            System.out.println("count is " + count);
            System.out.println("score is " + score);

            System.out.println(cards);


    }


    @Test
    public void passingCardFromPlayerToComputerTest() {

        Card card = new Card(Rank.EIGHT, Suit.SPADE);
        Card card1 = new Card(Rank.SEVEN, Suit.CLUB);
        Card card2 = new Card(Rank.ACE, Suit.CLUB);
        ArrayList<Card> computerHand1 = new ArrayList<>();
        computerHand1.add(card);
        computerHand1.add(card1);
        goFishGame.setComputerHand(computerHand1);
        Boolean expected = true;
        Boolean actual = goFishGame.checkComputerHandForPlayerRequestedCard("7");
        Boolean expected2 = false;
        Boolean actual2 = goFishGame.checkPlayerHasRequestedCardRank("6");
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected2, actual2);
    }

    @Test

    public void checkComputerHandForPlayerRequestedCardRank() {
        goFishGame.playerHand();
        Card card0 = new Card(Rank.SIX, Suit.SPADE);
        Card card = new Card(Rank.SEVEN, Suit.SPADE);
        Card card1 = new Card(Rank.SEVEN, Suit.CLUB);

        ArrayList<Card> computerHand1 = new ArrayList<>();
        computerHand1.add(card0);
        computerHand1.add(card);
        computerHand1.add(card1);

        goFishGame.setComputerHand(computerHand1);

        Boolean expected = true;
        Boolean actual = goFishGame.checkComputerHandForPlayerRequestedCard("7");

        Assert.assertEquals(expected, actual);
    }

  /*  @Test
    public void checkPlayerCanTakeCardFromComputerTest() {    // tested by viewing the console and passed the test.
        goFishGame.getDeck();
        goFishGame.playerHand();
        Card card0 = new Card(Rank.SIX, Suit.SPADE);
        Card card = new Card(Rank.SEVEN, Suit.SPADE);


        ArrayList<Card> computerHand1 = new ArrayList<>();
        computerHand1.add(card0);
        computerHand1.add(card);


        goFishGame.setComputerHand(computerHand1);

        String expected = " The computer has 7\nYour hand is [5♧, 10♤, 9♧, 3♧, 6♢, 9♢, J♧, 7♧]\n" +
                "Insert the next card you want: ";

        goFishGame.askComputerHandForACard("7");
    }*/


    @Test

    public void computerDecisionForCardTest() {
        Card card0 = new Card(Rank.SIX, Suit.SPADE);
        Card card1 = new Card(Rank.SIX, Suit.HEART);
        Card card2 = new Card(Rank.SEVEN, Suit.SPADE);
        Card card3 = new Card(Rank.SEVEN, Suit.HEART);
        Card card4 = new Card(Rank.SEVEN, Suit.SPADE);

        ArrayList<Card> computerHand1 = new ArrayList<>();
        computerHand1.add(card0);
        computerHand1.add(card1);
        computerHand1.add(card2);
        computerHand1.add(card3);
        computerHand1.add(card4);
        goFishGame.setComputerHand(computerHand1);

        String expected = "7";

        String actual = goFishGame.computerCardToRequest();

        Assert.assertEquals(expected, actual);

    }

    @Test

    public void checkPlayersCardRequestForInputBoundary() {
        Card card1 = new Card(Rank.SIX, Suit.HEART);
        Card card = new Card(Rank.SEVEN, Suit.DIAMOND);
        ArrayList<Card> playerHand1 = new ArrayList<>();
        playerHand1.add(card1);
        playerHand1.add(card);

        goFishGame.setPlayerHand(playerHand1);
        Boolean expected = true;
        Boolean actual = goFishGame.checkPlayersCardRequestForInputBoundary("9");
        Assert.assertEquals(expected, actual);
        Boolean expected2 = false;
        Boolean actual2 = goFishGame.checkPlayersCardRequestForInputBoundary("12");
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void checkPlayersCardRequestForGameRuleTest(){
        Card card1 = new Card(Rank.SIX, Suit.HEART);
        Card card = new Card(Rank.SEVEN, Suit.DIAMOND);

        ArrayList<Card> playerHand1 = new ArrayList<>();
        playerHand1.add(card1);
        playerHand1.add(card);

        goFishGame.setPlayerHand(playerHand1);

        Boolean expected = false;
        Boolean actual = goFishGame.checkPlayersCardRequestForGameRule("10");
        Assert.assertEquals(expected, actual);

        Boolean expected2 = true;
        Boolean actual2 = goFishGame.checkPlayersCardRequestForGameRule("7");
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

    @Test

    public void playerHandBookTest(){
        Card card1 = new Card(Rank.SIX, Suit.CLUB);
        Card card2 = new Card(Rank.SEVEN, Suit.HEART);
        Card card3 = new Card(Rank.SIX, Suit.DIAMOND);
        Card card4 = new Card(Rank.EIGHT, Suit.HEART);
        Card card5 = new Card(Rank.SIX, Suit.SPADE);
        Card card6 = new Card(Rank.SEVEN, Suit.CLUB);
        Card card7 = new Card(Rank.SIX, Suit.HEART);
        Card card8 = new Card(Rank.FIVE, Suit.SPADE);

        ArrayList<Card> playerHand1 = new ArrayList<>();
        playerHand1.add(card1);
        playerHand1.add(card2);
        playerHand1.add(card3);
        playerHand1.add(card4);
        playerHand1.add(card5);
        playerHand1.add(card6);
        playerHand1.add(card7);
        playerHand1.add(card8);


        goFishGame.setPlayerHand(playerHand1);

       // goFishGame.checkPlayerHandForBook();
        System.out.println(playerHand1.size());
        System.out.println(playerHand1.get(0));




    }



}