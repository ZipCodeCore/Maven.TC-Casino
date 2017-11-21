package io.zipcoder.casino.games.gofish;

import io.zipcoder.casino.nuts_n_bolts.User;
import io.zipcoder.casino.nuts_n_bolts.cards.Hand;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingCard;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingDeck;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingValue;

public class GoFish {

    private GoFishPlayer player;

    private GoFishPlayer dealer;

    private PlayingDeck deck;
    public GoFish(User user){
        this.player = new GoFishPlayer(user);
        this.dealer = createCompPlayer();
        this.deck = new PlayingDeck();
    }

    GoFishPlayer createCompPlayer(){
        return new GoFishPlayer(new User("Dealer"));
    }

    Boolean lastPlayerHandEmpty(GoFishPlayer player){
        return this.getPlayer().hand.isHandEmpty();
    }

    public GoFishPlayer getPlayer() {
        return player;
    }

    public GoFishPlayer getDealer() {
        return dealer;
    }

    public PlayingDeck getDeck() {
        return deck;
    }

    class GoFishPlayer {

        private User user;
        private Hand hand;
        private PlayingValue askedValue = null;

        GoFishPlayer(User user){
            this.user = user;
            this.hand = new Hand();
        }

        User getUser() {
            return user;
        }

        PlayingValue getAskedValue() {
            return askedValue;
        }

        Boolean askForValue(GoFishPlayer other, PlayingValue value){
            return null;
        }

        void getCards(GoFishPlayer other, PlayingValue value){}

        void nullAskedValue(){

        }

        PlayingCard drawCard(){
            return null;
        }

        Boolean hasFourOfKind(){
            return null;
        }

        void discardFourOfKind(){}

    }
}
