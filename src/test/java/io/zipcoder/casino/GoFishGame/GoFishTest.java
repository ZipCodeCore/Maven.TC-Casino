package io.zipcoder.casino.GoFishGame;

import io.zipcoder.casino.GoFishGame.GoFish;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.PlayerWarehouse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class GoFishTest {
    GoFish aGoFishGame;
    ArrayList<Player> listOfPlayers;

    @Before
    public void setup() {
        listOfPlayers = new ArrayList<>();
        Player playerOne = new Player("Andrew");
        Player playerTwo = new Player("Brian");
        Player playerThree = new Player("Tim");

        PlayerWarehouse.setCurrentPlayer(playerOne);
        aGoFishGame = new GoFish();

        playerOne.addPointToScore();
        playerTwo.addPointToScore();
        playerThree.addPointToScore();
        playerThree.addPointToScore();

        listOfPlayers.add(playerOne);
        listOfPlayers.add(playerTwo);
        listOfPlayers.add(playerThree);

        aGoFishGame.setPlayersList(listOfPlayers);
    }

    @After
    public void tearDown() {
        listOfPlayers = new ArrayList<>();
        aGoFishGame = new GoFish();
        aGoFishGame.setPlayersList(listOfPlayers);
    }

    @Test
    public void numOfOpponentsTest() {
        //private method, no need for test
    }

    @Test
    public void decideOrderOfPlayersTest() {
        //uses a java collections method and prints to console, no need to test
    }

    @Test
    public void dealARoundTest() {
        Integer expected = 1;
        aGoFishGame.dealARound();
        Integer actual = aGoFishGame.getPlayersList().get(0).getHand().size();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void dealFirstRoundTest() {
        Integer expected = 5;
        aGoFishGame.dealFirstRound(5);
        Integer actual = aGoFishGame.getPlayersList().get(0).getHand().size();
        Assert.assertEquals(expected,actual);
    }


//    @Test
//    public void checkForPairOf4Test() throws Exception {
//        GoFish aGoFishGame = new GoFish();
//        Player aPlayer = new Player("Andrew");
//        aGoFishGame.setCurrentPlayer(aPlayer);
//        //PlayerWarehouse.setCurrentPlayer(aPlayer);
//        Card cardOne = new Card(Suit.DIAMONDS, 10, Card.suitSymbols[1], "A");
//        Card cardTwo = new Card(Suit.CLUBS, 9, Card.suitSymbols[2], "9");
//        Card cardThree = new Card(Suit.HEARTS, 10, Card.suitSymbols[0], "J");
//        Card cardFour = new Card(Suit.HEARTS, 10, Card.suitSymbols[0], "A");
//        Card cardFive = new Card(Suit.SPADES, 10, Card.suitSymbols[3], "A");
//        Card cardSix = new Card(Suit.CLUBS, 10, Card.suitSymbols[2], "A");
//
//        aPlayer.addToHand(cardOne);
//        aPlayer.addToHand(cardTwo);
//        aPlayer.addToHand(cardThree);
//        aPlayer.addToHand(cardFour);
//        aPlayer.addToHand(cardFive);
//        aPlayer.addToHand(cardSix);
//
//        aGoFishGame.printPlayersHand(aPlayer);
//
//        int expected = 16;
//        aGoFishGame.checkForPairOf4(aPlayer);
//
//        aGoFishGame.printPlayersHand(aPlayer);
//    }
//
//    public void checkForCardInHandTest() {
//
//
//
//    }
//
//    public void returnFaceValue() {
//
//    }
//
//    @Test
//    public void doesPlayerHaveCardsInHandTest() {
//        boolean actual = aGoFishGame.noCardsInPlayersHandError(playerOne);
//        Assert.assertFalse(actual);
//    }
//
//    @Test
//    public void goFishWinnerTest() {
//        String expected = "Tim";
//        String actual = aGoFishGame.goFishWinner();
//        Assert.assertEquals(expected,actual);
//    }

}