package io.zipcoder.casino.Games;
import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Deck;
import io.zipcoder.casino.Players.GoFishAI;
import io.zipcoder.casino.Players.GoFishPlayer;
import io.zipcoder.casino.InputOutput.InputOutput;
import java.util.*;



public class GoFish {

    private ArrayList<GoFishPlayer> players;
    private InputOutput inputOutput;
    List<Card> stockPile;
    private int numPairsMatched;
    private GoFishAI goFishAI;

    public GoFish(GoFishPlayer player1) {
        inputOutput = new InputOutput();
        players = new ArrayList<GoFishPlayer>();
        players.add(player1);
        //players.add(goFishAI);
        numPairsMatched = 0;

        Deck deck = new Deck();
        deck.shuffleDeck();
    }

    public String play() {
        while (gameIsNotOver()) {

        }
        return null;
    }

        //decide who wins here


//    public void buildPlayerHand(){
//
//
//    }
//
//
//    public void deal() {
//
//    }

        public String displayCardHand () {
            StringBuilder cardHandBuilder = new StringBuilder();
            for (int i = 0; i < players.size(); i++) {
                //cardHandBuilder.append("Card " + (i + 1) + cardHand.get(i) + "\n");
            }
            return cardHandBuilder.toString();
        }

        private boolean gameIsNotOver () {
            for (GoFishPlayer player : players) {
                numPairsMatched = player.getNumPairs();
            }
            return numPairsMatched < 26;
        }

        public void takeTurn () {

        }

    }



