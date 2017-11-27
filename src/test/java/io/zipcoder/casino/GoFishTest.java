package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoFishTest {

    GoFish goFish = new GoFish();
    @Test

    public void goFishObjectTest(){

        Assert.assertTrue(goFish instanceof GoFishGame);
    }

    @Test
    public void goFishRun() throws Exception {

        goFish.goFishRun(); // should pop out Welcome to the <GoFish> table! insert nick name you want to use for the game?
                            // tested visually
    }

}