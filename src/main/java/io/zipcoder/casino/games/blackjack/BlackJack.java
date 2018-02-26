package io.zipcoder.casino.games.blackjack;

import io.zipcoder.casino.core.Player;
import io.zipcoder.casino.games.Card;
import io.zipcoder.casino.games.Deck;
import io.zipcoder.casino.games.Rank;
import io.zipcoder.casino.interfaces.Game;
import io.zipcoder.casino.utils.IOHandler;

import java.util.ArrayList;


public class BlackJack implements Game {

    private static final String fRULES_PATH = "BlackJack.Rules.txt";
    private Player player;
    static Deck playingDeck;
    static String output;
    private ArrayList<Card> playerValue;
    private ArrayList<Card> dealerValue;
    private ArrayList<Card> splitHandLeft;
    private ArrayList<Card> splitHandRight;
    private int splitHandScoreLeft;
    private int splitHandScoreRight;
    private int playerHandScore;
    private int dealerHandScore;
    private int insuranceBet;

    public BlackJack() {

    }
    public void welcomeToBlackJack() {
        do {
            String intro = "\n   /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =\\\n" +
                    "  /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =\\" +
                    "\n\n \n                             WELCOME TO: \n" +
                    " ______   __                 __          _____              __       \n" +
                    "|_   _ \\ [  |               [  |  _     |_   _|            [  |  _   \n" +
                    "  | |_) | | |  ,--.   .---.  | | / ]      | | ,--.   .---.  | | / ]  \n" +
                    "  |  __'. | | `'_\\ : / /'`\\] | '' <   _   | |`'_\\ : / /'`\\] | '' <   \n" +
                    " _| |__) || | // | |,| \\__.  | |`\\ \\ | |__' |// | |,| \\__.  | |`\\ \\  \n" +
                    "|_______/[___]\\'-;__/'.___.'[__|  \\_]`.____.'\\'-;__/'.___.'[__|  \\_] \n" +
                    "\n" +
                    "                   Press s to start the game.\n" +
                    "                          Type r for rules     \n" +
                    "                         Type quit to exit\n\n\n" +
                    "  \\= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =/\n" +
                    "   \\= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =/";

            output = IOHandler.promptForStringWithMessage(intro);
            if (output.equalsIgnoreCase("r")){
                IOHandler.printMessage(getRules());
            }
            if (output.equalsIgnoreCase("s")) {
                beginGame();
            }
        }
        while (!output.equalsIgnoreCase("quit"));
    }
    public void beginBeforeGame() {

        Deck playingDeck = new Deck();
        playerValue = new ArrayList<>();
        dealerValue = new ArrayList<>();
        splitHandLeft = new ArrayList<>();
        splitHandRight = new ArrayList<>();


        for (int i = 0; i < 2; i++){
            playerValue.add(playingDeck.pullMany(1)[0]);
            dealerValue.add(playingDeck.pullMany(1)[0]);
        }

        getPlayerCardValue();
        getDealerCardValue();

    }
    public void beginGame(){
        BlackJack blackJ = new BlackJack();
        blackJ.beginBeforeGame();
        System.out.println("The Dealer has: \n" + blackJ.displayDealerHand());
        System.out.println("Your hand is: \n" + blackJ.displayPlayerHand());

        blackJ.acePropertiesForDealer();
        blackJ.dealerHitOrStand();
        if(isDealerLessThan21()) {
            blackJ.blackJackNatural();
            blackJ.acePropertiesForPlayer();
            blackJ.isHandSplittable();
            blackJ.playerHitOrStand();
        }
    }
    public boolean isDealerLessThan21(){
        if (dealerHandScore <= 21){
            return true;
        }
        return false;
    }
    public void blackJackNatural(){
        if ((playerValue.get(0).getRank().equals(Rank.ACE) && playerValue.size() == 2 && getPlayerCardValue() == 11)
                || playerValue.get(1).getRank().equals(Rank.ACE) && playerValue.size() == 2 && getPlayerCardValue() == 11) {
            playerHandScore = 21;
            System.out.println(".------..------..------..------..------..------..------..------..------..------.\n" +
                    "|B.--. ||L.--. ||A.--. ||C.--. ||K.--. ||J.--. ||A.--. ||C.--. ||K.--. ||!.--. |\n" +
                    "| :(): || :/\\: || (\\/) || :/\\: || :/\\: || :(): || (\\/) || :/\\: || :/\\: || (\\/) |\n" +
                    "| ()() || (__) || :\\/: || :\\/: || :\\/: || ()() || :\\/: || :\\/: || :\\/: || :\\/: |\n" +
                    "| '--'B|| '--'L|| '--'A|| '--'C|| '--'K|| '--'J|| '--'A|| '--'C|| '--'K|| '--'!|\n" +
                    "`------'`------'`------'`------'`------'`------'`------'`------'`------'`------'\n\n");

        }
    }
    public void acePropertiesForPlayer() {
        Deck playingDeck = new Deck();
        if (isDealerLessThan21()) {
            if (playerValue.get(0).getRank().equals(Rank.ACE) || playerValue.get(1).getRank().equals(Rank.ACE)) {
                if (getPlayerCardValue() < 11) {
                    playerHandScore = getPlayerCardValue() + 10;
                    hitCycleAce(playingDeck);
                }
            }
        }
    }
    public void acePropertiesForDealer() {
/**
 * Not sure if I will implement this insurance thing yet.
 */
//      if (dealerValue.get(0).getRank().equals(Rank.ACE)) {
//            String prompt = "The dealer has an Ace, do you want to put down insurance?\n" +
//                    " Yes or No";
//            output = IOHandler.promptForStringWithMessage(prompt);
//            if (output.equalsIgnoreCase("Yes")) {
//                System.out.println("You put down insurance");
//            }
//            displayDealerHand();
//        }
        if(dealerValue.contains(Rank.ACE)){
            dealerHandScore = 11 + dealerValue.get(1).getIntValue();
        }
    }
    public Integer getPlayerCardValue() {
        playerHandScore = 0;
        for (Card pCard : playerValue) {
            playerHandScore += pCard.getIntValue();
        }
        return playerHandScore;
    }
    public Integer getDealerCardValue() {
        dealerHandScore = 0;
        for (Card dCard : dealerValue) {
            dealerHandScore += dCard.getIntValue();
        }
        return dealerHandScore;
    }
    public String displayPlayerHand() {
        String pHandCards = "";
        for (Card card : playerValue) {
            pHandCards += " || " + card.toString() + " || ";
        }
        return pHandCards;
    }
    public String displayDealerHand() {
        String dHandCards = "";
        for (int i = 0; i < 1; i++) {
            dHandCards += " || " + dealerValue.get(0).toString() + " || " + " ||   HIDDEN CARD   ||";
        }
        return dHandCards;
    }
    public Integer comparable(Card card1, Card card2) {
        Integer cardVal1 = card1.getIntValue();
        Integer cardVal2 = card2.getIntValue();
        if (cardVal1 > cardVal2) {
            return 1;
        }
        if (cardVal1 < cardVal2) {
            return -1;
        }
        return 0;
    }
    public Integer playerLeftHandScore() {
        splitHandScoreLeft = 0;
        for (Card cardLeft : splitHandLeft) {
            splitHandScoreLeft += cardLeft.getIntValue();
        }
        return splitHandScoreLeft;
    }
    public Integer playerRightHandScore(){
        splitHandScoreRight = 0;
        for (Card cardRight : splitHandRight){
            splitHandScoreRight += cardRight.getIntValue();
        }
        return splitHandScoreRight;
    }
    public String displayLeftHand(){
        String leftHandSplit = "";
        for (Card card : splitHandLeft){
            leftHandSplit += card.toString();
        }
        return leftHandSplit;
    }
    public String displayRightHand(){
        String rightHandSplit = "";
        for (Card card : splitHandRight){
            rightHandSplit += card.toString();
        }
        return rightHandSplit;
    }
    public void dealerHitOrStand(){
        Deck playingDeck = new Deck();
        while (dealerHandScore < 17){
            System.out.println("The drunken dealer does some weird shit...\n");
            dealerValue.add(playingDeck.pullMany(1)[0]);
            dealerHandScore = getDealerCardValue();
        }
        if (dealerHandScore > 21){
            System.out.println("The dealer busted at " + dealerHandScore + "!");
            System.out.println("You win!");
        }
    }
    public void playerHitOrStand() {
        Deck playingDeck = new Deck();
        if (isDealerLessThan21() && !(playerValue.get(0).getIntValue().equals(playerValue.get(1).getIntValue())) &&
                (!(playerValue.get(1).getRank().equals(Rank.ACE) || playerValue.get(0).getRank().equals(Rank.ACE)))){
            hitCycle(playingDeck);
        }
    }
    public void hitCycle(Deck playingDeck) {
        while (playerHandScore < 21) {
            String prompt = "Do you want to hit or stand?\n";
            output = IOHandler.promptForStringWithMessage(prompt);
            if (output.equalsIgnoreCase("hit")) {
                playerValue.add(playingDeck.pullMany(1)[0]);
                playerHandScore = getPlayerCardValue();
                System.out.println("You have: " + playerHandScore);
            }
            if (output.equalsIgnoreCase("stand")) {
                playerHandScore = getPlayerCardValue();
                break;
            }
        }
        if (playerHandScore > 21) {
            bust();
        }
        System.out.println("You have " + getPlayerCardValue() + ", the dealer has" +
                ": " + getDealerCardValue());
        winCondition();
    }
    public void hitCycleAce(Deck playingDeck) {
        while (playerHandScore < 21) {
            String prompt = "Do you want to hit or stand?\n";
            output = IOHandler.promptForStringWithMessage(prompt);
            if (output.equalsIgnoreCase("hit")) {
                playerValue.add(playingDeck.pullMany(1)[0]);
                playerHandScore = getPlayerCardValue() + 10;
                System.out.println("You have: " + playerHandScore);
            }
            if (output.equalsIgnoreCase("stand")) {
                playerHandScore = getPlayerCardValue() + 10;
                break;
            }
        }
        if (playerHandScore > 21) {
            bust();
        }
        System.out.println("You have " + playerHandScore + ", the dealer has" +
                ": " + getDealerCardValue());
        winConditionAce();
    }


    public void bust() {
        System.out.println("Over 21, you busted! You lost!");
    }
    public void isHandSplittable() {
        if (isDealerLessThan21()) {
            if (playerValue.get(0).getRank().equals(Rank.ACE) && playerValue.get(1).getRank().equals(Rank.ACE)) {
                System.out.println("I'm not crazy enough to program this now. Take your money and leave me alone.");
            }
            if (playerValue.get(0).getIntValue().equals(playerValue.get(1).getIntValue())) {
                splitHandLeft.add(playerValue.get(0));
                splitHandRight.add(playerValue.get(1));
                splitHandPrompt();
            }
        }
    }
    public void splitHandPrompt() {
        Deck playingDeck = new Deck();
        String prompt = "Your split value is " + playerValue.get(0).getIntValue() + ". Do you want to split?";
        output = IOHandler.promptForStringWithMessage(prompt);
        if (output.equalsIgnoreCase("yes")) {
            System.out.println("Your left hand split is: " + displayLeftHand() +
                    " || " + "Your right hand split is: " + displayRightHand());
            String whichHand = "Which hand do you want to hit first?\n";
            output = IOHandler.promptForStringWithMessage(whichHand);
            if (output.equalsIgnoreCase("left")) {
                splitHitLeftHand();
                splitHitRightHand();
            }
            if (output.equalsIgnoreCase("right")) {
                splitHitRightHand();
                splitHitLeftHand();
            }
        }
        if (output.equalsIgnoreCase("no")) {
            hitCycle(playingDeck);
        }
    }
    public void splitHitLeftHand(){
        Deck playingDeck = new Deck();
        while (splitHandScoreLeft < 21){
            String prompt = "Do you want to hit or stand your left hand?\n";
            output = IOHandler.promptForStringWithMessage(prompt);
            if (output.equalsIgnoreCase("hit")) {
                splitHandLeft.add(playingDeck.pullMany(1)[0]);
                splitHandScoreLeft = playerLeftHandScore();
                System.out.println("Your left hand has: " + splitHandScoreLeft);
            }
            else if (output.equalsIgnoreCase("stand")){
                splitHandScoreLeft = playerLeftHandScore();
                System.out.println("Your left hand has: " + splitHandScoreLeft);
                break;
            }
        }
        if (splitHandScoreLeft == 21 && dealerHandScore != 21){
            System.out.println("Your left wins!");
        }
        if (splitHandScoreLeft > 21){
            bust();
        }
        System.out.println("Your left hand has: " + playerLeftHandScore() +
                ", the dealer has" + ": " + getDealerCardValue());
        winConditionLeftHand();
    }
    public void splitHitRightHand(){
        Deck playingDeck = new Deck();
        while (splitHandScoreRight < 21){
            String prompt = "Do you want to hit or stand your right hand?\n";
            output = IOHandler.promptForStringWithMessage(prompt);
            if (output.equalsIgnoreCase("hit")) {
                splitHandRight.add(playingDeck.pullMany(1)[0]);
                splitHandScoreRight = playerRightHandScore();
                System.out.println("Your right hand has: " + splitHandScoreRight);
            }
            else if (output.equalsIgnoreCase("stand")){
                splitHandScoreRight = playerRightHandScore();
                System.out.println("Your right hand has: " + splitHandScoreRight);
                break;
            }
        }
        if (splitHandScoreRight == 21 && dealerHandScore != 21){
            System.out.println("Your right wins!");
        }
        if (splitHandScoreRight > 21){
            bust();
        }
        System.out.println("Your right hand has: " + playerRightHandScore() +
                ", the dealer has" + ": " + getDealerCardValue());
        winConditionRightHand();
    }
    public void winCondition() {
        if (getPlayerCardValue() > getDealerCardValue() && getPlayerCardValue() <= 21) {
            System.out.println("You Win!");
        } else if (playerHandScore == 21 && dealerHandScore != 21) {
            System.out.println("You Win!");
        } else if (getPlayerCardValue() < getDealerCardValue() && getDealerCardValue() > 21) {
            System.out.println("You Win!");
        } else if (getPlayerCardValue() <= 21 && getPlayerCardValue() == getDealerCardValue()) {
            System.out.println("You tied");
        } else if (getPlayerCardValue() < getDealerCardValue() && getDealerCardValue() <= 21) {
            System.out.println("You lost!");
        }
    }
    public void winConditionAce(){
        if (playerHandScore > getDealerCardValue() && playerHandScore <= 21){
            System.out.println("You Win!");
        } else if (playerHandScore == 21 && dealerHandScore !=21){
            System.out.println("You won with 21!");
        } else if (playerHandScore < getDealerCardValue() && getDealerCardValue() > 21){
            System.out.println("You Win!");
        } else if (playerHandScore <= 21 && playerHandScore == getDealerCardValue()){
            System.out.println("You tied, sorry.");
        } else if (playerHandScore < getDealerCardValue() && getDealerCardValue() <= 21){
            System.out.println("You lost!");
        }
    }
    public void winConditionLeftHand() {
        if (playerLeftHandScore() > getDealerCardValue() && playerLeftHandScore() <= 21) {
            System.out.println("You win this left hand!");
        }
        if (playerLeftHandScore() <= 21 && playerLeftHandScore() == getDealerCardValue()) {
            System.out.println("You tied with your left hand.");
        } else if (playerLeftHandScore() < getDealerCardValue()) {
            System.out.println("You lost this left hand!");
        }
    }
    public void winConditionRightHand(){
        if (playerRightHandScore() > getDealerCardValue() && playerRightHandScore() <= 21) {
            System.out.println("You win this right hand!");
        }
        else if (playerRightHandScore() <= 21 && playerRightHandScore() == getDealerCardValue()) {
            System.out.println("You tied with your right hand.");
        }
        else if (playerRightHandScore() < getDealerCardValue()) {
            System.out.println("You lost this right hand!");
        }
    }

    public void play(Player player) {
        welcomeToBlackJack();
    }

    @Override
    public void runWelcome() {
        welcomeToBlackJack();
    }

    @Override
    public String getRules() {
        return IOHandler.getMessageFromFile(fRULES_PATH);
    }
}
//    public void playerDoubleDown(){
//
//    }
//    public void wagerMultiplier(){
//
//    }