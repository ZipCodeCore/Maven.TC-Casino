package io.zipcoder.casino;

public interface Dice {

   static int rollDice(int diceNeeded){
       //Dice made to be dynamic to adapt to dice needed per game.
        int diceTotal =0;
        int die;

        for (int i = 0; i < diceNeeded; i++) {
            die= (int)(Math.random()*6) + 1;
            diceTotal += die;

        }

    return diceTotal;
    }

//    public static void main(String[] args) {
//
//        System.out.println(Dice.rollDice(2));
//    }

}
