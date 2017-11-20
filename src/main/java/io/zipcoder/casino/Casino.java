package io.zipcoder.casino;

import io.zipcoder.casino.Console.Console;

public class Casino {
    static Player casinoplayer;

    public void startCasino(){

        Console.print("Welcome to the casino");
        String name = Console.getString("What is your name?");
        int age = (int)Console.getDouble("How old ");
        casinoplayer= new Player(name,1000,age);

        new Blackjack(casinoplayer).start();

    }

    public void gameOptions(){
        String[] gameOptionList = {"Craps","Blackjack","Go Fish"};
        Console.print("Game options:\n"+gameOptionList.toString());
        String input = Console.getValidString("What game would you like to play?",gameOptionList);
        if("blackjack".equalsIgnoreCase(input)){
            new Blackjack(casinoplayer).start();
        }
    }


}
