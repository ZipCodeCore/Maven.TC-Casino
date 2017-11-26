package io.zipcoder.casino;

public interface Gamble {

    //Double pot = 0.0;

    public void setPot(Double betMoney);

    public Double getPot();

    public void placeBet(Double money);

    public boolean hasMoneyToMakeBet(Double moneyToBet);

    public void cashInWinnings();

}
