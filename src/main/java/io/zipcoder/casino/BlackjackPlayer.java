package io.zipcoder.casino;

public class BlackjackPlayer extends Player<BlackjackPlayer> implements Gamble {

    BlackjackPlayer(String name, Double money) {
        super(name, money);
    }
    public int score;

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

    }
