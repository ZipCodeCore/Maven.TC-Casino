package io.zipcoder.casino.games.roulette;


import io.zipcoder.casino.core.Player;
import io.zipcoder.casino.interfaces.Game;
import io.zipcoder.casino.utils.IOHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Roulette implements Game{
    private Player player = new Player();
    private RouletteBoardAndWheel rouletteBoardAndWheel = new RouletteBoardAndWheel();
    private RoulettePrompts prompts = new RoulettePrompts();
    private RouletteGamble rouletteGamble = new RouletteGamble();
    private String stringResponse = "";
    private int intResponse;
    private Integer initialBalance = player.getBalance().intValue();
    //    private Integer initialBalance = player.getBalance().intValue();
//    protected Integer currentBalance = initialBalance;
    protected HashMap<String, ArrayList<Integer>> bettingMap = new HashMap<>();
    protected ArrayList<Integer> singleNumberSelection = new ArrayList<>();
    protected ArrayList<Integer> doubleNumberSelection = new ArrayList<>();
    protected ArrayList<Integer> cornerNumberSelection = new ArrayList<>();
    protected ArrayList<Integer> rowNumberSelection = new ArrayList<>();
    protected ArrayList<Integer> basketNumberSelection = new ArrayList<>();
    protected ArrayList<Integer> fiveNumberSelection = new ArrayList<>();
    protected ArrayList<Integer> lineNumberSelection = new ArrayList<>();
    protected ArrayList<Integer> columnNumberSelection = new ArrayList<>();
    protected ArrayList<Integer> twelveNumberSelection = new ArrayList<>();
    protected ArrayList<Integer> oneThru8Selection = new ArrayList<>();
    protected ArrayList<Integer> nineteenThru36Selection = new ArrayList<>();
    protected ArrayList<Integer> evenNumberSelection = new ArrayList<>();
    protected ArrayList<Integer> oddNumberSelection = new ArrayList<>();
    protected ArrayList<Integer> redNumberSelection = new ArrayList<>();
    protected ArrayList<Integer> blackNumberSelection = new ArrayList<>();


    /**
     * operation path: Welcome -> Rules (if chosen) -> play -> pick bets -> win/loose (repeat til) -> welcome -> exit
     * <p>
     * betting options: single number, double number, corner, row (Straight), basket (0,00,2), 5 number (0,00,1,2,3),
     * line (6 numbers/2 rows), column, 12 number (1st, 2nd, 3rd), 1-18, 19-36, even, odd, black, red
     */

    public void play(Player player) {
        this.player = player;
        try {
            mainLoop();
        } catch (InterruptedException e) {
        }
        System.out.println("Thank you for playing Roulette!\n\n");
    }

    public void runWelcome() {
        String prompt = " (        )          (                             \n" +
                " )\\ )  ( /(          )\\ )        *   )  *   )      \n" +
                "(()/(  )\\())     (  (()/(  (   ` )  /(` )  /( (    \n" +
                " /(_))((_)\\      )\\  /(_)) )\\   ( )(_))( )(_)))\\   \n" +
                "(_))    ((_)  _ ((_)(_))  ((_) (_(_())(_(_())((_)  \n" +
                "| _ \\  / _ \\ | | | || |   | __||_   _||_   _|| __| \n" +
                "|   / | (_) || |_| || |__ | _|   | |    | |  | _|  \n" +
                "|_|_\\  \\___/  \\___/ |____||___|  |_|    |_|  |___|\n";
        System.out.println(prompt);
    }

    public String getRules(){
        String rules = prompts.rules();
        return rules;
    }
    public void mainLoop() throws InterruptedException {
        Integer atStartOfTurnBalance = player.getBalance().intValue();
        startProgram:
        while (true) {
            int betCounter = 1;
            runWelcome();
            stringResponse = prompts.welcomeMessage();
            if (stringResponse.equals("q")) {
                break startProgram;
            } else if (stringResponse.equals("r")) {
                System.out.println(getRules());
                TimeUnit.SECONDS.sleep(10);
            } else if (stringResponse.equals("b")) {
                prompts.bettingInfo();
                TimeUnit.SECONDS.sleep(10);
            } else if (stringResponse.equals("y")) {
                letsPlay(betCounter, atStartOfTurnBalance);
            } else {
                System.out.println("\nERROR! INVALID INPUT!\n\nRestarting game...\n\n\n");
                TimeUnit.SECONDS.sleep(5);
            }
        }
    }

    public void letsPlay(int betCounter, Integer atStartOfTurnBalance) throws InterruptedException {
        while (intResponse != 17) {
            intResponse = prompts.firstSetOfOptionsPrompt(betCounter);
            if (intResponse == 16) {
                prompts.bettingInfo();
                TimeUnit.SECONDS.sleep(10);
            }
            selectionOptions(intResponse);
            betCounter++;
        }
        calculateWinnersAndEarnings();
        rouletteGamble.printStats(initialBalance, atStartOfTurnBalance, player.getBalance().intValue());
        IOHandler.promptForStringWithMessage("\nPress 'c' to restart\n\n");
    }

    public void selectionOptions(int intResponse){
        long bet = 1;
        switch (intResponse) {
            case 1:
                player.betChips(bet);
                singleNumberSelection.addAll(prompts.singleNumberPrompt());
                bettingMap.put("Single Number", singleNumberSelection);
                break;
            case 2:
                player.betChips(bet);
                doubleNumberSelection.addAll(Arrays.asList(prompts.onTheLine()));
                bettingMap.put("Double Number", doubleNumberSelection);
                break;
            case 3:
                player.betChips(bet);
                cornerNumberSelection.addAll(Arrays.asList(prompts.corner()));
                bettingMap.put("Corner", cornerNumberSelection);
                break;
            case 4:
                player.betChips(bet);
                rowNumberSelection.addAll(Arrays.asList(prompts.straight()));
                bettingMap.put("Straight", rowNumberSelection);
                break;
            case 5:
                player.betChips(bet);
                basketNumberSelection.addAll(Arrays.asList(prompts.basket()));
                bettingMap.put("Basket", basketNumberSelection);
                break;
            case 6:
                player.betChips(bet);
                fiveNumberSelection.addAll(Arrays.asList(prompts.fiveNumberBet()));
                bettingMap.put("Five Number Bet", fiveNumberSelection);
                break;
            case 7:
                player.betChips(bet);
                lineNumberSelection.addAll(Arrays.asList(prompts.lineBet()));
                bettingMap.put("Line Bet", lineNumberSelection);
                break;
            case 8:
                player.betChips(bet);
                columnNumberSelection.addAll(Arrays.asList(prompts.columnBet()));
                bettingMap.put("Column Bet", columnNumberSelection);
                break;
            case 9:
                player.betChips(bet);
                twelveNumberSelection.addAll(Arrays.asList(prompts.twelveNumberBet()));
                bettingMap.put("12 Number Bet", twelveNumberSelection);
                break;
            case 10:
                player.betChips(bet);
                oneThru8Selection.addAll(Arrays.asList(prompts.numbers1Thru8()));
                bettingMap.put("Numbers 1 - 8", oneThru8Selection);
                break;
            case 11:
                player.betChips(bet);
                nineteenThru36Selection.addAll(Arrays.asList(prompts.numbers19thru36()));
                bettingMap.put("Numbers 19 - 36", nineteenThru36Selection);
                break;
            case 12:
                player.betChips(bet);
                evenNumberSelection.addAll(Arrays.asList(prompts.evenNumbers()));
                bettingMap.put("Even Numbers", evenNumberSelection);
                break;
            case 13:
                player.betChips(bet);
                oddNumberSelection.addAll(Arrays.asList(prompts.oddNumbers()));
                bettingMap.put("Odd Numbers", oddNumberSelection);
                break;
            case 14:
                player.betChips(bet);
                blackNumberSelection.addAll(Arrays.asList(prompts.blackNumbers()));
                bettingMap.put("Black Numbers", blackNumberSelection);
                break;
            case 15:
                player.betChips(bet);
                redNumberSelection.addAll(Arrays.asList(prompts.redNumbers()));
                bettingMap.put("Red Numbers", redNumberSelection);
                break;
        }
    }

    public  void calculateWinnersAndEarnings() throws InterruptedException{
        Integer winningNumber = rouletteBoardAndWheel.generateWinningNumber();
        System.out.println("\n\n\n\n\n\nThe winning number is... \n\n" + winningNumber + "\n\n");

        Integer earnings = rouletteGamble.getEarnings(bettingMap, winningNumber);
        Integer losses = rouletteGamble.getLosses(bettingMap, winningNumber);
        Integer difference = earnings - losses;
        if(difference > 0) {
            player.addChips(difference);
        } else if(difference == 0){
            player.addChips(earnings);
        }
    }
}
