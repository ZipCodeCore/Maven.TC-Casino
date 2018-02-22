package io.zipcoder.casinotest.test;

import io.zipcoder.casino.Profile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProfileTest {
    private final static double ROUND_NUMBER =.001;
    private String name1;
    private String name2;
    private double intialBalance1;
    private double intialBalance2;
    private Profile profile1;
    private Profile profile2;

    @Before
    public void setUp() throws Exception {
        name1 ="Tim";
        name2 = "Sonja";
        intialBalance1 = 100.0;
        intialBalance2 = 50.0;
        profile1 = new Profile(name1, intialBalance1, 1);
        profile2 = new Profile(name2, intialBalance2, 2);
    }

    @Test
    public void setNameTest(){
        profile1.setName(name2);
        String expexted = name2;
        String actual = profile1.getName();
        Assert.assertEquals(expexted, actual);
    }
    @Test
    public void setName2Test(){
        profile2.setName(name1);
        String expexted = name1;
        String actual = profile2.getName();
        Assert.assertEquals(expexted, actual);
    }

    @Test
    public void setAccountBalanceTest(){
        profile1.setAccountBalance(intialBalance2);
        double expexted = intialBalance2;
        double actual = profile1.getAccountBalance();
        Assert.assertEquals(expexted, actual,ROUND_NUMBER );
    }
    @Test
    public void setAccountBalance2Test(){
        profile2.setAccountBalance(intialBalance1);
        double expexted = intialBalance1;
        double actual = profile2.getAccountBalance();
        Assert.assertEquals(expexted, actual,ROUND_NUMBER );
    }
    @Test
    public void setIdTest() {
        profile1.setId(5);
        int expected = 5;
        int actual = profile1.getId();

        Assert.assertEquals(expected, actual);
    }



}
