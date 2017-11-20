//package io.zipcoder.casino.PlayerTest;
//
//
//import io.zipcoder.casino.Player;
//import org.junit.Assert;
//import org.junit.Test;
//
//public class PlayerTest {
//
//    Player testPlayer = new Player("wes",5000,21);
//
//    @Test
//    public void getRollTest(){
//        int lower = 2;
//        int upper = 12;
//
//        for(int i= 0;i<1000;i++) {
//            int actual = testPlayer.getRoll();
//            Assert.assertTrue(actual >= lower && actual <= upper);
//        }
//    }
//}
