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
import java.util.Map;

public class BlackJackGame extends CardGame {
    private BlackJackPlayer player;
    private BlackJackPlayer dealer;
    private boolean playAnotherGame;

    public BlackJackGame(Profile profile) {

        player = new BlackJackPlayer(profile);
        this.addPlayer(player);
        dealer = new BlackJackPlayer(null);

        player.setIsBusted(false);
        dealer.setIsBusted(false);
        playAnotherGame = true;
    }

    //TODO test this method
    public void playBlackJack() {
        while (!playAnotherGame) {
            round(player, dealer);
            Console.print(player.getProfile().getName().toString() + "Enter [Yes] to try your luck at another Round");

            if (Console.getString().equalsIgnoreCase("YES")) {
                playAnotherGame = true;
            } else if (Console.getString().equalsIgnoreCase("NO")) {
                playAnotherGame = false;
            } else {
                Console.print("Invalid entry");
            }
        }
        endGame();
    }


    //TODO test this method
    public String round(BlackJackPlayer thePlayer, BlackJackPlayer theDealer) {
        boolean roundFinished = false;
        deal(thePlayer);
        //player has blackjack upon first dealing

        if(isBlackJack(theDealer)){
           return settleBets(thePlayer, theDealer);
        }

        turn(thePlayer);



        //TODO
         if(isBlackJack(thePlayer)){
            return settleBets(thePlayer, theDealer);
         }

        //TODO handle player wins if dealer busts
        dealerBehavior();
//TODO determine winner if dealer doesnt bust
        thePlayer.getHand().clear();
        theDealer.getHand().clear();
        // dealer deals hand until cards are 17, busted or blackJack
        // make a call to winner
        // make a call to payOuts
        // promt to play another round
        // game should continue as long as player has money
        // game
        //TODO handle when deck isEmpty to sure game continues as long as players want to play
        return null;
    }

//    if its a player turn and player gets blackJack
//     then the escrow should be settled
//     the round should end and the player should have a choice to keep playing
//

    //TODO test this method;
    public String checksIfPlayerHasBlackAfterDeal(BlackJackPlayer thePlayer, BlackJackPlayer theDealer){
        if (isBlackJack(thePlayer)) {
            return settleBets(thePlayer, theDealer);
        }
        return "";
    }


    //TODO test this method
    public void turn(BlackJackPlayer currentPlayer) {
        currentPlayer.setCurrentPlayer(true);

        while (currentPlayer.getIsBusted() != true & currentPlayer.getHasStood() != true) {
            showListOfPlayerActions();
            String input = Console.getString();

            // player has an ace the player can choose to change value to 1;
            if (input.equalsIgnoreCase("Hit") & currentPlayer.getScore() < 21) {
                hit(currentPlayer);
                if (isBlackJack(currentPlayer)) {
                    Console.print("BLACKJACK!!!!!!!!!!!!!!!!!!!!!");

                    break;
                }
            } else if (input.equalsIgnoreCase("Stand")) {
                stand(currentPlayer);
                break;
            } else {
                Console.print("Invalid input enter one of the following actions");
            }


        }
        currentPlayer.setCurrentPlayer(false);
        // player must choose to bet
        // if player does not have any money promt the user to add more money or game is over.
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


    public String hit(BlackJackPlayer thePlayer) {
        String currentScore = String.valueOf(dealACard(thePlayer));
        Console.print(player.getProfile().getName() + " " + currentScore);
        return currentScore;
    }

    /**
     * @param thePlayer
     * @return
     */
    public boolean stand(BlackJackPlayer thePlayer) {
        thePlayer.setHasStood(true);
        return thePlayer.getHasStood();
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
            Console.print("Dealers Hand: " + dealer.getHand().showHand());
        }

        isBusted(dealer);

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
        while (placeInitialBet(player) == false) {
            placeInitialBet(player);
        }
        playBlackJack();

    }
    //TODO test this

    /**
     * Only time this method should be called is when both players have not busted
     *
     * @param thePlayer
     * @param theDealer
     * @return
     */
    public String settleBets(BlackJackPlayer thePlayer, BlackJackPlayer theDealer) {
        int payout = 0;
        String result = "";
        //settle winning bets;
        if (isBlackJack(thePlayer) || theDealer.getIsBusted() || decideWinner(thePlayer, theDealer) == thePlayer) {
            payout = 1;
            settlingBets(thePlayer, payout);
            result = winnerAsString(thePlayer);
        }//settle loosing bets
        else if (thePlayer.getIsBusted() || decideWinner(thePlayer, theDealer) == theDealer) {
            payout = 2;
            settlingBets(thePlayer, payout);
            result = looserAsString(thePlayer);
        } else if (decideWinner(thePlayer, theDealer) == null) {
            payout = 3;
            settlingBets(thePlayer, payout);
            result = playPushAsString(thePlayer);
        }
        return result;
    }


    //TODO test this
    public String winnerAsString(BlackJackPlayer thePlayer) {
        String winner = thePlayer.getProfile().getName() + " YOU WIN" + "\n"
                + "Your New Balance: " + thePlayer.getProfile().getAccountBalance();
        return winner;
    }

    public String playPushAsString(BlackJackPlayer thePlayer) {
        String winner = thePlayer.getProfile().getName() + " YOU PUSH" + "\n"
                + "Your New Balance: " + thePlayer.getProfile().getAccountBalance();
        return winner;
    }

    public String looserAsString(BlackJackPlayer thePlayer) {
        String looser = thePlayer.getProfile().getName() + "You Loose!!" + "\n"
                + "Your New Balance: " + thePlayer.getProfile().getAccountBalance();
        return looser;
    }


//TODO test this

    /**
     * @param thePlayer
     */
    public void settlingBets(BlackJackPlayer thePlayer, int payout) {
        for (TypeOfBet key : thePlayer.getAllBets().keySet()) {
            if (payout == 1) {
                settleBetsPlayerWins(thePlayer, key);
            } else if (payout == 2) {
                settleBetsPlayerLooses(thePlayer, key);
            } else {
                settleBetsPlayerPushes(thePlayer, key);
            }
        }
    }

    //TODO test this
    public void settleBetsPlayerLooses(BlackJackPlayer thePlayer, TypeOfBet key) {
        thePlayer.lose(key);
        thePlayer.setIsBusted(false);
    }

    //TODO test this

    public void settleBetsPlayerWins(BlackJackPlayer thePlayer, TypeOfBet key) {
        if (key == BlackJackBet.INTIAL_BET) {
            thePlayer.win(key, 3 / 2);
        } else if (key == BlackJackBet.DOUBLE_DOWN) {
            thePlayer.win(key, 2);
        }
    }

    //TODO test this
    public void settleBetsPlayerPushes(BlackJackPlayer thePlayer, TypeOfBet key) {
        thePlayer.win(key, 0);
    }

    //TODO test this
    public Player decideWinner(BlackJackPlayer thePlayer, BlackJackPlayer theDealer) {
        int playerScore = thePlayer.getScore();
        int dealerScore = theDealer.getScore();

        if (playerScore <= 21 & playerScore < dealerScore) {
            return theDealer;
        }
        // score is equal game is a push no player wins or looses
        else if (playerScore <= 21 & playerScore == dealerScore) {
            return null;
        }
        return thePlayer;
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