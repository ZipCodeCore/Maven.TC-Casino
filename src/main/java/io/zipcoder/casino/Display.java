package io.zipcoder.casino;

import java.util.ArrayList;

public class Display {

    public static void welcomeGoFish(Player player){
        System.out.println("Welcome To Go Fish, " + player.getName() + "\n");
    }

    public static int howManyComputers() {
        int numberOfComputers = Console.getIntegerInput("How many computer players would you like to play against? (1-3)");
        return numberOfComputers;
    }

    public static String choosePlayerToAsk(ArrayList<CardPlayer> players){
        String question = "What player do you want to choose from?\n" +
                          "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
        for (int i = 1; i < players.size(); i++){
            question += players.get(i).getName() + "\n";
        }
        String playerToAsk = Console.getStringInput(question);
        return playerToAsk;
    }

    public static String chooseCard(ArrayList<Card> hand){
        String question = "What card do you want to ask for?\n" +
                          "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
        for (Card card : hand){
            question += card.getValue() + "\n";
        }
        String cardToAskFor = Console.getStringInput(question);
        cardToAskFor = cardToAskFor.toUpperCase();
        return cardToAskFor;
    }

}
