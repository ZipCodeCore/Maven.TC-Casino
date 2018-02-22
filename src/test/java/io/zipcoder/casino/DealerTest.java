package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class DealerTest {

    @Test
    public void constructorTest() {
        Dealer dealer = new Dealer();
        String expected = "Dealer";
        String actual = dealer.getName();
        Assert.assertEquals(expected, actual);
    }
}
