package io.zipcoder.casino;

public class CrapsPlayer extends Player<CrapsPlayer> implements Gamble, Dice {

    private String name;
    private Double crapPlayerMoney, playerMoney, crapPlayerBet, playerBet;


    public CrapsPlayer(String name) {
    }

    public static void crapPlayerMoney(Double playerMoney){

    }

    public void crapPlayerBet(){
        System.out.println(Console.getUserInputDouble("How much would you like to bet?"));
    }



    public void setCrapPlayerMoney(Double playerMoney){
        this.crapPlayerMoney = playerMoney;
    }

    public Double getCrapPlayerMoney(){
        return playerMoney;
    }

    public void setCrapPlayerBet(Double playerBet){
        this.crapPlayerBet = playerBet;
    }

    public Double getCrapPlayerBet(){
        return playerBet;
    }

    public Double crapPlayerMoneyAvailable(){
        Double moneyAvailable = 0.0;
        Double getCrapPlayerMoney /*Total money available*/ = getCrapPlayerMoney();
        Double getCrapPlayerBet = getCrapPlayerBet();
        moneyAvailable = getCrapPlayerMoney - getCrapPlayerBet;
        return moneyAvailable;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    private Double money;
    private Card cardsInHand;
    private int playerPoint;

//    public Double getPlayerBet() {
//        return playerBet;
//    }
//
//    public void setPlayerBet(Double playerBet) {
//        this.bet = playerBet;
//    }
//
//    private Double playerBet;

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

    public void getBet(Double bet){
        this.bet = bet;
    }


    public Double bet(Double money) {
        money = money - bet;
          return money;
    }
//    public Double bet(Double money){
//        playerBet = money;
//        return playerBet;
//    }

    public int getPlayerPoint() {
        return playerPoint;
    }

    public void setPlayerPoint(int playerPoint) {
        this.playerPoint = playerPoint;
    }
}

