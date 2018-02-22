package io.zipcoder.casino.Game.diceGame.Craps;


import io.zipcoder.casino.CasinoUtilities.Console;
import io.zipcoder.casino.Game.diceGame.DiceGame;

public class CrapsGame extends DiceGame {
    private int point;


    public CrapsGame() {
        this.point = point;
    }
    public void comeOutPhase(){
        Console.print("Would you like to make a Pass Line or Do Not Pass bet?");
        String answer = Console.getString();


    }
    public void pointPhase(){

    }
    public void round(){

    }
    public void placeBet(double betAmount, String input){

    }

    public int getRollValue(){
        int [] rawRoll = this.rollDice();
        int sum = 0;
        for(int i : rawRoll){
            sum += i;
        }
        return sum;
    }

    public static boolean isCraps(int rollValue){
       if(rollValue == 2 || rollValue == 3 || rollValue == 12){
           return true;
       }
       else{
           return false;
       }
    }

    public static boolean isNatural(int rollValue){
        if(rollValue == 7 || rollValue == 11){
            return true;
        }
        else{
            return false;
        }

    }

    public int getPoint(){
        return this.point;
    }

    @Override
    public void startGame(){
        this.createDie(6,2);
        this.point = 0;
    }

}
