package io.zipcoder.casino.Game.diceGame;


import io.zipcoder.casino.CasinoUtilities.Console;
import io.zipcoder.casino.Game.Game;
import io.zipcoder.casino.Player;

import java.util.ArrayList;


abstract public class DiceGame implements Game {
    private Die[] dice;
    private ArrayList<Player> players;



    public DiceGame() {
        players = new ArrayList<Player>();
    }

    public void createDie(int faces, int number){
       Die[] diceToCreate = new Die[number];
        for (int i = 0; i< number; i++){
            diceToCreate[i] = new Die(faces);
        }
        this.dice = diceToCreate;
    }

    public Die[] getDice(){
        return this.dice;
    }

    public int[] rollDice(){
        int [] rollResult = new int[dice.length];
        for(int i = 0; i < dice.length; i++){
            rollResult[i] = dice[i].rollDie();
        }
        return rollResult;
    }

    public void addPlayer(Player player){
        if(players.contains(player)){
            Console.print("Error: Player already added to game - cannot add duplicate players");
        }
        else{
            players.add(player);
        }

    }
    public void removePlayer (Player player){
        if(!players.contains(player)){
            Console.print("Error: Player not in game - cannot remove nonexistent player");
        }
        else{
            players.remove(player);
        }

    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    //TODO: implement methods later once functionality is better understood
    public void startGame(){

    }
    public void endGame(){

    }
    public String getRules(){
        return null;
    }

}
