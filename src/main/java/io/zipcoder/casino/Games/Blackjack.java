package io.zipcoder.casino.Games;


import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Deck;
import io.zipcoder.casino.Games.Dealer.Dealer;
import io.zipcoder.casino.Players.BlackjackPlayer;
import io.zipcoder.casino.Players.Player;

import java.util.ArrayList;

public class Blackjack {

    protected ArrayList<BlackjackPlayer> playerList;
    protected Deck deck;
    protected Dealer bkjkDealer;


    Blackjack(Player... players){
        deck = new Deck();
        bkjkDealer = new Dealer();
        playerList = new ArrayList<BlackjackPlayer>();
        for (Player rootPlayer:players) {
            playerList.add(new BlackjackPlayer(rootPlayer));
        }
    }

    public void deal(BlackjackPlayer currentPlayer){
        Card temp = this.deck.deck.get(0);
        currentPlayer.addToHand(temp);
        this.deck.deck.remove(0);
    }

    public void initialHand(BlackjackPlayer... blackjackPlayers){
        for (BlackjackPlayer thisPlayer:blackjackPlayers) {
            this.deal(thisPlayer);
            this.deal(thisPlayer);
        }
    }

}
