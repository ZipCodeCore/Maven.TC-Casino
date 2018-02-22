package io.zipcoder.casino;

public class Profile {
    private String name;
    private double accountBalance;
    private int id;
    private double escrow;

    public Profile(String name, double accountBalance, int id) {
        this.name = name;
        this.accountBalance = accountBalance;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getAccountBalance() {
        return accountBalance;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {

        return id;
    }

    public void setEscrow(double incomingBet){
        this.escrow = incomingBet;
    }

    public double getEscrow(){
        return this.escrow;
    }
}
