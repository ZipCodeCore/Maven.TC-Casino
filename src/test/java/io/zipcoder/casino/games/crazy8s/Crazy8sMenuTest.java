package io.zipcoder.casino.games.crazy8s;

import io.zipcoder.casino.utils.IOHandler;
import org.junit.Assert;
import org.junit.Test;

public class Crazy8sMenuTest {


    @Test
    public void handleInputTestRules(){
        //Given
        Crazy8sMenu game = new Crazy8sMenu();

        String actualInput = "R";
        String expectedInput = game.handleInput("r");

        Assert.assertEquals(expectedInput, actualInput);
    }

    @Test
    public void handleInputTestPlay(){
        //Given
        Crazy8sMenu game = new Crazy8sMenu();

        String actualInput = "P";
        String expectedInput = game.handleInput("p");

        Assert.assertEquals(expectedInput, actualInput);
    }

    @Test
    public void handleInputTestQuit(){
        //Given
        Crazy8sMenu game = new Crazy8sMenu();

        String actualInput = "Q";
        String expectedInput = game.handleInput("q");

        Assert.assertEquals(expectedInput, actualInput);
    }

    @Test
    public void handleInputTestNull(){
        //Given
        Crazy8sMenu game = new Crazy8sMenu();

        String actualInput = " ";
        String expectedInput = game.handleInput(" ");

        Assert.assertEquals(expectedInput, actualInput);
    }

//    @Test
//    public void playTest(){
//        //Given
//        Crazy8sMenu game = new Crazy8sMenu();
//        //When
//        game.playGame();
//        //Then
//        //ASSERT!!!
//    }

    @Test
    public void runWelcomeTest(){
        Crazy8sMenu game = new Crazy8sMenu();

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
    public void getRulesTest(){
        Crazy8sMenu game = new Crazy8sMenu();

        String expected = "                    Crazy Eights Rules\n" +
"**************************************************************\n"+
"*   Crazy Eights is a game for two or more players.          *\n"+
"*                                                            *\n"+
"*   The object is to get rid of the cards in your hand       *\n"+
"*   onto a discard pile by matching the number or suit       *\n"+
"*   of the previous discard.                                 *\n"+
"*                                                            *\n"+
"*                   Basic Game Play:                         *\n"+
"**************************************************************\n"+
"*   The dealer deals eight cards to each player.             *\n"+
"*   The rest of the deck is placed face down on the table,   *\n"+
"*   and the top card of that deck is turned face up.         *\n"+
"*   Each player, in turn, must either play a legal card,     *\n"+
"*   or draw a card from the remaining. The following plays   *\n"+
"*   are legal.                                               *\n"+
"*                                                            *\n"+
"*	1.	If the top card of the discard pile is not an eight, *\n"+
"*	you may play any card which matches the rank or suit of  *\n"+
"*	the previous card (for example if the top card was the   *\n"+
"*	king of hearts you could play any king or any heart).    *\n"+
"*                                                            *\n"+
"*	2.	An eight may be played on any card, and the player   *\n"+
"*	of the eight must nominate a suit.                       *\n"+
"*                                                            *\n"+
"*	3.	If an eight is on top of the pile, you must play     *\n"+
"*	either another eight or any card of the suit nominated   *\n"+
"*                                                            *\n"+
"*   The first player who gets rid of all their cards wins!   *\n"+
"**************************************************************\n";
        String actual = IOHandler.getMessageFromFile("Crazy8Rules.txt");

        Assert.assertEquals(expected, actual);
    }
}
