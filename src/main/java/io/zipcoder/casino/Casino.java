package io.zipcoder.casino;


import io.zipcoder.casino.InputOutput.InputOutput;
import io.zipcoder.casino.Players.Player;
import java.util.ArrayList;


public class Casino {

    InputOutput inputOutput = new InputOutput();
    Player player;


    protected String askUserName(){
        //String name = inputOutput.promptForString("Hello Player! What is your name?");
        //return name;
        return null;
    }

    protected Integer askUserAge(){
        Integer age = inputOutput.promptForInt("How old are you?");
        return age;
    }

    protected Integer askUserBalance(){

        Integer balance = inputOutput.promptForInt("How much do you want to gamble with?");
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

        if(player.getAge() > 21) {
           Integer number =  inputOutput.displayOver21Menu();
           String selectedGame = inputOutput.under21Games.get(number -1);


        } else {
            String selectedGame = inputOutput.displayUnder21Menu();
        }
    }


    protected void start() {
        this.setUpUserProfile();
        this.showMainMenu();
    }
}

