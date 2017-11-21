package io.zipcoder.casino;


import io.zipcoder.casino.Console.Console;

public class Casino {


    //Console console = new Console();

    static Player casinoplayer;


    public void startCasino(){
        casinoplayer= new Player("testPlayer",1000,21);
//        new Blackjack(casinoplayer).start();
        new Craps(casinoplayer).play();

    }


}
