package io.zipcoder.casino.Game.cardGame.GoFIsh;


import io.zipcoder.casino.Game.Game;
import io.zipcoder.casino.Game.cardGame.CardGame;
import io.zipcoder.casino.Game.cardGame.utilities.Card;
import io.zipcoder.casino.Game.cardGame.utilities.Deck;
import io.zipcoder.casino.Game.cardGame.utilities.Hand;
import io.zipcoder.casino.House;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Profile;

import java.util.*;

public class GoFish extends CardGame implements Game {

    private Hand dealerHand;
    private Hand userHand;
    private Profile theHouse;
    private Player dealer;
    private Deck goFishDeck;

    public GoFish(Profile userProfile) {
        GoFishPlayer user = new GoFishPlayer(userProfile);
        GoFishPlayer dealer = new GoFishPlayer(House.HOUSE_PROFILE);
        goFishDeck = new Deck();
        //dealerHand = new Hand();
        //userHand= new Hand();
    }

   public void deal() {
        for(int i=0;i<7;i++){
           // dealer..addCard(goFishDeck.getCard());
            userHand.addCard(goFishDeck.getCard());
        }
    }


    public boolean ask(Card card) {

        return true;
    }

    public void transfer(Card card, Hand handTo, Hand handFrom) {
        /* while(handFrom.hasCard(card)){
         handTo.addCard(card);
         handFrom.remove(card);
        }

    }

    public void drawCard(Player player, Card card) {
        // .get(player).add(card);


    }

    public void passTurn(Player player1, Player player2) {
    }

    protected boolean add(Player player, Card card) {
        if (hasEntry(player)) {
            // getCards(player).add(card);
            return true;

        } else {
            ArrayList<Card> playerCards = new ArrayList<>();
            playerCards.add(card);
            //cardsAtHand.put(player, playerCards);
        }

        return true;
    }

    protected boolean hasEntry(Player player) {
        // if(cardsAtHand.containsKey(player)){
        return true;
    }
    //return false;
    // }


}
