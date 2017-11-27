package io.zipcoder.casino;

public class CrapsPlayer extends Player<CrapsPlayer> implements Gamble, Dice {

    private String name;

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    private Double money;
    private Card cardsInHand;
    private int playerPoint;

    public Double getPlayerBet() {
        return playerBet;
    }

    public void setPlayerBet(Double playerBet) {
        this.playerBet = playerBet;
    }

    private Double playerBet;

    CrapsPlayer(String name, Double money) {
        super(name, money);
    }


    //We won't be using this method of course, since Craps is a dice game, but I HAD to put this Override method here
    //to fulfill a contract we entered with our arrangement of abstracts and interfaces... it's just one of those
    //things we didn't anticipate when we were making the UML and now we are stuck with...
    @Override
    public void addCardToHand(Card newCard) {
        cardsInHand.add(newCard);
    }


//    public Double bet() {
//        return null;
//    }

    public Double bet(Double bet) {
        money = money - bet;
        this.playerBet = bet;
        return bet;
    }

    public int getPlayerPoint() {
        return playerPoint;
    }

    public void setPlayerPoint(int playerPoint) {
        this.playerPoint = playerPoint;
    }
}

