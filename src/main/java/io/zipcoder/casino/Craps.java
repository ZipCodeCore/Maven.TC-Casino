package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.HashMap;

public class Craps extends Game implements Gamble{

    public final int MIN_NUMBER_OF_PLAYERS = 1;
    public final int MAX_NUMBER_OF_PLAYERS = 8;

    private Dice dice = new Dice(2);
    private Integer point;

    private HashMap<Player<Craps>, Double> bets = new HashMap<Player<Craps>, Double>();
    private ArrayList<CrapsPlayer> playersOnPass = new ArrayList<>();
    private ArrayList<CrapsPlayer> playersOnDontPass = new ArrayList<>();
    private boolean passBetsWin = true;

    @Override
    public ArrayList<CrapsPlayer> getPlayers() {
        return (ArrayList<CrapsPlayer>) players;
    }

    public Integer getSumOfDice() {
        return getValueOfDieOne() + getValueOfDieTwo();
    }

    public Integer getValueOfDieOne() {
        return dice.getDice().get(0).getValue();
    }

    public Integer getValueOfDieTwo() {
        return dice.getDice().get(1).getValue();
    }

    public Dice getDice() {
        return dice;
    }

    public void rollDice() {
        dice.rollDice();
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public boolean isPassBetsWin() {
        return passBetsWin;
    }

    public void setPassBetsWin(boolean passBetsWin) {
        this.passBetsWin = passBetsWin;
    }

    @Override
    public void takeBet(Player player, Double amount) {
        bets.put(player, amount);
        player.bet(amount);
    }

    @Override
    public void payOutBets() {
        if(passBetsWin) {
            for(CrapsPlayer player : playersOnPass) {
                Double amountWon = bets.get(player) * 2;
                player.receiveWinnings(amountWon);
            }
        }
        else {
            for(CrapsPlayer player : playersOnDontPass) {
                Double amountWon = bets.get(player) * 2;
                player.receiveWinnings(amountWon);
            }
        }
        clearAllBets();
    }

    @Override
    public void clearAllBets() {
        bets.clear();
        playersOnPass.clear();
        playersOnDontPass.clear();
    }

    public void putPlayerOnPass(CrapsPlayer player) {
        playersOnPass.add(player);
    }

    public void putPlayerOnDontPass(CrapsPlayer player) {
        playersOnDontPass.add(player);
    }
}
