package io.zipcoder.casino;

import io.zipcoder.casino.Console.Console;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Casino {
    DecimalFormat format = new DecimalFormat("0.00");
    static Player casinoplayer;

    public void startCasino(){

        Console.print("Welcome to the casino");
        String name = Console.getString("What is your name?");
        int age = (int)Console.getDouble("How old are you?");
        double money  = Console.getDouble("How much coin you got?");
        casinoplayer= new Player(name,money,age);

        gameOptions();

    }

    public void gameOptions(){
        String[] gameOptionList = {"CRAPS","BLACKJACK","GO FISH"};
        Console.print("Game options:\n"+ Arrays.asList(gameOptionList).toString());
        String input = Console.getValidString("What game would you like to play?",gameOptionList);
        switch(input.toLowerCase()){
            case "blackjack":
                validAge();
                new Blackjack(casinoplayer).start();
                break;
            case "go fish":
                new GoFish(casinoplayer).goFishStart();
                break;
            case "craps":
                validAge();
                new Craps(casinoplayer).play();
                break;
            default:
                gameOptions();
        }
    }

    public void validAge(){
        if(casinoplayer.getAge()<21){
            Console.print("Too young sucka");
            gameOptions();
        }
    }

}
