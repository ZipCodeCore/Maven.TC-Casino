package io.zipcoder.casino;

public interface Gambler{

    public void bet(String typeOfBet, double amount);
    public void win(String typeOfBet, double payoutMultiplier);
    public void lose(String typeOfBet);

}
