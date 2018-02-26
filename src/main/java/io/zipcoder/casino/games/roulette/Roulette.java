package io.zipcoder.casino.games.roulette;


import io.zipcoder.casino.core.Player;
import io.zipcoder.casino.interfaces.Game;
import io.zipcoder.casino.utils.IOHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Roulette implements Game {
    private Player player = new Player();
    private RouletteBoardAndWheel rouletteBoardAndWheel = new RouletteBoardAndWheel();
    private RoulettePrompts prompts = new RoulettePrompts();
    private RouletteGamble rouletteGamble = new RouletteGamble();
    private String stringResponse = "";
    private int intResponse;
    private Integer earnings = 0;
    private Integer net = 0;
    protected Integer initialBalance;
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
        initialBalance = player.getBalance().intValue();
        if (initialBalance == 0) {
            System.out.println("\n\n\nYOU'RE BROKE!!!! GET OUT!\n\n");
        } else {
            runWelcome();
            try {
                mainLoop();
            } catch (InterruptedException e) {
            }
            System.out.println("Thank you for playing Roulette!\n\n");
        }
    }


    public void mainLoop() throws InterruptedException {
        startProgram:
        while (true) {
            stringResponse = prompts.startMessage();
            if (stringResponse.equals("q")) {
                break startProgram;
            } else if (stringResponse.equals("r")) {
                System.out.println(getRules());
                pressCtoContinue();
            } else if (stringResponse.equals("b")) {
                System.out.println(getBettingInfo());
                pressCtoContinue();
            } else if (stringResponse.equals("y")) {
                letsPlay();
            } else {
                System.out.println("\nERROR! INVALID INPUT!\n\nRestarting game...\n\n\n");
                TimeUnit.SECONDS.sleep(5);
            }
        }
    }

    public void letsPlay() throws InterruptedException {
        int turnCounter = 1;
        do {
            intResponse = prompts.firstSetOfOptionsPrompt(turnCounter);
            if (intResponse == 16) {
                System.out.println(getBettingInfo());
                pressCtoContinue();
            } else if(intResponse == 17){
                displayBoard();
                pressCtoContinue();
            } else if (intResponse != 18 && intResponse <= 18) {
                displayBoard();
                selectionOptions(intResponse);
                turnCounter++;
            } else if (intResponse > 18){
                System.out.println("\n\n\nINVALID INPUT\n\n\n");
            }
        } while (intResponse != 18);
        calculateWinnersAndEarnings();
        this.net = rouletteGamble.lose((turnCounter - 1) * 10, this.earnings);
        rouletteGamble.printStats(initialBalance, player.getBalance().intValue(), (turnCounter - 1) * 10, this.earnings, this.net);
        pressCtoContinue();
        clearNumberArraysAndBettingMap();
    }

    public void selectionOptions(int intResponse) {
        long betCost = 10;
        if (player.canCoverBet(betCost) == true) {
            player.betChips(betCost);
            switch (intResponse) {
                case 1:
                    singleNumberSelection.add(prompts.singleNumberPrompt());
                    bettingMap.put("Single Number", singleNumberSelection);
                    break;
                case 2:
                    doubleNumberSelection.addAll(Arrays.asList(prompts.onTheLine()));
                    bettingMap.put("Double Number", doubleNumberSelection);
                    break;
                case 3:
                    cornerNumberSelection.addAll(Arrays.asList(prompts.corner()));
                    bettingMap.put("Corner", cornerNumberSelection);
                    break;
                case 4:
                    rowNumberSelection.addAll(Arrays.asList(prompts.straight()));
                    bettingMap.put("Straight", rowNumberSelection);
                    break;
                case 5:
                    basketNumberSelection.addAll(Arrays.asList(prompts.basket()));
                    bettingMap.put("Basket", basketNumberSelection);
                    break;
                case 6:
                    fiveNumberSelection.addAll(Arrays.asList(prompts.fiveNumberBet()));
                    bettingMap.put("Five Number Bet", fiveNumberSelection);
                    break;
                case 7:
                    lineNumberSelection.addAll(Arrays.asList(prompts.lineBet()));
                    bettingMap.put("Line Bet", lineNumberSelection);
                    break;
                case 8:
                    columnNumberSelection.addAll(Arrays.asList(prompts.columnBet()));
                    bettingMap.put("Column Bet", columnNumberSelection);
                    break;
                case 9:
                    twelveNumberSelection.addAll(Arrays.asList(prompts.twelveNumberBet()));
                    bettingMap.put("12 Number Bet", twelveNumberSelection);
                    break;
                case 10:
                    oneThru8Selection.addAll(Arrays.asList(prompts.numbers1Thru18()));
                    bettingMap.put("Numbers 1 - 18", oneThru8Selection);
                    break;
                case 11:
                    nineteenThru36Selection.addAll(Arrays.asList(prompts.numbers19thru36()));
                    bettingMap.put("Numbers 19 - 36", nineteenThru36Selection);
                    break;
                case 12:
                    evenNumberSelection.addAll(Arrays.asList(prompts.evenNumbers()));
                    bettingMap.put("Even Numbers", evenNumberSelection);
                    break;
                case 13:
                    oddNumberSelection.addAll(Arrays.asList(prompts.oddNumbers()));
                    bettingMap.put("Odd Numbers", oddNumberSelection);
                    break;
                case 14:
                    blackNumberSelection.addAll(Arrays.asList(prompts.blackNumbers()));
                    bettingMap.put("Black Numbers", blackNumberSelection);
                    break;
                case 15:
                    redNumberSelection.addAll(Arrays.asList(prompts.redNumbers()));
                    bettingMap.put("Red Numbers", redNumberSelection);
                    break;
            }
        } else {
            System.out.println("***OUT OF CHIPS***");
        }
    }


    public void runWelcome() {
        String welcomeResponse =
                "********************* WELCOME TO **********************\n" +
                        "(        )          (                             \n" +
                        " )\\ )  ( /(          )\\ )        *   )  *   )      \n" +
                        "(()/(  )\\())     (  (()/(  (   ` )  /(` )  /( (    \n" +
                        " /(_))((_)\\      )\\  /(_)) )\\   ( )(_))( )(_)))\\   \n" +
                        "(_))    ((_)  _ ((_)(_))  ((_) (_(_())(_(_())((_)  \n" +
                        "| _ \\  / _ \\ | | | || |   | __||_   _||_   _|| __| \n" +
                        "|   / | (_) || |_| || |__ | _|   | |    | |  | _|  \n" +
                        "|_|_\\  \\___/  \\___/ |____||___|  |_|    |_|  |___|\n\n";
        System.out.println(welcomeResponse);
        pressCtoContinue();
    }


    public void calculateWinnersAndEarnings() throws InterruptedException {
        Integer winningNumber = rouletteBoardAndWheel.generateWinningNumber();
        System.out.println("\n\n\n\n\n\nThe winning number is... \n\n" + winningNumber + "\n\n");

        this.earnings = rouletteGamble.win(bettingMap, winningNumber);
        player.addChips(earnings);
    }

    public String getRules() {
        return prompts.rules();
    }

    public String getBettingInfo() {
        return prompts.bettingInfo();
    }

    public void displayBoard(){
        StringBuilder display = new StringBuilder();
        display.append("----------------\n");
        for(int[] array : rouletteBoardAndWheel.rouletteInnerBoard){

            display.append("|");
            for(int number: array){
                display.append(String.format(" %-3d|", number));
            }
            display.append("\n");
            display.append("----------------\n");
        }
        System.out.println(display);
    }

    public void pressCtoContinue() {
        String continueResponse;
        do {
            continueResponse = IOHandler.promptForStringWithMessage("Press 'c' to continue");
        } while (!continueResponse.equals("c"));
    }

    public void clearNumberArraysAndBettingMap() {
        singleNumberSelection.clear();
        doubleNumberSelection.clear();
        cornerNumberSelection.clear();
        rowNumberSelection.clear();
        basketNumberSelection.clear();
        fiveNumberSelection.clear();
        lineNumberSelection.clear();
        columnNumberSelection.clear();
        twelveNumberSelection.clear();
        oneThru8Selection.clear();
        nineteenThru36Selection.clear();
        evenNumberSelection.clear();
        oneThru8Selection.clear();
        blackNumberSelection.clear();
        redNumberSelection.clear();
        bettingMap.clear();
    }
}
