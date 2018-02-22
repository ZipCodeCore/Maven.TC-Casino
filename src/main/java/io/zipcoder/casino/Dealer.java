package io.zipcoder.casino;

public class Dealer extends Person{
    private String name = "Dealer";
    private Hand hand = null;
    private DealerWallet dealerWallet = null;


    public Dealer() {
        this.hand = new Hand();
        this.dealerWallet = new DealerWallet();
    }

}
