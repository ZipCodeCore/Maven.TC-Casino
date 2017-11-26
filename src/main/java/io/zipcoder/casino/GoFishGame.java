package io.zipcoder.casino;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GoFishGame extends CardGame {

    private ArrayList<Card> deck;
    private GoFishPlayer goFishPlayer;
    private ArrayList<Card> playerHand;
    private ArrayList<Card> computerHand;
    private GoFishPlayer computerPlayer;


    public GoFishGame() {
        this.goFishPlayer = new GoFishPlayer();
        this.deck = new Deck().getDeck();
        Collections.shuffle(deck);
        this.playerHand = new ArrayList<Card>();
        this.computerHand = new ArrayList<Card>();
        this.computerPlayer = new GoFishPlayer();
    }


    public void startGame() {

        if (goFishPlayer == null || deck == null || playerHand == null) {
            throw new IllegalStateException("Game tools doesnt exist");
        }

    }


    public ArrayList<Card> playerHand() {
        try {
            int i = 0;
            while (playerHand.size() != 7) {
                playerHand.add(deck.get(i));
                deck.remove(i);
                i++;
            }
            System.out.println("Here is your cards " + playerHand.toString() +
                    ". GoodLuck " + goFishPlayer.getName() + " !!!");
            return playerHand;
        } catch (Exception e) {
            System.out.println("no card in the deck");
            return null;
        }
    }


    public ArrayList<Card> computerHand() {
        int i = 0;


        try {
            if (getDeck().size() > 7) {

                while (computerHand.size() != 7) {
                    computerHand.add(deck.get(i));
                    deck.remove(i);
                    i++;
                }
            }

        } catch (Exception e) {
        }


        return computerHand;
    }


    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public GoFishPlayer getGoFishPlayer() {
        return goFishPlayer;
    }


    public void setDeck(ArrayList<Card> deck) {       //used for testing purpose. Delete when done.
        this.deck = deck;
    }

    public Boolean checkComputerHandForPlayerRequestedCard(String rank) {
        Boolean checkOutcome = false;
        for (int i = 0; i < getComputerHand().size(); i++) {
            if (rank.equals(getComputerHand().get(i).getRank().getSymbol()))
                checkOutcome = true;
        }
        return checkOutcome;
    }


    public void askComputerHandForACard(String rank) {
        ArrayList<Card> cards = new ArrayList<>();
        // if (checkComputerHandForPlayerRequestedCard(rank)) {
        // System.out.println("The computer has " + rank + ". The card is being added to your hand...");
        Card card = null;
        while (checkComputerHandForPlayerRequestedCard(rank)) {
            for (int i = 0; i < getComputerHand().size(); i++) {
                card = getComputerHand().get(i);
                if (rank.equals(card.getRank().getSymbol())) cards.add(card);
            }
            getPlayerHand().addAll(cards);
            removeBookedCard();
            getComputerHand().removeAll(cards);
            cards = new ArrayList<>();

            System.out.println("The computer has " + rank + ".The card" +
                    " is added to your hand.\n Insert the next card you want: ");

            rank = InPutConsole.getInput();
            checkComputerHandForPlayerRequestedCard(rank);

        }
        System.out.println("The computer doesnt have the card. Go Fish!!");
    }

    //// }


    public void goFishingPlayer() {
        System.out.println(goFishPlayer.getName() + " is fishing");
        getPlayerHand().add(getDeck().get(0));
        getDeck().remove(0);
    }


    public void checkIfComputerHandHasAcard() {
        getComputerHand();
        if (computerHand.size() == 0)
            computerHand();
    }

    public String computerCardToRequest() {
        int maxCount = 0;
        int count = 0;
        Card card = null;
        try {
            for (int i = 0; i < getComputerHand().size() - 1; i++) {
                card = getComputerHand().get(i);
                for (int j = i + 1; j < getComputerHand().size() - 1; j++) {
                    if (card.getRank() == getComputerHand().get(j).getRank()) {
                        count++;
                    }
                }
                if (count > maxCount)

                    maxCount = count;
                card = getComputerHand().get(i);
            }
            return card.getRank().getSymbol();
        } catch (Exception e) {
            System.out.println("no card, sorry!");
            return "";
        }
    }


    public Boolean checkPlayerHasRequestedCardRank(String rank) {
        rank = computerCardToRequest();
        Boolean checkOutcome = false;
        for (int i = 0; i < getPlayerHand().size(); i++) {
            if (rank.equals(getPlayerHand().get(i).getRank().getSymbol()))
                checkOutcome = true;
        }
        return checkOutcome;
    }


    public ArrayList<Card> askPlayerForACard(String rank) {
        System.out.println("The computer requested " + rank);
        if (checkPlayerHasRequestedCardRank(rank)) {
            ArrayList<Card> cards = new ArrayList<>();
            Card card = null;
            while (checkPlayerHasRequestedCardRank(rank)) {
                for (int i = 0; i < getPlayerHand().size(); i++) {
                    card = getPlayerHand().get(i);
                    if (rank.equals(card.getRank().getSymbol()))
                        cards.add(card);


                }
                System.out.println(goFishPlayer.getName() + " has " + rank + "." +

                        "The card is added to the computer hand");
                getComputerHand().addAll(cards);
                getPlayerHand().removeAll(cards);
                removeComputerBookedCard();
                cards = new ArrayList<>();
                rank = computerCardToRequest();
                checkPlayerHasRequestedCardRank(rank);
            }
        }
        System.out.println(goFishPlayer.getName() + " doesnt have " + rank + ". Go Fish!!");
        return getComputerHand();
    }

    public void goFishingComputer() {
        try {
            System.out.println("The computer is fishing");
            getComputerHand().add(getDeck().get(0));
            getDeck().remove(0);
        } catch (Exception e) {
        }
    }

    public Map<String, Long> playerHandDisplay() {
        // int score = player.getScore();

        Map<String, Long> result = getPlayerHand()
                .stream().map(card -> card.getRank().getSymbol())
                .collect(Collectors.groupingBy(Function.identity() , Collectors.counting()));

        System.out.println("You have " + result);

        return result;

    }

    public Card checkPlayerHandForBook() {
        int count = 0;
        Card card = null;
        //ArrayList<Card> toBeRemoved=new ArrayList<>();
        //int score = getGoFishPlayer().getScore();

        for (int i = 0; i < getPlayerHand().size(); i++) {
            boolean found = false;

            for (int j = i + 1; !found && j < getPlayerHand().size(); j++) {
                if (getPlayerHand().get(i).equals(getPlayerHand().get(j)))
                    found = true;
                count++;

                if (count == 4)
                    card = getPlayerHand().get(i);
            }
        }
        //System.out.println("You booked " + card.getRank().getSymbol() +
        //      ". Your score is " + score);

        return card;
    }

    public void removeBookedCard() {
        try {
            String cardTobeRemoved = checkPlayerHandForBook().getRank().getSymbol();

            ArrayList<Card> tobeRemovedList = new ArrayList<>();
            Card card = null;
            for (int i = 0; i < getPlayerHand().size(); i++) {
                card = getPlayerHand().get(i);
                if (card.getRank().getSymbol().equals(cardTobeRemoved))
                    tobeRemovedList.add(card);
            }

            getPlayerHand().removeAll(tobeRemovedList);
            int score = getGoFishPlayer().getScore() + 1;
            goFishPlayer.setScore(score);
            System.out.println(getGoFishPlayer().getName() + " score is " + getGoFishPlayer().getScore());
        } catch (Exception e) {
        }

    }

    public Card checkComputerHandForBook() {
        int count = 0;
        Card card = null;
        //ArrayList<Card> toBeRemoved=new ArrayList<>();
        //int score = getGoFishPlayer().getScore();

        for (int i = 0; i < getComputerHand().size(); i++) {
            boolean found = false;

            for (int j = i + 1; !found && j < getComputerHand().size(); j++) {
                if (getComputerHand().get(i).equals(getComputerHand().get(j)))
                    found = true;
                count++;

                if (count == 4)
                    card = getComputerHand().get(i);
            }
        }
        //System.out.println("You booked " + card.getRank().getSymbol() +
        //      ". Your score is " + score);

        return card;
    }

    public void removeComputerBookedCard() {
        try {
            String cardTobeRemoved = checkComputerHandForBook().getRank().getSymbol();
            ArrayList<Card> tobeRemovedList = new ArrayList<>();
            Card card = null;
            for (int i = 0; i < computerHand().size(); i++) {
                card = getComputerHand().get(i);
                if (card.getRank().getSymbol().equals(cardTobeRemoved))
                    tobeRemovedList.add(card);
            }

            getComputerHand().removeAll(tobeRemovedList);
            int score = getComputerPlayer().getScore() + 1;
            computerPlayer.setScore(score);
            System.out.println("computer score is " + getComputerPlayer().getScore());
        } catch (Exception e) {
            System.out.println("card cant be removed");
        }

    }

//    public void checkPlayersCardRequestForInputBoundary(String input) {
//        Boolean checkResult = true;
//        if ((Integer.parseInt(input) > 2 && Integer.parseInt(input) < 12)
//                || (input.toString().toUpperCase().equals("K"))
//                || (input.toString().toUpperCase().equals("J")) ||
//                (input.toString().toUpperCase().equals("Q"))) {
//                       checkPlayersCardRequestForGameRule(input);
//        } else {
//
//               System.out.println("Insert proper value");
//        }
//
//    }
//
//
//    public void checkPlayersCardRequestForGameRule(String input) {
//       // Boolean checkresult = false;
//        for (int i = 0; i < getPlayerHand().size(); i++) {
//            if (input.equals(getPlayerHand().get(i).getRank().getSymbol())) {
//                askComputerHandForACard(input);
//            }
//              System.out.println("You cannot request for card not in hand");
//                break;
//
//        }
//
//
//    }
//
//    public void checkInput(String input) {
//
//
//        while (checkPlayersCardRequestForInputBoundary(input) && checkPlayersCardRequestForGameRule(input)) {
//                 System.out.println("Insert proper value");
//        }
//       askComputerHandForACard(input);
//    }


    public void increaseComputerScore() {
        int computerSameRankCardCount = 0;
        int computerScore = computerPlayer.getScore();
        Card card = null;

        for (int i = 0; i < getComputerHand().size() - 1; i++) {
            card = getComputerHand().get(i);
            for (int j = i + 1; j < getComputerHand().size() - 1; j++)
                if (card.getRank() == getComputerHand().get(j).getRank()) {
                    computerSameRankCardCount++;
                    if (computerSameRankCardCount == 2)
                        computerScore += 1;

                }

        }
        System.out.println("Computer score is " + computerScore);

    }

    public void decideWiner() {
        if (computerPlayer.getScore() > goFishPlayer.getScore())
            System.out.println("nayyy! The machine won");
        else if (computerPlayer.getScore() < goFishPlayer.getScore())
            System.out.println("Wow, you won! Congrats!!!");
        else if (computerPlayer.getScore() == goFishPlayer.getScore())
            System.out.println("The game is tie! try again");
        else
            System.out.println("Sorry the score is not yet available. Please check again");
    }


    public void setPlayerHand(ArrayList<Card> playerHand) {
        this.playerHand = playerHand;
    }

    public void setComputerHand(ArrayList<Card> computerHand) {
        this.computerHand = computerHand;
    }

    public void setGoFishPlayer(GoFishPlayer goFishPlayer) {
        this.goFishPlayer = goFishPlayer;
    }

    public ArrayList<Card> getComputerHand() {
        return computerHand;
    }

    public GoFishPlayer getComputerPlayer() {
        return computerPlayer;
    }
}


