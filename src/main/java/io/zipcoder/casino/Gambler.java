package io.zipcoder.casino;

public interface Gambler{

    boolean bet(TypeOfBet betType, double amount);
    void win(TypeOfBet betType, double payoutMultiplier);
    void lose(TypeOfBet betType);
    void setEscrow(TypeOfBet typeOfBet, double incomingBet);
    double getEscrowBet(TypeOfBet typeOfBet);
    public boolean escrowContains(TypeOfBet typeOfBet);
}
