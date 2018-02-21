package io.zipcoder.casino;

import org.junit.Test;
import org.junit.Assert;

public class ScoreboardTest {

    @Test
    public void constructorWithNoParameterTest(){
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

        Assert.assertEquals(expected, actual);
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

        Assert.assertEquals(expected, actual);
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

        Assert.assertEquals(expectedPlayers, actualPlayers);

    }

    @Test
    public void addPlayerTest() {
        //given
        Scoreboard board = new Scoreboard();
        Person[] players = {person1, person2, person3};
        Person[] expected = {person2, person3};
        //when
        board.addPlayer(person2);
        board.addPlayer(person1);
        //then
        Person[] actual = board.getPlayers();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removePlayerTest() {
        //given
        Scoreboard board = new Scoreboard();
        Person[] players = {person1, person2, person3};
        //when
        board.addPlayer(person2);
        board.addPlayer(person1);
        Person[] expected = {person2, person3};
        //then
        Person[] actual = board.removePlayer(person1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateScoreTest() {
        //given
        Scoreboard board = new Scoreboard();
        Integer expectedScore = 6;
        //when
        board.addPlayer(person1);
        //then
        board.updateScore(person1, 6, 0);
        Integer actualScore = board.getScore(person1);

        Assert.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void clearScoreboardTest() {

    }

    @Test
    public void resetScoreboardForSamePlayers(){

    }

    @Test
    public void recordScoreTest() {

    }

    @Test
    public void displaySingleGameTest() {

    }

    @Test
    public void displayRunningGameTallyTest(){

    }

}
