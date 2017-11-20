package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GoFish extends CardGames {

    private Player currentPlayer = PlayerWarehouse.getCurrentPlayer();

    private ArrayList<Player> playersList = new ArrayList<>();
    private Deck aDeck = new Deck();

    public GoFish() {
    }

    private void numOfOpponents() {
        Integer numOfOpponents = Console.getIntegerInput("How many opponents would you like to play against? (1-3)");

        if (numOfOpponents.equals(1)) {
            playersList.add(currentPlayer);
            playersList.add(new Player("Brian", 100.0));
        }
        else if (numOfOpponents.equals(2)) {
            playersList.add(currentPlayer);
            playersList.add(new Player("Brian", 100.0));
            playersList.add(new Player("Pavel", 100.0));
        }
        else {
            playersList.add(currentPlayer);
            playersList.add(new Player("Brian", 100.0));
            playersList.add(new Player("Pavel", 100.0));
            playersList.add(new Player("Tim", 100.0));
        }
    }

    public void decideOrderOfPlayers() {
        Collections.shuffle(playersList);
        Console.print("Order Of Players Turns: \n");
        playersList.forEach(n -> System.out.println(n.getName()));
        Console.print("");
    }

    public void dealARound() {
        for (Player aPlayer : playersList) {
            aPlayer.addToHand(aDeck.getCard());
        }
    }

    public void dealFirstRound() {
        dealARound();
        dealARound();
        dealARound();
        dealARound();
        dealARound();
    }

    public void sortPlayerHand(Player aPlayer) {
        aPlayer.getHand().sort((a,b) -> a.toString().compareTo(b.toString()));
    }

    public void displayHand(Player aPlayer) {
        Console.print("This is your hand: ");
        sortPlayerHand(aPlayer);

        for (int x = 0; x < aPlayer.getHand().size(); x++) {
            Console.print(x+") "+aPlayer.getHand().get(x));
        }
        Console.print("");
    }

    public void pickCardToAskFor(Player aPlayer) {
        int cardIndex = Console.getIntegerInput("Please pick a card you'd like to ask for.");
        Card aCard = aPlayer.getHand().get(cardIndex);
        System.out.println(aCard.toString());
    }



    public void displayPlayersNames() {
        Console.print("Please pick a person you'd like to ask for cards.");
        Console.print("");
        for (int x = 0; x < playersList.size(); x++) {
            String playersName = playersList.get(x).getName();
            if (!currentPlayer.getName().equalsIgnoreCase(playersName)) {
                Console.print(x+") "+playersName+", has "+playersList.get(x).getHand().size()+" cards in his hand.");
            }
        }


        Console.print("");
    }

//    public void checkForCardInHand() {
//        int indexOfPlayerPicked = Console.getIntegerInput("");
//        Player playerPicked = playersList.get(indexOfPlayerPicked);
//        ArrayList<Card> playerPickedHand = playerPicked.getHand();
//
//        for (int x = 0; x < playerPickedHand.size(); x++) {
//            if (playerPickedHand.get(x))
//        }
//    }

    @Override
    public void play() {
        Console.print(getPlayer().getName());
        numOfOpponents();
        decideOrderOfPlayers();
        dealFirstRound();
        displayHand(currentPlayer);
        pickCardToAskFor(currentPlayer);
        displayPlayersNames();
        //pickAPlayer();
    }
}
