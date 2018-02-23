package io.zipcoder.casino.Game.cardGame.GoFIsh;


import io.zipcoder.casino.Game.Game;
import io.zipcoder.casino.Game.cardGame.CardGame;
import io.zipcoder.casino.Game.cardGame.utilities.Card;
import io.zipcoder.casino.Game.cardGame.utilities.Deck;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Profile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Stack;

public class GoFish extends CardGame implements Game{


    private Player goFishPlayer;
    private Player dealer;
    private Profile playerProfile;
    private Profile dealerProfile;
    ArrayList<Card>dealerCards= new ArrayList<Card>();
    ArrayList<Card>playerCards= new ArrayList<Card>();
    private Deck newDeck;

    public GoFish(GoFishPlayer goFishPlayer){
        dealerProfile = new Profile("DealerName",0,0);
        dealer= new GoFishPlayer(dealerProfile);
        this.goFishPlayer = goFishPlayer;
    }

    public GoFish() {

    }

    public void deal( Deck deckOfCards, Player player1,Player dealer){
        deckOfCards.shuffle();
        if(deckOfCards.countRemainingCards()<1){
            deckOfCards.fillDeck();
        }
        for(int i=0;i<7;i++){
            playerCards.add(deckOfCards.getCard());
            dealerCards.add(deckOfCards.getCard());
        }

    }
    public boolean ask(Card card){

        return true;
    }
    public void transfer(Card card,Player player){

    }
    public void drawCard(Player player){


    }
    public void passTurn(Player player1,Player player2){
    }


}
