package io.zipcoder.casino.games.roulette;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RouletteGamble {
    /**
     * this class will hold stats, therefore calculating chips winnings and losses
     */

    private Integer initialBalance;
    private Integer atTurnStartBalance;
    private Integer currentBalance;
    private HashMap<String, Integer> bettingMultipliers = new HashMap<>();

    public RouletteGamble() {
        bettingMultipliers.put("Single Number", 35);
        bettingMultipliers.put("Double Number", 17);
        bettingMultipliers.put("Corner", 8);
        bettingMultipliers.put("Straight", 11);
        bettingMultipliers.put("Basket", 11);
        bettingMultipliers.put("Five Number Bet", 6);
        bettingMultipliers.put("Line Bet", 5);
        bettingMultipliers.put("Column Bet", 2);
        bettingMultipliers.put("12 Number Bet", 2);
        bettingMultipliers.put("Numbers 1 - 8", 1);
        bettingMultipliers.put("Numbers 19 - 36", 1);
        bettingMultipliers.put("Even Numbers", 1);
        bettingMultipliers.put("Odd Numbers", 1);
        bettingMultipliers.put("Black Numbers", 1);
        bettingMultipliers.put("Red Numbers", 1);
    }

    public RouletteGamble(Integer initialBalance, Integer atTurnStartBalance, Integer currentBalance) {
        this.initialBalance = initialBalance;
        this.atTurnStartBalance = atTurnStartBalance;
        this.currentBalance = currentBalance;
    }

    public Integer getEarnings(HashMap<String, ArrayList<Integer>> numberSelections, Integer winningNumber) {
        Integer earnings = 0;
        for (Map.Entry<String, ArrayList<Integer>> entry : numberSelections.entrySet()) {
            if (entry.getValue().contains(winningNumber)) {
                earnings += bettingMultipliers.get(entry.getKey()) + 1;
            }
        }
        return earnings;
    }



    public Integer getLosses(HashMap<String, ArrayList<Integer>> numberSelections, Integer winningNumber) {
        Integer losses = 0;
        for (Map.Entry<String, ArrayList<Integer>> entry : numberSelections.entrySet()) {
            if (!entry.getValue().contains(winningNumber)) {
                losses += (entry.getKey().equalsIgnoreCase("single number") ? returnLossesForSingleNumber(entry.getValue()) : 1);
            }
        }
        return losses;
    }
    public Integer returnLossesForSingleNumber(ArrayList<Integer> singleNumberArray) {
        Integer loss = 0;
        for (int i = 0; i < singleNumberArray.size(); i++) {
            loss += 1;
        }
        return loss;
    }



    public void printStats(Integer initialBalance, Integer currentBalance, Integer atTurnStartBalance){
        this.initialBalance = initialBalance;
        this.currentBalance = currentBalance;
        this.atTurnStartBalance = atTurnStartBalance;
        String stats = "\n***HERE ARE YOUR STATS!***\n"+
                "Your chip balance at the start of the game: " + initialBalance +
                "\nYour chip balance at the start of the last turn: " + atTurnStartBalance +
                "\nYour current balance: " + currentBalance + "\n\n\n";
        System.out.println(stats);
    }
}
