package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GoFishTest {

    @Test
    public void startGameTest(){
        GoFish goFish = new GoFish();
        CardPlayer chewy = new CardPlayer("chewy", 100.00);
        goFish.startGame(chewy, 2);

        String expected = "";
        String actual = goFish.playersToString();

        Assert.assertEquals(expected, actual);
    }

    //Single card deal test
//    @Test
//    public void dealCardsTest(){
//        GoFish goFish = new GoFish();
//        goFish.goFishDeck.createFullDeck();
//        CardPlayer chewy = new CardPlayer("Chewy", 100.00);
//
//        Card expected = new Card(Suit.SPADE, Value.THREE);
//        Card actual = goFish.dealCards();
//
//        Assert.assertEquals(expected, actual);
//
//    }

    @Test
    public void giveGoFishCard(){
        GoFish goFish = new GoFish();
        goFish.goFishDeck.createFullDeck();
        CardPlayer chewy = new CardPlayer("Chewy", 100.00);

        Card expected = new Card(Suit.HEART, Value.EIGHT);
        Card actual = goFish.goFishDeck.giveCard();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void dealCardsTest(){
        GoFish goFish = new GoFish();
        goFish.goFishDeck.createFullDeck();
        CardPlayer chewy = new CardPlayer("Chewy", 100.00);

        goFish.startGame(chewy, 1);
        goFish.dealCards();

        int expected = 8;
        int actual = goFish.players.get(0).getHand().size();

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