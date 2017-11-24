package io.zipcoder.casino;

import java.util.ArrayList;

public class Craps implements Game, Gamble{

    ArrayList<DicePlayer> players = new ArrayList<DicePlayer>();

    public boolean wonRound(){
        int win=0;
        int lose=0;
        int diceValue = Dice.rollDice();
        if(diceValue==7 || diceValue==11){
            win=1;
            System.out.println("You rolled "+ diceValue+ ".You win!");
        }
        else if(diceValue==2|| diceValue==3 || diceValue==12){
            lose=1;
            System.out.println("You rolled "+diceValue+".You lost!");
        }
        else{
            System.out.println("Keep rolling until you get the point number.");
            int secondRoll = Dice.rollDice();
            while(secondRoll!= diceValue && secondRoll!=7){
                secondRoll=Dice.rollDice();
            }
            if(secondRoll==7){
                System.out.println("You rolled a 7, you lost!");
                lose=1;
            }
            else{
                System.out.println("You rolled the point number " + secondRoll +".You win!");
                win=1;
            }
        }
        return win>lose;
    }

    public void takeBet(Double playerMoney) {
        //if player wins, playerMoney doubles and add to player's total money amount, otherwise deducts the playerMoney from player's money
        if(wonRound()){
            =playerMoney*2;
        }
//        else{
//            Player.getMoney-playerMoney
//        }
    }

    public boolean play() {
        return false;
    }
}
