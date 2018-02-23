package io.zipcoder.casino.games.roulette;


import io.zipcoder.casino.core.Player;


import java.util.ArrayList;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class Roulette {
    private Player player;
    private RouletteBoardAndWheel rouletteBoardAndWheel = new RouletteBoardAndWheel();
    private RoulettePrompts prompts = new RoulettePrompts();
    private String stringResponse = "";
    private int intResponse;
    private Integer initialBalance = (int) player.getBalance().longValue();
    protected Integer currentBalance = initialBalance;
    protected TreeMap<String, ArrayList<Integer>> bettingMap = new TreeMap<>();
    protected ArrayList<Integer> singleNumberSelection = new ArrayList<>();
    protected ArrayList<Integer> doubleNumberSelection = new ArrayList<>();
    protected ArrayList<Integer> cornerNumberSelection = new ArrayList<>();
    protected ArrayList<Integer> rowNumberSelection = new ArrayList<>();
    protected ArrayList<Integer> basketNumberSelection = new ArrayList<>();
    protected ArrayList<Integer> fiveNumberSelection = new ArrayList<>();
    protected ArrayList<Integer> lineNumberSelection = new ArrayList<>();
    protected ArrayList<Integer> columnNumberSelection = new ArrayList<>();
    protected ArrayList<Integer> twelveNumberSelection = new ArrayList<>();
    protected ArrayList<Integer> oneThru18Selection = new ArrayList<>();
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

    public Roulette(Player player) {
        this.player = player;
    }

    public void play(Player player) throws InterruptedException {
        startProgram:
        while (true) {
            int betCounter = 1;
            stringResponse = prompts.welcomeMessage();
            if (stringResponse == "q") {
                break startProgram;
            } else if (stringResponse == "r") {
                prompts.rules();
            } else if (stringResponse == "b") {
                prompts.bettingInfo();
            } else if (stringResponse == "p") {
                while (intResponse != 18) {
                    intResponse = prompts.firstSetOfOptionsPrompt(betCounter);
                    if (intResponse == 17) {
                        prompts.bettingInfo();
                    }
                    switch (intResponse) {
                        case 1:
                            singleNumberSelection.add(prompts.singleNumberPrompt());
                            bettingMap.put("Single number", singleNumberSelection);
                            break;

                    }
                    betCounter++;
                }
            } else {
                System.out.println("ERROR! INVALID INPUT!\n\nRestarting game...");
                TimeUnit.SECONDS.sleep(5000);
            }
        }
        System.out.println("Thank you for playing Roulette!\n\nLoading the main menu...");
        TimeUnit.SECONDS.sleep(5000);
    }
}
