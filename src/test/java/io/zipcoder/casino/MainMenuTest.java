package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class MainMenuTest {

    @Test
    public void testChooseGame() {
        String chosenGame = "war";
        Person player = new Person ("Adam");
        Game expected = new War(player);

        Game actual = MainMenu.chooseGame(chosenGame, player);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testChooseGame2() {
        String chosenGame = "theibhwn";
        Person player = new Person ("Adam");
        Game expected = new War(player);

        Game actual = MainMenu.chooseGame(chosenGame, player);

        Assert.assertNotEquals(actual, expected);
    }

}
