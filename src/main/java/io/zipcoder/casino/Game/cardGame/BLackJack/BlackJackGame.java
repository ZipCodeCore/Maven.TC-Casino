package io.zipcoder.casino.Game.cardGame.BLackJack;

import io.zipcoder.casino.CasinoUtilities.Console;
import io.zipcoder.casino.Game.cardGame.CardGame;
import io.zipcoder.casino.Game.cardGame.utilities.Card;
import io.zipcoder.casino.Game.cardGame.utilities.CardRank;
import io.zipcoder.casino.Game.cardGame.utilities.Hand;

import io.zipcoder.casino.House;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Profile;
import io.zipcoder.casino.TypeOfBet;

public class BlackJackGame extends CardGame {
    private BlackJackPlayer player;
    private BlackJackPlayer dealer;
    private boolean playAnotherGame;

    public BlackJackGame(Profile profile) {
        player = new BlackJackPlayer(profile);
        dealer = new BlackJackPlayer(null);
        player.setIsBusted(false);
        dealer.setIsBusted(false);
        playAnotherGame = true;
    }

    @Override
    public void startGame() {
        Console.print("Welcome to BlackJack!" + " " + player.getProfile().getName().toString());
        while (placeInitialBet(player) == false) {
            placeInitialBet(player);
        }
        playBlackJack();
        endGame();
    }

    //TODO test this method
    public void playBlackJack() {

        while (playAnotherGame == true) {
            reset();
            Console.print(round(player, dealer));
            Console.print(player.getProfile().getName().toString() + " Play Again: Enter [Yes] : [NO] to end game");

            if (Console.getString().equalsIgnoreCase("YES")) {
                continue;
            } else if (Console.getString().equalsIgnoreCase("NO")) {
                playAnotherGame = false;
            } else {
                Console.print("Invalid entry");
            }
        }
    }

    /**
     * changes
     * when intial is blackJack needs to be auto win
     * when hitting need to print hand
     * need to print blackJack if blackJack occurs
     * need to print bust if bust occurs
     * isBust is not working properly loop should break if busted and should settle bets
     * need to reset all values before each round
     * need to handle if dealer gets black jack at start
     *
     * @param thePlayer
     * @param theDealer
     * @return
     */
    //TODO test this method
    public String round(BlackJackPlayer thePlayer, BlackJackPlayer theDealer) {
        String result = "";
        deal(thePlayer);
        /*check to see if player or dealer has blackjack upon first dealing if so round ends by return result.*/
        result = settlesIfBlackJAck(thePlayer, theDealer);
        if (result != null) {
            return result;
        }/*player plays turn if player has blackjack or busts then round will end by returning result.*/
        result = turn(thePlayer);
        if (result != null) {
            return result;
        }/*dealer deals to self: ends round if dealer has blackJack or busts.*/
        result = dealerBehavior(thePlayer, theDealer);
        if (result != null) {
            return result;
        }/*determines winner and settles all the bets accordingly*/
        result = settleBets(thePlayer, theDealer);
        return result;
    }

    //TODO test this method;
    public String settlesIfBlackJAck(BlackJackPlayer thePlayer, BlackJackPlayer theDealer) {
        if (isBlackJack(thePlayer) == true) {
            return settleBets(thePlayer, theDealer);
        } else if (isBlackJack(theDealer)) {
            return settleBets(thePlayer, theDealer);
        }
        return null;
    }

    //TODO test this method

    /**
     * player takes turn by perfoming game actions until either Bust,BlackJack or Stands.
     *
     * @param currentPlayer
     * @return
     */
    public String turn(BlackJackPlayer currentPlayer) {
        String aResult = null;
        currentPlayer.setCurrentPlayer(true);
        while (currentPlayer.getIsBusted() == false || currentPlayer.getHasStood() == false) {

            showListOfPlayerActions();
            String input = Console.getString();
            if (currentPlayer.getScore() > 21) {
                currentPlayer.setIsBusted(true);
                aResult = settleBets(currentPlayer, dealer);
            } else if (input.equalsIgnoreCase("Hit") & currentPlayer.getScore() < 21) {
                hit(currentPlayer);
                Console.print(currentPlayer.getProfile().getName() + " " + currentPlayer.getHand().showHand());
            } else if (isBlackJack(currentPlayer) == true) {
                Console.print("BLACKJACK!!!!!!!!");
                aResult = settlesIfBlackJAck(currentPlayer, dealer);
            } else if (input.equalsIgnoreCase("Stand")) {
                stand(currentPlayer);
                break;
            } else {
                Console.print("Invalid input enter one of the following actions");
            }

        }
        currentPlayer.setCurrentPlayer(false);
        return aResult;
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
        int cardValue;
        int updateScore;

        if (cardToScore.getRank() == CardRank.ACE & countAcesInHand(thePlayer) > 1) {
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

    public String dealerBehavior(BlackJackPlayer thePlayer, BlackJackPlayer theDealer) {
        String result = "";
        // TODO consider When dealer has a soft 17
        while (theDealer.getScore() < 17) {
            dealACard(theDealer);
            Console.print("Dealers Hand: " + theDealer.getHand().showHand());
        }
        if (isBusted(theDealer) | isBlackJack(theDealer)) {
            result = settleBets(thePlayer, theDealer);
            return result;
        }
        return null;
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
        String theResult = "";
        //settle winning bets;
        if (isBlackJack(thePlayer) == true | theDealer.getIsBusted() == true | decideWinner(thePlayer, theDealer) == thePlayer) {
            payout = 1;
            settlingBets(thePlayer, payout);
            theResult = winnerAsString(thePlayer);
        }//settle loosing bets
        else if (thePlayer.getIsBusted() == true | decideWinner(thePlayer, theDealer) == theDealer) {
            payout = 2;
            settlingBets(thePlayer, payout);
            theResult = looserAsString(thePlayer);
        } else if (decideWinner(thePlayer, theDealer) == null) {
            payout = 3;
            settlingBets(thePlayer, payout);
            theResult = playPushAsString(thePlayer);
        }
        return theResult;
    }


    //TODO test this
    public String winnerAsString(BlackJackPlayer thePlayer) {
        String winner = thePlayer.getProfile().getName() + " YOU WIN" + "\n"
                + "Your New Balance: " + thePlayer.getProfile().getAccountBalance();
        return winner;
    }

    public String playPushAsString(BlackJackPlayer thePlayer) {
        String push = thePlayer.getProfile().getName() + " YOU PUSH" + "\n"
                + "Your New Balance: " + thePlayer.getProfile().getAccountBalance();
        return push;
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

        if (playerScore <= 21 & dealerScore <= 21 & playerScore < dealerScore) {
            return theDealer;
        }
        // score is equal game is a push no player wins or looses
        else if (playerScore <= 21 & dealerScore <= 21 & playerScore == dealerScore) {
            return null;
        }
        return thePlayer;
    }

    public boolean isBusted(BlackJackPlayer thePlayer) {
        if (thePlayer.getScore() > 21) {
            thePlayer.setIsBusted(true);
        }
        return thePlayer.getIsBusted();
    }


    public boolean isBlackJack(BlackJackPlayer currentPlayer) {
        boolean blackJack = false;
        if (currentPlayer.getScore() == 21) {
            blackJack = true;
        }
        return blackJack;
    }

    //TODO test this
    public void reset() {
        player.setIsBusted(false);
        dealer.setIsBusted(false);
        player.setHasStood(false);
        dealer.setHasStood(false);
        player.getHand().clear();
        dealer.getHand().clear();
    }


    public void endGame() {
        House.INSTANCE.gameSelection();
    }

    public String getRules() {
        return null;
    }

}