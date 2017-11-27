package io.zipcoder.casino.games.gofish;

import io.zipcoder.casino.nuts_n_bolts.User;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingCard;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingDeck;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingSuit;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingValue;
import org.junit.Assert;
import org.junit.Test;

public class GoFishTest {

    @Test
    public void gameCreationAndGetterTest(){
        User user = new User("Uncle Bob", 1000000d);
        GoFish goFish = new GoFish(user);

        Assert.assertEquals(user, goFish.getHumanPlayer().getUser());
        Assert.assertEquals(goFish.getCompPlayer().getUser().getName(), "Dealer");
        Assert.assertTrue(goFish.getDeck() instanceof PlayingDeck);
    }

    @Test
    public void createCompPlayerTest(){
        User user = new User("Uncle Bob", 1000000d);
        GoFish goFish = new GoFish(user);

        Assert.assertNotNull(goFish.createCompPlayer());
    }

    @Test
    public void playerHandIsEmptyTest(){
        User user = new User("Uncle Bob", 1000000d);
        GoFish goFish = new GoFish(user);

        Assert.assertTrue(goFish.lastPlayerHandEmpty(goFish.getHumanPlayer()));
    }

    @Test
    public void askingSetsValueTest(){
        User user = new User("Uncle Bob", 1000000d);
        GoFish goFish = new GoFish(user);

        goFish.getHumanPlayer().askForValue(goFish.getCompPlayer(), PlayingValue.QUEEN);

        PlayingValue expected = PlayingValue.QUEEN;
        PlayingValue actual = goFish.getHumanPlayer().getAskedValue();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void nullAskedValueTest(){
        User user = new User("Uncle Bob", 1000000d);
        GoFish goFish = new GoFish(user);

        goFish.getHumanPlayer().askForValue(goFish.getCompPlayer(), PlayingValue.QUEEN);

        goFish.getHumanPlayer().nullAskedValue();
        PlayingValue actual = goFish.getHumanPlayer().getAskedValue();

        Assert.assertNull(actual);
    }

    @Test
    public void askingForValueTrueTest(){
        User user = new User("Uncle Bob", 1000000d);
        GoFish goFish = new GoFish(user);

        for (int i = 0; i < 3; i++) {
            goFish.getCompPlayer().getHand().addCard(new PlayingCard(PlayingSuit.SPADE, PlayingValue.ACE));
        }
        for (int i = 0; i < 2; i++) {
            goFish.getCompPlayer().getHand().addCard(new PlayingCard(PlayingSuit.CLUB, PlayingValue.KING));
        }

        Integer actual = goFish.getHumanPlayer().askForValue(goFish.getCompPlayer(), PlayingValue.ACE);
        Integer expected = 3;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void askingForValueFalseTest(){
        User user = new User("Uncle Bob", 1000000d);
        GoFish goFish = new GoFish(user);

        for (int i = 0; i < 5; i++) {
            goFish.getCompPlayer().getHand().addCard(new PlayingCard(PlayingSuit.CLUB, PlayingValue.KING));
        }

        Integer actual = goFish.getHumanPlayer().askForValue(goFish.getCompPlayer(), PlayingValue.QUEEN);
        Integer expected = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void takeCardsTest(){
        User user = new User("Uncle Bob", 1000000d);
        GoFish goFish = new GoFish(user);

        for (int i = 0; i < 5; i++) {
            goFish.getCompPlayer().getHand().addCard(new PlayingCard(PlayingSuit.CLUB, PlayingValue.KING));
        }

        int beforeDealer = goFish.getCompPlayer().checkIfHandHasValue(PlayingValue.KING);
        int beforePlayer = goFish.getHumanPlayer().checkIfHandHasValue(PlayingValue.KING);

        Assert.assertEquals(5, beforeDealer);
        Assert.assertEquals(0, beforePlayer);

        goFish.getHumanPlayer().takeCardsFromOther(goFish.getCompPlayer(), PlayingValue.KING);

        int afterDealer = goFish.getCompPlayer().checkIfHandHasValue(PlayingValue.KING);
        int afterPlayer = goFish.getHumanPlayer().checkIfHandHasValue(PlayingValue.KING);

        Assert.assertEquals(0, afterDealer);
        Assert.assertEquals(5, afterPlayer);
    }

    @Test
    public void dealInitialHandTest(){
        User user = new User("Uncle Bob", 1000000d);
        GoFish goFish = new GoFish(user);

        goFish.dealInitialHands(7);

        Assert.assertEquals(7, goFish.getHumanPlayer().getHand().getAllCards().size());
        Assert.assertEquals(7, goFish.getCompPlayer().getHand().getAllCards().size());
        Assert.assertEquals(((52-7)-7), goFish.getDeck().getAllCards().size());
    }

}
