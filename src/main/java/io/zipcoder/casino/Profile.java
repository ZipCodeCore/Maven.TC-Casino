package io.zipcoder.casino;

public class Profile {
    private String name;
    private double accountBalance;

    public Profile(String name, double accountBalance) {
        this.name = name;
        this.accountBalance = accountBalance;
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
}
