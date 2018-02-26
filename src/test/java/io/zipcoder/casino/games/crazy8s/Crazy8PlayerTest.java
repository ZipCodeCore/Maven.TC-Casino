package io.zipcoder.casino.games.crazy8s;

import io.zipcoder.casino.games.Card;
import io.zipcoder.casino.games.Deck;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class Crazy8PlayerTest {

        @Test
        public void  Crazy8PlayerTest(String name) {
            //Given

            Crazy8Player game = new Crazy8Player("Kay");
            String expected = "Kay";

            Assert.assertEquals(game, expected);

        }

        @Test
        public void getPlayersHandTest() {

            //Given
            Deck deck = new Deck(); //get new deck to play with
            int handSize = 8;

            Card[] playersHand = deck.pullMany(handSize);   //deal playersHand

            Assert.assertEquals(true, playersHand.length == 8);
            }


        @Test
        public void setPlayersHandTest(ArrayList<Card> playersHand) {
            //Given
            Crazy8Player player = new Crazy8Player("player");

            Deck deck = new Deck(); //get new deck to play with

            Assert.assertEquals(true, playersHand.size() == 8);
        }

        @Test
        public void isPlayerCardsValidTest() {
            Crazy8Player player = new Crazy8Player("player");


        }

        @Test
        public void setPlayerCardsValidTest(boolean playerCardsValid) {
            Crazy8Player player = new Crazy8Player("player");


        }

        @Test
        public void isPlayerHasEightTest() {
            Crazy8Player player = new Crazy8Player("player");

            player.setPlayerHasEight(true);
            Assert.assertEquals(true ,player.isPlayerHasEight());
        }

        @Test
        public void setPlayerHasEightTest(boolean playerHasEight) {

            Crazy8Player player = new Crazy8Player("player");

            player.setPlayerHasEight(true);
            Assert.assertTrue(playerHasEight);

        }

        @Test
        public void getNameTest() {
            Crazy8Player player = new Crazy8Player("player");

            String expected = "player";
            String actual = player.getName();

            Assert.assertEquals(expected, actual);
        }

        @Test
        public void setNameTest(String name) {
            Crazy8Player player = new Crazy8Player("player");


            player.setName(name);
            String actual = player.getName();

            Assert.assertEquals(name, actual);
        }

        }


