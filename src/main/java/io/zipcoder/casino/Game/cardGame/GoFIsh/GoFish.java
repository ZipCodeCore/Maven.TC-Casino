package io.zipcoder.casino.Game.cardGame.GoFIsh;

import io.zipcoder.casino.Game.cardGame.CardGame;
import io.zipcoder.casino.Game.cardGame.utilities.Card;
import io.zipcoder.casino.Game.cardGame.utilities.Hand;
import io.zipcoder.casino.House;
import io.zipcoder.casino.Profile;


public class GoFish extends CardGame {

    private GoFishPlayer user;
    private GoFishPlayer dealer;


    public GoFish(Profile userProfile) {

        super();
        user = new GoFishPlayer(userProfile);
        dealer = new GoFishPlayer(House.HOUSE_PROFILE);
    }


    public void deal() {
            for (int i = 0; i < 7; i++) {
            user.getHand().addCard(deck.getCard());
            dealer.getHand().addCard(deck.getCard());
        }
    }


    public boolean ask(Card card) {

        return true;
    }

    public void transfer(Card card, Hand handTo, Hand handFrom) {
        while(handFrom.hasCard(card)){
            handTo.addCard(card);
            handFrom.removeCard(card);
        }

    }

}
