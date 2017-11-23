package io.zipcoder.casino.games.blackjack;

import io.zipcoder.casino.games.CardGame;
import io.zipcoder.casino.games.Gamble;
import io.zipcoder.casino.nuts_n_bolts.MoneyContainer;
import io.zipcoder.casino.nuts_n_bolts.User;
import io.zipcoder.casino.nuts_n_bolts.cards.Hand;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingCard;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingDeck;

import java.util.ArrayList;

public class BlackJack extends CardGame implements Gamble {

    private MoneyContainer pot;
    private PlayingDeck deck;
    private int playerScore;
    private int dealerScore;
    private Hand player;
    private Hand dealer;

    public BlackJack() {

        pot = new MoneyContainer();
        deck = new PlayingDeck();
        deck.shuffle();
        playerScore = 0;
        dealerScore = 0;
        player = new Hand();
        dealer = new Hand();

        for (int i = 0; i < 2; i++) {
            player.addCard(deck.getAndRemoveCard());
            dealer.addCard(deck.getAndRemoveCard());
        }
    }

    public void takeBet(Double bet) {
        pot.addMoney(bet);
    }

    public Double settleBet(Double winnings) {
        return (pot.takeOutMoney(winnings));
    }

    public Double emptyPot() {
        return pot.takeAllMoney();
    }

    public Double showPot() {
        return pot.getMoney();
    }

    public Integer getPlayerScore() {
        playerScore = 0;
        ArrayList<PlayingCard> handArray = player.getAllCards();

        for (PlayingCard c : handArray) {
            playerScore += cardScore(c, playerScore);
        }

        return playerScore;
    }

    private Integer getDealerScore() {
        dealerScore = 0;
        ArrayList<PlayingCard> handArray = dealer.getAllCards();

        for (PlayingCard c : handArray) {
            dealerScore += cardScore(c, dealerScore);
        }

        return dealerScore;
    }

    public Integer getDealerScoreShowing(){
        return (cardScore(dealer.getAllCards().get(0), 0));
    }

    private Integer cardScore(PlayingCard c, int score) {

        switch (c.getValue().toString()) {
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
            case "J":
            case "Q":
            case "K":
                return 10;
            default: {
                if (score + 11 > 21) {
                    return 1;
                }
            }
        }
        return 11;
    }

    public void playerHit() {
        player.addCard(deck.getAndRemoveCard());
        playerScore = getPlayerScore();
    }

    public void dealerHit() {
        dealer.addCard(deck.getAndRemoveCard());
        dealerScore = getDealerScore();
    }

    public void dealerHitUntilFinished(){
        while (getDealerScore()<=17){
            dealer.addCard(deck.getAndRemoveCard());
        }
    }

    public boolean playerWins(){
        return (((getPlayerScore()>getDealerScore())&&(getPlayerScore()<=21)) ||
                (getDealerScore()>21 && getPlayerScore()<=21));
    }

    @Override
    public String toString(){
        String returnMe="";

        returnMe+="---\nOpponent\n---\n"+getDealerScore()+"---\n";
        for (PlayingCard c : player.getAllCards()){
            returnMe+=c.toString()+"\n";
        }

        returnMe+="\n\n\nPot: "+pot.getMoney()+"\n\n\n\n";

        returnMe+="---\nYou\n---\n"+getPlayerScore()+"---\n";
        for (PlayingCard c : player.getAllCards()){
            returnMe+=c.toString()+"\n";
        }

        returnMe+="\n\n";

        return returnMe;
    }

    public boolean play(String userInput) {
        return ("Y".equalsIgnoreCase(userInput));
    }

}

      /////////////
     /////////////
    /////////////
   //BlackJack unaltered Below
  /////////////
 /////////////
/////////////

// private Player player;
//    private Deck deck;
//    private Player dealer;
//    private Double pot;
//
//    public Game(){
//        player = new Player();
//        deck = new Deck();
//        dealer = new Player("Dealer");
//        deck.shuffle();
//        pot = 0.0;
//    }
//
//    public Double getPot() {
//        return pot;
//    }
//
//    public void addToPot(Double amount) {
//        this.pot += amount;
//    }
//
//    public Player getPlayer() {
//        return player;
//    }
//
//    public Player getDealer() {
//        return dealer;
//    }
//
//    public void run() {
//
//        //Deal two cards to the player and the dealer
//        for (int i = 0; i < 2; i++)
//        {
//            dealCard(player);
//            dealCard(dealer);
//        }
//
//    }
//
//    public boolean playerWins() {
//        // if both player and dealer scores are = to 21 dealer wins
//        // if both player and dealer score are over 21 then dealer wins
//        // if player's score is <= 21 and players score is greater than dealers score then player wins.
//        //if dealer's score is > 21 and player's score is <= 21 then players wins.
//        player.calculateScore();
//        dealer.calculateScore();
//
//        if(     (player.getScore().equals(21) && !dealer.getScore().equals(21)) ||
//                (player.getScore()<21 && dealer.getScore() < player.getScore()) ||
//                (player.getScore() < 21 && dealer.getScore() > 21)) {
//            //Player wins
//            return true;
//        }
//        //Dealer wins
//        return false;
//    }
//
//    public void dealCard(Player playerToReceiveCard){
//        Card card = deck.getCard();
//        playerToReceiveCard.addToHand(card);
//    }
//
//    public void dealerHitUntilFinished() {
//        while (dealer.calculateScore() <= 17)
//        {
//            dealCard(dealer);
//        }
//    }
//
//    public void returnBet() {
//        if (playerWins()) {
//            player.receiveWinnings(pot * 2);
//        }
//        else {
//            this.pot = 0.0;
//        }
//    }
//
