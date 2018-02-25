package io.zipcoder.casino.Game.cardGame.BLackJack;

import io.zipcoder.casino.BlackJackBet;
import io.zipcoder.casino.CasinoUtilities.Console;
import io.zipcoder.casino.Game.cardGame.CardGame;
import io.zipcoder.casino.Game.cardGame.utilities.Card;
import io.zipcoder.casino.Game.cardGame.utilities.CardRank;
import io.zipcoder.casino.Game.cardGame.utilities.Hand;

import io.zipcoder.casino.Player;
import io.zipcoder.casino.Profile;
import io.zipcoder.casino.TypeOfBet;

import java.util.ArrayList;

public class BlackJackGame extends CardGame {
    BlackJackPlayer player;
    BlackJackPlayer dealer;


    public BlackJackGame(Profile profile) {
        player = new BlackJackPlayer(profile);
        this.addPlayer(player);
        dealer = new BlackJackPlayer(null);

        player.setIsBusted(false);
        dealer.setIsBusted(false);

    }


    public static void main(String[] args) {
        Profile someProfile = new Profile("Commander", 100.0, 1);
        BlackJackGame game = new BlackJackGame(someProfile);
        game.startGame();
    }


    // need to change deal to accomodate multiple players not just given players
    //Multiple players would loop through list of players at table and deal to each player
    public void deal(BlackJackPlayer player1) {
        Card temp;
        for (int i = 0; i < 2; i++) {
            temp = deck.getCard();
            player1.getHand().addCard(deck.getCard());
            updateScore(temp, player1);

            temp = deck.getCard();
            dealer.getHand().addCard(temp);
            updateScore(temp, dealer);
        }

        Console.print(player.getHand().showHand());
        Console.print("Dealer Face Card: " + showDealersFaceCard());
    }

    //bets are placed be for the dealer deals
    //need to change list of players to cardPlayers
    public boolean placeInitialBet(BlackJackPlayer thePlayer) {
        return placeBet(BlackJackBet.INTIAL_BET, thePlayer);
    }

    public void turn(BlackJackPlayer currentPlayer) {
        currentPlayer.setCurrentPlayer(true);


        while (currentPlayer.getIsBusted() != true & currentPlayer.getHasStood() != true) {
            // show list of Actions
            showListOfPlayerActions();
            String input = Console.getString();
            // player has an ace the player can choose to change value to 1;
            if (input.equalsIgnoreCase("Hit") & currentPlayer.getScore() < 21) {
                hit(currentPlayer);
                continue;
            } else if (input.equalsIgnoreCase("Stand")) {
                stand();
                break;
            }
        }
        currentPlayer.setCurrentPlayer(false);
        // player must choose to bet
        // if player does not have any money promt the user to add more money or game is over.
    }


    public String hit(BlackJackPlayer thePlayer) {
        String currentScore = String.valueOf(dealACard(thePlayer));
        Console.print(currentScore);
        return currentScore;
    }

    public boolean stand() {
        //player.isCurrentPlayer();


        return false;
    }

    public void split() {

    }


    /**
     * updates the current Score
     *
     * @param cardToScore
     * @param thePlayer
     * @return
     */
    //makes changes to include aces
    // players hand has more than one ace add ace score as score plus 1
    public int updateScore(Card cardToScore, BlackJackPlayer thePlayer) {
        int cardValue, updateScore;

        if (cardToScore.getRank() == CardRank.ACE & countAcesInHand(thePlayer) < 2) {
            cardValue = 1;
        } else {
            cardValue = cardToScore.getRank().getCardValue();
        }
        updateScore = thePlayer.getScore() + cardValue;
        thePlayer.setScore(updateScore);
        return updateScore;
    }


    public void round() {
     // goes through list ofPlayers turns
        // once all players have either stood or busted
        // dealer deals hand until cards are 17, busted or blackJack
        // make a call to winner
        // make a call to payOuts
        // promt to play another round
        // game should continue as long as player has money
        // game 



    }

    /**
     * @param currentPlayer
     * @return
     */
    public int countAcesInHand(BlackJackPlayer currentPlayer) {
        int numberOfAces = 0;
        for (Card ace : currentPlayer.getHand().getCards()) {
            if (ace.getRank() == CardRank.ACE) {
                numberOfAces++;
            }
        }
        return numberOfAces;
    }

    public void dealerBehavior() {
        // TODO consider When dealer has a soft 17
        while (dealer.getScore() < 17) {
            dealACard(dealer);
        }

    }

    public int dealACard(BlackJackPlayer cardPlayer) {
        Card temp = deck.getCard();
        cardPlayer.getHand().addCard(temp);
        return updateScore(temp, cardPlayer);

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


    public boolean placeBet(TypeOfBet betType, BlackJackPlayer currentPlayer) {
        Double betAmount;
        boolean keepRunning = true;
        do {
            // Console.print(bar);
            Console.print("Your current balance is: $" + currentPlayer.getProfile().getAccountBalance());
            Console.print("How much would you like to bet?");
            betAmount = Console.getDouble();
            if (betAmount >= 0 && betAmount < 0.01) {
                Console.print("Cannot bet fractions of a cent.  Please enter a valid bet");
            } else if (betAmount >= 0) {
                keepRunning = false;
            } else if (betAmount == -0.001) {
                continue;
            } else if (betAmount < 0) {
                Console.print("Cannot bet negative values.  Please enter a valid bet");
            }
        }
        while (keepRunning);
        boolean wasBetPlaced = currentPlayer.bet(betType, betAmount);
        //Console.print(bar);
        //Console.print();
        return wasBetPlaced;
    }


    @Override
    public void startGame() {
        Console.print("Welcome to BlackJack!" + " " + player.getProfile().getName().toString());
        while(placeInitialBet(player) == false) {
            placeInitialBet(player);
        }
        deal(player);
    }
//if Player score is > 21 console print score you loose play
    // if Player Score is <

    public Player decideWinner(BlackJackPlayer player1, BlackJackPlayer player2) {
        int player1Score = player1.getScore();
        int player2Score = player2.getScore();

        if (player1Score <= 21 & player1Score < player2Score) {
            return player2;
        }
        // score is equal game is a push no player wins or looses
        else if (player1Score <= 21 & player1Score == player2Score) {
            return null;
        }
        return player1;
    }

    public boolean isBusted(BlackJackPlayer player1) {
        if (player1.getScore() > 21) {
            player1.setIsBusted(true);
        }
        return player1.getIsBusted();
    }

    public boolean isBlackJack(BlackJackPlayer currentPlayer) {
        boolean blackJack = false;
        if (currentPlayer.getScore() == 21) {
            blackJack = true;
        }
        return blackJack;
    }


    public void endGame() {

    }

    public String getRules() {
        return null;
    }

}