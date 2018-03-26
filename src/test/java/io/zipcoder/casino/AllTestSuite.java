package io.zipcoder.casino;

import io.zipcoder.casino.ConcreteMenus.BlackJackMenu;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CardTest.class,
        PlayerTest.class,
        GameTest.class,
        BlackJackMenu.class,
        DeckTest.class
})
public class AllTestSuite {
}
