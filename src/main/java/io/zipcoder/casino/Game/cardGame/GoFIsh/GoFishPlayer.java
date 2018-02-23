package io.zipcoder.casino.Game.cardGame.GoFIsh;



import io.zipcoder.casino.Game.cardGame.CardPlayer;
import io.zipcoder.casino.Game.cardGame.utilities.Card;
import io.zipcoder.casino.Game.cardGame.utilities.Hand;
import io.zipcoder.casino.Profile;

import java.util.ArrayList;
import java.util.HashMap;

public class GoFishPlayer extends CardPlayer {


    private HashMap<Card, Integer>books;
    private ArrayList<Card>goFishHand;
    private Hand gfHand;


    public Hand getHand() {
    return this.gfHand;
    }

    public GoFishPlayer(Profile playerProfile){
        super(playerProfile);
        goFishHand = new ArrayList<>();
        gfHand = new Hand(goFishHand);
    }


    public void buildBook(ArrayList<Card> inputCards){



    }


}
