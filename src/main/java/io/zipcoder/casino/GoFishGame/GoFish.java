package io.zipcoder.casino.GoFishGame;

import io.zipcoder.casino.*;

import java.util.*;

public class GoFish extends CardGames {
    private ArrayList<Player> playersList = new ArrayList<>();
    private Player currentPlayer = PlayerWarehouse.getCurrentPlayer();
    private int numOfCompletedSuits = 0;

    public ArrayList<Player> getPlayersList() {
        return playersList;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setPlayersList(ArrayList<Player> playersList) {
        this.playersList = playersList;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public GoFish() {
        super();
    }

    public void numOfOpponents() {
        Integer numOfOpponents = Console.getIntegerInput("\nHow many opponents would you like to play against? (1-3)");

        if (numOfOpponents.equals(1)) {
            playersList.add(currentPlayer);
            playersList.add(new Player("Leon", 100.0));
        }
        else if (numOfOpponents.equals(2)) {
            playersList.add(currentPlayer);
            playersList.add(new Player("Leon", 100.0));
            playersList.add(new Player("Pavel", 100.0));
        }
        else {
            playersList.add(currentPlayer);
            playersList.add(new Player("Leon", 100.0));
            playersList.add(new Player("Pavel", 100.0));
            playersList.add(new Player("Tim", 100.0));
        }
    }

    public void decideOrderOfPlayers() {
        Collections.shuffle(playersList);
    }


    public void dealARound() {
        for (Player aPlayer : playersList) {
            aPlayer.addToHand(deck.getCard());
        }
    }

    public void dealFirstRound(Integer numOfCardsToDeal) {
        for (int x = 0; x<numOfCardsToDeal; x++) {
            dealARound();
        }
    }

    private int verifyPlayerAboutToGoHasCardsInHand(int x) {
        Player tempCurrentPlayer = playersList.get(x);
        if (tempCurrentPlayer.areCardsLeftInHand()) {
            currentPlayer = playersList.get(x);
            Console.print("\n=============================================\n");
            Console.print("It is now " + currentPlayer.getName() + "'s turn!");
        }
        else {
            Console.print(tempCurrentPlayer + " has no cards in their hand. On to the next person.");
            x++;
            currentPlayer = playersList.get(x);
            Console.print("\n=============================================\n");
            Console.print("It is now " + currentPlayer.getName() + "'s turn!");
        }
        return x;
    }

    public String goFishWinner() {
        playersList.sort(Comparator.comparing(Player::getScore).reversed());
        return playersList.get(0).getName();
    }

    @Override
    public void play() {
        numOfOpponents();
        decideOrderOfPlayers();
        GoFishConsole.printOrderOfPlayers(playersList);
        dealFirstRound(5);

        while (numOfCompletedSuits<13) {
            for (int x = 0; x < playersList.size(); x++) {
                if (x == playersList.size()) {
                    x = 0;
                }

                x = verifyPlayerAboutToGoHasCardsInHand(x);

                TurnOfGoFish turnOfGoFish = new TurnOfGoFish(playersList.get(x), playersList);

                GoFishConsole.printPlayersHand(turnOfGoFish.getCurrentPlayer());

                GoFishConsole.printPlayerOpponents(turnOfGoFish);

                Integer personIndex = Console.getIntegerInput("Please pick player to ask a card from.");

                turnOfGoFish.pickAnOpponent(personIndex);

                Integer cardIndex = Console.getIntegerInput("Please pick a card you'd like to ask for.");

                AskForCardLogic askForCardLogic = new AskForCardLogic(turnOfGoFish);

                Card cardPicked = askForCardLogic.pickCardFromOwnHand(cardIndex);

                Boolean isCardFound = askForCardLogic.isCardFound();

                GiveCardLogic giveCardLogic = new GiveCardLogic(playersList.get(x), deck, numOfCompletedSuits, cardPicked);

                if (isCardFound) {
                    giveCardLogic.cardFoundInHand(isCardFound);
                    x--;
                }
                else{
                    giveCardLogic.drawWhenCardNotFound(isCardFound);

                    if (giveCardLogic.drewCardAskedFor(cardPicked)) {
                        x--;
                    }
                }
            }
        }

        String goFishWinner = goFishWinner();
        Console.print(goFishWinner);
        play(); // add the loop
    }

}
