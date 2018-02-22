package io.zipcoder.casino.Players;
import io.zipcoder.casino.GameTools.Deck.Card;

import java.util.ArrayList;
import java.util.List;



public class GoFishPlayer extends Player {
        private String name;
        private Double balance;
        private Integer age;
        private List<Card> cardHand;


        public GoFishPlayer(Player rootPlayer) {
            this.name = rootPlayer.getName();
            this.age = rootPlayer.getAge();
            this.balance = rootPlayer.getBalance();
            cardHand = new ArrayList<Card>();
        }




}
