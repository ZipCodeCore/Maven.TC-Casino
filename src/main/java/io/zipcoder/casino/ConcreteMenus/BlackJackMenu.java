package io.zipcoder.casino.ConcreteMenus;

import io.zipcoder.casino.BlackJack.BlackJack;
import io.zipcoder.casino.Casino;
import io.zipcoder.casino.Console;
import io.zipcoder.casino.Player;

import java.util.Scanner;

public class BlackJackMenu {
    private static final double MIN_BET_ALLOWED=0.01;
    private static BlackJack game = new BlackJack();
    private static Scanner scanner = new Scanner (System.in);
    public static void run(){
        Player userPlayer = game.getPlayer();
        System.out.print("" +
                " ____   _            _     _            _    \n" +
                "| __ ) | | __ _  ___| | __(_) __ _  ___| | __\n" +
                "|    \\ | |/ _` |/ __| |/ /| |/  ` |/ __| |/ / \n" +
                "| |_) || | (_| | (__| | < | | (_| | (__|   < \n" +
                "|____/ |_|\\__,_|\\___|_|\\_\\| |\\__,_|\\___|_|\\_\\ \n" +
                "                        |__/ \n" +
                "+--------------------------------------------+" +
                "\n\nWelcome to the <BlackJackGame> table!" +
                "\n\nWhat's your name? ");
        String userName = getInput();
        userPlayer.setName(userName);
        System.out.println("Hello, " + userName + "!");
        System.out.println("\nYou have $"+forceTwoDecimalDouble(userPlayer.getMoney().toString()));
        do {
            game.play();
            playerBets(userPlayer);
            displayPlayerHandAndScore(userPlayer);
            displayDealerCardShowing();
            playerHitsOrStays(userPlayer);
            game.dealerHitUntilFinished();
            determineWinOrLoss(userPlayer);
        } while (playerStaysForAnotherRound(userPlayer));
        System.out.println("\nReturning back to the Casino\n");
        Casino casino = new Casino();
        casino.start();
    }
    private static boolean playerStaysForAnotherRound(Player userPlayer) {
        String input;
        System.out.println("\nYou have $" + forceTwoDecimalDouble(userPlayer.getMoney().toString()));
        if (userPlayer.getMoney() >= 0.01) {
            do {
                System.out.print("\nStay for another round? [Yes/No]  ");
                input = getInput();
                if (isInputYesOrNo(input))
                {
                    return ("yes".equalsIgnoreCase(input));
                }
            } while (!isInputYesOrNo(input));
        }
        else {
            System.out.println("\nYou are out of money.");
        }
        return false;
    }
    private static void determineWinOrLoss(Player userPlayer){
        if (game.playerWins()) {
            System.out.println("\nPlayer wins!");
        } else {
            System.out.println("\nHouse wins!");
        }
        System.out.println("\nHouse has score: " + game.getDealer().getScore());
        resetPotAndDiscardHands(userPlayer);
    }
    private static void resetPotAndDiscardHands(Player userPlayer){
        game.returnBet();
        userPlayer.getHand().clear();
        game.getDealer().getHand().clear();
    }
    private static void playerHitsOrStays(Player userPlayer){
        String input;
        do {
            input=forceHitOrStay();
            if ("hit".equalsIgnoreCase(input)) {
                game.dealCard(userPlayer);
            }
            displayPlayerHandAndScore(userPlayer);
        } while ("hit".equalsIgnoreCase(input) && (userPlayer.calculateScore() <= 21));
    }
    private static String forceHitOrStay(){
        String input;
        do {
            System.out.print("\nHit or stay? ");
            input = getInput();
        } while (!isInputStayOrHit(input));
        return input;
    }
    private static void displayDealerCardShowing(){
        System.out.println("\nDealer is showing:\n"+game.getDealer().getHand().get(0).toString());
    }
    private static void displayPlayerHandAndScore(Player userPlayer){
        Console.displayPlayerHandAndScore(userPlayer);
        System.out.println("\nYour current score is: " + userPlayer.calculateScore());
    }
    private static void playerBets(Player userPlayer){
        Double betAmount;
        String input;
        input=forcePlayerBet(userPlayer);
        betAmount=Double.valueOf(input);
        userPlayer.makeBet(betAmount);
        game.takeBet(betAmount);
    }
    private static String forcePlayerBet(Player userPlayer){
        String input;
        do {
            input=forceDoubleInput();
        }
        while (!userPlayer.hasMoneyToMakeBet(Double.valueOf(input)));
        return (input);
    }
    private static String forceDoubleInput() {
        String input;
        do {
            System.out.print("\nHow much do you want to bet?  ");
            input = getInput();
        } while (!isInputDouble(input) || !isInputPositive(input));
        return forceTwoDecimalDouble(input);
    }
    private static String getInput()
    {
        return scanner.nextLine();
    }
    public static boolean isInputPositive(String passedString){
        return Double.valueOf(passedString)>=MIN_BET_ALLOWED;
    }
    public static boolean isInputDouble(String passedString)
    {
        try {
            Double output = Double.valueOf(passedString);
        } catch (NumberFormatException e) {
            return false;
        }
        return (true);
    }
    public static boolean isInputStayOrHit(String passedString)
    {
        return ("hit".equalsIgnoreCase(passedString) ||
                "stay".equalsIgnoreCase(passedString));
    }
    public static boolean isInputYesOrNo(String passedString)
    {
        return ("yes".equalsIgnoreCase(passedString) ||
                "no".equalsIgnoreCase(passedString));
    }
    public static String forceTwoDecimalDouble(String input){
        if ( !(input.contains(".")) ||
                input.substring(input.indexOf("."), input.length()).length()==3)
        {
            return input;
        }
        else
        {
            if (input.substring(input.indexOf("."), input.length()).length()<3) {
                do {
                    input = input + "0";
                } while (input.substring(input.indexOf("."), input.length()).length() < 3);
                return input;
            }
            input = input.substring(0,input.indexOf("."))+
                    input.substring(input.indexOf("."), input.indexOf(".")+3);
            return input;
        }
    }
}