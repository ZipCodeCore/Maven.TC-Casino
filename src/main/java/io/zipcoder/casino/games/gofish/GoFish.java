package io.zipcoder.casino.games.gofish;

import io.zipcoder.casino.nuts_n_bolts.User;
import io.zipcoder.casino.nuts_n_bolts.cards.Hand;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingCard;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingDeck;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingValue;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        return player.hand.isHandEmpty();
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

        public Hand getHand() {
            return hand;
        }

        PlayingValue getAskedValue() {
            return askedValue;
        }

        Integer askForValue(GoFishPlayer other, PlayingValue value){
            this.askedValue = value;
            return other.checkIfHandHasValue(value);
        }

        Integer checkIfHandHasValue(PlayingValue value) {
            return getAllOfValue(value).size();
        }

        private ArrayList<PlayingCard> getAllOfValue(PlayingValue value) {
            return (ArrayList<PlayingCard>) this.getHand().getAllCards().stream().
                    filter(card -> value.equals(card.getValue())).collect(Collectors.toList());
        }

        void takeCardsFromOther(GoFishPlayer other, PlayingValue value){
            ArrayList<PlayingCard> movingCards = other.getAllOfValue(value);
                other.getHand().getAllCards().removeAll(movingCards);
                this.getHand().getAllCards().addAll(movingCards);
        }

        void nullAskedValue(){
            this.askedValue = null;
        }

        PlayingCard drawCard(){
            PlayingCard drawnCard;
            drawnCard = deck.getAndRemoveCard();
            hand.addCard(drawnCard);
            return drawnCard;
        }

        PlayingValue fourOfKindValue(){
            HashMap<PlayingValue, Integer> count = new HashMap<>();
            PlayingValue hasFour = null;
            for (PlayingCard card : this.getHand().getAllCards()) {
                if (count.containsKey(card.getValue())) {
                    count.put(card.getValue(), (count.get(card.getValue()) + 1));
                    if (count.get(card.getValue()) == 4) {
                        hasFour = card.getValue();
                    }
                } else {
                    count.put(card.getValue(), 1);
                }
            }
            return hasFour;
            }

        void discardFourOfKind(PlayingValue value){
            this.getHand().getAllCards().removeIf(card -> card.getValue() == value);
        }

    }
}
