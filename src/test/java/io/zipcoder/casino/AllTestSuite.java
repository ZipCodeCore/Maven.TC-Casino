package io.zipcoder.casino;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BlackJackPlayerTest.class,
        BlackJackTest.class,
        CardGameTest.class,
        CardPileTest.class,
        CardPlayerTest.class,
        CardTest.class,
        CrapsTest.class,
        DiceTest.class,
        GoFishPlayerTest.class,
        GoFishTest.class,
        StandardDeck.class
})

public class AllTestSuite {
}
