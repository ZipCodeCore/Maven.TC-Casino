package io.zipcoder.casino;

import java.util.ArrayList;

public class GoFish extends CardGame {

    CardPlayer currentUser;
    ArrayList<CardPlayer> players = new ArrayList<CardPlayer>();
    ArrayList<Integer> score = new ArrayList<Integer>();
    ArrayList<Card> booksPlayed = new ArrayList<Card>();
    Deck goFishDeck = new Deck();



    public void welcome(CardPlayer player){

    }

    public void setCurrentUser(CardPlayer currentUser) {
        this.currentUser = currentUser;
    }

    public void setPlayers(ArrayList<CardPlayer> players) {
        this.players = players;
    }

    public void dealCards(){
        for (int numberOfCardsToDeal = 0; numberOfCardsToDeal < 5; numberOfCardsToDeal++) {
            for (CardPlayer player : players) {
                Card newCard = goFishDeck.giveCard();
                player.takeCard(newCard);
            }
        }
    }

    public void generateComputerPlayers(int numberOfComputerPlayers){

        CardPlayer computerPlayer;

        ArrayList<String> computerNames = new ArrayList<String>();
        computerNames.add("Jack");
        computerNames.add("Lina");
        computerNames.add("Marin");

        for (int i = 0; i < numberOfComputerPlayers; i++){
            computerPlayer = new CardPlayer(computerNames.get(i), 200.00);
            players.add(computerPlayer);
        }
    }

//    public String askToPlay(CardPlayer player){
//        String answer = Display.welcomeGoFish(player);
//        return answer;
//    }

    public void startGame(CardPlayer player, int numberOfComputers){

        Display.welcomeGoFish(player);

        goFishDeck.createFullDeck();

        currentUser = player;
        players.add(currentUser);
        generateComputerPlayers(numberOfComputers);

        for (int i = 0; i < players.size(); i++){
            score.add(0);
        }

        dealCards();

    }

    public String playersToString() {
        String output = "";
        for (CardPlayer player : players){
            output += player.getName() + "\n";
        }
        return output;
    }
}
