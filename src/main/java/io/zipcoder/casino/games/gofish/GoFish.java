package io.zipcoder.casino.games.gofish;

import io.zipcoder.casino.games.CardGame;
import io.zipcoder.casino.nuts_n_bolts.User;
import io.zipcoder.casino.nuts_n_bolts.cards.Hand;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingValue;

import java.util.ArrayList;

public class GoFish extends CardGame {

    private ArrayList<GoFishPlayer> players;

    public GoFish(Integer numberOfCompPlayers){

    }

    public void play() {

    }

    private GoFishPlayer createCompPlayer(){
        return null;
    }

    private void shufflePlayerOrder(){}

    private Boolean lastPlayerHandEmpty(){
        return null;
    }

    private void declareWinner(){}

    private class GoFishPlayer {

        private User user;
        private Hand hand = new Hand();
        private PlayingValue askedValue = null;

        public GoFishPlayer(User user){
            this.user = user;
        }

        public void askForCards(GoFishPlayer other, PlayingValue value){}

        private void getCards(GoFishPlayer other, PlayingValue value){}

        private void drawCard(){}

        private Boolean hasFourOfKind(){
            return null;
        }

        private void discardFourOfKind(){}

    }
}
