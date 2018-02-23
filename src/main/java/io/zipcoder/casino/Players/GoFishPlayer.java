package io.zipcoder.casino.Players;
import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Rank;
import io.zipcoder.casino.GameTools.Deck.Suit;
import io.zipcoder.casino.Games.GoFish;
import io.zipcoder.casino.InputOutput.InputOutput;

import java.util.ArrayList;
import java.util.List;



public class GoFishPlayer extends Player {
        public List<Card> cardHand;
        private int numPairs;
        private InputOutput inputOutput = new InputOutput();

        public GoFishPlayer(Player rootPlayer) {
            super(rootPlayer.getName(), rootPlayer.getAge());
            cardHand = new ArrayList<Card>();
            numPairs = 0;
        }

        public GoFishPlayer(){

        }

        public int getNumPairs() {
            return numPairs;
        }

    public List<Card> getCardHand() {
            return cardHand;
    }

    public boolean hasCard(Card cardToCheck) {
            return cardHand.contains(cardToCheck);
        }

        public void removeCardFromHand(Card cardToRemove) {
            cardHand.remove(cardToRemove);
        }

//        public Card askForCard() {
//           inputOutput.promptForString("");
//           return Card
//        }

    public static void main(String[] args) {
        Player player1 = new Player("Bob", 34);
        GoFishPlayer goFishPlayer1 = new GoFishPlayer(player1);

        //List<Card> cardHand = new ArrayList<Card>();
        Card temp1 = new Card(Rank.ACE, Suit.HEARTS);
        Card temp2 = new Card(Rank.FOUR, Suit.DIAMOND);
        Card temp3 = new Card(Rank.QUEEN, Suit.SPADE);
        goFishPlayer1.cardHand.add(temp1);
        goFishPlayer1.cardHand.add(temp2);
        goFishPlayer1.cardHand.add(temp3);

        System.out.println(goFishPlayer1.getCardHand());





    }

}
