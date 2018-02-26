package io.zipcoder.casino.Games;

import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Deck;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Players.Player;
import io.zipcoder.casino.Players.WarPlayer;

public class War implements Game {

   private Integer playerPoints;
   private Integer computerPoints;
   private WarPlayer player = new WarPlayer();
   private Deck deck = new Deck();

    public void shuffle() {
        deck.shuffleDeck();
    }

    public Card deal() {
//        player.currentHand.add(deck.deck.get(0));
//        deck.deck.remove(deck.deck.get(0));
        for(int i = 0; i < deck.deck.size(); i++) {
            System.out.println(deck.deck.get(i).toString());
        }
        return null;
    }

    public String compareCards() {
        return null;
    }

    public void itisWar() {


    }

    public Integer awardPoint() {
        return 0;
    }

    public boolean cardsLeftInDeck() {
//        if(deck.get(0) != null) {
//            return true;
//        }
        return false;
    }

    public String declareWinner() {
        if(playerPoints > computerPoints) {
            return "Congratulations. " + player.getName() + "You won";
        }
        return "You lost to a computer...";
    }

    public static void main(String[] args) {
        War war = new War();
        war.deal();
    }

    public void startGame() {

    }

    public void endGame() {

    }
}
