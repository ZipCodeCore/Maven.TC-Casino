package io.zipcoder.casino.Game.cardGame.GoFIsh;

import io.zipcoder.casino.Game.cardGame.CardPlayer;
import io.zipcoder.casino.Game.cardGame.utilities.Card;
import io.zipcoder.casino.Game.cardGame.utilities.CardRank;
import io.zipcoder.casino.Profile;

import java.util.ArrayList;
import java.util.HashMap;


public class GoFishPlayer extends CardPlayer {

    private HashMap<Card, Integer>books;
//    private Hand gfHand;

    public GoFishPlayer(Profile playerProfile){
        super(playerProfile);
//        gfHand = new Hand();
    }

//
//    public Hand getHand() {
//        super.getHand();
//        return this.gfHand;
//
//    }


    public ArrayList<Card> buildBooks(GoFishPlayer aPlayer, CardRank aCardRank){
        ArrayList<Card>books = new ArrayList<>();
        for(int i =0; i<aPlayer.getHand().getCards().size();i++){
            if(aPlayer.getHand().getCards().get(i).getRank()==aCardRank){
                books.add(aPlayer.getHand().getCards().get(i));
            }
        }
        return books;
    }

}
