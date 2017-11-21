package io.zipcoder.casino;

public class BlackJack extends CardGame implements Game {

    //dealer and player object? where would they live

    private Player player = new BlackJackPlayer();

    private Player dealer = new BlackJackDealer();

    public BlackJack() { }

    public boolean reportWinner() {
        // if both player and dealer scores are = to 21 dealer wins
        // if both player and dealer score are over 21 then dealer wins
        // if player's score is <= 21 and players score is greater than dealers score then player wins.
        //if dealer's score is > 21 and player's score is <= 21 then players wins.
        player.calculateScore();
        dealer.calculateScore();

        if(     (player.getScore().equals(21) && !dealer.getScore().equals(21)) ||
                (player.getScore()<21 && dealer.getScore() < player.getScore()) ||
                (player.getScore() < 21 && dealer.getScore() > 21)) {
            //Player wins
            return true;
        }
        //Dealer wins
        return false;
    }

    public void play() {
        //Deal two cards to the player and the dealer
        for (int i = 0; i < 2; i++)
        {
            dealCard(player);
            dealCard(dealer);
        }

    } //start the playing field specific for BlackJack

    public void placeBet(Double money) {

    }
}
