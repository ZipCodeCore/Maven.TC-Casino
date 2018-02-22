package io.zipcoder.casino;

public interface Gambler{

    public void bet(double amount);
    public void win(double payoutMultiplier);
    public void lose();

}
