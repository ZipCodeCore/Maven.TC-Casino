//package io.zipcoder.casino.games.ceelo;
//
//import io.zipcoder.casino.core.Player;
//import io.zipcoder.casino.utils.IOHandler;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * filename:
// * project: casino
// * author: https://github.com/vvmk
// * date: 2/23/18
// */
//public class CeeLoTest {
//    private CeeLo clo;
//    private Player player;
//
//    @Before
//    public void setup() {
//        clo = new CeeLo();
//    }
//
//    @Test
//    public void getRulesTest() {
//        String expected = IOHandler.getMessageFromFile("ceelo.rules.txt");
//        String actual = clo.getRules();
//
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testGetPoint() {
//        Integer[] i = {1, 2, 3, 4, 5, 6};
//        List<Integer> expected = new ArrayList<>(Arrays.asList(i));
//        int actual = clo.rollForPoint();
//
//        Assert.assertTrue(expected.contains(actual));
//    }
//}
