package io.zipcoder.casino;

import java.util.ArrayList;

public class GoFish extends CardGames {

    ArrayList<GoFishPlayer> goFishPlayers;

    public void start() {


        GoFishPlayer player = new GoFishPlayer("Donald");
        goFishPlayers.add(player);
        Deck goFishDeck = new Deck();
        goFishDeck.shuffle();
        player.dealGoFishHAnd(goFishPlayers, goFishDeck);


    }
}
