package io.zipcoder.casino;

import org.junit.Test;

public class HandTest {

    @Test
    public void emptyHandTest(){
        Deck hand = new Deck();
        hand.pull(1);

    }
}
