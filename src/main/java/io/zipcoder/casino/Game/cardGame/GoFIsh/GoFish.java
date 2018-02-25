package io.zipcoder.casino.Game.cardGame.GoFIsh;

import io.zipcoder.casino.CasinoUtilities.Console;
import io.zipcoder.casino.Game.cardGame.CardGame;
import io.zipcoder.casino.Game.cardGame.utilities.Card;
import io.zipcoder.casino.Game.cardGame.utilities.CardRank;
import io.zipcoder.casino.Game.cardGame.utilities.Hand;
import io.zipcoder.casino.House;
import io.zipcoder.casino.Profile;

import java.util.ArrayList;


public class GoFish extends CardGame {

    private GoFishPlayer user;
    private GoFishPlayer dealer;
    boolean isTurn;


    public GoFish(Profile userProfile) {

        super();
        user = new GoFishPlayer(userProfile);
        dealer = new GoFishPlayer(House.HOUSE_PROFILE);
        addPlayer(user);
        addPlayer(dealer);
    }

    public void deal() {

        for (int i = 0; i < 7; i++) {
            user.getHand().addCard(deck.getCard());
            dealer.getHand().addCard(deck.getCard());
        }
    }

    public void startGame() {
        Console.print("Lets play Go Fish! Shuffle up and deal...");
        deal();
    }

    public static void main(String[] args) {
        Profile luckyPlayer = new Profile("Kibret", 1000000, 11);
        GoFish goFishGame = new GoFish(luckyPlayer);
        goFishGame.startGame();
        do {
            goFishGame.playUserTurn();
            goFishGame.playDealerTurn();
        } while (goFishGame.getDeck().countRemainingCards() > 0 &&
                goFishGame.user.getHand().getCards().size() > 0 &&
                goFishGame.dealer.getHand().getCards().size() > 0);
    }

    public void playUserTurn() {

        Console.print("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
        do {
            dealer.getHand().orderCards();
            Console.print(dealer.getHand().showHand());
            user.getHand().orderCards();
            Console.print(user.getHand().showHand());
            Console.print("Which card value would you like to ask for?");
            CardRank requestedRank = convertStringToRank(Console.getString());
            playerAsk(requestedRank, dealer, user);
        } while (isTurn);

    }

    public void playDealerTurn() {

        Console.print("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _");


//        int dealerHandSize = dealer.getHand().getCards().size();
//        int randomSelector = (int) Math.floor(Math.random() * dealerHandSize);
//        CardRank aCardRank = dealer.getHand().getCards().get(randomSelector).getRank();

        Console.print("Now its my turn!");

        do {
            int dealerHandSize = dealer.getHand().getCards().size();
            int randomSelector = (int) Math.floor(Math.random() * dealerHandSize);
            CardRank aCardRank = dealer.getHand().getCards().get(randomSelector).getRank();
            Console.print("Do you have any " + aCardRank + "s?");
            dealerAsk(aCardRank);
        } while (!isTurn);

    }

    public void playerAsk(CardRank aCardRank, GoFishPlayer playerBeingAsked, GoFishPlayer askingPlayer) {

        isTurn = true;

        if (countMatchesInHand(askingPlayer, aCardRank) < 1) {
            Console.print("You cannot ask for a card that you do not have. Try again.");

        } else if (countMatchesInHand(playerBeingAsked, aCardRank) < 1) {
            Console.print("Go fish.");
            Console.print("You fished: " + getDeck().peek().toString());
            fish(askingPlayer);
//            Console.print(askingPlayer.getHand().showHand());
            if (getHandForBook(user,aCardRank)>0) {
                Console.print("You made a book!!");
                askingPlayer.getHand().orderCards();
                Console.print(askingPlayer.getHand().showHand());
                addCardToBookAndRemoveFromHand(askingPlayer,aCardRank);
                Console.print(askingPlayer.getHand().showHand());

                // SCORE IT
                // REMOVE CARDS
            }
            isTurn = false;

        } else {
            transfer(aCardRank, playerBeingAsked, askingPlayer);
            Console.print("Good guess! Here you go!");
            if (getHandForBook(user,aCardRank)>0) {
                Console.print("You made a book!!");
                addCardToBookAndRemoveFromHand(askingPlayer,aCardRank);
                askingPlayer.getHand().orderCards();
                Console.print(askingPlayer.getHand().showHand());

                // SCORE IT
                // REMOVE CARDS
            }

        }
        int askingPlayerScore = askingPlayer.getScores();
        int playerBeingAskedScores = playerBeingAsked.getScores();
        if(askingPlayerScore>playerBeingAskedScores){
            Console.print("you win: You scored "+ askingPlayerScore +"And I scored "+playerBeingAskedScores);
        }else if(askingPlayerScore<playerBeingAskedScores){
            Console.print("I won: I scored "+ playerBeingAskedScores+" And you scored "+askingPlayerScore);
        }
    }

    public void dealerAsk(CardRank aCardRank) {

        isTurn = false;

        if (countMatchesInHand(user, aCardRank) < 1) {
            Console.print("Darn. I'm fishing. Your turn now.");
            fish(dealer);
            isTurn = true;

        } else {
            transfer(aCardRank, user, dealer);
            Console.print("Thanks! Now I guess again!");
        }

    }

    public int getHandForBook(GoFishPlayer aPlayer, CardRank aCardRank) {
        int books =0;
        int count=0;
        for (int i = 0; i < aPlayer.getHand().getCards().size(); i++) {
            if(aCardRank==aPlayer.getHand().getCards().get(i).getRank()){
                count++;
            }
            if(count==4){
                books++;
            }
        }
        return books;
    }
    public void addCardToBookAndRemoveFromHand(GoFishPlayer aPlayer, CardRank aCardRank){
        for(int i =0;i<aPlayer.getHand().getCards().size();i++){
            if(aPlayer.getHand().getCards().get(i).getRank()==aCardRank){
                aPlayer.buildBooks(aPlayer,aCardRank);
                aPlayer.getHand().getCards().remove(aPlayer.getHand().getCards().get(i));
            }

        }

    }

    public void fish(GoFishPlayer askingPlayer) {
        askingPlayer.getHand().addCard(getDeck().getCard());
    }

    public int countMatchesInHand(GoFishPlayer goFishPlayer, CardRank someCardRank) {

        int countOfCard = 0;
        ArrayList<Card> cardsBeingChecked = goFishPlayer.getHand().getCards();

        for (int i = 0; i < cardsBeingChecked.size(); i++) {
            if (cardsBeingChecked.get(i).getRank() == (someCardRank)) {
                countOfCard++;
            }
        }

        return countOfCard;
    }

    public void transfer(CardRank someCardRank, GoFishPlayer fromPlayer, GoFishPlayer toPlayer) {

        for (int i = 0; i < fromPlayer.getHand().getCards().size(); i++) {

            if (fromPlayer.getHand().getCards().get(i).getRank() == someCardRank) {
                toPlayer.getHand().addCard(fromPlayer.getHand().getCards().get(i));
            }
        }

        ArrayList<Card> tempHand = new ArrayList<>();

        for (int i = 0; i < fromPlayer.getHand().getCards().size(); i++) {
            if (fromPlayer.getHand().getCards().get(i).getRank() != someCardRank) {
                tempHand.add(fromPlayer.getHand().getCards().get(i));
            }
        }

        fromPlayer.getHand().setCards(tempHand);

    }

    public GoFishPlayer getUser() {
        return user;
    }

    public GoFishPlayer getDealer() {
        return dealer;
    }

    public CardRank convertStringToRank(String aString) {

//        try {
//            return CardRank.valueOf(aString.toLowerCase());
//        } catch (IllegalArgumentException iae) {
//            return null;
//        }
//    }

        String lowercase = aString.toLowerCase();


        switch (lowercase) {

            case "two":
                return CardRank.TWO;

            case "three":
                return CardRank.THREE;

            case "four":
                return CardRank.FOUR;

            case "five":
                return CardRank.FIVE;

            case "six":
                return CardRank.SIX;

            case "seven":
                return CardRank.SEVEN;

            case "eight":
                return CardRank.EIGHT;

            case "nine":
                return CardRank.NINE;

            case "ten":
                return CardRank.TEN;

            case "jack":
                return CardRank.JACK;

            case "queen":
                return CardRank.QUEEN;

            case "king":
                return CardRank.KING;

            case "ace":
                return CardRank.ACE;

            default:
                Console.print("Invalid entry. Try again.");
                break;
        }

        return null;
    }

}
