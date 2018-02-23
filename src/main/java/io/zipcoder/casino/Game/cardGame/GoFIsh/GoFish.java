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

    private Deck goFishDeck;
    private GoFishPlayer user;
    private GoFishPlayer dealer;

    public GoFish(Profile userProfile) {
 master
        user = new GoFishPlayer(userProfile);
        dealer = new GoFishPlayer(House.HOUSE_PROFILE);
        goFishDeck = new Deck();

    }

   public void deal() {
        for(int i=0;i<7;i++){
            user.getHand().addCard(goFishDeck.getCard());
            dealer.getHand().addCard(goFishDeck.getCard());
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
