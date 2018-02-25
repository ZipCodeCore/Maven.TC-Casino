package io.zipcoder.casino;

import java.util.*;

public class Craps extends Game implements GameInterface, DiceGameInterface, GamblingInterface {

    private DiceManager crapsDice = new DiceManager(2);
    private int point = 0;
    private int passLineBet = 0;
    private int dontPassLineBet = 0;
    private int comeBet = 0;
    private int dontComeBet = 0;
    private int fieldBet = 0;
    private int passOddsBet = 0;
    private int dontPassOddsBet = 0;
    private ArrayList<Integer> fieldValues = new ArrayList<Integer>();
    private ArrayList<Integer> winLosePlaceValues = new ArrayList<Integer>();
    private HashMap<Integer, Integer> comeBetPoints = new HashMap<Integer, Integer>();
    private HashMap<Integer, Integer> dontComeBetPoints = new HashMap<Integer, Integer>();
    private HashMap<Integer, Integer> comeBetPointOdds = new HashMap<Integer, Integer>();
    private HashMap<Integer, Integer> dontComeBetPointOdds = new HashMap<Integer, Integer>();
    private HashMap<Integer, Integer> placeWinBets = new HashMap<Integer, Integer>();
    private HashMap<Integer, Integer> placeLoseBets = new HashMap<Integer, Integer>();
    private boolean keepPlaying = true;
    private Scanner userInput = new Scanner(System.in);


    Person player;


    public void rollDice() {
        crapsDice.rollAllDice();
    }

    public int getNumberOfDice() {
        return 2;
    }

    public int checkChipAmount(Person personToCheck) {
        return personToCheck.getWallet().checkChipAmount();
    }

    public void placeBet(Person personPlacingBet, int betAmount) {
        personPlacingBet.getWallet().removeChipsFromAmount(betAmount);

    }

    public int getAnte() {
        return 5;
    }

    public void bootPlayerFromGame(Person personToBoot) {
        System.out.println("You don't have enough money!");

    }

    public int checkPot() {
        return 0;
    }

    public Craps(){}

    public Craps(Person player) {
        this.player = player;
    }

    public void start() {
        System.out.println("Welcome to Craps!");
        do {
            if (player.getWallet().checkChipAmount() < 5) {
                bootPlayerFromGame(player);
                break;
            }
            firstBetChecker();
            comeOutRoll();
            quitProgram();
        } while (keepPlaying);

    }

    public void comeOutRoll() {
        System.out.println("Time to make your first roll!");
        rollDice();
        System.out.println("You rolled a " + crapsDice.getTotalValue() + "!");
        checkComeOutRoll();
    }

    private void checkComeOutRoll() {
        if (crapsDice.getTotalValue() == 2 || crapsDice.getTotalValue() == 3) {
            System.out.println("You crapped out. Pass line bets loose and Don't Pass bets win.");
            passLineBetLose();
            dontPassLineBetWin();
        } else if (crapsDice.getTotalValue() == 7 || crapsDice.getTotalValue() == 11) {
            System.out.println("You rolled a natural! Pass Line bets win and Don't Pass loses.");
            passLineBetWin();
            dontPassLineBetLose();
        } else if (crapsDice.getTotalValue() == 12) {
            System.out.println("Pass Line looses and Don't Pass bets are pushed to next round.");
            passLineBetLose();
        } else {
            System.out.println("The point is now " + crapsDice.getTotalValue());
            point = crapsDice.getTotalValue();
            phaseTwoRolls();
        }
    }

    private void phaseTwoRolls() {
        System.out.println("Time for phase two! Roll a " + point + " and not a 7!");
        do {
            createFieldValues();
            createWinLosePlaceValues();
            placeBetPhaseTwoHandler();
            rollDice();
            System.out.println("You rolled a " + crapsDice.getTotalValue() + "!");
            checkPhaseTwoRolls();
        } while (!(crapsDice.getTotalValue() == point) && !(crapsDice.getTotalValue() == 7));
    }

    public void checkPhaseTwoRolls() {
        if (crapsDice.getTotalValue() == point) {
            System.out.println("You rolled the point! Pass Line wins and Don't Pass loses!");
            checkBetHandler();
        } else if (crapsDice.getTotalValue() == 7) {
            System.out.println("You rolled a 7. Don't Pass wins and Pass Line loses!");
            checkBetHandler();
        } else {
            checkBetHandler();
        }
    }


    public void checkBetHandler() {
        passLineChecker();
        dontPassLineChecker();
        comeBetPointChecker();
        comeBetChecker();
        dontComeBetPointChecker();
        dontComeBetChecker();
        checkPassLineOdds();
        checkDontPassLineOdds();
        checkComeBetPointOdds();
        checkDontComeBetPointOdds();
        checkFieldBet();
        placeWinBetChecker();
        placeLoseBetChecker();
    }

    public void passLineChecker() {
        if (crapsDice.getTotalValue() == point && passLineBet != 0) {
            passLineBetWin();
        } else if (crapsDice.getTotalValue() == 7 && passLineBet != 0) {
            passLineBetLose();
        }
    }

    public void passLineBetWin() {
        System.out.println("Pass line bets pay 1:1. You won " + passLineBet + " chips!");
        player.getWallet().addChipsToAmount(passLineBet);
        passLineBet = 0;

    }

    public void passLineBetLose() {
        System.out.println("Pass Line lost. You lost " + passLineBet + " chips.");
        passLineBet = 0;
    }

    public void dontPassLineChecker() {
        if (crapsDice.getTotalValue() == point && dontPassLineBet != 0) {
            dontPassLineBetLose();
        } else if (crapsDice.getTotalValue() == 7 && dontPassLineBet != 0) {
            dontPassLineBetWin();
        }
    }

    public void dontPassLineBetWin() {
        System.out.println("Don't Pass bets pay 1:1. You won " + dontPassLineBet + " chips!");
        player.getWallet().addChipsToAmount(dontPassLineBet);
        dontPassLineBet = 0;
    }

    public void dontPassLineBetLose() {
        System.out.println("Don't Pass Line lost. You lost " + dontPassLineBet + " chips.");
        dontPassLineBet = 0;
    }

    public void comeBetChecker() {
        if ((crapsDice.getTotalValue() == 7 || crapsDice.getTotalValue() == 11) && comeBet != 0) {
            comeBetWin();
        } else if ((crapsDice.getTotalValue() == 2 || crapsDice.getTotalValue() == 3 || crapsDice.getTotalValue() == 12)
                && comeBet != 0) {
            comeBetLose();
        } else if (comeBet > 4){
            comeBetToComePoint();
        }
    }

    private void comeBetWin() {
        System.out.println("Come bet wins! Come bet pays 1:1. You won " + comeBet + " chips!");
        player.getWallet().addChipsToAmount(comeBet);
        comeBet = 0;
    }

    private void comeBetLose() {
        System.out.println("Come Bet loses. You lost " + comeBet + " chips.");
        comeBet = 0;
    }

    public void dontComeBetChecker() {
        if ((crapsDice.getTotalValue() == 7 || crapsDice.getTotalValue() == 11) && dontComeBet != 0) {
            dontComeBetLose();
        } else if ((crapsDice.getTotalValue() == 2 || crapsDice.getTotalValue() == 3)
                && dontComeBet != 0) {
            dontComeBetWin();
        } else if (dontComeBet > 4 && !(crapsDice.getTotalValue() ==12)) {
            dontCometoDontComePoint();
        }
    }

    private void dontComeBetWin() {
        System.out.println("Don't Come bet wins! You won " + dontComeBet + " chips!");
        player.getWallet().addChipsToAmount(dontComeBet);
        dontComeBet = 0;
    }

    private void dontComeBetLose() {
        System.out.println("Don't Come bet loses. You lost " + dontComeBet + " chips.");
        dontComeBet = 0;
    }

    public void comeBetPointChecker() {
        if (comeBetPoints.containsKey(crapsDice.getTotalValue())) {
            comeBetPointWin();
        } else if (crapsDice.getTotalValue() == 7 && !(comeBetPoints.isEmpty())) {
            comeBetPointLose();
        }
    }

    private void comeBetPointWin() {
        System.out.println("Your Come bet on point " + crapsDice.getTotalValue() + " wins! Come Bet points are 1:1. " +
                " You won " + comeBetPoints.get(crapsDice.getTotalValue()) + " chips!");
        player.getWallet().addChipsToAmount(comeBetPoints.get(crapsDice.getTotalValue()));
        comeBetPoints.remove(crapsDice.getTotalValue());
    }

    private void comeBetPointLose() {
        int totalValueOfPoints = 0;
        for (Map.Entry<Integer, Integer> entry: comeBetPoints.entrySet()) {
            totalValueOfPoints += entry.getValue();
        }
        System.out.println("Your Come bet points lost! You lost a total of " + totalValueOfPoints + " chips.");
        comeBetPoints.clear();
    }

    public void dontComeBetPointChecker() {
        if (dontComeBetPoints.containsKey(crapsDice.getTotalValue())) {
            dontComeBetPointLose();
        } else if (crapsDice.getTotalValue() == 7 && !(dontComeBetPoints.isEmpty())) {
            dontComeBetPointWin();
        }
    }

    private void dontComeBetPointWin() {
        int totalValueOfPoints = 0;
        for (Map.Entry<Integer, Integer> entry: dontComeBetPoints.entrySet()) {
            totalValueOfPoints += entry.getValue();
        }
        System.out.println("Your Don't Come bet points won! You won a total of " + totalValueOfPoints + " chips.");
        player.getWallet().addChipsToAmount(totalValueOfPoints);
        dontComeBetPoints.clear();
    }

    private void dontComeBetPointLose() {
        System.out.println("Your Don't Come bet on point " + crapsDice.getTotalValue() + " lost." +
                " You lost " + dontComeBetPoints.get(crapsDice.getTotalValue()) + " chips!");
        dontComeBetPoints.remove(crapsDice.getTotalValue());
    }

    private void comeBetToComePoint() {
        System.out.println("Your Come bet is now a point.");
        comeBetPoints.put(crapsDice.getTotalValue(), comeBet);
        comeBet = 0;
    }

    private void dontCometoDontComePoint() {
        System.out.println("You Don't Come bet is now a point.");
        dontComeBetPoints.put(crapsDice.getTotalValue(), dontComeBet);
        dontComeBet = 0;
    }

    private void checkFieldBet() {
        if (fieldValues.contains(crapsDice.getTotalValue()) && fieldBet != 0){
            if (crapsDice.getTotalValue() == 2 || crapsDice.getTotalValue() == 12) {
                fieldDoubleWin();
            } else {
                fieldWin();
            }
        } else if (fieldBet != 0) {
            fieldLose();
        }
    }

    private void fieldDoubleWin() {
        System.out.println("Field win is doubled! You wn " + fieldBet * 2 + " chips!");
        player.getWallet().addChipsToAmount(fieldBet * 2);
        fieldBet = 0;
    }

    private void fieldWin() {
        System.out.println("Field wins! Payout is 1:1. You won " + fieldBet + " chips!");
        player.getWallet().addChipsToAmount(fieldBet);
        fieldBet = 0;
    }

    private void fieldLose() {
        System.out.println("Field loses. You lost " + fieldBet + " chips.");
        fieldBet = 0;
    }

    public void checkPassLineOdds() {
        if (passOddsBet != 0 && crapsDice.getTotalValue() == point) {
            passLineOddsWin();
        } else if (passOddsBet != 0 && crapsDice.getTotalValue() ==7) {
            passLineOddsLose();
        }
    }

    private void passLineOddsWin() {
        if (point == 4 || point == 10) {
            System.out.println("Pass Line odds wins! Payout is 2:1. You won " + (passOddsBet + passOddsBet * 2) + " chips!");
            player.getWallet().addChipsToAmount(passOddsBet = passOddsBet * 2);
            passOddsBet = 0;
        } else if (point == 5 || point == 9) {
            System.out.println("Pass Line odds wins! Payout is 3:2. You won " + (passOddsBet +(int)
                    Math.floor(passOddsBet * .5)) + " chips!");
            player.getWallet().addChipsToAmount(passOddsBet + (int)Math.floor(passOddsBet * 1.5));
            passOddsBet = 0;
        } else if (point == 6 || point == 8) {
            System.out.println("Pass Line odds wins! Payout is 6:5. You won " + (passOddsBet + (int)
                    Math.floor(passOddsBet * .2)) + " chips!");
            player.getWallet().addChipsToAmount(passOddsBet + (int)Math.floor(passOddsBet * 1.2));
            passOddsBet = 0;
        }
    }

    private void passLineOddsLose() {
        System.out.println("Pass Line odds lose! You lost " + passOddsBet + " chips");
        passOddsBet = 0;
    }

    public void checkDontPassLineOdds() {
        if (dontPassOddsBet !=0 && crapsDice.getTotalValue() == point) {
            dontPassLineOddsLose();
        } else if (dontPassOddsBet != 0 && crapsDice.getTotalValue() ==7) {
            dontPassLineOddsWin();
        }
    }

    private void dontPassLineOddsWin() {
        if (point == 4 || point == 10) {
            System.out.println("Don't Pass odds wins! Payout is 1:2. You won " + (dontPassOddsBet +
                    (int)Math.floor(dontPassOddsBet * .5)) + " chips!");
            player.getWallet().addChipsToAmount(dontPassOddsBet + (int)Math.floor(dontPassOddsBet * .5));
            dontPassOddsBet = 0;
        } else if (point == 5 || point == 9) {
            System.out.println("Don't Pass odds wins! Payout is 2:3. You won " + (dontPassOddsBet +
                    (int)Math.floor(dontPassOddsBet * .66)) + " chips!");
            player.getWallet().addChipsToAmount(dontPassOddsBet + (int)Math.floor(dontPassOddsBet * .66));
            dontPassOddsBet = 0;
        } else if (point == 6 || point == 8) {
            System.out.println("Don't Pass odds wins! Payout is 5:6. You won " +(dontPassOddsBet +
                    (int)Math.floor(dontPassOddsBet * .83)) + " chips!");
            player.getWallet().addChipsToAmount((dontPassOddsBet + (int)Math.floor(dontPassOddsBet * .83)));
            dontPassOddsBet = 0;
        }
    }

    private void dontPassLineOddsLose() {
        System.out.println("Don't Pass odds lose! You lost " + dontPassOddsBet + " chips.");
        dontPassOddsBet = 0;
    }

    public void checkComeBetPointOdds() {
        if (comeBetPointOdds.containsKey(crapsDice.getTotalValue())) {
            comeBetPointOddsWin();

        } else if (crapsDice.getTotalValue() == 7 && !(comeBetPointOdds.isEmpty())) {
            comeBetPointOddsLose();
        }
    }

    private void comeBetPointOddsWin() {
        if (crapsDice.getTotalValue() == 4 || crapsDice.getTotalValue() == 10) {
            System.out.println("Your Come bet Odds on point " + crapsDice.getTotalValue() + " wins! Payout is 2:1." +
                    " You won " + (comeBetPointOdds.get(crapsDice.getTotalValue()) +
                    comeBetPointOdds.get(crapsDice.getTotalValue()) * 2)  + " chips!");
            player.getWallet().addChipsToAmount(comeBetPointOdds.get(crapsDice.getTotalValue()) +
                    comeBetPointOdds.get(crapsDice.getTotalValue()) * 2);
            comeBetPointOdds.remove(crapsDice.getTotalValue());
        } else if (crapsDice.getTotalValue() == 5 || crapsDice.getTotalValue() == 9) {
            System.out.println("Your Come bet Odds on point " + crapsDice.getTotalValue() + " wins! Payout is 3:2." +
                    " You won " + (comeBetPointOdds.get(crapsDice.getTotalValue()) +
                    (int) Math.floor(comeBetPointOdds.get(crapsDice.getTotalValue()) * 1.5))  + " chips!");
            player.getWallet().addChipsToAmount(comeBetPointOdds.get(crapsDice.getTotalValue()) +
                    (int) Math.floor(comeBetPointOdds.get(crapsDice.getTotalValue()) * 1.5));
            comeBetPointOdds.remove(crapsDice.getTotalValue());
        } else if (crapsDice.getTotalValue() == 6 || crapsDice.getTotalValue() == 8) {
            System.out.println("Your Come bet Odds on point " + crapsDice.getTotalValue() + " wins! Payout is 6:5." +
                    " You won " + (comeBetPointOdds.get(crapsDice.getTotalValue()) +
                    (int) Math.floor(comeBetPointOdds.get(crapsDice.getTotalValue()) * 1.2))  + " chips!");
            player.getWallet().addChipsToAmount(comeBetPointOdds.get(crapsDice.getTotalValue()) +
                    (int) Math.floor(comeBetPointOdds.get(crapsDice.getTotalValue()) * 1.2));
            comeBetPointOdds.remove(crapsDice.getTotalValue());
        }
    }

    private void comeBetPointOddsLose() {
        int totalValueOfPoints = 0;
        for (Map.Entry<Integer, Integer> entry: comeBetPointOdds.entrySet()) {
            totalValueOfPoints += entry.getValue();
        }
        System.out.println("Your Come bet odds lost! You lost a total of " + totalValueOfPoints + " chips.");
        comeBetPointOdds.clear();
    }

    public void checkDontComeBetPointOdds() {
        if (dontComeBetPointOdds.containsKey(crapsDice.getTotalValue())) {
            dontComeBetPointOddsLose();

        } else if (crapsDice.getTotalValue() == 7 && !(dontComeBetPointOdds.isEmpty())) {
            dontComeBetPointOddsWin();
        }
    }

    private void dontComeBetPointOddsLose() {
        System.out.println("Your Don't Come Odds bet on point " + crapsDice.getTotalValue() + " lost." +
                " You lost " + dontComeBetPointOdds.get(crapsDice.getTotalValue()) + " chips!");
        dontComeBetPoints.remove(crapsDice.getTotalValue());
    }

    private void dontComeBetPointOddsWin() {
        int grandTotal = 0;
        for (Map.Entry<Integer, Integer> entry: dontComeBetPointOdds.entrySet()) {
            if (entry.getKey() == 4 || entry.getKey() == 10) {
                System.out.println("Your Don't Come bet Odds on point " + entry.getKey() + " wins! Payout is 1:2." +
                        " You won " + (entry.getValue() +
                        (int) Math.floor(entry.getValue() * .5)) + " chips!");
                player.getWallet().addChipsToAmount(entry.getValue() +
                        (int) Math.floor(entry.getValue() * .5));
                grandTotal += (entry.getValue() +
                        (int) Math.floor(entry.getValue() * .5));
            } else if (entry.getKey() == 5 || entry.getKey() == 9) {
                System.out.println("Your Don't Come bet Odds on point " + entry.getKey() + " wins! Payout is 2:3." +
                        " You won " + (entry.getValue() +
                        (int) Math.floor(entry.getValue() * .66)) + " chips!");
                player.getWallet().addChipsToAmount(entry.getValue() +
                        (int) Math.floor(entry.getValue() * .66));
                grandTotal += (entry.getValue() +
                        (int) Math.floor(entry.getValue() * .66));
            } else if (entry.getKey() == 6 || entry.getKey() == 8) {
                System.out.println("Your Don't Come bet Odds on point " + entry.getKey() + " wins! Payout is 5:6." +
                        " You won " + (entry.getValue() +
                        (int) Math.floor(entry.getValue() * .83)) + " chips!");
                player.getWallet().addChipsToAmount(entry.getValue() +
                        (int) Math.floor(entry.getValue() * .83));
                grandTotal += (entry.getValue() +
                        (int) Math.floor(entry.getValue() * .83));
            }
        }
        dontComeBetPointOdds.clear();
        System.out.println("You won a total of " + grandTotal + " chips on Don't Come Point Odds bets!");
    }


    private void placeWinBetChecker() {
        if (placeWinBets.containsKey(crapsDice.getTotalValue())) {
            placeWinBetWin();
        } else if (crapsDice.getTotalValue() == 7 && !(placeWinBets.isEmpty())) {
            placeWinBetLose();
        }
    }

    private void placeWinBetWin() {
        if (crapsDice.getTotalValue() == 6 || crapsDice.getTotalValue() == 8) {
            System.out.println("Your Place Win bet won! Payout is 7:6. You won " + ((int) Math.floor(
                    placeWinBets.get(crapsDice.getTotalValue()) + placeWinBets.get(crapsDice.getTotalValue())
                    * 1.16)) +  " chips!");
            player.getWallet().addChipsToAmount((int) Math.floor(
                    placeWinBets.get(crapsDice.getTotalValue()) + placeWinBets.get(crapsDice.getTotalValue())
                            * 1.16));
            placeWinBets.remove(crapsDice.getTotalValue());
        } else if (crapsDice.getTotalValue() == 5 || crapsDice.getTotalValue() == 9) {
            System.out.println("Your Place Win bet won! Payout is 7:5. You won " + ((int) Math.floor(
                    placeWinBets.get(crapsDice.getTotalValue()) + placeWinBets.get(crapsDice.getTotalValue())
                            * 1.4)) +  " chips!");
            player.getWallet().addChipsToAmount((int) Math.floor(
                    placeWinBets.get(crapsDice.getTotalValue()) + placeWinBets.get(crapsDice.getTotalValue())
                            * 1.4));
            placeWinBets.remove(crapsDice.getTotalValue());
        } else if (crapsDice.getTotalValue() == 4 || crapsDice.getTotalValue() == 10) {
            System.out.println("Your Place Win bet won! Payout is 9:5. You won " + ((int) Math.floor(
                    placeWinBets.get(crapsDice.getTotalValue()) + placeWinBets.get(crapsDice.getTotalValue())
                            * 1.8)) +  " chips!");
            player.getWallet().addChipsToAmount((int) Math.floor(
                    placeWinBets.get(crapsDice.getTotalValue()) + placeWinBets.get(crapsDice.getTotalValue())
                            * 1.8));
            placeWinBets.remove(crapsDice.getTotalValue());
        }
    }

    private void placeWinBetLose() {
        int totalValueOfPoints = 0;
        for (Map.Entry<Integer, Integer> entry: placeWinBets.entrySet()) {
            totalValueOfPoints += entry.getValue();
        }
        System.out.println("Your Place Win bets lost! You lost a total of " + totalValueOfPoints + " chips.");
        placeWinBets.clear();
    }

    private void placeLoseBetChecker() {
        if (placeLoseBets.containsKey(crapsDice.getTotalValue())) {
            placeLoseBetLose();
        } else if (crapsDice.getTotalValue() == 7 && !(placeLoseBets.isEmpty())) {
            placeLoseBetWin();
        }
    }

    private void placeLoseBetLose() {
        System.out.println("Your Place Lose bet on point " + crapsDice.getTotalValue() + " lost." +
                " You lost " + placeLoseBets.get(crapsDice.getTotalValue()) + " chips!");
        placeLoseBets.remove(crapsDice.getTotalValue());
    }

    private void placeLoseBetWin() {
        int grandTotal = 0;
        for (Map.Entry<Integer, Integer> entry : placeLoseBets.entrySet()) {
            if (entry.getKey() == 6 || entry.getKey() == 8) {
                System.out.println("Your Place Lose bet on " + entry.getKey() + " won! Payout is 4:5. You won " +
                        (entry.getValue() + (int) Math.floor(entry.getValue() * .8)) + " chips!");
                player.getWallet().addChipsToAmount(entry.getValue() + (int) Math.floor(entry.getValue()
                                * .8));
                grandTotal += (entry.getValue() + (int) Math.floor(entry.getValue()
                        * .8));
            } else if (entry.getKey() == 5 || entry.getKey() == 9) {
                System.out.println("Your Place Lose bet on " + entry.getKey() + " won! Payout is 5:8. You won " +
                        (entry.getValue() + (int) Math.floor(entry.getValue() * .62)) + " chips!");
                player.getWallet().addChipsToAmount(entry.getValue() + (int) Math.floor(entry.getValue()
                                * .62));
                grandTotal += (entry.getValue() + (int) Math.floor(entry.getValue()
                        * .62));
            } else if (entry.getKey() == 4 || entry.getKey() == 10) {
                System.out.println("Your Place Lose bet on " + entry.getKey() + " won! Payout is 5:11. You won " +
                        (entry.getValue() + (int) Math.floor(entry.getValue() * .45)) + " chips!");
                player.getWallet().addChipsToAmount(entry.getValue()+ (int) Math.floor(entry.getValue()
                                * .45));
                grandTotal += (entry.getValue()+ (int) Math.floor(entry.getValue()
                        * .45));
            }
        }
        placeLoseBets.clear();
        System.out.println("You won a total of " + grandTotal + " chips on Place Lose bets!");
    }

    private void placeBetPhaseTwoHandler() {
        String userAnswer = "";
        do {
            if (player.getWallet().checkChipAmount() < 5) {
                System.out.println("You don't have enough money for more bets!");
                break;
            }
            System.out.println("What type of bet would you like to place?" +
                    "\nCome" +
                    "\nDon't Come" +
                    "\nField" +
                    "\nOdds" +
                    "\nPlace Win" +
                    "\nPlace Lose" +
                    "\nCheck Wallet Amount" +
                    "\nRoll Dice");
            userAnswer= getBetTypeInput();
            placeBetSelection(userAnswer);

        } while (!(userAnswer.equals("roll dice")));

    }

    public void placeBetSelection(String userAnswer) {
        if (userAnswer.equals("come")) {
            placeComeBet();
        } else if (userAnswer.equals("don't come")) {
            placeDontComeBet();
        } else if (userAnswer.equals("field")) {
            placeFieldBet();
        } else if (userAnswer.equals("odds")) {
            oddsTypeHandler();
        } else if (userAnswer.equals("place win")) {
            placeWinChecker();
        } else if (userAnswer.equals("place lose")) {
            placeLoseChecker();
        } else if (userAnswer.equals("check wallet amount")) {
            System.out.println(player.getWallet().checkChipAmount());
        } else if (userAnswer.equals("roll dice")) {
        } else {
            System.out.println("Input not recognized. Please try again.");
        }
    }

    private void placeComeBet() {
        System.out.println("How much would you like to bet for the Come bet?");
        comeBet += minimumBetChecker();
        placeBet(player, comeBet);
    }

    private void placeDontComeBet() {
        System.out.println("How much would you like to bet for the Don't Come bet?");
        dontComeBet += minimumBetChecker();
        placeBet(player, dontComeBet);
    }

    private void placeFieldBet() {
        System.out.println("How much would you like to bet on the Field?");
        fieldBet += minimumBetChecker();
        placeBet(player, fieldBet);
    }

    private void placeWinChecker() {
        System.out.println("Which number would you like to be on? 4, 5, 6, 8, 9, or 10");
        System.out.println(winLosePlaceValues.toString());
        int userAnswer = getBetInput();
        if (winLosePlaceValues.contains(userAnswer)) {
            System.out.println("How much would you like to bet?");
            int userBet = getBetInput();
            placeWinBets.put(userAnswer, userBet);
        } else {
            System.out.println("Input not recognized.");
        }

    }

    private void placeLoseChecker() {
        System.out.println("Which number would you like to be on? 4, 5, 6, 8, 9, or 10");
        int userAnswer = getBetInput();
        if (winLosePlaceValues.contains(userAnswer)) {
            System.out.println("How much would you like to bet?");
            int userBet = getBetInput();
            placeLoseBets.put(userAnswer, userBet);
        } else {
            System.out.println("Input not recognized.");
        }
    }

    public void firstBetChecker(){
        do {
            placePassBetChecker();
            if (player.getWallet().checkChipAmount() < 5 ) {
                System.out.println("You don't have enough money for another bet!");
            } else {
                placeDontPassLineBetChecker();
            }
            if (passLineBet == 0 && dontPassLineBet == 0) {
                System.out.println("You must place an initial bet!");
            }
        } while (passLineBet == 0 && dontPassLineBet == 0);
    }

    private void placePassBetChecker() {
        System.out.println("Would you like to place a Pass bet? Yes or no.");
        String userAnswer = "";
        do {
            userAnswer = getBetTypeInput();
            if (userAnswer.equals("yes")) {
                placePassLineBet();
            } else if (!(userAnswer.equals("yes")) && !(userAnswer.equals("no"))) {
                System.out.println("Answer not recognized. Please try again.");
            }
        } while (!(userAnswer.equals("yes")) && !(userAnswer.equals("no")));
    }

    private void placePassLineBet() {
        System.out.println("How much would you like to bet on the Pass Line?");
        passLineBet += minimumBetChecker();
        placeBet(player, passLineBet);
    }

    private void placeDontPassLineBetChecker() {
        System.out.println("Would you like to place a Don't Pass bet? Yes or no.");
        String userAnswer = "";
        do {
            userAnswer = getBetTypeInput();
            if (userAnswer.equals("yes")) {
                placeDontPassLineBet();
            } else if (!(userAnswer.equals("yes")) && !(userAnswer.equals("no"))) {
                System.out.println("Answer not recognized. Please try again.");
            }
        } while (!(userAnswer.equals("yes")) && !(userAnswer.equals("no")));
    }

    private void placeDontPassLineBet() {
        System.out.println("How much would you like to bet on the Don't Pass Line?");
        dontPassLineBet += minimumBetChecker();
        placeBet(player, dontPassLineBet);
    }

    private void oddsTypeHandler() {
        String userAnswer = "";
        do {
            System.out.println("What type of odds would you like to place?\n" +
                    "Pass\n" +
                    "Don't Pass\n" +
                    "Come\n" +
                    "Don't Come\n" +
                    "None");
            userAnswer = getBetTypeInput();
            oddsTypeSelector(userAnswer);
        } while (!(userAnswer.equals("none")));
    }

    public void oddsTypeSelector(String userAnswer) {
        if (userAnswer.equals("pass")) {
            placePassOddsBet();
        } else if (userAnswer.equals("don't pass")) {
            placeDontPassOddsBet();
        } else if (userAnswer.equals("come")) {
            placeComeOddsBet();
        } else if (userAnswer.equals("don't come")) {
            placeDontComeOddsBet();
        } else if (userAnswer.equals("none")) {

        } else {
            System.out.println("Input is not recognized. Try again.");
        }
    }

    private void placePassOddsBet() {
        if (passLineBet != 0){
            System.out.println("How much would you like to bet on Pass Line odds?");
            passOddsBet += minimumBetChecker();
            placeBet(player, passOddsBet);
        } else {
            System.out.println("You don't have a Pass Line bet!");
        }
    }

    private void placeDontPassOddsBet() {
        if (dontPassLineBet != 0) {
            System.out.println("How much would you like to bet on Don't Pass odds?");
            dontPassOddsBet += minimumBetChecker();
            placeBet(player, dontPassOddsBet);
        } else {
            System.out.println("You don't have a Don't Pass bet!");
        }
    }

    private void placeComeOddsBet() {
        if (comeBetPoints.isEmpty()) {
            System.out.println("You have no Come Bet points.");
        } else if (!(comeBetPoints.isEmpty())) {
            System.out.println("Which point would you like to put odds on?");
            System.out.println(comeBetPoints.keySet().toString());
            comeBetOddsSelector();
        }
    }

    private void comeBetOddsSelector() {
        int userAnswer = getBetInput();
        if (comeBetPoints.containsKey(userAnswer)) {
            System.out.println("How much would you like to bet?");
            int userBet = getBetInput();
            comeBetPointOdds.put(userAnswer, userBet);
        } else {
            System.out.println("That option is not available.");
        }
    }

    private void placeDontComeOddsBet() {
        if (dontComeBetPoints.isEmpty()) {
            System.out.println("You have no Don't Come Bet points.");
        } else if (!(dontComeBetPoints.isEmpty())) {
            System.out.println("Which point would you like to put odds on?");
            System.out.println(dontComeBetPoints.keySet().toString());
            dontComeBetOddsSelector();
        }
    }

    private void dontComeBetOddsSelector() {
        int userAnswer = getBetInput();
        if (dontComeBetPoints.containsKey(userAnswer)) {
            System.out.println("How much would you like to bet?");
            int userBet = getBetInput();
            dontComeBetPointOdds.put(userAnswer, userBet);
        } else {
            System.out.println("That option is not available.");
        }
    }

    private int minimumBetChecker() {
        int betAmount = 0;
        do {
            betAmount = getBetInput();
            if (betAmount < getAnte()) {
                System.out.println("The minimum bet is " + getAnte() + ". Try again.");
            }
        } while (betAmount < getAnte());
        return betAmount;
    }

    private int getBetInput() {
        try {
            int betInput = userInput.nextInt();
            userInput.nextLine();
            return betInput;
        } catch (InputMismatchException e) {
            System.out.println("That is not a number. Setting bet to 5.");
            userInput.nextLine();
            return 5;
        }
    }

    private String getBetTypeInput() {
        return userInput.nextLine().toLowerCase();
    }

    public void createFieldValues() {
        fieldValues.add(2);
        fieldValues.add(3);
        fieldValues.add(4);
        fieldValues.add(9);
        fieldValues.add(10);
        fieldValues.add(11);
        fieldValues.add(12);
    }

    private void createWinLosePlaceValues() {
        winLosePlaceValues.add(4);
        winLosePlaceValues.add(5);
        winLosePlaceValues.add(6);
        winLosePlaceValues.add(8);
        winLosePlaceValues.add(9);
        winLosePlaceValues.add(10);
    }

    private void quitProgram() {
        System.out.println("Would you like to keep playing? Yes or no.");
        String userAnswer = "";
        do {
            userAnswer = getBetTypeInput();
            if (userAnswer.equals("yes")) {
                System.out.println("New round starting!");
            } else if (userAnswer.equals("no")) {
                System.out.println("Thanks for playing!");
                keepPlaying = false;
            } else {
                System.out.println("Your answer was not recognized. Please try again.");
            }
        }while (!(userAnswer.equals("yes")) && !(userAnswer.equals("no")));
    }


    //Testing methods
    public Person getPlayer() {
        return player;
    }

    public DiceManager getDiceManager() {
        return crapsDice;
    }

    public void setPassLineBet(int testInput) {
        passLineBet = testInput;
    }

    public void setDontPassLineBet(int testInput) {
        dontPassLineBet = testInput;
    }

    public void setPoint(int testInput) {
        point = testInput;
    }

    public void setComeBet(int testInput) {
        comeBet = testInput;
    }

    public void setDontComeBet(int testInput) {
        dontComeBet = testInput;
    }

    public void setFieldBet( int testInput) {
        fieldBet = testInput;
    }

    public void setPassOddsBet(int testInput) {
        passOddsBet = testInput;
    }

    public void setDontPassOddsBet(int testInput) {
        dontPassOddsBet = testInput;
    }

    public void setComeBetPoints(int testInput1, int testInput2){
        comeBetPoints.put(testInput1,testInput2);
    }

    public void setDontComeBetPoints(int testInput1, int testInput2) {
        dontComeBetPoints.put(testInput1, testInput2);
    }

    public void setComeBetPointOdds(int testInput1, int testInput2) {
        comeBetPointOdds.put(testInput1, testInput2);
    }

    public void setDontComeBetPointOdds(int testInput1, int testInput2) {
        dontComeBetPointOdds.put(testInput1,testInput2);
    }

    public void setPlaceWinBets(int testInput1, int testInput2) {
        placeWinBets.put(testInput1, testInput2);
    }

    public void setPlaceLoseBets(int testInput1, int testInput2) {
        placeLoseBets.put(testInput1, testInput2);
    }
}
