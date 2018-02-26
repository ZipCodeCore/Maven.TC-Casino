package io.zipcoder.casino.games.roulette;


import io.zipcoder.casino.interfaces.Gamble;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RouletteGamble {
    /**
     * this class will hold stats, therefore calculating chips winnings and losses
     */


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
        bettingMultipliers.put("Numbers 1 - 18", 1);
        bettingMultipliers.put("Numbers 19 - 36", 1);
        bettingMultipliers.put("Even Numbers", 1);
        bettingMultipliers.put("Odd Numbers", 1);
        bettingMultipliers.put("Black Numbers", 1);
        bettingMultipliers.put("Red Numbers", 1);
    }


    public Integer win(HashMap<String, ArrayList<Integer>> numberSelections, Integer winningNumber) {
        Integer earnings = 0;
        for (Map.Entry<String, ArrayList<Integer>> entry : numberSelections.entrySet()) {
            if (entry.getValue().contains(winningNumber)) {
                earnings += (bettingMultipliers.get(entry.getKey())*10) + 10;
            }
        }
        return earnings;
    }

    public Integer lose(Integer betAmount, Integer winnings){
        Integer losses = winnings - betAmount;
        return losses;
    }



    public void printStats(Integer initialBalance, Integer currentBalance, Integer betAmount, Integer winnings, Integer losses){
        String stats = "\n***HERE ARE YOUR STATS!***\n"+
                "You bet " + betAmount + " chips.\n"+
                "You won " + winnings + " chips. \n"+
                "Net total: " + losses +
                "\nYour chip balance at the start of the game: " + initialBalance +
                "\nYour current balance: " + currentBalance + "\n\n\n";
        System.out.println(stats);
    }
}
