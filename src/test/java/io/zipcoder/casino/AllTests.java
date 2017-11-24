package io.zipcoder.casino;

import io.zipcoder.casino.games.blackjack.BlackJackTest;
import io.zipcoder.casino.games.craps.CrapsTest;
import io.zipcoder.casino.games.gofish.GoFishPlayerTest;
import io.zipcoder.casino.games.gofish.GoFishTest;
import io.zipcoder.casino.nuts_n_bolts.DiceTest;
import io.zipcoder.casino.nuts_n_bolts.MoneyContainerTest;
import io.zipcoder.casino.nuts_n_bolts.UserTest;
import io.zipcoder.casino.nuts_n_bolts.cards.HandTest;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingCardTest;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingDeckTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        //CasinoTest.class,
        BlackJackTest.class,
        CrapsTest.class,
        GoFishTest.class,
        GoFishPlayerTest.class,
        HandTest.class,
        PlayingCardTest.class,
        PlayingDeckTest.class,
        //ConsoleTest.class,}
        DiceTest.class,
        MoneyContainerTest.class,
        UserTest.class
})
public class AllTests {
}
