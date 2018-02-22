package io.zipcoder.casinotest.test.GameTest.cardGameTest.utilitiesTest;

import io.zipcoder.casino.Game.cardGame.utilities.Card;
import io.zipcoder.casino.Game.cardGame.utilities.Deck;
import org.junit.Before;
import org.junit.Test;


public class DeckTest {

    Deck testDeck;

    @Before
    public void setup () {

        testDeck = new Deck();
    }

    @Test
    public void getCard1() {

      Card card = testDeck.getCard();
        System.out.println(card.getRank() + " of " + card.getSuit());
        testDeck.shuffle();
        System.out.println(card.getRank() + " of " + card.getSuit());




    }



}
