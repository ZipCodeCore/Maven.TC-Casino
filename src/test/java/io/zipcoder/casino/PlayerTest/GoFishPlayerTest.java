package io.zipcoder.casino.PlayerTest;
import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Rank;
import io.zipcoder.casino.GameTools.Deck.Suit;
import io.zipcoder.casino.Players.GoFishPlayer;
import io.zipcoder.casino.Players.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.zipcoder.casino.GameTools.Deck.Rank.ACE;
import static io.zipcoder.casino.GameTools.Deck.Suit.HEARTS;


public class GoFishPlayerTest {


    @Test
    public void constructorTestName() {
        String expectedName = "Bob";

        Player player1 = new Player(expectedName, 34);
        GoFishPlayer goFishPlayer1 = new GoFishPlayer(player1);

        String actualName = goFishPlayer1.getName();

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void constructorTestAge() {
        int expectedAge = 78;

        Player player1 = new Player("Phoebe", expectedAge);
        Player goFishPlayer1 = new GoFishPlayer(player1);

        int actualAge = goFishPlayer1.getAge();

        Assert.assertEquals(expectedAge, actualAge);
    }

    @Test
    public void getCardHandTest() {
        Player player1 = new Player("Bob", 34);
        GoFishPlayer goFishPlayer1 = new GoFishPlayer(player1);

        //List<Card> cardHand = new ArrayList<Card>();
        Card temp1 = new Card(Rank.ACE, Suit.HEARTS);
        Card temp2 = new Card(Rank.FOUR, Suit.DIAMOND);
        Card temp3 = new Card(Rank.QUEEN, Suit.SPADE);
        goFishPlayer1.cardHand.add(temp1);
        goFishPlayer1.cardHand.add(temp2);
        goFishPlayer1.cardHand.add(temp3);

        List<Card> expectedCards =
        List<Card> actualCards = goFishPlayer1.getCardHand();

        Assert.assertEquals(expectedCards, actualCards);
    }


}
