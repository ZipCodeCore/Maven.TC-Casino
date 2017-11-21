package io.zipcoder.casino.games.gofish;

import io.zipcoder.casino.nuts_n_bolts.User;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingDeck;
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

}
