package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    Player player=new Player("Jake", 1000,false );

    @Test
    public void getNameTest() throws Exception {
        String expected="Jake";
        String actual=player.getName();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isPersonTest() throws Exception {
        boolean expected=false;
        boolean actual=player.isPerson();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCashTest() throws Exception {
        Integer expected=1000;
        Integer actual = player.getCash();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addCashTest() throws Exception {
        Integer expected=player.getCash()+1000;
        player.addCash(1000);
        Integer actual=player.getCash();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void withdrawalCashTest() throws Exception {
        Integer expected=player.getCash()-500;
        Integer withdrawn=player.withdrawalCash(500);
        Integer actual=player.getCash();

        Assert.assertEquals(expected,actual);
        Assert.assertEquals(500,withdrawn.intValue());

    }

}