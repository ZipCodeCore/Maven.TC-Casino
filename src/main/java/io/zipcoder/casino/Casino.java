package io.zipcoder.casino;


import io.zipcoder.casino.Games.Blackjack;
import io.zipcoder.casino.Games.Craps;
import io.zipcoder.casino.Games.GoFish;
import io.zipcoder.casino.Games.War;
import io.zipcoder.casino.InputOutput.InputOutput;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Players.GoFishHumanPlayer;
import io.zipcoder.casino.Players.GoFishPlayer;
import io.zipcoder.casino.Players.Player;
import java.util.ArrayList;


public class Casino {

    InputOutput inputOutput = new InputOutput();
    Player player;
    private boolean isPlaying = true;

    protected String askUserName(){
        String name = inputOutput.promptForString("Hello Player! What is your name?");
        return name;
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

    protected void initiateGame() {
        do {
            String selectedGame = inputOutput.availableGames(this.player);
            if(selectedGame.equals("Exit")){
                continue;
            } else {
                selectGame(selectedGame).startGame();

            }
        }
        while(isPlaying);
    }

    protected Game selectGame(String selectedGame) {
        Game game = null;

        switch (selectedGame) {
            case "War":
                game = new War();
                break;
            case "Go Fish":
                game = new GoFish(new GoFishHumanPlayer(player));
                break;
            case "BlackJack":
                game = new Blackjack();
                break;

            case "Craps":
                game = new Craps();
                break;
            case "Exit":
                isPlaying = false;
        }
        return game;
    }

    protected void start() {
        this.setUpUserProfile();
        this.initiateGame();
    }
}

