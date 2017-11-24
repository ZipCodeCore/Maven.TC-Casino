package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Collections;

public class BlackJack extends CardPlayer implements Gamble{


    public BlackJack(String name, Double money) {
        super(name, money);
    }

    public BlackJack(){

    }

    private Deck deckObj= new Deck();
    private ArrayList<Card> deckBlackJAck;
    private ArrayList<Card> playerHand = new ArrayList<Card>();
    private ArrayList<Card> dealerHand = new ArrayList<Card>();
    private Double betAmount;
    private Player player1;
    int option = 0;
    public void startGame(Player player){
        player1 = new Player(player.getName(),player.getMoney());
        do{
           option = Console.getIntegerInput("Choose one option \n1. Play\n0. exit");
           switch (option){
               case 1:
                   betAmount = Console.getDoubleInput("Enter your bet amount");
                   if(betAmount > player1.getMoney()){
                       System.out.println("You don't have $"+betAmount+" in your bank");
                   }
                   else {
                       play();
                   }
                   break;
               case 0:
                   System.out.println("Exiting from Black Jack");
                   break;
               default:
                   System.out.println("Please enter 1 or 0");
           }
       }while (option != 0 && player1.getMoney() > 0);
    }
    public boolean play() {
        deckBlackJAck = deckObj.createFullDeck();
        Collections.shuffle(deckBlackJAck);
        giveHand(deckBlackJAck,playerHand);
        giveHand(deckBlackJAck,dealerHand);
        System.out.println("Your hand value\n"+playerHand);
        //System.out.println("Dealer hand "+dealerHand);
        //System.out.println(deckBlackJAck.size());
        if(addHandValues(playerHand) == 21){
            if(stay(dealerHand) == addHandValues(playerHand))
                System.out.println("Push ,dealer and you have same hand value");
            else{
                System.out.println("You won !!!");
                player1.setMoney(player1.getMoney()+betAmount+betAmount);
            }
            return true;
        }
        else {
            while (addHandValues(playerHand) < 21){
                int hitOrStay = Console.getIntegerInput("1. Hit\n2. Stay");
                if(hitOrStay == 1)
                    hit(deckBlackJAck,playerHand);
                else{
                    int dealerSum = stay(dealerHand);
                    int playerSum = addHandValues(playerHand);
                    if (dealerSum ==playerSum)
                        System.out.println("Push ,dealer and you have same hand value");
                    if (playerSum <= 21 && playerSum > dealerSum){
                        System.out.println("You won !!!");
                        player1.setMoney(player1.getMoney()+betAmount+betAmount);
                    }
                    else {
                        System.out.println("You bust");
                    }
                }
            }
        }
        return true;
    }

    public void giveHand(ArrayList<Card> deckOfBlackJack,ArrayList<Card> playerHand){
        Card temp;
        for (int i=deckOfBlackJack.size()-1,k=1;k<=2;i--,k++){
            temp = deckOfBlackJack.remove(i);
            playerHand.add(temp);
        }
    }
    public void hit(ArrayList<Card> deckBlackJAck,ArrayList<Card> playerHand){
         playerHand.add(deckBlackJAck.remove(deckBlackJAck.size()-1));
    }
    public int stay(ArrayList<Card> dealerHand){
        while (addHandValues(dealerHand)< 17){
            hit(deckBlackJAck,dealerHand);
        }
        return addHandValues(dealerHand);
    }
    public int addHandValues(ArrayList<Card> playerHand){
        int sum = 0;
        for (Card card:playerHand) {
            sum += card.getValue().getValue();
        }
        return sum;
    }
}
