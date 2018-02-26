package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Blackjack extends Game implements GameInterface, CardGameInterface, GamblingInterface {

    private Person player1;
    private Hand player1Hand;
    private Wallet player1Wallet;
    private int player1Chips;

    private Dealer dealer;
    private Hand dealerHand;
    private Wallet dealerWallet;

    private Deck deck;

    // these 2 args are now in Person constructor for gambling games
    public Blackjack(Person player) {
        this.player1 = player;
        this.player1Hand = player1.getHand();
        this.player1Wallet = player1.getWallet();
        //player1Wallet.addChipsToAmount(chipsToStart); // add chipsToStart is now in Person constructor for gambl games
        this.player1Chips = player1Wallet.checkChipAmount();

        this.dealer = new Dealer();
        this.dealerHand = dealer.getHand();
        this.dealerWallet = dealer.getDealerWallet();

        this.deck = new Deck();
    }

    // can have another constructor that takes a number int of Persons, and places those Persons
    // into an array of players and one dealer.

    public Person getPlayer() {
        return player1;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public Deck getDeck() {
        return deck;
    }

    public int sumOfRanksInHand(Person person) {
        int sumOfRanksInHand = 0;
        Card aceRank = new Card(Rank.ACE, Suit.CLUBS);
        int numberOfAceRankRepetitions = countRankRepetitionsInHand(person, aceRank);

        // If there are 2 or more Aces in handArrayList, treat all Aces as = 1
        if (numberOfAceRankRepetitions != 1) {
            for (Card card : person.getHand().getHandArrayList()) {
                if (card.getRank().toInt() == 11 || card.getRank().toInt() == 12
                        || card.getRank().toInt() == 13) {
                    sumOfRanksInHand += 10;
                } else {
                    sumOfRanksInHand += card.getRank().toInt();
                }
            }
        } else { // implement Ace = 1 or Ace = 11 sumOfRanksInHand/difference/choice
            int sumWhenAceEqualsOne = 0;
            int sumWhenAceEqualsEleven = 0;
            for (Card card : person.getHand().getHandArrayList()) {
                if (card.getRank().toInt() == 11 || card.getRank().toInt() == 12
                        || card.getRank().toInt() == 13) {
                    sumWhenAceEqualsOne += 10;
                    sumWhenAceEqualsEleven += 10;
                } else if (card.getRank().toInt() == 1) {
                    sumWhenAceEqualsOne += 1;
                    sumWhenAceEqualsEleven += 11;
                } else {
                    sumWhenAceEqualsOne += card.getRank().toInt();
                    sumWhenAceEqualsEleven += card.getRank().toInt();
                }
            }
            if ( (sumWhenAceEqualsOne <= 21) && (sumWhenAceEqualsEleven <= 21) ) {
                int greaterOfTwoAceSums = findGreaterOfTwoInts(sumWhenAceEqualsOne, sumWhenAceEqualsEleven);
                sumOfRanksInHand = greaterOfTwoAceSums;
            } else {
                int smallerOfTwoAceSums = findSmallerOfTwoInts(sumWhenAceEqualsOne, sumWhenAceEqualsEleven);
                sumOfRanksInHand = smallerOfTwoAceSums;
            }
        }

        return sumOfRanksInHand;
    }

    public int countRankRepetitionsInHand(Person person, Card cardRankToCount) {
        int numberOfRankRepetitions = 0;
        for (Card card : person.getHand().getHandArrayList()) {
            if (card.getRank().toInt() == cardRankToCount.getRank().toInt()) {
                numberOfRankRepetitions++;
            }
        }
        return numberOfRankRepetitions;
    }

    public int findSmallerOfTwoInts(int number1, int number2) {
        if (number1 <= number2) {
            return number1;
        } else {
            return number2;
        }
    }

    public int findGreaterOfTwoInts(int number1, int number2) {
        if (number1 >= number2) {
            return number1;
        } else {
            return number2;
        }
    }

    public void personDecision(Person person) {
        Scanner scanner = new Scanner(System.in);
        String playerDecisionString = scanner.nextLine();

        if (playerDecisionString.equals("hit")) {
            this.hit(person);
        }
    }

    public String handToString(ArrayList<Card> handArrayList) {
        StringBuilder sb = new StringBuilder();
        for (Card card : handArrayList) {
            sb.append(card.toString() + " ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public void hit(Person person) {
        Card cardFromDealer = this.getDeck().drawCard();
        person.getHand().receiveCards(cardFromDealer);
    }

    // CardGameInterface
    public int checkNumberOfCards() {
        return 0;
    }

    @Override
    public int checkNumberOfCards(Hand hand) {
        return 0;
    }

    // CardGameInterface
    public void dealCards() {

    }

    // GamblingInterface
    public int checkChipAmount(Person personToCheck) {
        return 0;
    }

    // GamblingInterface
    public void placeBet(Person personPlacingBet, int betAmount) {

    }

    // GamblingInterface
    public int getAnte() {
        return 0;
    }

    // GamblingInterface
    public void bootPlayerFromGame(Person personToBoot) {

    }

    // GamblingInterface
    public int checkPot() {
        return 0;
    }

    // GameInterface or Game Class
    public void start() {
        //Blackjack blackjack = new Blackjack("player1", 1000);
        Person player1 = this.getPlayer();
        Dealer dealer = this.getDealer();
        this.getDeck().shuffleDeck();

        this.hit(player1);
        this.hit(player1);
        this.hit(dealer);
        this.hit(dealer);

        int personHandSum = 0;
        int dealerHandSum = 0;

        String myHand = "";
        String dealerHand = "";
        String playerDecisionString = "";

        System.out.println();
        System.out.println("+++ PLAY BLACKJACK +++");
        do {
            personHandSum = this.sumOfRanksInHand(this.getPlayer());
            System.out.println();
            System.out.print("Player1: " + "\u270B");
            System.out.print(this.handToString(this.getPlayer().getHand().getHandArrayList()));
            System.out.print("\u270B" + ", hand = " + personHandSum);

            System.out.println();
            String dealerCardShown = this.getDealer().getHand().getHandArrayList().get(1).toString();
            System.out.print("Dealer: " + "\u270B" + "\uD83C\uDCA0" + " " + dealerCardShown + "\u270B");

            if (personHandSum == 21) {
                System.out.println();
                System.out.println("+++++++++++++++++++++");
                System.out.println("BLACKJACK!+++ You won");
                System.out.println("+++++++++++++++++++++");
                break;
            } else if (personHandSum > 21){
                System.out.println();
                System.out.println("++++++++++++++");
                System.out.println("BUST! You lost");
                System.out.println("++++++++++++++");
                break;
            }

            System.out.println();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you want to \"hit\" or \"stay\"?: ");
            playerDecisionString = scanner.nextLine();

            if (playerDecisionString.equals("hit")) {
                this.hit(player1);
            } else if (playerDecisionString.equals("stay")) {
                break;
            }
        } while (personHandSum < 21);

        dealerHandSum = this.sumOfRanksInHand(this.getDealer());
        if ( !(personHandSum >= 21) ) { // If player stayed with a hand < 21
            if (dealerHandSum <= 16) { // If dealer's hand >= 17, dealer has to stay
                this.hit(dealer); // Hit dealer only once if dealer's hand <= 16
            }
        }

        if (playerDecisionString.equals("stay")) {
            if ( (dealerHandSum <= 21) && (dealerHandSum > personHandSum) ) {
                System.out.println("++++++++++++");
                System.out.println("Dealer wins!");
                System.out.println("++++++++++++");
            } else if (dealerHandSum == personHandSum) {
                System.out.println("+++++++++++");
                System.out.println("It's a tie!");
                System.out.println("+++++++++++");
            } else {
                System.out.println("+++++++++++++");
                System.out.println("Player1 wins!");
                System.out.println("+++++++++++++");
            }
        }

        System.out.println();
        System.out.println("FINAL SCORE:");
        personHandSum = this.sumOfRanksInHand(this.getPlayer());
        System.out.print("Player1: " + "\u270B");
        System.out.print(this.handToString(this.getPlayer().getHand().getHandArrayList()));
        System.out.print("\u270B" + ", hand = " + personHandSum);

        dealerHandSum = this.sumOfRanksInHand(this.getDealer());
        System.out.println();
        System.out.print("Dealer: " + "\u270B");
        System.out.print(this.handToString(this.getDealer().getHand().getHandArrayList()));
        System.out.print("\u270B" + ", hand = " + dealerHandSum);
        System.out.println();

        System.out.println();
        //this.doYouWantToContinuePlaying();
        System.out.println();
    }

//    public void doYouWantToContinuePlaying() {
//        Scanner scanner = new Scanner(System.in);
//        String test = "";
//        do {
//            System.out.println("Keep playing? (yes/no) ");
//            test = scanner.nextLine();
//            if (test.equals("yes")) {
//                Blackjack blackjack = new Blackjack("keepPlaying", 200);
//                blackjack.start();
//                break;
//            } if (test.equals("no")) {
//                break;
//            }
//        } while(true);
//    }

    // Game Class
    public void end() {
        System.out.print("Thank you for playing");
        System.out.println();
    }

//    public static void main (String[] args) {
//       Blackjack blackjack = new Blackjack("test", 500);
//        blackjack.start();
//        blackjack.end();
//
//    }
}
