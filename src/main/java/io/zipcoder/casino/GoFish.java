package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Random;

public class GoFish extends CardGame {

    CardPlayer currentUser;
    ArrayList<CardPlayer> players = new ArrayList<CardPlayer>();
    ArrayList<Integer> score = new ArrayList<Integer>();
    ArrayList<Card> booksPlayed = new ArrayList<Card>();
    Deck goFishDeck = new Deck();
    CardPlayer playerToAct;



    public void welcome(CardPlayer player){

    }

    public void setCurrentUser(CardPlayer currentUser) {
        this.currentUser = currentUser;
    }

    public void setPlayers(ArrayList<CardPlayer> players) {
        this.players = players;
    }

    public void dealCards(){

        for (int i = 0; i < 5; i++) {
            for (CardPlayer player : players) {
                Card topCard = goFishDeck.deal();
                player.takeCard(topCard);
            }
        }

    }

    public void generateComputerPlayers(int numberOfComputerPlayers){

        CardPlayer computerPlayer;

        ArrayList<String> computerNames = new ArrayList<String>();
        computerNames.add("Moose");
        computerNames.add("Lina");
        computerNames.add("Merin");

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

        goFishDeck.shuffle();
        dealCards();

        // make user always first for testing
        // fix when done
        //playerToAct = pickCurrentPlayer();
        playerToAct = currentUser;

        String playersHand = currentUser.getHand().toString() + "\n";
        System.out.println(playersHand);

        while (playerToAct == currentUser){

            boolean yourTurn = true;
            while (yourTurn) {

                CardPlayer playerToAsk = choosePlayerToAsk();
                String cardToAskFor = chooseCard();

                boolean playerHasCard = askForCard(playerToAsk, cardToAskFor);
                while (playerHasCard) {

                    for (Card card : playerToAsk.getHand()) {
                        if (cardToAskFor.equals(card.getValue().toString())) {
                            currentUser.takeCard(playerToAsk.givePlayerCard(card));
                        }
                    }

                    playerToAsk = choosePlayerToAsk();
                    cardToAskFor = chooseCard();
                    playerHasCard = askForCard(playerToAsk, cardToAskFor);

                }

                Card topCard = goFishDeck.deal();
                currentUser.takeCard(topCard);

                if (!(topCard.getValue().toString().equals(cardToAskFor))) {
                    yourTurn = false;
                }
                playerToAct = playerToAsk;
            }


        }

    }

    public String chooseCard(){
        String answer = Display.chooseCard(currentUser.getHand());
        return answer;
    }



    public boolean askForCard(CardPlayer playerToAsk, String cardToAskFor){
        boolean hasCard = false;
        ArrayList<String> handValues = new ArrayList<String>();
        for (Card card : playerToAsk.getHand()){
            handValues.add(card.getValue().toString());
        }
        if (handValues.contains(cardToAskFor)){
            hasCard = true;
        }
        return hasCard;
    }

    public CardPlayer choosePlayerToAsk(){
        String answer = Display.choosePlayerToAsk(players);
        CardPlayer playerToAsk = null;
        for (CardPlayer player : players){
            if (answer.equalsIgnoreCase(player.getName())){
                playerToAsk = player;
            }
        }
        return playerToAsk;
    }

    public CardPlayer pickCurrentPlayer(){
        Random random = new Random();
        int indexOfPlayer = random.nextInt(players.size());
        CardPlayer firstPlayer = players.get(indexOfPlayer);
        return firstPlayer;
    }

    public String playersToString() {
        String output = "";
        for (CardPlayer player : players){
            output += player.getName() + "\n";
        }
        return output;
    }
}
