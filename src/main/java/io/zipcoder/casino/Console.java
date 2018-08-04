package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Scanner;

import static io.zipcoder.casino.Utilities.*;

public abstract class Console {

    public abstract String getNameOfGame();

    public abstract void start();

    public abstract void setUpGame();

    public Integer getNumPlayers(Integer min, Integer max) {
        if(min.equals(max)) {
            return min;
        }
        boolean validInput = false;
        Integer numPlayers = 0;
        while(!validInput) {
            numPlayers = getIntegerInput(String.format("How many players? May have %d to %d players.", min, max));
            if(numPlayers >= min && numPlayers <= max) {
                validInput = true;
            }
        }
        return numPlayers;
    }

    public ArrayList<String> getPlayerNames(Integer numPlayers) {
        ArrayList<String> names = new ArrayList<>();
        for(int i = 0; i < numPlayers; i++) {
            String prompt = String.format("Enter name of Player %d", i+1);
            String name = getUserInput(prompt);
            names.add(name);
        }
        return names;
    }

    public void getPlayerChips(Game game) {
        ArrayList<Player<? extends Game>> players = game.getPlayers();
        int i = 1;
        for(Player player : players) {
            Double amount = getMoneyInput(String.format("Player %d, %s, how much money do you have in chips?", i, player.getName()));
            player.setMoney(amount);
            i++;
        }
    }

    public void playRoundsUntilAllPlayersCashOut(Game game) {
        while(atLeastOnePlayerHasMoney(game)) {
            playRound();
        }
    }

    public boolean atLeastOnePlayerHasMoney(Game game) {
        ArrayList<Player<? extends Game>> players = game.getPlayers();
        for(Player player : players) {
            if(player.getMoney() > 0) {
                return true;
            }
        }
        return false;
    }

    public abstract void playRound();
}
