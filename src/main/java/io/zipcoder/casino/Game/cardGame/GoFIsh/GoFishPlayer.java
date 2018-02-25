package io.zipcoder.casino.Game.cardGame.GoFIsh;

import io.zipcoder.casino.Game.cardGame.CardPlayer;
import io.zipcoder.casino.Game.cardGame.utilities.Card;
import io.zipcoder.casino.Game.cardGame.utilities.CardRank;
import io.zipcoder.casino.Profile;

import java.util.ArrayList;
import java.util.HashMap;


public class GoFishPlayer extends CardPlayer {

    //private HashMap<Card, Integer>books;
//    private Hand gfHand;
ArrayList<Card>books = new ArrayList<>();

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


    public void buildBooks(GoFishPlayer aPlayer, CardRank aCardRank){
        for(int i =0; i<aPlayer.getHand().getCards().size();i++){
            if(aPlayer.getHand().getCards().get(i).getRank()==aCardRank){
                books.add(aPlayer.getHand().getCards().get(i));
            }
        }
    }
    public ArrayList<Card> getBook(){
        return this.books;
    }
    public int getScores(){
        return this.books.size()/4;
    }


}
