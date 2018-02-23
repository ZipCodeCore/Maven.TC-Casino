package io.zipcoder.casino.Game.cardGame.GoFIsh;


import io.zipcoder.casino.Game.Game;
import io.zipcoder.casino.Game.cardGame.CardGame;
import io.zipcoder.casino.Game.cardGame.utilities.Card;
import io.zipcoder.casino.Game.cardGame.utilities.Deck;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Profile;

import java.util.*;

public class GoFish extends CardGame implements Game {


    private Player goFishPlayer;
    private Player dealer;
    private Profile playerProfile;
    private Profile dealerProfile;
    Map<Player,ArrayList<Card>>cardsAtHand=new HashMap<>();
    ArrayList<Card> dealerCards = new ArrayList<Card>();
    ArrayList<Card> playerCards = new ArrayList<Card>();


    public GoFish(GoFishPlayer goFishPlayer) {
        dealerProfile = new Profile("DealerName", 0, 0);
        dealer = new GoFishPlayer(dealerProfile);
        this.goFishPlayer = goFishPlayer;

    }

    public GoFish() {

    }

    public void deal(Deck deckOfCards, Player player1, Player dealer) {

        deckOfCards.fillDeck();
        deckOfCards.shuffle();
        this.goFishPlayer=player1;
        this.dealer=dealer;
        for (int i = 0; i < 7; i++) {
                cardsAtHand.get(player1).add(deckOfCards.getCard());
                cardsAtHand.get(dealer).add(deckOfCards.getCard());
        }

    }

    public boolean ask(Card card) {

        return true;
    }

    public void transfer(Card card, ArrayList<Card>to,ArrayList<Card>from) {
        while(from.contains(card)){
            to.add(card);
            from.remove(card);
        }

    }

    public void drawCard(Player player,Card card) {
        cardsAtHand.get(player).add(card);


    }

    public void passTurn(Player player1, Player player2) {
    }

    protected boolean add(Player player, Card card) {
        if (hasEntry(player)) {
            getCards(player).add(card);
            return true;

        } else {
            ArrayList<Card> playerCards = new ArrayList<>();
            playerCards.add(card);
            cardsAtHand.put(player, playerCards);
        }

        return true;
    }
    protected boolean hasEntry(Player player){
        if(cardsAtHand.containsKey(player)){
            return true;
        }
        return false;
    }
    protected ArrayList<Card> getCards(Player player){
        return cardsAtHand.get(player);
    }


}
