package io.zipcoder.casino.games.gofish;

import io.zipcoder.casino.games.CardGame;
import io.zipcoder.casino.nuts_n_bolts.User;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingCard;

import java.util.ArrayList;

public class GoFish extends CardGame {

    public void play() {

    }

    private class GoFishPlayer {

        private double score = 0;
        private User user;
        private ArrayList<PlayingCard> hand = new ArrayList<>();

        public GoFishPlayer(User user){
            this.user = user;
        }

        public void askForCards(GoFishPlayer other){}

        private void getCards(GoFishPlayer other){}

        private void drawCard(){}
    }
}
