package io.zipcoder.casino.nuts_n_bolts;

public class User {

    private String name;
    private MoneyContainer wallet = new MoneyContainer();

    public User(String name){
        this.name = name;
    }

    public User(String name, Double money){
        this(name);
        this.wallet.addMoney(money);
    }

    public String getName() {
        return this.name;
    }

    public MoneyContainer getWallet() {
        return this.wallet;
    }
}


/*
*    private ArrayList<Card> hand;
    private String name;
    private Double money;
    private Integer score;

    public Player(){
        hand = new ArrayList<Card>(2);
        name="Player";
        money = 500.0;
        score = 0;
    }
    public Player(Double passedMoney){
        this();
        money=passedMoney;
    }
    public Player(String name, Double passedMoney){
        this();
        money=passedMoney;
        this.name=name;
    }
    public Player(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public Integer getScore() {
        return score;
    }



    // blackjack hit
    public void addToHand(Card card) {
        hand.add(card);
    }

    public boolean hasMoneyToMakeBet(Double amount) {
        return (amount <= money);
    }

    public void makeBet(Double amount) {
        money -= amount;
    }

    public boolean isAceInHand() {
        for(Card card: hand) {
            if(card.getValue() == 1) {
                return true;
            }
        }
        return false;
    }

    public Integer calculateScore() {
        int sum = 0;
        for(Card card: hand) {
            sum += card.getValue();
        }

        if(isAceInHand() && sum <= 11) {
            sum += 10;
        }
        score = sum;

        return sum;
    }

    public void receiveWinnings(Double amount) {
        money += amount;
    }
* */