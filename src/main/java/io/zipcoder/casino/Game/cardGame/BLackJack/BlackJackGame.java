package io.zipcoder.casino.Game.cardGame.BLackJack;

import io.zipcoder.casino.BlackJackBet;
import io.zipcoder.casino.CasinoUtilities.Console;
import io.zipcoder.casino.Game.cardGame.CardGame;
import io.zipcoder.casino.Game.cardGame.utilities.Card;
import io.zipcoder.casino.Game.cardGame.utilities.Hand;

import io.zipcoder.casino.Player;
import io.zipcoder.casino.Profile;
import io.zipcoder.casino.TypeOfBet;

public class BlackJackGame extends CardGame {
    BlackJackPlayer player;
    BlackJackPlayer dealer;


    public BlackJackGame(Profile profile) {
        player = new BlackJackPlayer(profile);
        this.addPlayer(player);
        dealer = new BlackJackPlayer(null);
        this.addPlayer(dealer);

        player.setIsBusted(false);
        dealer.setIsBusted(false);

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
            updateScore(temp, player);

            temp = deck.getCard();
            dealer.getHand().addCard(temp);
            updateScore(temp, dealer);
        }

        Console.print(player.getHand().showHand());
        Console.print(showDealersFaceCard());
    }

    public void turn(BlackJackPlayer currentPlayer) {
        currentPlayer.setCurrentPlayer(true);
        //loop while its still the players turn
        while (currentPlayer.getIsBusted() == false) {
            // show list of Actions
            showListOfPlayerActions();
            String input = Console.getString();

            // player has an ace the player can choose to change value to 1;
            if (input.equalsIgnoreCase("Hit") & player.getScore() < 21) {
                hit(player);
                continue;
            } else if (input.equalsIgnoreCase("Stand")) {
                stand();
                break;
            }
        }


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
    public int updateScore(Card cardToScore, BlackJackPlayer thePlayer) {
        int cardValue = cardToScore.getRank().getCardValue();
        int updateScore = thePlayer.getScore() + cardValue;
        thePlayer.setScore(updateScore);

        return updateScore;
    }


    public void round() {

    }


    public void dealerBehavior() {

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
        Console.print("Welcome to BlackJack!" + "\n" + player.getProfile().toString());
        Console.print("Please Enter Your Starting [Bet]\n");
        double bet = Console.getDouble();


        player.bet(BlackJackBet.INTIAL_BET, bet);

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