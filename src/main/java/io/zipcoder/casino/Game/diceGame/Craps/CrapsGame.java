package io.zipcoder.casino.Game.diceGame.Craps;


import io.zipcoder.casino.CasinoUtilities.Console;
import io.zipcoder.casino.Game.diceGame.DiceGame;
import io.zipcoder.casino.Profile;
import io.zipcoder.casino.TypeOfBet;

import java.util.Arrays;

public class CrapsGame extends DiceGame {
    private int point;
    boolean isComeOutPhase = true;
    private CrapsPlayer currentPlayer;
    private boolean newRound = true;
    private boolean hardRoll = false;


    public CrapsGame(Profile profile) {
        this.currentPlayer = new CrapsPlayer(profile);
    }

    public static void main(String[] args) {
        Profile stinkyProfile = new Profile("Stinky Pete", 1000, 11);
        CrapsGame testGame = new CrapsGame(stinkyProfile);
        testGame.startGame();
        testGame.turn();
    }

    public void comeOutPhase() {
        Console.print(bar);
        Console.print("The game is in the Come Out phase");
        this.printComePoints();
        this.printDontComePoints();
        int roll = this.getRollValue();
        if (isNatural(roll)) {
            Console.print("You rolled a Natural");
            if(roll == 7){
                this.comePointPayout(roll);
                this.hardWayPayouts(roll);
                this.dontComePointPayout(roll);
                this.bigSixPayout(roll);
                this.bigEightPayout(roll);
                this.oneRollBetPayouts(roll);
            }
            this.oneRollBetPayouts(roll);
            this.rollIsNaturalPayout();
            this.newRound = true;
            this.hardRoll = false;
            this.turn();
        } else if (isCraps(roll)) {
            Console.print("You rolled Craps");
            this.oneRollBetPayouts(roll);
            this.rollIsCrapsPayout(roll);
            this.newRound = true;
            this.hardRoll = false;
            this.turn();
        } else {
            this.point = roll;
            this.hardWayPayouts(roll);
            this.oneRollBetPayouts(roll);
            this.comePointPayout(roll);
            this.dontComePointPayout(roll);
            this.bigSixPayout(roll);
            this.bigEightPayout(roll);
            Console.print("The game is entering the Point phase");
            Console.print("The point is set to: [" + this.point +"]");
            this.isComeOutPhase = false;
            this.hardRoll = false;
            this.turn();
        }
    }

    public void pointPhase() {
        Console.print(bar);
        Console.print("The game is in the Point phase");
        Console.print("The Point is set to: [" + this.point + "]");
        this.printComePoints();
        this.printDontComePoints();
        int roll = this.getRollValue();
        if (roll == this.point) {
            this.oneRollBetPayouts(roll);
            this.hardWayPayouts(roll);
            this.passLinePayout();
            this.dontComePointPayout(roll);
            this.comePointPayout(roll);
            this.newComePoint(roll);
            this.bigSixPayout(roll);
            this.bigEightPayout(roll);

            if(currentPlayer.hasOdds() && currentPlayer.isPassLine()){
                this.passLineOddsPayout(roll);
                currentPlayer.setOdds(false);
            }
            else if(currentPlayer.hasOdds() && !currentPlayer.isPassLine()){
                this.doNotPassOddsPayout(1);
                currentPlayer.setOdds(false);
            }

            this.newRound = true;
            Console.print("The game is entering the Come Out Phase");
            this.isComeOutPhase = true;
            this.hardRoll = false;
            this.turn();
        } else if (roll == 7) {
            this.oneRollBetPayouts(roll);
            this.hardWayPayouts(roll);
            this.doNotPassPayout();
            this.comeNaturalPayout(roll);
            this.comePointPayout(roll);
            this.dontComePointPayout(roll);
            this.bigSixPayout(roll);
            this.bigEightPayout(roll);

            if(currentPlayer.hasOdds() && !currentPlayer.isPassLine()){
                this.doNotPassOddsPayout(this.point);
                currentPlayer.setOdds(false);
            }
            else if(currentPlayer.hasOdds() && currentPlayer.isPassLine()){
                this.passLineOddsPayout(1);
                currentPlayer.setOdds(false);
            }

            this.newRound = true;
            Console.print("The game is entering the Come Out Phase");
            this.isComeOutPhase = true;
            this.hardRoll = false;
            this.turn();
        }
        else if(!isCraps(roll) && roll != 11){
            this.oneRollBetPayouts(roll);
            this.hardWayPayouts(roll);
            this.comePointPayout(roll);
            this.dontComePointPayout(roll);
            this.newComePoint(roll);
            this.newDontComePoint(roll);
            this.bigSixPayout(roll);
            this.bigEightPayout(roll);
            this.hardRoll = false;
            this.turn();
        }
        else {
            this.oneRollBetPayouts(roll);
            this.hardWayPayouts(roll);
            this.comeNaturalPayout(roll);
            this.doNotComeCrapsPayout(roll);
            this.bigSixPayout(roll);
            this.bigEightPayout(roll);
            this.hardRoll = false;
            this.turn();
        }
    }

    public void turn() {

        String rollOrBet;
        do {
            Console.print(bar);
            Console.print("Would you like to [roll] or [bet]?");
            rollOrBet = Console.getString();
            if (rollOrBet.equalsIgnoreCase("roll") && newRound) {
                Console.print("You must make a Pass Line or Do Not Pass bet before starting a new round");
                this.turn();
            } else if (rollOrBet.equalsIgnoreCase("roll")) {
                if (isComeOutPhase) {
                    this.comeOutPhase();
                } else {
                    this.pointPhase();
                }
            } else if (rollOrBet.equalsIgnoreCase("bet")) {
                Console.print(bar);
                this.selectBet();
            } else {
                Console.print(invalidInput);
            }
        }
        while (!rollOrBet.equalsIgnoreCase("roll"));
    }

    public void selectBet() {
        boolean keepRunning = true;
        do {
            Console.print(this.printBettingMenu());
            Console.print("What type of bet would you like to place?");
            Console.print("Enter [stop] to finish betting");
            String textBet = Console.getString();
            keepRunning = this.chooseBet(textBet);

        }
        while (keepRunning == true);

    }

    public boolean chooseBet(String textBet) {
        boolean validBet;
        TypeOfBet betType;
        textBet = textBet.toLowerCase();
        switch (textBet) {

            case "stop":
                return false;

            case "pass line":
                if (!newRound && isInvalidBet(!currentPlayer.isPassLine() || !this.isComeOutPhase)) {
                    break;
                }
                betType = CrapsBet.PASS_LINE;
                validBet = this.placeBet(betType);
                if (validBet) {
                    currentPlayer.setPassLine(true);
                    newRound = false;
                }
                break;

            case "do not pass":
                if (!newRound && isInvalidBet(currentPlayer.isPassLine() || !this.isComeOutPhase)) {
                    break;
                }
                betType = CrapsBet.DO_NOT_PASS;
                validBet = this.placeBet(betType);
                if (validBet) {
                    currentPlayer.setPassLine(false);
                    newRound = false;
                }
                break;

            case "pass line odds":
                if (isInvalidBet(!currentPlayer.isPassLine() || this.isComeOutPhase)) {
                    break;
                }
                betType = CrapsBet.PASS_LINE_ODDS;
                validBet = this.placeBet(betType);
                if (validBet) {
                    currentPlayer.setOdds(true);
                }
                break;

            case "do not pass odds":
                if (isInvalidBet(currentPlayer.isPassLine() || this.isComeOutPhase)) {
                    break;
                }
                betType = CrapsBet.DO_NOT_PASS_ODDS;
                validBet = this.placeBet(betType);
                if (validBet) {
                    currentPlayer.setOdds(true);
                }
                break;

            case "come":
                if(isInvalidBet(currentPlayer.isDontCome() || this.isComeOutPhase)){
                    break;
                }
                betType = CrapsBet.COME;
                validBet = this.placeBet(betType);
                if(validBet){
                    currentPlayer.setCome(true);
                }
                break;

            case "do not come":
                if(isInvalidBet(currentPlayer.isCome() || this.isComeOutPhase)){
                    break;
                }
                betType = CrapsBet.DO_NOT_COME;
                validBet = this.placeBet(betType);
                if(validBet){
                    currentPlayer.setDontCome(true);
                }
                break;

            case "big six":
                betType = CrapsBet.BIG_SIX;
                validBet = this.placeBet(betType);
                if(validBet){
                    currentPlayer.setBigSix(true);
                }
                break;

            case "big eight":
                betType = CrapsBet.BIG_EIGHT;
                validBet = this.placeBet(betType);
                if(validBet){
                    currentPlayer.setBigEight(true);
                }
                break;

            case "field":
                betType = CrapsBet.FIELD;
                validBet = this.placeBet(betType);
                if(validBet){
                    currentPlayer.setField(true);
                }
                break;

            case "hard four":
                betType = CrapsBet.HARD_FOUR;
                validBet = this.placeBet(betType);
                if(validBet){
                    currentPlayer.setHardFour(true);
                }
                break;

            case "hard six":
                betType = CrapsBet.HARD_SIX;
                validBet = this.placeBet(betType);
                if(validBet){
                    currentPlayer.setHardSix(true);
                }
                break;

            case "hard eight":
                betType = CrapsBet.HARD_EIGHT;
                validBet = this.placeBet(betType);
                if(validBet){
                    currentPlayer.setHardEight(true);
                }
                break;

            case "hard ten":
                betType = CrapsBet.HARD_TEN;
                validBet = this.placeBet(betType);
                if(validBet){
                    currentPlayer.setHardTen(true);
                }
                break;

            default:
                Console.print(invalidInput);
                Console.print(bar);
        }
        return true;
    }

    public boolean isInvalidBet(boolean betCondition) {
        if (betCondition) {
            Console.print("You cannot place that type of bet at this time");
            Console.print(bar);
            return true;
        }
        return false;
    }


    public String printBettingMenu() {
        StringBuilder bettingMenu = new StringBuilder("Here are the types of bets you can make: \n");
        if ((newRound || currentPlayer.isPassLine()) && this.isComeOutPhase) {
            bettingMenu.append("[Pass Line] \n");
        }
        if ((newRound || !currentPlayer.isPassLine()) && this.isComeOutPhase) {
            bettingMenu.append("[Do Not Pass]\n");
        }
        if ((newRound || currentPlayer.isPassLine()) && !this.isComeOutPhase) {
            bettingMenu.append("[Pass Line Odds] \n");
        }
        if ((newRound || !currentPlayer.isPassLine()) && !this.isComeOutPhase) {
            bettingMenu.append("[Do Not Pass Odds]\n");
        }
        if(!this.isComeOutPhase && !currentPlayer.isDontCome()){
            bettingMenu.append("[Come]\n");
        }
        if(!this.isComeOutPhase && !currentPlayer.isCome()){
            bettingMenu.append("[Do Not Come]\n");
        }
        bettingMenu.append("[Big Six]\n");
        bettingMenu.append("[Big Eight]\n");
        bettingMenu.append("[Field]\n");
        bettingMenu.append("[Hard Four]\n");
        bettingMenu.append("[Hard Six]\n");
        bettingMenu.append("[Hard Eight]\n");
        bettingMenu.append("[Hard Ten]\n");
        return bettingMenu.toString();
    }

    public boolean placeBet(TypeOfBet betType) {
        Double betAmount;
        boolean keepRunning = true;
        do {
            Console.print(bar);
            Console.print("Your current balance is: $" + currentPlayer.getProfile().getAccountBalance());
            Console.print("How much would you like to bet?");
            betAmount = Console.getDouble();
            if(betAmount >=0 && betAmount<0.01){
                Console.print("Cannot bet fractions of a cent.  Please enter a valid bet");
            }
            else if(betAmount >=0){
                keepRunning = false;
            }
            else if(betAmount == -0.001){
                continue;
            }
            else if(betAmount <0){
                Console.print("Cannot bet negative values.  Please enter a valid bet");
            }
        }
        while(keepRunning);
        boolean wasBetPlaced = currentPlayer.bet(betType, betAmount);
        Console.print(bar);
        Console.print(newBalance());
        return wasBetPlaced;
    }

    public void rollIsNaturalPayout() {
        if (currentPlayer.isPassLine()) {
            Console.print("Your Pass Line bet pays even money!");
            currentPlayer.win(CrapsBet.PASS_LINE, 1);
            Console.print(newBalance());
        } else if (!currentPlayer.isPassLine()) {
            Console.print("Your Do Not Pass bet loses");
            currentPlayer.lose(CrapsBet.DO_NOT_PASS);
            Console.print(newBalance());
        }
    }

    public void rollIsCrapsPayout(int roll) {
        if (currentPlayer.isPassLine()) {
            Console.print("You Crapped Out");
            Console.print("Your Pass Line bet loses");
            currentPlayer.lose(CrapsBet.PASS_LINE);
            Console.print(newBalance());
        } else if (!currentPlayer.isPassLine() && roll == 12) {
            Console.print("Your Do Not Pass bet breaks even");
            currentPlayer.win(CrapsBet.DO_NOT_PASS, 0);
            Console.print(newBalance());
        } else if (!currentPlayer.isPassLine()) {
            Console.print("Your Do Not Pass bet pays even money!");
            currentPlayer.win(CrapsBet.DO_NOT_PASS, 1);
            Console.print(newBalance());
        }
    }

    public void passLinePayout() {
        if (currentPlayer.isPassLine()) {
            Console.print("Your made your Point!");
            Console.print("Your Pass Line bet pays even money!");
            currentPlayer.win(CrapsBet.PASS_LINE, 1);
            Console.print(newBalance());
        } else if (!currentPlayer.isPassLine()) {
            Console.print("The Point came before a 7");
            Console.print("Your Do Not Pass bet loses");
            currentPlayer.lose(CrapsBet.DO_NOT_PASS);
            Console.print(newBalance());
        }
    }

    public void doNotPassPayout() {
        if (currentPlayer.isPassLine()) {
            Console.print("A 7 came before the Point");
            Console.print("You Sevened Out");
            Console.print("Your Pass Line bet loses");
            currentPlayer.lose(CrapsBet.PASS_LINE);
            Console.print(newBalance());
        } else if (!currentPlayer.isPassLine()) {
            Console.print("A 7 came before the Point!");
            Console.print("Your Do Not Pass bet pays even money!");
            currentPlayer.win(CrapsBet.DO_NOT_PASS, 1);
            Console.print(newBalance());
        }

    }

    public void passLineOddsPayout(int roll){
        if(roll == 4 || roll == 10){
            Console.print("Your Pass Line Odds bet pays 2:1!");
            currentPlayer.win(CrapsBet.PASS_LINE_ODDS, 2);
            Console.print(newBalance());
        }
        else if(roll == 5 || roll == 9){
            Console.print("Your Pass Line Odds bet pays 3:2!");
            currentPlayer.win(CrapsBet.PASS_LINE_ODDS, 1.5);
            Console.print(newBalance());
        }
        else if(roll == 6 || roll == 8){
            Console.print("Your Pass Line Odds bet pays 6:5!");
            currentPlayer.win(CrapsBet.PASS_LINE_ODDS, 1.2);
            Console.print(newBalance());
        }
        else{
            Console.print("Your Pass Line Odds bet loses");
            currentPlayer.lose(CrapsBet.PASS_LINE_ODDS);
            Console.print(newBalance());
        }
    }

    public void doNotPassOddsPayout(int point){
        if(point == 4 || point == 10){
            Console.print("Your Do Not Pass Odds bet pays 1:2!");
            currentPlayer.win(CrapsBet.DO_NOT_PASS_ODDS, .5);
            Console.print(newBalance());
        }
        else if(point == 5 || point == 9){
            Console.print("Your Do Not Pass Odds bet pays 2:3!");
            currentPlayer.win(CrapsBet.DO_NOT_PASS_ODDS, .66);
            Console.print(newBalance());
        }
        else if(point == 6 || point == 8){
            Console.print("Your Do Not Pass Odds bet pays 5:6!");
            currentPlayer.win(CrapsBet.DO_NOT_PASS_ODDS, .83);
            Console.print(newBalance());
        }
        else{
            Console.print("Your Do Not Pass Odds bet loses");
            currentPlayer.lose(CrapsBet.DO_NOT_PASS_ODDS);
            Console.print(newBalance());
        }

    }

    public void comeNaturalPayout(int roll){
        if(currentPlayer.isCome() && isNatural(roll)){
            Console.print("Your Come bet pays even money!");
            currentPlayer.win(CrapsBet.COME,1);
            Console.print(newBalance());
            currentPlayer.setCome(false);
        }
        else if(currentPlayer.isDontCome() && isNatural(roll)){
            Console.print("Your Do Not Come bet loses");
            currentPlayer.lose(CrapsBet.DO_NOT_COME);
            Console.print(newBalance());
            currentPlayer.setDontCome(false);
        }

    }

    public void doNotComeCrapsPayout(int roll){
        if(currentPlayer.isDontCome() && (roll == 2 || roll == 3)){
            Console.print("Your Do Not Come bet wins even money!");
            currentPlayer.win(CrapsBet.DO_NOT_COME, 1);
            Console.print(newBalance());
            currentPlayer.setDontCome(false);
        }
        else if(currentPlayer.isDontCome() && roll == 12){
            Console.print("Your Do Not Come bet breaks even");
            currentPlayer.win(CrapsBet.DO_NOT_COME, 0);
            Console.print(newBalance());
            currentPlayer.setDontCome(false);
        }
        else if(currentPlayer.isCome() && isCraps(roll)){
            Console.print("Your Come bet loses");
            currentPlayer.lose(CrapsBet.COME);
            Console.print(newBalance());
            currentPlayer.setCome(false);
        }

    }

    public void changeComeBet(int roll){
        double betValue;
        switch(roll){

            case 4:
                betValue = currentPlayer.getEscrowBet(CrapsBet.COME);
                currentPlayer.setEscrow(CrapsBet.COME,0);
                currentPlayer.setEscrow(CrapsBet.COME_FOUR, betValue);
                break;

            case 5:
                betValue = currentPlayer.getEscrowBet(CrapsBet.COME);
                currentPlayer.setEscrow(CrapsBet.COME,0);
                currentPlayer.setEscrow(CrapsBet.COME_FIVE, betValue);
                break;

            case 6:
                betValue = currentPlayer.getEscrowBet(CrapsBet.COME);
                currentPlayer.setEscrow(CrapsBet.COME,0);
                currentPlayer.setEscrow(CrapsBet.COME_SIX, betValue);
                break;

            case 8:
                betValue = currentPlayer.getEscrowBet(CrapsBet.COME);
                currentPlayer.setEscrow(CrapsBet.COME,0);
                currentPlayer.setEscrow(CrapsBet.COME_EIGHT, betValue);
                break;

            case 9:
                betValue = currentPlayer.getEscrowBet(CrapsBet.COME);
                currentPlayer.setEscrow(CrapsBet.COME,0);
                currentPlayer.setEscrow(CrapsBet.COME_NINE, betValue);
                break;

            case 10:
                betValue = currentPlayer.getEscrowBet(CrapsBet.COME);
                currentPlayer.setEscrow(CrapsBet.COME,0);
                currentPlayer.setEscrow(CrapsBet.COME_TEN, betValue);
                break;

        }

    }

    public void setComePoint(int roll){
        currentPlayer.getComePoints().add(roll);
    }

    public void changeDontComeBet(int roll){
        double betValue;
        switch(roll){

            case 4:
                betValue = currentPlayer.getEscrowBet(CrapsBet.DO_NOT_COME);
                currentPlayer.setEscrow(CrapsBet.DO_NOT_COME,0);
                currentPlayer.setEscrow(CrapsBet.DO_NOT_COME_FOUR, betValue);
                break;

            case 5:
                betValue = currentPlayer.getEscrowBet(CrapsBet.DO_NOT_COME);
                currentPlayer.setEscrow(CrapsBet.DO_NOT_COME,0);
                currentPlayer.setEscrow(CrapsBet.DO_NOT_COME_FIVE, betValue);
                break;

            case 6:
                betValue = currentPlayer.getEscrowBet(CrapsBet.DO_NOT_COME);
                currentPlayer.setEscrow(CrapsBet.DO_NOT_COME,0);
                currentPlayer.setEscrow(CrapsBet.DO_NOT_COME_SIX, betValue);
                break;

            case 8:
                betValue = currentPlayer.getEscrowBet(CrapsBet.DO_NOT_COME);
                currentPlayer.setEscrow(CrapsBet.DO_NOT_COME,0);
                currentPlayer.setEscrow(CrapsBet.DO_NOT_COME_EIGHT, betValue);
                break;

            case 9:
                betValue = currentPlayer.getEscrowBet(CrapsBet.DO_NOT_COME);
                currentPlayer.setEscrow(CrapsBet.DO_NOT_COME,0);
                currentPlayer.setEscrow(CrapsBet.DO_NOT_COME_NINE, betValue);
                break;

            case 10:
                betValue = currentPlayer.getEscrowBet(CrapsBet.DO_NOT_COME);
                currentPlayer.setEscrow(CrapsBet.DO_NOT_COME,0);
                currentPlayer.setEscrow(CrapsBet.DO_NOT_COME_TEN, betValue);
                break;

        }

    }

    public void setDontComePoint(int roll){
        currentPlayer.getDontComePoints().add(roll);
    }

    public void newComePoint(int roll){
        if(currentPlayer.isCome()){
            this.changeComeBet(roll);
            this.setComePoint(roll);
            currentPlayer.setCome(false);
            Console.print("You have a new Come Point: [" + roll +"]");
        }
    }

    public void newDontComePoint(int roll){
        if(currentPlayer.isDontCome()){
            this.changeDontComeBet(roll);
            this.setDontComePoint(roll);
            currentPlayer.setDontCome(false);
            Console.print("You have a new Do Not Come Point: [" + roll +"]");
        }
    }

    public void comePointPayout(int roll){
        if(currentPlayer.hasComePoints()){
            if(currentPlayer.getComePoints().contains(roll)){
                Console.print("You made your Come Point before a 7 was rolled!");
                Console.print("Your Come bet on [" + roll + "] pays even money!");
                currentPlayer.win(intToComePoint(roll), 1);
                currentPlayer.removeComePoint(roll);
                Console.print(newBalance());
            }
            else if(roll == 7){
                Console.print("A 7 came before your Come Point");
                for(int i = 0; i<currentPlayer.getComePoints().size(); i++){
                    Console.print("Your Come bet on [" + currentPlayer.getComePoints().get(i) + "] loses");
                    currentPlayer.lose(intToComePoint(currentPlayer.getComePoints().get(i)));
                }
                Console.print(newBalance());
                currentPlayer.getComePoints().clear();
            }
        }

    }

    public void dontComePointPayout(int roll){
        if(currentPlayer.hasDontComePoints()){
            if(currentPlayer.getDontComePoints().contains(roll)){
                Console.print("Your Do Not Come Point came before a 7");
                Console.print("Your Do Not Come bet on [" + roll + "] loses");
                currentPlayer.lose(intToDontComePoint(roll));
                currentPlayer.removeDontComePoint(roll);
                Console.print(newBalance());
            }
            else if(roll == 7){
                Console.print("A 7 came before your Do Not Come Point!");
                for(int i = 0; i<currentPlayer.getDontComePoints().size(); i++){
                    Console.print("Your Do Not Come bet on [" + currentPlayer.getDontComePoints().get(i) + "] pays even money!");
                    currentPlayer.win(intToDontComePoint(currentPlayer.getDontComePoints().get(i)), 1);
                }
                Console.print(newBalance());
                currentPlayer.getDontComePoints().clear();
            }
        }
    }

    public CrapsBet intToComePoint (int roll){
        switch (roll){
            case 4:
                return CrapsBet.COME_FOUR;

            case 5:
                return CrapsBet.COME_FIVE;

            case 6:
                return CrapsBet.COME_SIX;

            case 8:
                return CrapsBet.COME_EIGHT;

            case 9:
                return CrapsBet.COME_NINE;

            case 10:
                return CrapsBet.COME_TEN;

        }
        return null;
    }

    public CrapsBet intToDontComePoint (int roll){
        switch (roll){
            case 4:
                return CrapsBet.DO_NOT_COME_FOUR;

            case 5:
                return CrapsBet.DO_NOT_COME_FIVE;

            case 6:
                return CrapsBet.DO_NOT_COME_SIX;

            case 8:
                return CrapsBet.DO_NOT_COME_EIGHT;

            case 9:
                return CrapsBet.DO_NOT_COME_NINE;

            case 10:
                return CrapsBet.DO_NOT_COME_TEN;

        }
        return null;
    }

    public void printComePoints(){
        if (currentPlayer.hasComePoints()){
            StringBuilder pointsList = new StringBuilder();
            for(int i = 0; i< currentPlayer.getComePoints().size(); i++){
                pointsList.append("[" + currentPlayer.getComePoints().get(i) + "] ");
            }
            Console.print("Your current Come Points are: " + pointsList.toString());
        }
    }

    public void printDontComePoints(){
        if (currentPlayer.hasDontComePoints()){
            StringBuilder pointsList = new StringBuilder();
            for(int i = 0; i< currentPlayer.getDontComePoints().size(); i++){
                pointsList.append("[" + currentPlayer.getDontComePoints().get(i) + "] ");
            }
            Console.print("Your current Do Not Come Points are: " + pointsList.toString());
        }
    }

    public void bigSixPayout(int roll){
        if(currentPlayer.isBigSix()){
            if(roll == 6){
                Console.print("You rolled a 6 before a 7!");
                Console.print("Your Big Six bet pays even money!");
                currentPlayer.win(CrapsBet.BIG_SIX, 1);
                currentPlayer.setBigSix(false);
                Console.print(newBalance());
            }
            else if(roll == 7){
                Console.print("A 7 came before a 6");
                Console.print("Your Big Six bet loses");
                currentPlayer.lose(CrapsBet.BIG_SIX);
                currentPlayer.setBigSix(false);
                Console.print(newBalance());
            }
        }
    }

    public void bigEightPayout(int roll){
        if(currentPlayer.isBigEight()){
            if(roll == 8){
                Console.print("You rolled a 8 before a 7!");
                Console.print("Your Big Eight bet pays even money!");
                currentPlayer.win(CrapsBet.BIG_EIGHT, 1);
                currentPlayer.setBigEight(false);
                Console.print(newBalance());
            }
            else if(roll == 7){
                Console.print("A 7 came before a 8");
                Console.print("Your Big Eight bet loses");
                currentPlayer.lose(CrapsBet.BIG_EIGHT);
                currentPlayer.setBigEight(false);
                Console.print(newBalance());
            }
        }

    }

    public void fieldPayout(int roll){
        if(currentPlayer.isField()){
            if(roll == 2){
                Console.print("Your Field bet pays 2:1 on a 2!");
                currentPlayer.win(CrapsBet.FIELD,2);
                currentPlayer.setField(false);
                Console.print(newBalance());
            }
            else if(roll == 3 || roll == 4 || roll == 9 || roll == 10 || roll == 11){
                Console.print("Your Field bet pays even money on a " + roll + "!");
                currentPlayer.win(CrapsBet.FIELD,1);
                currentPlayer.setField(false);
                Console.print(newBalance());
            }
            else if(roll == 12){
                Console.print("Your Field bet pays 3:1 on a 12!");
                currentPlayer.win(CrapsBet.FIELD,3);
                currentPlayer.setField(false);
                Console.print(newBalance());
            }
            else{
                Console.print("Your Field bet loses");
                currentPlayer.lose(CrapsBet.FIELD);
                currentPlayer.setField(false);
                Console.print(newBalance());
            }
        }

    }

    public void hardFourPayout(int roll){
        if (currentPlayer.isHardFour()){
            if(this.hardRoll == true && roll == 4){
                Console.print("You rolled a Hard Four!");
                Console.print("Your Hard Four bet pays 7:1!");
                currentPlayer.win(CrapsBet.HARD_FOUR,7);
                currentPlayer.setHardFour(false);
                Console.print(newBalance());
            }
            else if(this.hardRoll == false && roll == 4){
                Console.print("A Soft Four came before a Hard Four");
                Console.print("Your Hard Four bet loses");
                currentPlayer.lose(CrapsBet.HARD_FOUR);
                currentPlayer.setHardFour(false);
                Console.print(newBalance());
            }
            else if(roll == 7){
                Console.print("A 7 came before a Hard Four");
                Console.print("Your Hard Four bet loses");
                currentPlayer.lose(CrapsBet.HARD_FOUR);
                currentPlayer.setHardFour(false);
                Console.print(newBalance());
            }
        }

    }

    public void hardSixPayout(int roll){
        if (currentPlayer.isHardSix()){
            if(this.hardRoll == true && roll == 6){
                Console.print("You rolled a Hard Six!");
                Console.print("Your Hard Six bet pays 9:1!");
                currentPlayer.win(CrapsBet.HARD_SIX,9);
                currentPlayer.setHardSix(false);
                Console.print(newBalance());
            }
            else if(this.hardRoll == false && roll == 6){
                Console.print("A Soft Six came before a Hard Six");
                Console.print("Your Hard Six bet loses");
                currentPlayer.lose(CrapsBet.HARD_SIX);
                currentPlayer.setHardSix(false);
                Console.print(newBalance());
            }
            else if(roll == 7){
                Console.print("A 7 came before a Hard Six");
                Console.print("Your Hard Six bet loses");
                currentPlayer.lose(CrapsBet.HARD_SIX);
                currentPlayer.setHardSix(false);
                Console.print(newBalance());
            }
        }

    }

    public void hardEightPayout(int roll){
        if (currentPlayer.isHardEight()){
            if(this.hardRoll == true && roll == 8){
                Console.print("You rolled a Hard Eight!");
                Console.print("Your Hard Eight bet pays 9:1!");
                currentPlayer.win(CrapsBet.HARD_EIGHT,9);
                currentPlayer.setHardEight(false);
                Console.print(newBalance());
            }
            else if(this.hardRoll == false && roll == 8){
                Console.print("A Soft Eight came before a Hard Eight");
                Console.print("Your Hard Eight bet loses");
                currentPlayer.lose(CrapsBet.HARD_EIGHT);
                currentPlayer.setHardEight(false);
                Console.print(newBalance());
            }
            else if(roll == 7){
                Console.print("A 7 came before a Hard Eight");
                Console.print("Your Hard Eight bet loses");
                currentPlayer.lose(CrapsBet.HARD_EIGHT);
                currentPlayer.setHardEight(false);
                Console.print(newBalance());
            }
        }

    }

    public void hardTenPayout(int roll){
        if (currentPlayer.isHardTen()){
            if(this.hardRoll == true && roll == 10){
                Console.print("You rolled a Hard Ten!");
                Console.print("Your Hard Ten bet pays 7:1!");
                currentPlayer.win(CrapsBet.HARD_TEN,7);
                currentPlayer.setHardTen(false);
                Console.print(newBalance());
            }
            else if(this.hardRoll == false && roll == 10){
                Console.print("A Soft Ten came before a Hard Ten");
                Console.print("Your Hard Ten bet loses");
                currentPlayer.lose(CrapsBet.HARD_TEN);
                currentPlayer.setHardTen(false);
                Console.print(newBalance());
            }
            else if(roll == 7){
                Console.print("A 7 came before a Hard Ten");
                Console.print("Your Hard Ten bet loses");
                currentPlayer.lose(CrapsBet.HARD_TEN);
                currentPlayer.setHardTen(false);
                Console.print(newBalance());
            }
        }

    }

    public void hardWayPayouts(int roll){
        this.hardFourPayout(roll);
        this.hardSixPayout(roll);
        this.hardEightPayout(roll);
        this.hardTenPayout(roll);
    }

    public void oneRollBetPayouts(int roll){
        this.fieldPayout(roll);
    }



    public int getRollValue() {
        int[] rawRoll = this.rollDice();

        int sum = 0;
        for (int i : rawRoll) {
            sum += i;
        }
        Console.print(Arrays.toString(rawRoll) + "\n<<You rolled a [" + sum + "]>>");
        if(rawRoll[0] == rawRoll[1]){
            this.hardRoll = true;
        }
        return sum;
    }

    public void setHardRoll(boolean input){
        this.hardRoll = input;
    }

    public static boolean isCraps(int rollValue) {
        if (rollValue == 2 || rollValue == 3 || rollValue == 12) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNatural(int rollValue) {
        if (rollValue == 7 || rollValue == 11) {
            return true;
        } else {
            return false;
        }

    }

    public int getPoint() {
        return this.point;
    }

    @Override
    public void startGame() {
        this.createDie(6, 2);
        this.point = 0;
    }

    public CrapsPlayer getCurrentPlayer() {
        return this.currentPlayer;
    }


    private String invalidInput = "Invalid input: please enter your choice again";
    private String bar = "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$";

    public String newBalance() {
        return "Your new balance is: $" + currentPlayer.getProfile().getAccountBalance();
    }
}
