package io.zipcoder.casino.nuts_n_bolts;

import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Random;

public class DiceTest {

    @Test
    public void testDiceCreation(){
        ArrayList<Integer> oneToSix = new ArrayList<>();
        for (int i=1; i<=6; i++){
            oneToSix.add(i);
        }
        Dice<Integer> standardDice = new Dice<>(oneToSix);
        ArrayList<Integer> standardFaces = standardDice.getAllSides();
        int j=1;

        for (Integer i : standardFaces){
            Assert.assertEquals(i.intValue(),j);
            j++;
        }

        Random rando = new Random();
        ArrayList<String> stringList = new ArrayList<>();

        for (int i = 0; i<Math.abs(rando.nextInt()); i++){
            stringList.add(""+i);
        }
        j=0;
        Dice<String> stringDice = new Dice<>(stringList);
        for (String s : stringDice.getAllSides()){
            Assert.assertEquals(""+j, s);
            j++;
        }
    }

    @Test
    public void testDiceRoll(){
        ArrayList<Integer> oneToSix = new ArrayList<>();
        for (int i=1; i<=6; i++){
            oneToSix.add(i);
        }
        Dice<Integer> standardDice = new Dice<>(oneToSix);
        int totalRolls=0;
        int desiredRolls=0;
        double percentage=0;
        double expected=16.7;
        Random rando = new Random();

        for (int i=0; i<1000000; i++){
            if (standardDice.rollDie()==1){
                desiredRolls++;
            }
            totalRolls++;
        }

        percentage=(double)desiredRolls/(double)totalRolls;
        Assert.assertEquals(expected, percentage*100, 0.1);

    }

}
