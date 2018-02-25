package io.zipcoder.casino.Game.cardGame.BLackJack;

import io.zipcoder.casino.BlackJackBet;
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
      Card temp;
        for (int i = 0; i < 2; i++) {
            temp = deck.getCard();
            player.getHand().addCard(deck.getCard());
            currentScore(temp, player);

            temp = deck.getCard();
            dealer.getHand().addCard(temp);
            currentScore(temp, dealer);
        }

        Console.print(player.getHand().showHand());
        Console.print(showDealersFaceCard());
    }

    public void turn() {
        //loop while its still the players turn
        while(player.getIsBusted() == false || player.isCurrentPlayer() == true) {


            // show list of Actions
            showListOfPlayerActions();


            // player must choose to bet
            // if player does not have any money promt the user to add more money or game is over.
        }
    }


    public String hit(BlackJackPlayer thePlayer) {
        Card cardToAdd = deck.getCard();
        thePlayer.getHand().addCard(cardToAdd);

        String currentScore = String.valueOf(currentScore(cardToAdd, thePlayer));
        Console.print(currentScore);
        //player.getIsBusted();
     return currentScore;
    }

    public void stand() {
     //dealer.isCurrentPlayer();

    }

    public void split(){

    }

    /**
     * updates the current Score
     *
     * @param cardToScore
     * @param thePlayer
     * @return
     */
    public int currentScore(Card cardToScore, BlackJackPlayer thePlayer) {
        int cardValue = cardToScore.getRank().getCardValue();
        int updateScore = thePlayer.getScore() + cardValue;
        thePlayer.setScore(updateScore);

        return updateScore;
    }



    public void round() {

    }



    public void dealerBehavior() {

    }

    public String showDealersFaceCard() {
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
        Console.print("Welcome to BlackJack!" + "\n" + player.getProfile().toString());
        Console.print("Please Enter Your Starting [Bet]\n");
        double bet = Console.getDouble();


        player.bet(BlackJackBet.INTIAL_BET, bet);

    }

    public Player decideWinner(BlackJackPlayer player1, BlackJackPlayer player2) {
         return null;
    }

    public void endGame() {

    }

    public String getRules() {
        return null;
    }

}