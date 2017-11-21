package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CrapsTest {

    @Test
    public void printPlayersMoneyTest() {
        Craps game = new Craps();
        ArrayList<CrapsPlayer> players = new ArrayList<>();
        CrapsPlayer player1 = new CrapsPlayer("A");
        CrapsPlayer player2 = new CrapsPlayer("B");
        CrapsPlayer player3 = new CrapsPlayer("C");
        players.add(player1);
        players.add(player2);
        players.add(player3);
        game.addPlayers(players);

        player1.setMoney(100.0);
        player2.setMoney(300.0);
        player3.setMoney(400.0);

        String expected = "[ Player 1, A, Total money: $100.00 ] , [ Player 2, B, Total money: $300.00 ] , [ Player 3, C, Total money: $400.00 ]";
        String actual = game.printPlayersMoney();
        Assert.assertEquals(expected, actual);
    }
}
