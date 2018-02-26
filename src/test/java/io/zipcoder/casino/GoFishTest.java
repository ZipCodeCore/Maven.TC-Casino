package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class GoFishTest {

    private Deck houseDeckTest = new Deck();
    private Deck houseDeckTest2 = new Deck();

    private Person player1Test = new Person("Joe");
    private Person dealerTest = new Person("Dealer");
    private Person playerBookTest = new Person("BookTest");

    private Card cardTest1 = new Card(Rank.SEVEN,Suit.SPADES);
    private Card cardTest2 = new Card(Rank.SEVEN,Suit.HEARTS);
    private Card cardTest3 = new Card(Rank.SEVEN,Suit.DIAMONDS);
    private Card cardTest4 = new Card(Rank.SEVEN,Suit.CLUBS);
    private Card cardTest5 = new Card(Rank.ACE,Suit.SPADES);


    @Before
    public void startingUp() {
        for (int i = 0; i < 7; i++) {
            player1Test.getHand().getHandArrayList().add(houseDeckTest.drawCard());
        }

        for (int i = 0; i < 7; i++) {
            dealerTest.getHand().getHandArrayList().add(houseDeckTest.drawCard());
        }

        houseDeckTest2.clearDeck();
        houseDeckTest2.getDeckOfCards().add(cardTest1);
        houseDeckTest2.getDeckOfCards().add(cardTest2);
        houseDeckTest2.getDeckOfCards().add(cardTest3);
        houseDeckTest2.getDeckOfCards().add(cardTest4);
        houseDeckTest2.getDeckOfCards().add(cardTest5);

        for (int i = 0; i < 5; i++) {
            playerBookTest.getHand().getHandArrayList().add(houseDeckTest2.drawCard());
        }
    }

    @Test
    public void StartingDeckTest() {
        Person player1 = new Person("Joe");
        GoFish goFishTest = new GoFish(player1);
        Deck deckTest = new Deck();
        Person dealer = new Person();

        Hand dealerHandTest = new Hand();

        goFishTest.startingDrawDeck(deckTest);

        int expected = 38;
        int actual = deckTest.getDeckOfCards().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void doYouHaveTheCardThatIWant() {
        Person player1 = new Person("Joe");
        GoFish goFishTest = new GoFish(player1);
        Person dealer = new Person();

        // card counts as int 1
        Card cardSend = new Card(Rank.ACE, Suit.SPADES);

        int expected = 1;
        int actual = goFishTest.doYouHaveTheCardThatIWantFromComputer(1, dealerTest);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeCardsFromComputerPlayerAndIntoHandTest () {
        Person player1 = new Person("Joe");
        GoFish goFishTest = new GoFish(player1);

        Card cardSend = new Card(Rank.ACE, Suit.SPADES);

        int actual = goFishTest.removeCardsFromComputerPlayerAndIntoHand(1, dealerTest, player1Test);
        int expected = cardSend.getRank().toInt();


        Assert.assertEquals(expected, actual);
    }

    @Test
    public void BookCheckerTest(){
        GoFish goFishTest = new GoFish();

        System.out.println(playerBookTest.getHand().getHandArrayList());

        Card cardSend = new Card(Rank.SEVEN,Suit.CLUBS);

        String expected = "[A♠, 7♣, 7♦, 7♥, 7♠]";
        String actual = playerBookTest.getHand().getHandArrayList().toString();

        System.out.println(playerBookTest.getHand().getHandArrayList());

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void goFishTest(){
        GoFish goFishTest = new GoFish();

        Card cardExpected = new Card(Rank.KING,Suit.SPADES);

        String expected = "K♠";
        String actual = cardExpected.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkNumberOfHandsTest(){
        Person player1 = new Person("Joe");
        GoFish goFishTest = new GoFish(player1);

        int expected = 0;
        int actual = goFishTest.checkNumberOfCard();

        Assert.assertEquals(expected, actual);
    }

}
