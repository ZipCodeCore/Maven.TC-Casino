package io.zipcoder.casino.Games;

import io.zipcoder.casino.Casino;
import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Deck;
import io.zipcoder.casino.Players.ComputerPlayer;
import io.zipcoder.casino.Players.GoFishPlayer;
import io.zipcoder.casino.Players.Player;
import io.zipcoder.casino.InputOutput.InputOutput;

import java.util.*;

public class GoFish {
    private List<Card> cardHand;
    private ArrayList<Player> players;


    public String play() {
        InputOutput inputOutput = new InputOutput();
        Player rootPlayer = new Player("Bob", 45, 100);
        GoFishPlayer goFishPlayer1 = new GoFishPlayer(rootPlayer);
        ComputerPlayer computerPlayer = new ComputerPlayer();

        cardHand = new ArrayList<Card>();

        players = new ArrayList<Player>();
        players.add(rootPlayer);
        players.add(goFishPlayer1);

        Deck deck = new Deck();
        deck.shuffleDeck();


        while(goFishPlayer1.getNumPairs() + computerPlayer.getNumPairs() < 26) {


        }

        if (goFishPlayer1.getNumPairs() > computerPlayer.getNumPairs()) {

            String winner = inputOutput.promptForString("Congratulations, you win!");
            return winner;
        }
        else {

        }
        return null;
    }


    public void buildPlayerHand() {

    }

    public void buildComputerHand() {

    }


    public void deal() {
        this.buildPlayerHand();
        this.buildComputerHand();
        //this.buildStockPile();
    }

    public int deckSize() {
        return cardHand.size();
    }


    public String displayCardHand() {
        StringBuilder cardHandBuilder = new StringBuilder();
        for (int i = 0; i < cardHand.size(); i++) {
            cardHandBuilder.append("Card " + (i + 1) + cardHand.get(i) + "\n");
        }

        return cardHandBuilder.toString();
    }

    public boolean isGameOver() {
        return false;
    }

    public void takeTurn() {

    }


}
