package io.zipcoder.casino;


import java.util.ArrayList;

public class Casino {

    InputOutput inputOutput = new InputOutput();
    Player player;




    protected void setUpUserProfile(){

        String name = this.askUserName();
        Integer age = this.askUserAge();

        if(age > 21) {
           Integer balance = this.askUserBalance();
           player = new Player(name, age, balance);

        } else{
            player = new Player(name, age);
        }
    }

    protected void showMainMenu() {
       ArrayList selectedGame;
        if(player.getAge() > 21) {
            selectedGame = inputOutput.displayOver21Menu();
        } else {
            selectedGame = inputOutput.displayUnder21Menu();
        }
    }



    protected String askUserName(){

        System.out.println("Hello Player! What is your name?");
        String name = inputOutput.scanForString();
        return name;


    }

    protected Integer askUserAge(){
        System.out.println("How old are you?");
        Integer age = inputOutput.scanForInt();
        return age;
    }

    protected Integer askUserBalance(){
        System.out.println("How much do you want to gamble with?");
        Integer balance = inputOutput.scanForInt();
        return balance;

    }

    protected void start() {
        this.setUpUserProfile();
        this.showMainMenu();


    }

}

