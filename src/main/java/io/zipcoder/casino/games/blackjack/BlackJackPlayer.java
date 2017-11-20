package io.zipcoder.casino.games.blackjack;

import io.zipcoder.casino.nuts_n_bolts.Player;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingCard;

import java.util.ArrayList;

public class BlackJackPlayer extends Player{


    private ArrayList<PlayingCard> hand;
    private Double money;

    private BlackJackPlayer(String name){
        super(name);
    }

    public BlackJackPlayer(Player player, Double startingMoney) {
        this.name = player.getName();
        this.money = money;
    }


}
