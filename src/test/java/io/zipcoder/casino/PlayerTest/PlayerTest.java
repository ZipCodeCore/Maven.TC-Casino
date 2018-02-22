package io.zipcoder.casino.PlayerTest;


import io.zipcoder.casino.Players.Player;
import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {
    @Test
    public void constructorWithNameAndAgeTest() {
        String expectedName = "Bob";
        Integer expectedAge = 21;
        Player player1 = new Player(expectedName, expectedAge);

        String actualName = player1.getName();
        Integer actualAge = player1.getAge();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedAge, actualAge);
    }

    @Test
    public void constructorWithNameAgeBalanceTest() {
        String expectedName = "Suzy";
        Integer expectedAge = 24;
        Double expectedBalance = 100.00;
        Player player1 = new Player(expectedName, expectedAge, expectedBalance);

        String actualName = player1.getName();
        Integer actualAge = player1.getAge();
        Double actualBalance = player1.getBalance();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedAge, actualAge);
        Assert.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void setNameTest() {
        Player player1 = new Player("George", 51);
        String expected = "George";
        player1.setName(expected);
        String actual = player1.getName();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getNameTest() {
        Player player1 = new Player("George", 51);
        String expected = "George";

        String actual = player1.getName();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void setAgeTest() {
        Player player1 = new Player("Alex", 26);
        Integer expected = 26;
        player1.setAge(expected);
        Integer actual = player1.getAge();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getAgeTest() {
        Player player1 = new Player("George", 51);
        Integer expected = 51;

        Integer actual = player1.getAge();
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void setBalanceTest() {
        Player player1 = new Player("Bob", 49, 100.00);
        Double expected = 100.00;
        player1.setBalance(expected);
        Double actual = player1.getBalance();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getBalanceTest() {
        Player player1 = new Player("George", 51, 200.00);
        Double expected = 200.00;

        Double actual = player1.getBalance();
        Assert.assertEquals(expected, actual);

    }
}
