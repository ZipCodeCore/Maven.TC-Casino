package io.zipcoder.casino.games.roulette;

import io.zipcoder.casino.Player;

public class RouletteGamble {
    /**
     * this class will hold stats, therefore calculating chips winnings and losses
     */

    private Integer winnings;
    private Integer losses;
    private Integer initialBalance;
    private Integer atTurnStartBalance;
    private Integer currentBalance;
    Player player;

    public RouletteGamble(Player player, Integer initialBalance, Integer atTurnStartBalance, Integer currentBalance) {
        this.player = player;
        this.initialBalance = initialBalance;
        this.atTurnStartBalance = atTurnStartBalance;
        this.currentBalance = currentBalance;
    }

    public Integer earningsCalculator(Integer multiplier){
        Integer earnings = this.currentBalance + multiplier;
        return  earnings;
    }
}
