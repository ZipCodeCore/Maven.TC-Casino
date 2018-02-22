package io.zipcoder.casino;


import io.zipcoder.casino.InputOutput.InputOutput;
import io.zipcoder.casino.Players.Player;
import java.util.ArrayList;


public class Casino {

    InputOutput inputOutput = new InputOutput();
    Player player;


    protected String askUserName(){
        String name = inputOutput.promptForString("Hello Player! What is your name?");
        return name;
    }

    protected Integer askUserAge(){
        Integer age = inputOutput.promptInt("How old are you?");
        return age;
    }

    protected Integer askUserBalance(){
        Integer balance = inputOutput.promptInteger("How much do you want to gamble with?");
        return balance;
    }

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

    protected void start() {
        this.setUpUserProfile();
        this.showMainMenu();
    }
}

