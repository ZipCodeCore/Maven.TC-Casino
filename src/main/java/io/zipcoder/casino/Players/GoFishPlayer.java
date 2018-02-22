package io.zipcoder.casino.Players;

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
