package io.zipcoder.casino.PlayerTest;
import io.zipcoder.casino.Players.GoFishPlayer;
import io.zipcoder.casino.Players.Player;
import org.junit.Assert;
import org.junit.Test;



public class GoFishPlayerTest {

    @Test
    public void constructorTest() {
        String expectedName = "Bob";
        Integer expectedAge = 24;
        Integer expectedBalance = 50;

        Player player1 = new Player(expectedName, expectedAge, expectedBalance);
        Player goFishPlayer1 = new GoFishPlayer(player1);

        String actualName = goFishPlayer1.getName();
        Integer actualAge = player1.getAge();
        Integer actualBalance = player1.getBalance();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedAge, actualAge);
        Assert.assertEquals(expectedBalance, actualBalance);
    }
}
