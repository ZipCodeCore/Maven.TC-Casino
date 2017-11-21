package io.zipcoder.casino.games.gofish;

import io.zipcoder.casino.nuts_n_bolts.User;
import org.junit.Assert;
import org.junit.Test;

public class GoFishPlayerTest {



    @Test
    public void creationAndGetterTest(){
        User user = new User("Uncle Bob", 1000000d);
        GoFish goFish = new GoFish(user);
        GoFish.GoFishPlayer player = goFish.getPlayer();

        Assert.assertEquals(user, player.getUser());
        Assert.assertNull(player.getAskedValue());
    }

    @Test
    public void drawCardTest(){
        User user = new User("Uncle Bob", 1000000d);
        GoFish goFish = new GoFish(user);
        GoFish.GoFishPlayer player = goFish.getPlayer();


        //player.drawCard()
    }

}
