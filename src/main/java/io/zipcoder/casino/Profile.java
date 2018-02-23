package io.zipcoder.casino;


import java.util.HashMap;

public class Profile {
    private String name;
    private double accountBalance;
    private int id;
    private HashMap<String, Double> escrow;

    public Profile(String name, double accountBalance, int id) {
        this.name = name;
        this.accountBalance = accountBalance;
        this.id = id;
        escrow = new HashMap<String, Double>(0);
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

    public void setEscrow(String typeOfBet, double incomingBet){
        this.escrow.put(typeOfBet, incomingBet);
    }

    public double getEscrow(String typeOfBet){
        return this.escrow.get(typeOfBet);
    }

    public boolean escrowContains(String typeOfBet){
        return escrow.containsKey(typeOfBet) ? true : false;
    }

}
