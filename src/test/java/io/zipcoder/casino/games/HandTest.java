package io.zipcoder.casino.games;

import org.junit.Test;

public class HandTest {

    @Test
    public void emptyHandTest() {
        Deck hand = new Deck();
        hand.pull(1);

    }
}
