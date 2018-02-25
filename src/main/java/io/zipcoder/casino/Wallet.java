package io.zipcoder.casino;

import java.util.Scanner;

public class Wallet {

    private int chipAmount;

    public Wallet(){
        this.chipAmount = 0;
    }

    public void addChipsToAmount(int chipsToAdd) {
        this.chipAmount = this.chipAmount + chipsToAdd;
    }

    public void removeChipsFromAmount(int chipsToRemove) {
        this.chipAmount = this.chipAmount - chipsToRemove;
    }

    public int checkChipAmount(){
        return this.chipAmount;
    }

    //has Scanner and Wilhelm told me not to test methods with Scanner
    //is called in sendNewPlayerToGame in Casino
    public void fillPlayerWalletFromUserInput() {
        String isGambling;
        int walletAmount;
        Scanner in = new Scanner(System.in);
        System.out.println("If you will be playing a gambling game press y, if not, press n.");
        isGambling = in.nextLine();
        if(isGambling.equals("y")) {
            System.out.println("Please enter number of chips you would like to begin with");
            walletAmount = in.nextInt();
            addChipsToAmount(walletAmount);
        }
    }

}
