package io.zipcoder.casino.Game.cardGame.GoFIsh;

import io.zipcoder.casino.CasinoUtilities.Console;
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

    public void ask(CardRank aCardRank, GoFishPlayer askingPlayer, GoFishPlayer playerBeingAsked) {

        if (countMatchesInHand(askingPlayer, aCardRank) < 1) {
            Console.print("You cannot ask for a card that you do not have. Try again.");
        } else if (countMatchesInHand(playerBeingAsked, aCardRank) < 1) {
            Console.print("Go fish.");
            fish(askingPlayer);
        } else {
            transfer(aCardRank, playerBeingAsked, askingPlayer);
        }
    }

    public void fish(GoFishPlayer askingPlayer) {
        askingPlayer.getHand().addCard(getDeck().getCard());
    }

    public int countMatchesInHand(GoFishPlayer goFishPlayer, CardRank someCardRank) {

        int countOfCard = 0;
        ArrayList<Card> cardsBeingChecked = goFishPlayer.getHand().getCards();

        for (int i = 0; i < cardsBeingChecked.size(); i++) {
            if (cardsBeingChecked.get(i).getRank() == (someCardRank)) {
                countOfCard++;
            }
        }

        return countOfCard;
    }

    public void transfer(CardRank someCardRank, GoFishPlayer fromPlayer, GoFishPlayer toPlayer) {

        for (int i = 0; i < fromPlayer.getHand().getCards().size(); i++) {
            
            if (fromPlayer.getHand().getCards().get(i).getRank() == someCardRank) {

                toPlayer.getHand().addCard(fromPlayer.getHand().getCards().get(i));

                fromPlayer.getHand().removeCard(fromPlayer.getHand().getCards().get(i));
            }
        }
    }

    public GoFishPlayer getUser() {
        return user;
    }

    public GoFishPlayer getDealer() {
        return dealer;
    }

}
