package io.zipcoder.casinotest.test.GameTest.cardGameTest.BlackJackTest;

import io.zipcoder.casino.Game.cardGame.BLackJack.BlackJackGame;
import io.zipcoder.casino.Game.cardGame.BLackJack.BlackJackPlayer;
import io.zipcoder.casino.Profile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BlackJackGameTest {

    private Profile   testPlayerProfile;
    private Profile   testDealerProfile;
    private BlackJackPlayer testPlayer;
    private BlackJackPlayer testDealer;
    private BlackJackGame testBlackJackGAme;
    @Before
    public void setUp() throws Exception {
        testPlayerProfile = new Profile("name", 1000.0, 1);
        testBlackJackGAme = new BlackJackGame(testPlayerProfile);
        testPlayer = new BlackJackPlayer(testPlayerProfile);
    }

    @Test
    public void dealTest() {
        testBlackJackGAme.deal();
        int expected = 48;
        int actual =testBlackJackGAme.getDeck().countRemainingCards();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hitTest() {

    }

    @Test
    public void standTest() {

    }

    @Test
    public void roundTest() {

    }

    @Test
    public void dealerBehavior() {

    }

    @Test
    public void addPlayerTest() {

    }

    @Test
    public void removePlayerTest() {

    }

    @Test
    public void startGame() {

    }

    @Test
    public void endGame() {

    }

    @Test
    public void getRulesTest() {

    }


}
