package io.zipcoder.casino.Game.cardGame.BLackJack;

import io.zipcoder.casino.CasinoUtilities.Console;
import io.zipcoder.casino.Game.cardGame.CardGame;
import io.zipcoder.casino.Game.cardGame.utilities.Card;
import io.zipcoder.casino.Game.cardGame.utilities.Hand;

import io.zipcoder.casino.Player;
import io.zipcoder.casino.Profile;

public class BlackJackGame extends CardGame {
    BlackJackPlayer player;
    BlackJackPlayer dealer;


    public BlackJackGame(Profile profile) {
        player = new BlackJackPlayer(profile);
        this.addPlayer(player);
        dealer = new BlackJackPlayer(null);
        this.addPlayer(dealer);

    }


    public static void main(String[] args) {
        Profile someProfile = new Profile("Commander", 100.0, 1);
        BlackJackGame game = new BlackJackGame(someProfile);
        game.startGame();

    }

    public void deal() {

        for (int i = 0; i < 2; i++) {
            player.getHand().addCard(deck.getCard());
            // print card value to string
            dealer.getHand().addCard(deck.getCard());
        }

        Console.print(player.getHand().showHand());

    }

    public void turn() {

    }


    public void hit(BlackJackPlayer aPlayer) {
        Card cardToAdd = deck.getCard();
        aPlayer.getHand().addCard(cardToAdd);
        currentScore(cardToAdd, aPlayer);
         // Console.print();

        // if player score is over 21 change is busted to true
    }

    public void stand() {

    }

    public int currentScore(Card cardToScore, BlackJackPlayer aPlayer) {
        int cardValue = cardToScore.getRank().getCardValue();
        int updateScore = aPlayer.getScore() + cardValue;
        aPlayer.setScore(updateScore);
        return updateScore;
    }

    public void round(Card card) {

    }

    public void dealerBehavior() {

    }

    public String ShowDealersFaceCard() {
        Hand hand = dealer.getHand();
        Card faceCard = hand.getCards().get(0);

        // /Console.print(faceCard.toString());
        return faceCard.toString();
    }

    public String showListOfPlayerActions() {
        String playerActions = "Choose Action: [Bet], [Hit], [Stand], [Spilt]";

        Console.print(playerActions);

        return playerActions;
    }


    @Override
    public void startGame() {
        //Console.print("Welcome to BlackJack! Please place your [Bet] amount");
        //player.bet(Console.getDouble());

        deal();
    }

    public void endGame() {

    }

    public String getRules() {
        return null;
    }


}
