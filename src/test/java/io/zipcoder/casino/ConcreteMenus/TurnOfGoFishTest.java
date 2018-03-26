package io.zipcoder.casino.ConcreteMenus;

import io.zipcoder.casino.GoFishGame.GoFish;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.PlayerWarehouse;
import io.zipcoder.casino.GoFishGame.TurnOfGoFish;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TurnOfGoFishTest {

    GoFish aGoFishGame;
    ArrayList<Player> listOfPlayers;
    TurnOfGoFish aTurnOfGoFish;

    @Before
    public void setup() {
        listOfPlayers = new ArrayList<>();
        Player playerOne = new Player("Andrew");
        Player playerTwo = new Player("Brian");
        Player playerThree = new Player("Tim");

        PlayerWarehouse.setCurrentPlayer(playerOne);
        aGoFishGame = new GoFish();

        playerOne.addPointToScore();
        playerTwo.addPointToScore();
        playerThree.addPointToScore();
        playerThree.addPointToScore();

        listOfPlayers.add(playerOne);
        listOfPlayers.add(playerTwo);
        listOfPlayers.add(playerThree);

        aGoFishGame.setPlayersList(listOfPlayers);
        aTurnOfGoFish = new TurnOfGoFish(aGoFishGame.getCurrentPlayer(), aGoFishGame.getPlayersList());
    }

    @Test
    public void stringOfOpponentsNamesTest() {
        String expected =
                "1) Brian, has 0 cards in his hand.\n" +
                        "2) Tim, has 0 cards in his hand.\n";
        String actual = aTurnOfGoFish.stringOfOpponentsNames();
        Assert.assertEquals(expected,actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void pickedYourselfError_PickedYourselfError() {
        aTurnOfGoFish.pickAnOpponent(-1);
    }

}