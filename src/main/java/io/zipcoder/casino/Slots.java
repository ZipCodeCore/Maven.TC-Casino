package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Slots extends Game implements Gamble {

    public final int MIN_NUMBER_OF_PLAYERS = 1;
    public final int MAX_NUMBER_OF_PLAYERS = 1;

    private SlotsSymbols[] slotsEntries = new SlotsSymbols[3];

    private HashMap<Player<Craps>, Double> bets = new HashMap<Player<Craps>, Double>();

    public void pullSlotMachine() {
        Random rand = new Random();
        for(int i = 0; i < slotsEntries.length; i++) {
            int numSymbols = SlotsSymbols.values().length;
            slotsEntries[i] = SlotsSymbols.values()[rand.nextInt(numSymbols)];
        }
    }

    public String printSlotMachine() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\uD83C\uDFB0 Uncle Bob's Slot Machine\n");
        stringBuilder.append("*******************************\n");
        stringBuilder.append(String.format("%-10s%-10s%-10s%s\n", "*", "*", "*", "*"));
        for(int i = 0; i < slotsEntries.length; i++) {
            stringBuilder.append(String.format("%-5s%-5s", "*", slotsEntries[i].getIcon()));
        }
        stringBuilder.append("*\n");
        stringBuilder.append(String.format("%-10s%-10s%-10s%s\n", "*", "*", "*", "*"));
        stringBuilder.append("*******************************\n");
        return stringBuilder.toString();
    }

    @Override
    public ArrayList<SlotsPlayer> getPlayers() {
        return (ArrayList<SlotsPlayer>) players;
    }

    @Override
    public void takeBet(Player player, Double amount) {
        bets.put(player, amount);
        player.bet(amount);
    }

    @Override
    public void payOutBets() {
        if(slotsEntries[0].equals(slotsEntries[1])) {
            if(slotsEntries[1].equals(slotsEntries[2])) {
                for(SlotsPlayer player : getPlayers()) {
                    Double amountWon = bets.get(player) * 3;
                    player.receiveWinnings(amountWon);
                    System.out.printf("You win $%.2f\n", amountWon);
                }
            }
            else {
                for(SlotsPlayer player : getPlayers()) {
                    Double amountWon = Math.floor(bets.get(player) * 1.5 * 100) / 100;
                    player.receiveWinnings(amountWon);
                    System.out.printf("You win $%.2f\n", amountWon);
                }
            }
        }
        clearAllBets();
    }

    @Override
    public void clearAllBets() {
        bets.clear();
    }

    public enum SlotsSymbols {

        UMBRELLA ("\u2602"),
        MUSIC_NOTES ("\u266B"),
        RECYCLE ("\u267B");

        private String icon;

        SlotsSymbols(String icon) {
            this.icon = icon;
        }

        public String getIcon() {
            return icon;
        }
    }
}
