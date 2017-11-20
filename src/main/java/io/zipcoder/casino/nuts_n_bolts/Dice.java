package io.zipcoder.casino.nuts_n_bolts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Dice<E> {

    private ArrayList<E> sides;


    public Dice(ArrayList<E> sides){
        this.sides=sides;
    }

    public ArrayList<E> getAllSides(){
        return sides;
    }

    public E rollDie(){

        Random rando = new Random();
        int numOfSides = sides.size();

        return sides.get(rando.nextInt(numOfSides));
    }

}
