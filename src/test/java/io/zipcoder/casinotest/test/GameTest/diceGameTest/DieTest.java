package io.zipcoder.casinotest.test.GameTest.diceGameTest;

import io.zipcoder.casino.Game.diceGame.Die;
import org.junit.Assert;
import org.junit.Test;

public class DieTest {

    @Test
    public void getNumberOfFacesTest(){
        //Given
        Die testDie = new Die (6);

        //When
        int expected = 6;
        int actual = testDie.getNumberOfFaces();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getNumberOfFacesTest2(){
        //Given
        Die testDie = new Die (20);

        //When
        int expected = 20;
        int actual = testDie.getNumberOfFaces();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void rollDieTest(){
        //Given
        Die testDie = new Die(6);

        //When
        int expectedLowerBound = 1;
        int expectedUpperBound = 6;
        boolean actual = isOutOfBounds(testDie, expectedLowerBound, expectedUpperBound);

        //Then
        Assert.assertFalse(actual);

    }

    @Test
    public void rollDieTest2(){
        //Given
        Die testDie = new Die(20);

        //When
        int expectedLowerBound = 1;
        int expectedUpperBound = 20;
        boolean actual = isOutOfBounds(testDie, expectedLowerBound, expectedUpperBound);

        //Then
        Assert.assertFalse(actual);

    }

    private boolean isOutOfBounds(Die testDie, int expectedLowerBound, int expectedUpperBound) {
        for(int i = 0; i< 100000; i++){
            int actual = testDie.rollDie();
            if(actual < expectedLowerBound || actual > expectedUpperBound){
                return true;
            }
        }
        return false;
    }


}
