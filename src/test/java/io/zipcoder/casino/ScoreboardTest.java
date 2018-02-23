package io.zipcoder.casino;

import org.junit.Test;
import org.junit.Assert;

import java.util.LinkedHashMap;
import java.util.Set;

public class ScoreboardTest {
    private Person person1 = new Person("Harry");
    private Person person2 = new Person("Sally");
    private Person person3 = new Person("Elise");
    @Test
    public void constructorOneTest(){
        Scoreboard board = new Scoreboard();
        Assert.assertNotNull(board);
    }

    @Test
    public void secondConstructorTest(){
        //given
        Scoreboard board = new Scoreboard();
        Person[] expected = {person1, person2, person3};
        //when
        board.addPlayer(person1);
        board.addPlayer(person2);
        board.addPlayer(person3);
        //then
        Person[] actual = board.getPlayers();

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void thirdConstructorTest(){
        //given
        Scoreboard board = new Scoreboard();
        Person[] expected = {person1, person2};
        //when
        board.addPlayer(person1);
        board.addPlayer(person2);
        //then
        Person[] actual = board.getPlayers();

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void setScoreboardTest(){

    }

    @Test
    public void getScoreboardTest(){

    }

    @Test
    public void getPlayersTest() {
        //given
        Scoreboard board = new Scoreboard();
        Person[] expectedPlayers = {person1, person2};
        //when
        board.addPlayer(person1);
        board.addPlayer(person2);
        //then
        Person[] actualPlayers = board.getPlayers();

        Assert.assertArrayEquals(expectedPlayers, actualPlayers);

    }

    @Test
    public void addPlayerTest() {
        //given
        Scoreboard board = new Scoreboard();
        Person[] expected = {person1, person2, person3};
        //when
        board.addPlayer(person1);
        board.addPlayer(person2);
        board.addPlayer(person3);
        //then
        Person[] actual = board.getPlayers();

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void removePlayerTest() {
        //given
        Scoreboard board = new Scoreboard();
        Person[] players = {person1, person2, person3};
        //when
        board.addPlayer(person2);
        board.addPlayer(person1);
        board.addPlayer(person3);
        Person[] expected = {person2, person3};
        //then
        board.removePlayer(person1);
        Person[] actual = board.getPlayers();

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void updateScoreTest() {
        //given
        Scoreboard board = new Scoreboard();
        Integer expectedScore = 6;
        //when
        board.addPlayer(person1);
        //then
        board.updateScore(person1, 6);
        Integer actualScore = board.getScore(person1);

        Assert.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void clearScoreboardTest() {

        Scoreboard board = new Scoreboard();
        Person[] expected = {};
        board.addPlayer(person1);
        board.addPlayer(person2);

        board.clearScoreboardOfPlayersAndScores();
        Person[] actual = board.getPlayers();
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void resetScoreboardForSamePlayers(){
        //Given
        Scoreboard board = new Scoreboard();
        Person[] expected = {person1, person2};
        //when
        board.addPlayer(person1);
        board.addPlayer(person2);
        board.updateScore(person1, 7);
        board.updateScore(person2, 9);
        //then
        board.resetScoreboardForSamePlayers();
        Person[] actual = board.getPlayers();
        Assert.assertArrayEquals(expected, actual);

    }

    @Test
    public void resetScoreboardForSamePlayer2() {
        Scoreboard board = new Scoreboard();
        Integer expected = 0;
        board.addPlayer(person1);
        board.updateScore(person1, 7);
        board.resetScoreboardForSamePlayers();
        Integer actual = board.getScore(person1);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void displaySingleGameTest() {

    }

    @Test
    public void displayRunningGameTallyTest(){
        Scoreboard board = new Scoreboard();
        board.addPlayer(person1);
        board.updateScore(person1, 7);
        board.displayRunningGameTally();
        String actual = board.displayRunningGameTally();
        System.out.println(actual);


    }

}
