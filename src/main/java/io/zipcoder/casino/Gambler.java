package io.zipcoder.casino;

public interface Gambler{

    void bet(TypeOfBet betType, double amount);
    void win(TypeOfBet betType, double payoutMultiplier);
    void lose(TypeOfBet betType);
}
