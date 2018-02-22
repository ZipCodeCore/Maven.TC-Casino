package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class PersonTest {


    @Test
    public void constructorTest() {
        Person testPesron = new Person("Joe");
        String expected = "Joe";
        String actual = testPesron.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHandTest() {
        Person person = new Person("Joe");
        ArrayList<Card> expected = new ArrayList<Card>();
        ArrayList<Card> actual = person.getHand().getHandArrayList();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getWalletTest() {
        Person person = new Person("Joe");
        int expected = 0;
        int actual = person.getWallet().checkChipAmount();
        Assert.assertEquals(actual, expected);
    }
}
