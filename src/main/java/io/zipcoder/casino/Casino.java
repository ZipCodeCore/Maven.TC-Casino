package io.zipcoder.casino;


public class Casino {

    InputOutput inputOutput = new InputOutput();

    protected void askForUserName(){

        InputOutput inputOutput = new InputOutput();

        System.out.println("Hello Player! What is your name?");
        String name = inputOutput.scanForString();


        //Player player = new Player(name, age);
       // player.setName(name);
    }

    

}
