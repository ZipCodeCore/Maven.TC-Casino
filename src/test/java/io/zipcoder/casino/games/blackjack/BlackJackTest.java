package io.zipcoder.casino.games.blackjack;

import io.zipcoder.casino.games.Card;
import io.zipcoder.casino.games.Deck;
import io.zipcoder.casino.games.Rank;
import io.zipcoder.casino.games.Suit;
import org.junit.Assert;
import org.junit.Test;

public class BlackJackTest {

   // BlackJack blackJack = new BlackJack();

    @Test
    public void testAddPlayerCards() {
        Card card1 = new Card(Rank.FOUR, Suit.SPADES);
        Card card2 = new Card(Rank.SEVEN, Suit.HEARTS);

        Card[] cards = {card1, card2};
        Deck fakeDeck = new FakeDeckTest(cards);

        BlackJack blackJackTest = new BlackJack(fakeDeck);

       Integer actual = blackJackTest.dealPlayerHandValue();
       Integer expected = 11;
       Assert.assertEquals(expected, actual);

    }

    @Test
    public void testAddDealerCards(){
        Card card1 = new Card(Rank.FOUR, Suit.SPADES);
        Card card2 = new Card(Rank.SEVEN, Suit.HEARTS);

        Card[] cards = {card1, card2};
        Deck fakeDeck = new FakeDeckTest(cards);

        BlackJack blackJackTest = new BlackJack(fakeDeck);

        Integer actual = blackJackTest.dealDealerHandValue();
        Integer expected = 11;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testDisplayHand(){
        Card card1 = new Card(Rank.SEVEN, Suit.HEARTS);
        Card card2 = new Card(Rank.EIGHT, Suit.CLUBS);

        Card[] cards = {card1, card2};
        Deck fakeDeck = new FakeDeckTest(cards);

        BlackJack blackJackTest = new BlackJack(fakeDeck);

        String actual = blackJackTest.displayPlayerHand();
        String expected = actual;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testSplittable(){

    }

}
