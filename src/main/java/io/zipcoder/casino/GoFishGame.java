package io.zipcoder.casino;

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
            throw new IllegalStateException("Player doesnt exist");
        }
    }


    public ArrayList<Card> playerHand() {
        int i = 0;
        while (playerHand.size() != 7) {
            playerHand.add(deck.get(i));
            deck.remove(i);
            i++;
        }
        System.out.println("Here is your hand " + playerHand.toString() + ". GoodLuck!!!");
        return playerHand;
    }


    public ArrayList<Card> computerHand() {

        int i = 0;
        while (computerHand.size() != 7) {
            computerHand.add(deck.get(i));
            deck.remove(i);
            i++;
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
        if (checkComputerHandForPlayerRequestedCard(rank)) {
           // System.out.println("The computer has " + rank + ". The card is being added to your hand...");
            Card card = null;
            while (checkComputerHandForPlayerRequestedCard(rank)) {
                for (int i = 0; i < getComputerHand().size(); i++) {
                    card = getComputerHand().get(i);
                    if (rank.equals(card.getRank().getSymbol())) cards.add(card);
                }
                getPlayerHand().addAll(cards);
                //checkPlayerForBook();
                getComputerHand().removeAll(cards);
                cards = new ArrayList<>();

                System.out.println("The computer has " + rank +".The card" +
                        " is added to your hand. Insert the next card you want: ");

                rank = InPutConsole.getInput();

            }
        }
        System.out.println("The computer doesnt have the card. Go Fish!!");
    }


    public void goFishingPlayer() {
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
                    if (rank.equals(card.getRank().getSymbol())) cards.add(card);
                }
                getComputerHand().addAll(cards);
                getPlayerHand().removeAll(cards);
               // checkComputerForBook();
                cards = new ArrayList<>();
                rank = computerCardToRequest();
                checkPlayerHasRequestedCardRank(rank);
            }
        }
        System.out.println("The player doesnt have " + rank + ". Go Fish!!");
        return getComputerHand();
    }

    public void goFishingComputer() {
        getComputerHand().add(getDeck().get(0));
        getDeck().remove(0);
    }

    public Map<String, Long> playerHandDisplay() {
       // int score = player.getScore();

        Map<String, Long> result = getPlayerHand()
                .stream().map(card -> card.getRank().getSymbol())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("You have " + result);

        return result;

    }

    public void checkPlayerHandForBook() {
          Map<String, Long> playerMap = playerHandDisplay();
           int z=0;
           int count=0;

        int score = goFishPlayer.getScore();
        ArrayList<Card> cards2 = new ArrayList<>();
        ArrayList<Card> cards = getPlayerHand();
      //  while (getPlayerHand().size() > 3) {
        while(z< getPlayerHand().size()){
            String rank = getPlayerHand().get(z).getRank().getSymbol();
             for (Iterator<Card> it = getPlayerHand().iterator(); it.hasNext(); ){
                 Card card = it.next();
                 if (it.next().getRank().getSymbol().equalsIgnoreCase(rank)){
                     count++;
                 }
//            for (int i = 1; i < getPlayerHand().size(); i++) {
//                int count = 0;
//                Card card = getPlayerHand().get(i);
//                //for (int j = 0; j < getPlayerHand().size(); j++) {
//                    Card card1 = cards.get(i-1);
//                    if ((card.getRank().getSymbol().equals(card1.getRank().getSymbol())) )
//                        count++;

                    if (count == 4) {
                        // score++;
                        System.out.println("You booked " + card.getRank().getSymbol());
                        System.out.println("Your score is " + score);

                        for (int k = 0; k < 4; k++)
                            cards.add(card);
                    }

                }
            }
            cards.removeAll(cards);
        }
   // }


    public void checkComputerForBook() {
        int score = computerPlayer.getScore();
        for (int i = 0; i < getComputerHand().size(); i++) {
            int count = 0;
            Card card = getComputerHand().get(i);

            for (int j = i + 1; j < getComputerHand().size(); j++) {
                Card card2 = getComputerHand().get(j);
                if (card.getRank().getSymbol().equals(card2.getRank().getSymbol()) && i != j)
                    count++;
                if (count == 4) {
                    System.out.println("Computer booked " + card.getRank().getSymbol());
                    for (int k = 0; k < 4; k++)
                        getComputerHand().remove(card);
                    score++;
                    System.out.println("Computer score is " + score);
                }
            }
        }
    }
//
    public Boolean checkPlayersCardRequestForInputBoundary(String input) {
        Boolean checkResult = true;
        if ((Integer.parseInt(input) > 2 && Integer.parseInt(input) < 12) || input.toUpperCase().equals("K")
                || input.toUpperCase().equals("J") || input.toUpperCase().equals("J")) {
            checkResult = true;
        } else {
            System.out.println("insert proper value");
            checkResult = false;
        }
        return checkResult;
    }


    public Boolean checkPlayersCardRequestForGameRule(String input) {
        Boolean checkresult = false;
        for (int i = 0; i < getPlayerHand().size(); i++) {
            if (input.equals(getPlayerHand().get(i).getRank().getSymbol())) {
                checkresult = true;
            }
        }

        return checkresult;
    }

    public void checkInput(String input) {


        while (!checkPlayersCardRequestForInputBoundary(input) && checkPlayersCardRequestForGameRule(input)) {
            System.out.println("Insert proper value");
        }
        askComputerHandForACard(input);
    }



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

 //   public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//
//        GoFishGame goFishGame = new GoFishGame();
//        String response = "No";
//
//        goFishGame.startGame();
//        goFishGame.playerHand();
//        goFishGame.computerHand();
//
//        try {
//            do {
//
//                while (!goFishGame.getDeck().isEmpty()) {
//                    //System.out.println(goFishGame.getComputerHand());
//                    System.out.println("Insert the rank of the card you want to request: ");
//                    String rank = InPutConsole.getInput();
//                    goFishGame.askComputerHandForACard(rank);
//                    goFishGame.playerHandDisplay();
//                    goFishGame.increasePlayerScoreForBook();
//                    goFishGame.goFishingPlayer();
//                    goFishGame.checkIfComputerHandHasAcard();
//                    goFishGame.askPlayerForACard(goFishGame.computerCardToRequest());
//                    goFishGame.checkComputerForBook();
//                    goFishGame.goFishingComputer();
//
//                    // System.out.println(goFishGame.getPlayerHand());
//                }
//
//                System.out.println("The deck has finished");
//                //  goFishGame.increasePlayerScore();
//
//                // goFishGame.increaseComputerScore();
//
//                System.out.println("Computer score is " + goFishGame.computerPlayer.getScore());
//                System.out.println("Your score is " + goFishGame.goFishPlayer.getScore());
//                goFishGame.decideWiner();
//                System.out.println("Do you want to play again?");
//                response = InPutConsole.getInput();
//            } while (response == "YES");
//        } catch(Exception e) {
//            System.out.println("please insert YES or NO" );
//        }
//    }

    public void decideWiner() {
        if (computerPlayer.getScore() > goFishPlayer.getScore())
            System.out.println("nayyy! The machine won");
        else if (computerPlayer.getScore() < goFishPlayer.getScore())
            System.out.println("Wow, you won! Congrats!!!");
        else if (computerPlayer.getScore() == goFishPlayer.getScore())
            System.out.println("The game is tie! try again");
        else
            System.out.println("Sorry the score is not yet available. Please check again") ;
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


