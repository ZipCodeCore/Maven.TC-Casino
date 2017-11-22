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

        Assert.assertEquals(user, goFish.getPlayer().getUser());
        Assert.assertEquals(goFish.getDealer().getUser().getName(), "Dealer");
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

        Assert.assertTrue(goFish.lastPlayerHandEmpty(goFish.getPlayer()));
    }

    @Test
    public void askingSetsValueTest(){
        User user = new User("Uncle Bob", 1000000d);
        GoFish goFish = new GoFish(user);

        goFish.getPlayer().askForValue(goFish.getDealer(), PlayingValue.QUEEN);

        PlayingValue expected = PlayingValue.QUEEN;
        PlayingValue actual = goFish.getPlayer().getAskedValue();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void nullAskedValueTest(){
        User user = new User("Uncle Bob", 1000000d);
        GoFish goFish = new GoFish(user);

        goFish.getPlayer().askForValue(goFish.getDealer(), PlayingValue.QUEEN);

        goFish.getPlayer().nullAskedValue();
        PlayingValue actual = goFish.getPlayer().getAskedValue();

        Assert.assertNull(actual);
    }

    @Test
    public void askingForValueTrueTest(){
        User user = new User("Uncle Bob", 1000000d);
        GoFish goFish = new GoFish(user);

        for (int i = 0; i < 3; i++) {
            goFish.getDealer().getHand().addCard(new PlayingCard(PlayingSuit.SPADE, PlayingValue.ACE));
        }
        for (int i = 0; i < 2; i++) {
            goFish.getDealer().getHand().addCard(new PlayingCard(PlayingSuit.CLUB, PlayingValue.KING));
        }

        Integer actual = goFish.getPlayer().askForValue(goFish.getDealer(), PlayingValue.ACE);
        Integer expected = 3;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void askingForValueFalseTest(){
        User user = new User("Uncle Bob", 1000000d);
        GoFish goFish = new GoFish(user);

        for (int i = 0; i < 5; i++) {
            goFish.getDealer().getHand().addCard(new PlayingCard(PlayingSuit.CLUB, PlayingValue.KING));
        }

        Integer actual = goFish.getPlayer().askForValue(goFish.getDealer(), PlayingValue.QUEEN);
        Integer expected = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void takeCardsTest(){
        User user = new User("Uncle Bob", 1000000d);
        GoFish goFish = new GoFish(user);

        for (int i = 0; i < 5; i++) {
            goFish.getDealer().getHand().addCard(new PlayingCard(PlayingSuit.CLUB, PlayingValue.KING));
        }

        int beforeDealer = goFish.getDealer().checkIfHandHasValue(PlayingValue.KING);
        int beforePlayer = goFish.getPlayer().checkIfHandHasValue(PlayingValue.KING);

        Assert.assertEquals(5, beforeDealer);
        Assert.assertEquals(0, beforePlayer);

        goFish.getPlayer().takeCardsFromOther(goFish.getDealer(), PlayingValue.KING);

        int afterDealer = goFish.getDealer().checkIfHandHasValue(PlayingValue.KING);
        int afterPlayer = goFish.getPlayer().checkIfHandHasValue(PlayingValue.KING);

        Assert.assertEquals(0, afterDealer);
        Assert.assertEquals(5, afterPlayer);
    }



}
