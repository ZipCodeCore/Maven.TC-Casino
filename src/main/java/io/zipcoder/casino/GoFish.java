package io.zipcoder.casino;

import java.util.ArrayList;

public class GoFish extends CardGame {

    Player currentUser;
    ArrayList<Player> players;
    ArrayList<Integer> score = new ArrayList<Integer>();
    ArrayList<Card> booksPlayed = new ArrayList<Card>();
    Deck goFishDeck = new Deck();

    public void welcome(Player player){

    }

    public void dealCards(){
        for (Player player : players){

        }
    }

    public void generatePlayers(int numberOfComputerPlayers){

        players = new ArrayList<Player>();
        players.add(currentUser);

        Player computerPlayer;

        ArrayList<String> computerNames = new ArrayList<String>();
        computerNames.add("Jack");
        computerNames.add("Lina");
        computerNames.add("Marin");

        for (int i = 0; i < numberOfComputerPlayers; i++){
            computerPlayer = new Player(computerNames.get(i), 200.00);
            players.add(computerPlayer);
        }
    }

//    public void howManyPlayers(){
//        String numberOfPlayers = Console.getStringInput("How many computer players would you like to play against? (1-3)");
//
//        sw
//    }

    public void startGame(Player player){
        currentUser = player;
        String answer = Display.welcomeGoFish(player);

        if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")){
            //goFishDeck.
        } else {

        }
    }
}
