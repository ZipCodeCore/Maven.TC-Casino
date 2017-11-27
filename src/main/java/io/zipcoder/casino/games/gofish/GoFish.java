package io.zipcoder.casino.games.gofish;

import io.zipcoder.casino.games.Game;
import io.zipcoder.casino.nuts_n_bolts.Input;
import io.zipcoder.casino.nuts_n_bolts.User;
import io.zipcoder.casino.nuts_n_bolts.cards.Hand;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingCard;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingDeck;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingValue;

import java.util.*;
import java.util.stream.Collectors;

public class GoFish implements Game {

    private GoFishPlayer humanPlayer;

    private GoFishPlayer compPlayer;

    private PlayingDeck deck;
    private GoFishPlayer winner = null;

    public GoFish(User user){
        this.humanPlayer = new GoFishPlayer(user);
        this.compPlayer = createCompPlayer();
        this.deck = new PlayingDeck();
        this.deck.shuffle();
    }

    @Override
    public boolean play(String userInput) {
        return false;
    }

    GoFishPlayer createCompPlayer(){
        return new GoFishPlayer(new User("Dealer"));
    }

    Boolean lastPlayerHandEmpty(GoFishPlayer player){
        return player.hand.isHandEmpty();
    }

    public GoFishPlayer getHumanPlayer() {
        return humanPlayer;
    }

    public GoFishPlayer getCompPlayer() {
        return compPlayer;
    }

    public PlayingDeck getDeck() {
        return deck;
    }

    public void run() {
        humanPlayer.hand.clear();
        compPlayer.hand.clear();
        dealInitialHands(7); //change to 6, 5 for 3, 4 players
        do {
            playHumanTurn(humanPlayer);
            playComputerTurn(compPlayer);
        } while (winner == null);
        endGame();
    }

    private void playHumanTurn(GoFishPlayer player) {
        displayHand(player);
        tryAskingForValue();
    }

    private void playComputerTurn(GoFishPlayer compPlayer) {
        System.out.println(compPlayer.getUser().getName()+" has "+compPlayer.hand.getAllCards().size()+" cards.");
        compAskingForValue();
    }

    private void compAskingForValue() {
        do {
            PlayingValue value = null;
            value = getRandomPlayingValue(compPlayer);
            System.out.println(compPlayer.getUser().getName()+" asks for "+value+"!");
            if (compPlayer.askForValue(humanPlayer, value) > 0) {
                compPlayer.takeCardsFromOther(humanPlayer, value);
                System.out.println("Since you had "+value+", "+compPlayer.getUser().getName()+" takes it/them!");
                if(compPlayer.hand.isHandEmpty()){
                    winner = compPlayer;
                    System.out.println(compPlayer.getUser().getName()+"'s hand is empty!");
                    break;
                }
                System.out.println(compPlayer.getUser().getName()+" has "+compPlayer.hand.getAllCards().size()+" cards.");
            } else {
                System.out.println("You didn't have any of those, "+compPlayer.getUser().getName()+" has to Go Fish!");
                PlayingCard drawnCard = compPlayer.drawCard();
                if (drawnCard.getValue() == value) {
                    System.out.println(compPlayer.getUser().getName()+" drew a card.");
                    if(compPlayer.hand.isHandEmpty()){
                        winner = compPlayer;
                        System.out.println(compPlayer.getUser().getName()+"'s hand is empty!");
                        break;
                    }
                    System.out.println(compPlayer.getUser().getName()+" asked for " + value + " and drew a card of that rank! It can ask for another card!");
                    continue;
                } else {
                    System.out.println(compPlayer.getUser().getName()+" has "+compPlayer.hand.getAllCards().size()+" cards.");
                    System.out.println("This ends "+compPlayer.getUser().getName()+"'s turn.\n\n");
                    compPlayer.nullAskedValue();
                    break;
                }
            }
        } while (true);
    }

    private PlayingValue getRandomPlayingValue(GoFishPlayer compPlayer) {
        Random random = new Random();
        TreeSet<PlayingValue> values = compPlayer.getValuesInHand();
        ArrayList<PlayingValue> list = new ArrayList<>(values);
        return list.get(random.nextInt(list.size()));
    }

    private void tryAskingForValue() {
        do {
            PlayingValue value = null;
            value = getPlayingValue(humanPlayer);
            if (humanPlayer.askForValue(compPlayer, value) > 0) {
                humanPlayer.takeCardsFromOther(compPlayer, value);
                if(humanPlayer.hand.isHandEmpty()){
                    winner = humanPlayer;
                    break;
                }
                displayHand(humanPlayer);
            } else {
                System.out.println("They didn't have any of those, Go Fish!");
                PlayingCard drawnCard = humanPlayer.drawCard();
                if (drawnCard.getValue() == value) {
                    System.out.println("You draw a "+drawnCard.toString());
                    System.out.println("You asked for " + value + " and drew a card of that rank! You can ask for another card!");
                    if(humanPlayer.hand.isHandEmpty()){
                        winner = humanPlayer;
                        break;
                    }
                    displayHand(humanPlayer);
                    continue;
                } else {
                    System.out.println("This ends your turn.\n\n");
                    humanPlayer.nullAskedValue();
                    break;
                }
            }
        } while (true);
    }

    private PlayingValue getPlayingValue(GoFishPlayer player) {
        PlayingValue value;
        do {
            value = Input.getPlayingValue("");
            if (player.checkIfHandHasValue(value) > 0) {
                break;
            } else {
                System.out.println("Your hand doesn't have that value! Try another.");
                value = null;
            }
        } while (true);
        return value;
    }

   /* private GoFishPlayer switchPlayer() {
        if(nextPlayer == humanPlayer){
            return compPlayer;
        } else {
            return humanPlayer;
        }
    }*/

    private void endGame() {
        if(winner == humanPlayer){
            System.out.println("Congratulations, you won!");
        } else {
            System.out.println("Awww, you loooooost.");
        }
    }

    private void displayHand(GoFishPlayer player) {
        System.out.println(compPlayer.getUser().getName()+" has "+compPlayer.hand.getAllCards().size()+" cards.");
        System.out.println("Cards in your hand:");
        System.out.println(player.hand.toString());
        System.out.println("\n\n What rank do you want to ask for?");
        String values = "";
        for (PlayingValue value:
             player.getValuesInHand()) {
            values += " ["+value+"] ";
        }
        System.out.println(values);
    }

    public void dealInitialHands(int numberOfCards) {
        for (int i = 0; i < numberOfCards; i++) {
            humanPlayer.addCard(deck.getAndRemoveCard());
            compPlayer.addCard(deck.getAndRemoveCard());
        }
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

        void addCard(PlayingCard card){
            this.hand.addCard(card);
            PlayingValue four = this.fourOfKindValue();
            if(four != null){
                this.discardFourOfKind(four);
                System.out.println("Completed a set of "+four+"!");
            }
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
            System.out.println(other.getUser().getName()+" had "+movingCards.size()+" of "+value+"!");
                other.getHand().getAllCards().removeAll(movingCards);
            for (PlayingCard card :
                    movingCards) {
                this.addCard(card);
            }
        }

        void nullAskedValue(){
            this.askedValue = null;
        }

        PlayingCard drawCard(){
            PlayingCard drawnCard;
            drawnCard = deck.getAndRemoveCard();
            this.addCard(drawnCard);
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

        TreeSet<PlayingValue> getValuesInHand(){
            return new TreeSet<>(this.hand.getAllCards().stream().
                    map(PlayingCard::getValue).collect(Collectors.toList()));
        }

    }
}
