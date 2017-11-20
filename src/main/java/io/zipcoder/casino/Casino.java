package io.zipcoder.casino;

import io.zipcoder.casino.Console.Console;

public class Casino {
    static Player casinoplayer;

    public void startCasino(){

        Console.print("Welcome to the casino");
        String name = Console.getString("What is your name?");
        double age = Console.getDouble("How old ")
        casinoplayer= new Player("testPlayer",1000,21);
        new Blackjack(casinoplayer).start();

    }


}
