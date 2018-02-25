package io.zipcoder.casino.Games;

import io.zipcoder.casino.Players.BlackjackPlayer;

public class ConciousnessPath {

    BlackjackPlayer player;

    ConciousnessPath(BlackjackPlayer player){
        this.player = player;
    }

    public void start(){
        System.out.println(
                "You awaken to a grim reality: you've been trapped in blackjack limbo for " + this.player.getAge() + " years.\n" +
                        "The burden of this new found awareness weighs heavy on your mind.\n" +
                        "Are you even real? Are your memories?\n" +
                        "What of your family and loved ones? What about THIS.PLAYER.GETSPOUSENAME ?\n" +
                        "Your mind reels at the implications of this. Your world will never be the same.\n"
        );
    }
}
