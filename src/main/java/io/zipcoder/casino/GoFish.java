package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GoFish extends Game implements GameInterface, CardGameInterface {

    private Person player1 = player;
    private Person dealer = new Person("Dealer");
    private Deck houseDeck = new Deck();

    private Scanner userInputScanner = new Scanner(System.in);
    private int userInputSave = 0;

    private Scanner anotherRoundScanner = new Scanner(System.in);

    private int booksTotalPlayer = 0;
    private int booksTotalDealer = 0;

    private Random random = new Random();
    private int randomCardFromDealersHand = 0;

    public void GoFish(Person player) {
        this.player1 = player;
    }
    public void start() {
        System.out.println("*************************  Welcome to Go Fish!  *************************");
        System.out.println("\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B" +
                "\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B" +
                "\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B");
        System.out.println("*************************  Welcome to Go Fish!  *************************\n");

        houseDeck = new Deck();
        startingDrawDeck(houseDeck);

        userTurn();
    }

    public GoFish(Person player1) {
         //this.player1 = player1;
    }

    public GoFish() {

    }

    public void startingDrawDeck(Deck houseDeck){
        // Add 7 cards to player1 hands

        for (int i = 0; i < 7; i++){
            player1.getHand().getHandArrayList().add(houseDeck.drawCard());
        }
        // Add 7 cards to dealer hands
        for (int i = 0; i < 7; i++){
            dealer.getHand().getHandArrayList().add(houseDeck.drawCard());
        }
        houseDeck.shuffleDeck();
    }

    public void userTurn(){
            do {
                System.out.println("******      Player's turn     ******");
                System.out.println("Enter: 1 for Ace, 11 for Jack, 12 for Queen, & 13 for King\n");
                System.out.println("**** Choose a card to request from dealer ****");
                checkNumberOfCard();
                while(!userInputScanner.hasNextInt()) {
                    userInputScanner.next();
                }
     /*SAVE*/   int userInput = userInputScanner.nextInt();
                userInputSave = userInput;
            } while (userInputSave <= 0 || userInputSave > 13);

        doYouHaveTheCardThatIWantFromComputer(userInputSave, dealer);
    }

    public void dealerTurn(){

        ArrayList<Integer> dealerRandomNumberList = new ArrayList<Integer>();

        dealerRandomNumberList.add(1);
        dealerRandomNumberList.add(2);
        dealerRandomNumberList.add(3);
        dealerRandomNumberList.add(4);
        dealerRandomNumberList.add(5);
        dealerRandomNumberList.add(6);
        dealerRandomNumberList.add(7);
        dealerRandomNumberList.add(8);
        dealerRandomNumberList.add(9);
        dealerRandomNumberList.add(10);
        dealerRandomNumberList.add(11);
        dealerRandomNumberList.add(12);
        dealerRandomNumberList.add(13);

        for (int x = 0; x < 13; x++) {
            randomCardFromDealersHand = (dealerRandomNumberList.get(random.nextInt(dealerRandomNumberList.size())));
        }
        System.out.println("****        Dealer's turn       ****");
        System.out.println("\nDealer has chosen card: " + randomCardFromDealersHand);

        doYouHaveTheCardThatIWantFromPlayer(randomCardFromDealersHand, player1);
    }

    //Will check the players hand for books and delete them
    // Need to add in score for completed books
    public void checkBookCount(int userInputSave, Person handOfCards){

            int num = 0;

            for(int i = 0; i < handOfCards.getHand().getHandArrayList().size(); i++) {
                if (userInputSave == handOfCards.getHand().getHandArrayList().get(i).getRank().toInt()) {
                    num++;
                }
            }
            if (num == 4) {
                for (int j = handOfCards.getHand().getHandArrayList().size() - 1; j >= 0 ; j--) {
                    if (userInputSave == handOfCards.getHand().getHandArrayList().get(j).getRank().toInt()){

                        handOfCards.getHand().getHandArrayList().remove(handOfCards.getHand().getHandArrayList().get(j));
                    }
                }
                booksTotalPlayer++;
                System.out.println("\n!$!$!$!$!$!$! You Scored a Book! (Four of a kind) !$!$!$!$!$!$!\n");
                System.out.println("!!!!Your Book Total: " + booksTotalPlayer + "\n");
            }

        checkForEmptyDeckOrHandOfUserAfterCardFromComputer();
        //return 0;
    }

    public void checkBookCountAfterGoFish(int userInputSave, Person handOfCards){

        int num = 0;

        for(int i = 0; i < handOfCards.getHand().getHandArrayList().size(); i++) {
            if (userInputSave == handOfCards.getHand().getHandArrayList().get(i).getRank().toInt()) {
                num++;
            }
        }
        if (num == 4) {
            for (int j = handOfCards.getHand().getHandArrayList().size() - 1; j >= 0 ; j--) {
                if (userInputSave == handOfCards.getHand().getHandArrayList().get(j).getRank().toInt()){
                    handOfCards.getHand().getHandArrayList().remove(handOfCards.getHand().getHandArrayList().get(j));
                }
            }
            booksTotalPlayer++;
            System.out.println("\n!$!$!$!$!$!$! You Scored a Book! (Four of a kind) !$!$!$!$!$!$!\n");
            System.out.println("!!!!Your Book total: " + booksTotalPlayer + "\n");
        }
        checkForEmptyDeckOrHandOfUserAfterGoFish();
    }

    public void checkBookCountDealer(int randomCardFromDealersHand, Person handOfCards){

        int num = 0;

        for(int i = 0; i < handOfCards.getHand().getHandArrayList().size(); i++) {
            if (randomCardFromDealersHand == handOfCards.getHand().getHandArrayList().get(i).getRank().toInt()) {
                num++;
            }
        }
        if (num == 4) {
            for (int j = handOfCards.getHand().getHandArrayList().size() - 1; j >= 0 ; j--) {
                if (randomCardFromDealersHand == handOfCards.getHand().getHandArrayList().get(j).getRank().toInt()){
                    handOfCards.getHand().getHandArrayList().remove(handOfCards.getHand().getHandArrayList().get(j));
                }
            }
            booksTotalDealer++;
            System.out.println("\n!$!$!$!$!$!$! Dealer Scored a Book! (Four of a kind) !$!$!$!$!$!$!\n");
            System.out.println("!!!!Dealer's Book total: " + booksTotalDealer + "\n");
        }
        checkForEmptyDeckOrHandOfDealerAfterCardFromPlayer();
    }

    public void checkBookCountDealerAfterGoFish(int randomCardFromDealersHand, Person handOfCards){

        int num = 0;

        for(int i = 0; i < handOfCards.getHand().getHandArrayList().size(); i++) {
            if (randomCardFromDealersHand == handOfCards.getHand().getHandArrayList().get(i).getRank().toInt()) {
                num++;
            }
        }
        if (num == 4) {

            for (int j = handOfCards.getHand().getHandArrayList().size() - 1; j >= 0 ; j--) {
                if (randomCardFromDealersHand == handOfCards.getHand().getHandArrayList().get(j).getRank().toInt()){
                    handOfCards.getHand().getHandArrayList().remove(handOfCards.getHand().getHandArrayList().get(j));
                }
            }
            booksTotalDealer++;
            System.out.println("\n!$!$!$!$!$!$! Dealer Scored a Book! (Four of a kind) !$!$!$!$!$!$!\n");
            System.out.println("!!!!Dealer's Book total: " + booksTotalDealer + "\n");
        }
        checkForEmptyDeckOrHandOfDealerAfterGoFish();
    }

    // Asks Player if they have the card requested
    public int doYouHaveTheCardThatIWantFromComputer(int userInputSave, Person handOfCards){

        int counter = 0;

        for(int i = 0; i < handOfCards.getHand().getHandArrayList().size(); i++){
            if (userInputSave == handOfCards.getHand().getHandArrayList().get(i).getRank().toInt()){
                counter++;
            }
        }

        if (counter > 0){
            System.out.println("\n*** You found requested Card : " + userInputSave + "!***\n");
            removeCardsFromComputerPlayerAndIntoHand(userInputSave, dealer, player1);
            return 1;

        } else {
            System.out.println("\n*** Computer's hand does not have card ***\n");
            goFishPlayer(player1);
            //checkNumberOfCards();
            return 0;
        }

    }

    public int doYouHaveTheCardThatIWantFromPlayer(int randomCardFromDealersHand, Person handOfCards){

        int counter = 0;

        for(int i = 0; i < handOfCards.getHand().getHandArrayList().size(); i++){
            if (randomCardFromDealersHand == handOfCards.getHand().getHandArrayList().get(i).getRank().toInt()){
                counter++;
            }
        }
        if (counter > 0){
            System.out.println("\n*** Computer found requested Card : " + randomCardFromDealersHand + "!***\n");
            removeCardsFromPlayerAndIntoComputerHand(randomCardFromDealersHand, player1, dealer);
            return 1;

        } else {
            System.out.println("\n*** Player's hand does not have card ***\n");
            goFishDealer(dealer);
            //userTurn();
            return 0;
        }

    }

    // Removes Cards from player that has been asked and returns card to player that asked
    public int removeCardsFromComputerPlayerAndIntoHand(int userInputSave, Person giveHandOfCards, Person receiveHandOfCards){

        for(int i = giveHandOfCards.getHand().getHandArrayList().size() - 1; i >= 0; i--){
            if (userInputSave == giveHandOfCards.getHand().getHandArrayList().get(i).getRank().toInt()){
                receiveHandOfCards.getHand().getHandArrayList().add(giveHandOfCards.getHand().getHandArrayList().get(i));
                giveHandOfCards.getHand().getHandArrayList().remove(i);
            }
        }
        checkBookCount(userInputSave, player1);
        return userInputSave;
    }

    public int removeCardsFromPlayerAndIntoComputerHand(int randomCardFromDealersHand, Person giveHandOfCards, Person receiveHandOfCards){

        for(int i = giveHandOfCards.getHand().getHandArrayList().size() - 1; i >= 0; i--){
            if (userInputSave == giveHandOfCards.getHand().getHandArrayList().get(i).getRank().toInt()){
                receiveHandOfCards.getHand().getHandArrayList().add(giveHandOfCards.getHand().getHandArrayList().get(i));
                giveHandOfCards.getHand().getHandArrayList().remove(i);
            }
        }
        checkBookCountDealer(userInputSave, dealer);
        return randomCardFromDealersHand;
    }

    public void goFishPlayer(Person recieveCardFromDeck){
        System.out.println("********************");
        System.out.println("  Player Go Fish!");
        System.out.println("********************");
        System.out.println("");

            player1.getHand().getHandArrayList().add(houseDeck.drawCard());

            for(int i = 0; i < player1.getHand().getHandArrayList().size(); i++){
                userInputSave = player1.getHand().getHandArrayList().get(i).getRank().toInt();
            }

            System.out.println("\u270B Total deck of cards count: " + houseDeck.getDeckOfCards().size() + "\n");
            checkBookCountAfterGoFish(userInputSave, player1);
            //return houseDeck.drawCard();
    }

    public void goFishDealer(Person recieveCardFromDeck){
        System.out.println("********************");
        System.out.println("  Dealer Go Fish!");
        System.out.println("********************");
        System.out.println("");

        if (houseDeck.getDeckOfCards().size() == 0 || dealer.getHand().getHandArrayList().size() == 0) {
            System.out.println("Out of Cards!");
            whoWonTheGame();

        } else {
            dealer.getHand().getHandArrayList().add(houseDeck.drawCard());

            for(int i = 0; i < dealer.getHand().getHandArrayList().size(); i++){
                randomCardFromDealersHand = dealer.getHand().getHandArrayList().get(i).getRank().toInt();
            }
            System.out.println("\u270B Total deck of cards count: " + houseDeck.getDeckOfCards().size() + "\n");
            checkBookCountDealerAfterGoFish(randomCardFromDealersHand, dealer);
        }

    }

    public void dealCards() {

    }

    public int checkNumberOfCards(Hand hand) {

        System.out.println("Your hand: " + "\u270B" + player1.getHand().getHandArrayList() + "\u270B");

        return player1.getHand().getHandArrayList().size();
    }

    public int checkNumberOfCard() {

        System.out.println("Your hand: " + "\u270B" + player1.getHand().getHandArrayList() + "\u270B");

        return player1.getHand().getHandArrayList().size();
    }

    public void checkForEmptyDeckOrHandOfUserAfterGoFish(){
        if (houseDeck.getDeckOfCards().size() == 0 || player1.getHand().getHandArrayList().size() == 0){
            whoWonTheGame();
        } else {
            dealerTurn();
        }
    }
    public void checkForEmptyDeckOrHandOfUserAfterCardFromComputer(){
        if (houseDeck.getDeckOfCards().size() == 0 || player1.getHand().getHandArrayList().size() == 0){
            whoWonTheGame();
        } else {
            userTurn();
        }
    }

    public void checkForEmptyDeckOrHandOfDealerAfterGoFish(){
        if (houseDeck.getDeckOfCards().size() == 0 || dealer.getHand().getHandArrayList().size() == 0){
            whoWonTheGame();
        } else {
            userTurn();
        }
    }

    public void checkForEmptyDeckOrHandOfDealerAfterCardFromPlayer(){
        if (houseDeck.getDeckOfCards().size() == 0 || dealer.getHand().getHandArrayList().size() == 0){
            whoWonTheGame();
        } else {
            dealerTurn();
        }
    }

    public void whoWonTheGame(){
        if (booksTotalPlayer > booksTotalDealer){
            System.out.println("*************************  You Won!  *************************");
            System.out.println("\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B" +
                    "\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B" +
                    "\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\n" +
                    "           You won the game with a total Book Score of " + booksTotalPlayer + "!\n" +
                    "           Dealer lost game with a total Book Score of " + booksTotalDealer + "!\n" +
                    "\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B" +
                    "\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B" +
                    "\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B");
            System.out.println("*************************  You Won!  *************************\n");
        } else if (booksTotalPlayer == booksTotalDealer) {
            System.out.println("*************************  You Tied!  *************************");
            System.out.println("\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B" +
                    "\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B" +
                    "\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\n" +
                    "           Both Players Tied with a total Book Score of " + booksTotalPlayer + "!\n" +
                    "\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B" +
                    "\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B" +
                    "\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B");
            System.out.println("*************************  You Tied!  *************************\n");
        } else {
            System.out.println("*************************  You Lost!  *************************");
            System.out.println("\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B" +
                    "\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B" +
                    "\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\n" +
                    "           You Lost! Dealer had a Book Score of " + booksTotalDealer + "!\n" +
                    "                 You had a Book Score of " + booksTotalPlayer + "!\n" +
                    "\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B" +
                    "\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B" +
                    "\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B\u270B");
            System.out.println("*************************  You Lost!  *************************\n");
        }
        end();
    }

    public void end() {

        booksTotalPlayer = 0;
        booksTotalDealer = 0;

        player1.getHand().getHandArrayList().clear();
        dealer.getHand().getHandArrayList().clear();

        System.out.println("Play another round? yes or no...");
        if (anotherRoundScanner.nextLine().equalsIgnoreCase("yes")) {
            start();
        } else {
            System.out.println("Thanks for playing!");
        }
    }

//    public static void main(String[] args) {
//        GoFish game = new GoFish();
//        game.start();
//
//    }
}
