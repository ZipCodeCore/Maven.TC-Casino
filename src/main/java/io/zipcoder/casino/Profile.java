package io.zipcoder.casino;


import java.util.HashMap;

public class Profile {
    private String name;
    private double accountBalance;
    private int id;


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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" " + name +" " + "Your Account Balance is: $ " +accountBalance);
        return sb.toString();
    }
}
