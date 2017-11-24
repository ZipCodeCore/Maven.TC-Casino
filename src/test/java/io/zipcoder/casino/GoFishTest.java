package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class GoFishTest {

    @Test
    public void startGameTest(){
        GoFish goFish = new GoFish();
        CardPlayer chewy = new CardPlayer("chewy", 100.00);
        goFish.startGame(chewy, 2);

        String expected = "";
        String actual = goFish.goFishDeck.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void giveGoFishCard(){
        GoFish goFish = new GoFish();
        goFish.goFishDeck.createFullDeck();
        CardPlayer chewy = new CardPlayer("Chewy", 100.00);

        Card expected = new Card(Suit.HEART, Value.EIGHT);
        Card actual = goFish.goFishDeck.deal();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void dealCardsTest(){
        GoFish goFish = new GoFish();
        CardPlayer chewy = new CardPlayer("Chewy", 100.00);

        goFish.startGame(chewy, 3);

        String expected = "";

        String actual = "";
        for (CardPlayer player : goFish.players){
            actual += player.toString() + "\n\n";
        }
        actual += goFish.goFishDeck.getSize();

        Assert.assertEquals(expected, actual);
    }

    // Single run test
    @Test
    public void pickFirstPlayerTest(){
        GoFish goFish = new GoFish();
        CardPlayer chewy = new CardPlayer("Chewy", 100.00);

        goFish.startGame(chewy, 3);

        String expected = "";

        String actual = goFish.pickCurrentPlayer().getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void askForCardTest(){
        GoFish goFish = new GoFish();
        CardPlayer chewy = new CardPlayer("Chewy", 100.00);

        goFish.startGame(chewy, 3);
        System.out.println(goFish.players.get(1).toString());

        boolean expected = false;
        boolean actual = goFish.askForCard(goFish.players.get(1), "FIVE");

        Assert.assertEquals(expected, actual);
    }

    // loop to test multiple starts
    @Test
    public void pickFirstPlayerTest2(){
//        GoFish goFish = new GoFish();
//        CardPlayer chewy = new CardPlayer("Chewy", 100.00);

        String expected = "";
        String actual = "";

        for (int i = 0; i < 10; i++){
            GoFish goFish = new GoFish();
            CardPlayer chewy = new CardPlayer("Chewy", 100.00);
            goFish.startGame(chewy, 3);
            actual += goFish.pickCurrentPlayer().getName() + "\n";
        }

        Assert.assertEquals(expected, actual);
    }

//    @Test
//    public void constructorTest(){
//        CardPlayer chewy = new CardPlayer("chewy", 100.00);
//        GoFish goFish = new GoFish(chewy, 2);
//
//        String expected = "";
//        String actual = goFish.players.get(0).getName();
//
//        Assert.assertEquals(expected, actual);
//    }

//    @Test
//    public void startGameTest(){
//        CardPlayer chewy = new CardPlayer("chewy", 100.00);
//        GoFish goFish = new GoFish();
//        goFish.startGame(chewy);
//
//        String expected = "";
//        String actual = goFish.currentUser.getName();
//
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void generatePlayersTest(){
//        GoFish goFish = new GoFish();
//
//        CardPlayer chewy = new CardPlayer("chewy", 100.00);
//        goFish.setCurrentUser(chewy);
//
//        ArrayList<CardPlayer> players = new ArrayList<CardPlayer>();
//        goFish.setPlayers(players);
//
//        goFish.generatePlayers(2);
//
//        String expected = "";
//        String actual = goFish.playersToString();
//
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void dealCardsTest(){
//        GoFish goFish = new GoFish();
//        goFish.goFishDeck.createFullDeck();
//
//        CardPlayer chewy = new CardPlayer("chew", 100.00);
//        goFish.setCurrentUser(chewy);
//
//        ArrayList<CardPlayer> players = new ArrayList<CardPlayer>();
//        goFish.setPlayers(players);
//
//        goFish.generatePlayers(3);
//
//        goFish.dealCards(goFish.goFishDeck);
//
//        int expected = 1;
//        int actual = chewy.getHand().size();
//
//        Assert.assertEquals(expected, actual);
//    }

}