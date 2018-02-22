package io.zipcoder.casino.Players;
import io.zipcoder.casino.GameTools.Deck.Card;

import java.util.ArrayList;
import java.util.List;



public class GoFishPlayer extends Player {
        private String name;
        private Integer age;
        private List<Card> cardHand;
        private int numPairs;


        public GoFishPlayer(Player rootPlayer) {
            this.name = rootPlayer.getName();
            this.age = rootPlayer.getAge();
            cardHand = new ArrayList<Card>();
            numPairs = 0;
        }

        public int getNumPairs() {
            return numPairs;
        }






}
