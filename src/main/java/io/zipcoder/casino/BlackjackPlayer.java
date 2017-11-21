package io.zipcoder.casino;

public class BlackjackPlayer extends Player<BlackjackPlayer> implements Comparable<BlackjackPlayer>, Gamble {



    BlackjackPlayer(String name, Double money) {
        super(name, money);
    }


    public void addToList(BlackjackPlayer player) {
        players.add(player);
    }

    public boolean hitStay(String userAnswer){
        if(userAnswer.equalsIgnoreCase("yes")){
            return true;
        }
        return false;
    }

    public Double bet() {
        return null;
    }

    public int compareTo(BlackjackPlayer o) {
        return 0;
    }

    public Hand getHand(){
        Hand hand = new Hand();
        hand.blackjackHand();
        return hand;
    }
}
