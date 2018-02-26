package io.zipcoder.casinotest.test;

import io.zipcoder.casinotest.test.GameTest.cardGameTest.BlackJackTest.BlackJackGameTest;
import io.zipcoder.casinotest.test.GameTest.cardGameTest.BlackJackTest.BlackJackPlayerTest;
import io.zipcoder.casinotest.test.GameTest.cardGameTest.GoFishTest.GoFishPlayerTest;
import io.zipcoder.casinotest.test.GameTest.cardGameTest.GoFishTest.GoFishTest;
import io.zipcoder.casinotest.test.GameTest.cardGameTest.utilitiesTest.CardTest;
import io.zipcoder.casinotest.test.GameTest.cardGameTest.utilitiesTest.DeckTest;
import io.zipcoder.casinotest.test.GameTest.cardGameTest.utilitiesTest.HandTest;
import io.zipcoder.casinotest.test.GameTest.diceGameTest.CrapsTest.CrapsGameTest;
import io.zipcoder.casinotest.test.GameTest.diceGameTest.CrapsTest.CrapsPlayerTest;
import io.zipcoder.casinotest.test.GameTest.diceGameTest.DiceGameTest;
import io.zipcoder.casinotest.test.GameTest.diceGameTest.DieTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)


@Suite.SuiteClasses({
        BlackJackGameTest.class,
        BlackJackPlayerTest.class,
        GoFishPlayerTest.class,
        GoFishTest.class,
        CardTest.class,
        DeckTest.class,
        HandTest.class,
        CrapsGameTest.class,
        CrapsPlayerTest.class,
        DiceGameTest.class,
        DieTest.class,
        HouseTest.class,
        PlayerTest.class,
        ProfileTest.class,

})
public class TestSuite {
}
