package io.zipcoder.casino.Games.GoFish;

import io.zipcoder.casino.Player;

public class GoFishPlayer {
        private String name;
        private Double balance;
        private Integer age;
        //private Card[] hand;


        public GoFishPlayer(Player rootPlayer) {
            this.name = rootPlayer.getName();
            this.age = rootPlayer.getAge();
            this.balance = rootPlayer.getBalance();

        }
}
