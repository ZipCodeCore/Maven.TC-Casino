package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoFishTest {
    GoFish goFish=new GoFish();
    GoFishPlayer joe=new GoFishPlayer(new Player("joe",10, false));

    @Test
    public void play() throws Exception {
        goFish.play(joe);
    }

    @Test
    public void addAIPlayers() throws Exception {
        String expected="Computer 1 Computer 2 ";
        String actual="";
        goFish.addAIPlayers(2);
        for (GoFishPlayer player:goFish.getPlayers())
            actual+=player.getName()+" ";

        Assert.assertEquals(expected, actual);
    }


}