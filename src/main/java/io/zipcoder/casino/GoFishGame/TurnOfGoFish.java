package io.zipcoder.casino.GoFishGame;

import io.zipcoder.casino.Console;
import io.zipcoder.casino.Player;
import java.util.ArrayList;

public class TurnOfGoFish {
    private Player currentPlayer;
    private Player playerPicked;
    private ArrayList<Player> playersList;

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getPlayerPicked() {
        return playerPicked;
    }

    public TurnOfGoFish(Player currentPlayer, ArrayList<Player> playersList) {
        this.currentPlayer = currentPlayer;
        this.playersList = playersList;
    }

    public String stringOfOpponentsNames() {
        //Console.print("Please pick a person you'd like to ask for cards.\n");

        StringBuilder output = new StringBuilder();

        for (int x = 0; x < this.playersList.size(); x++) {
            String playersName = this.playersList.get(x).getName();
            if (!this.currentPlayer.getName().equalsIgnoreCase(playersName)) {
                output.append(x).append(") ").append(playersName).append(", has ").append(this.playersList.get(x).getHand().size()).append(" cards in his hand.\n");
            }
        }
        return output.toString();
    }

    private void pickedYourselfError(Integer indexOfPlayerPicked) {
        if ((indexOfPlayerPicked == playersList.indexOf(currentPlayer))) {
            throw new IndexOutOfBoundsException("Can not pick yourself.");
        }
    }

    private void noCardsInPlayersHandError(Integer indexOfPlayerPicked){
        Player aPlayer = playersList.get(indexOfPlayerPicked);
        if (!aPlayer.areCardsLeftInHand()) {
            throw new IndexOutOfBoundsException("Can not pick "+
                    aPlayer.getName()+", he has no cards left in his hand.");
        }
    }

    public Player pickAnOpponent(Integer indexOfPlayerPicked) {
        Player aPlayer;
        try {
            pickedYourselfError(indexOfPlayerPicked);
            noCardsInPlayersHandError(indexOfPlayerPicked);
            aPlayer = playersList.get(indexOfPlayerPicked);
            playerPicked = aPlayer;
            return aPlayer;

        } catch (IndexOutOfBoundsException e) {
            Integer playerIndex = Console.getIntegerInput(
                    "Please pick a valid player to ask a card from.");
            return pickAnOpponent(playerIndex);
            //e.printStackTrace();
        }
    }
}
