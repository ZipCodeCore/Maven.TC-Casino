package io.zipcoder.casino;

public class Bank {
    private Double balance;

    public double withdraw(double amount) {
        if(sufficientFunds(amount)) {
            balance -= amount;
            return amount;

        }return 0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public Double getBalance() {
        return balance;
    }

    public boolean sufficientFunds(double amount){
        return amount <= this.balance;
    }
}
