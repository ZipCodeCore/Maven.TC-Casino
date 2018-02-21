package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoFishPlayerTest {

    GoFishPlayer goFishPlayer = new GoFishPlayer();
    @Test
    public void getAndSetScore() throws Exception {

        goFishPlayer.setScore(2);

        int expeted = 2;

        int actual = goFishPlayer.getScore();

        Assert.assertEquals(expeted, actual);
    }

    @Test
    public void getAndSetName() throws Exception {
        goFishPlayer.setName("me");
        String expected ="me";
        String actual = goFishPlayer.getName();
        Assert.assertEquals(expected,actual);
    }


}