package io.zipcoder.casino.games.crazy8s;

import io.zipcoder.casino.core.Player;
import io.zipcoder.casino.games.Card;
import io.zipcoder.casino.games.Deck;
import io.zipcoder.casino.utils.IOHandler;
import org.junit.Assert;
import org.junit.Test;


class Crazy8PlayTest {

    @Test
    public void playerTurnTest(){
        Crazy8Game game = new Crazy8Game();
        Crazy8Player player = new Crazy8Player("player");
        //Given

        Assert.assertTrue(player.isPlayerCardsValid());
    }

    @Test
    public void dealCardsTestPlayer() {
        //Given
        Deck deck = new Deck(); //get new deck to play with
        int handSize = 8;

        Card[] playersHand = deck.pullMany(handSize);   //deal playersHand

        Assert.assertEquals(true, playersHand.length == 8);
    }

    @Test
    public void dealCardsTestComputer() {
        //Given
        Deck deck = new Deck(); //get new deck to play with
        int handSize = 8;

        Card[] computer = deck.pullMany(handSize); //and computer's hand

        Assert.assertEquals(true, computer.length == 8);
    }


    @Test
    public void playerSelectCardTest() {
        Crazy8Game game = new Crazy8Game();


    }

    @Test
    public void displayPreselectionMessageTest() {
        Crazy8Game game = new Crazy8Game();


    }

    @Test
    public void ChangeSuitWithEightTest() {
        Crazy8Game game = new Crazy8Game();


    }

    @Test
    public void removeCardTest() {
        Crazy8Game game = new Crazy8Game();


    }

    @Test
    public void validateSelectionTest() {
        Crazy8Game game = new Crazy8Game();


    }

    @Test
    public void displayPlayerHandTest() {
        Crazy8Game game = new Crazy8Game();


    }

    @Test
    public void displayCardToMatchTest() {
        Crazy8Game game = new Crazy8Game();



    }

    @Test
    public void displayWinnerTestWin() {

        //Given
        Crazy8Player winner = new Crazy8Player("playerOne");
        String winningResults = "Player 1 Won!";

        //When
        String expected = "Player 1 Won!";

        String actual = winningResults;

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void displayWinnerTestLose() {

        //Given
        Crazy8Player winner = new Crazy8Player("playerTwo");

        String resultLose = "Player 2 Won!";
        //When

        String expected = "Player 2 Won!";

        String actual = resultLose;

        Assert.assertEquals(expected, actual);
    }

    //CANT TEST USER INPUT!
    @Test
    public void playAgainPromptTest(){
        //Given
        Crazy8Game game = new Crazy8Game();
        //When
        String expected = "Do you want to play again? [Y/N]";

        String actual = IOHandler.promptForStringWithMessage("Do you want to play again? [Y/N]");

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void runWelcomeTest(){
        String expected =   "       WELCOME TO CRAZY EIGHTS!\n" +
                "**************************************\n" +
                "*                                    *\n" +
                "*                                    *\n" +
                "* This is a non-gambling game so,    *\n" +
                "*       Hold on to your chips!!      *\n" +
                "*                                    *\n" +
                "*                                    *\n" +
                "**************************************\n" +
                "*                                    *\n" +
                "*        Press 'P' to PLAY           *\n" +
                "*        Press 'Q' to QUIT           *\n" +
                "*        Press 'R' for RULES         *\n" +
                "*                                    *\n" +
                "**************************************\n";

        String actual = IOHandler.getMessageFromFile("Crazy8Welcome.txt");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getRulesTest() {
        String expected = "                    Crazy Eights Rules\n" +
                "**************************************************************\n" +
                "*   Crazy Eights is a game for two or more players.          *\n" +
                "*                                                            *\n" +
                "*   The object is to get rid of the cards in your hand       *\n" +
                "*   onto a discard pile by matching the number or suit       *\n" +
                "*   of the previous discard.                                 *\n" +
                "*                                                            *\n" +
                "*                   Basic Game Play:                         *\n" +
                "**************************************************************\n" +
                "*   The dealer deals eight cards to each player.             *\n" +
                "*   The rest of the deck is placed face down on the table,   *\n" +
                "*   and the top card of that deck is turned face up.         *\n" +
                "*   Each player, in turn, must either play a legal card,     *\n" +
                "*   or draw a card from the remaining. The following plays   *\n" +
                "*   are legal.                                               *\n" +
                "*                                                            *\n" +
                "*	1.	If the top card of the discard pile is not an eight, *\n" +
                "*	you may play any card which matches the rank or suit of  *\n" +
                "*	the previous card (for example if the top card was the   *\n" +
                "*	king of hearts you could play any king or any heart).    *\n" +
                "*                                                            *\n" +
                "*	2.	An eight may be played on any card, and the player   *\n" +
                "*	of the eight must nominate a suit.                       *\n" +
                "*                                                            *\n" +
                "*	3.	If an eight is on top of the pile, you must play     *\n" +
                "*	either another eight or any card of the suit nominated   *\n" +
                "*                                                            *\n" +
                "*   The first player who gets rid of all their cards wins!   *\n" +
                "**************************************************************\n";
        String actual = IOHandler.getMessageFromFile("Crazy8Rules.txt");

        Assert.assertEquals(expected, actual);
    }
}
