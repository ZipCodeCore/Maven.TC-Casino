package io.zipcoder.casino.games.craps;

import io.zipcoder.casino.games.Gamble;
import io.zipcoder.casino.games.Game;
import io.zipcoder.casino.nuts_n_bolts.Dice;
import io.zipcoder.casino.nuts_n_bolts.Pot;
import io.zipcoder.casino.nuts_n_bolts.User;

import java.util.ArrayList;

public class Craps implements Game, Gamble {

    //2 players
    //roll to decide first, highest wins
    //both make a bet -> pot
    //decide if bet is pass or don't pass
    //player throwin dice = shooter
    //roll 2 dice 7/11 on first roll -> win
    // 2/3/12 on first roll -> lose
    //come/don't come bets

    private ArrayList<CrapsPlayer> players;
    private Dice<Integer> dice = new Dice<>(1,2,3,4,5,6);
    private Pot pot;

    public void play() {

    }

    @Override
    public void takeBet(Double bet) {

    }

    @Override
    public void settleBet() {

    }

    private class CrapsPlayer {

        private User user;



        public CrapsPlayer(User user) {
            this.user = user;
        }

        public void makeABet(Double money) {
        }

        public void winABet(Double money) {
        }
    }
}
