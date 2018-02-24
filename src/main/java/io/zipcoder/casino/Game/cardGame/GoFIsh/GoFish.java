package io.zipcoder.casino.Game.cardGame.GoFIsh;

import io.zipcoder.casino.Game.cardGame.CardGame;
import io.zipcoder.casino.Game.cardGame.utilities.Card;
import io.zipcoder.casino.Game.cardGame.utilities.CardRank;
import io.zipcoder.casino.Game.cardGame.utilities.Hand;
import io.zipcoder.casino.House;
import io.zipcoder.casino.Profile;

import java.util.ArrayList;


public class GoFish extends CardGame {

    private GoFishPlayer user;
    private GoFishPlayer dealer;


    public GoFish(Profile userProfile) {

        super();
        user = new GoFishPlayer(userProfile);
        dealer = new GoFishPlayer(House.HOUSE_PROFILE);
        addPlayer(user);
        addPlayer(dealer);
    }


    public void deal() {

        for (int i = 0; i < 7; i++) {
            user.getHand().addCard(deck.getCard());
            dealer.getHand().addCard(deck.getCard());
        }
    }


    public void playTurn() {

    }

    public int checkHandForCard(GoFishPlayer goFishPlayer, CardRank someCardRank) {

        int countOfCard = 0;
        ArrayList<Card> cardsBeingChecked = goFishPlayer.getHand().getCards();

        for (int i = 0; i < cardsBeingChecked.size(); i++) {
            if (cardsBeingChecked.get(i).getRank() == (someCardRank)) {
                countOfCard++;
            }
        }

        return countOfCard;
    }

    public void transfer(Card card, Hand handTo, Hand handFrom) {
        while (handFrom.hasCard(card)) {
            handTo.addCard(card);
            handFrom.removeCard(card);
        }

    }

    public GoFishPlayer getUser() {
        return user;
    }

    public GoFishPlayer getDealer() {
        return dealer;
    }

}
