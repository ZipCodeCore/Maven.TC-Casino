package io.zipcoder.casino.Game.diceGame;


import io.zipcoder.casino.Game.Game;
import io.zipcoder.casino.Player;

import java.util.Random;

abstract public class DiceGame implements Game {
    private Die[] listOfDice;
    private int[] resultOfRoll;
    private Random randomNumber;

    public DiceGame() {
    }

    public Die[] createDie(int faces, int number){
        return null;
    }
    public void rollDice(Die someDie){

    }
    public int[] getResultOfRoll(){
        return null;
    }

    public void addPlayer(Player player){

    }
    public void removePlayer (Player player){

    }
    public void startGame(){

    }
    public void endGame(){

    }
    public String getRules(){
        return null;
    }

}
