package io.zipcoder.casino;

public class Wallet {
    private int chipAmount = 0;

    public void addChipsToAmount(int chipsToAdd) {
        this.chipAmount = this.chipAmount + chipsToAdd;
    }

    public void removeChipsFromAmount(int chipsToRemove) {
        this.chipAmount = this.chipAmount - chipsToRemove;
    }

    public int checkChipAmount(){
        return this.chipAmount;
    }
}
