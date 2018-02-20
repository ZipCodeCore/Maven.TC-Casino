package io.zipcoder.casino.PlayerTest;


import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

    Player testPlayer = new Player("wes",5000,21);

    @Test
    public void getNameTest(){
        String expected = "wes";
        String actual = testPlayer.getName();

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void setNameTest(){
        String expected = "bob";
        testPlayer.setName("bob");
        String actual = testPlayer.getName();

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getBalanceTest(){
        double expected = 5000;
        double actual = testPlayer.getBalance();

        Assert.assertEquals(expected,actual,0);
    }
    @Test
    public void setBalanceTest(){
        double expected = 100000;
        testPlayer.setBalance(100000);
        double actual = testPlayer.getBalance();

        Assert.assertEquals(expected,actual,0);
    }
    @Test
    public void getAgeTest(){
        int expected = 21;
        int actual = testPlayer.getAge();

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void setAgeTest(){
        int expected = 99;
        testPlayer.setAge(99);
        int actual = testPlayer.getAge();

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void addToBalanceTest(){
        double expected = 5001;
        testPlayer.addToBalance(1);
        double actual = testPlayer.getBalance();

        Assert.assertEquals(expected,actual,0);
    }
}
