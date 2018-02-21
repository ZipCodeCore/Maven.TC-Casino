package io.zipcoder.casino;

import java.util.LinkedHashMap;
import java.util.Map;

public class Scoreboard {

    private LinkedHashMap<Person, Integer> scoreboard;

    public Scoreboard() {
        this.scoreboard = new Scoreboard<Person, Integer>();
    }

    public Scoreboard(Person... people) {
        this.scoreboard = new Scoreboard<Person, Integer>();
        for(int i = 0; i<people.length; i++) {
            scoreboard.put(people[i],0);
        }
    }

    public Scoreboard(LinkedHashMap scoreboard) {
        this.scoreboard = scoreboard;

    }

    public void setScoreboard(LinkedHashMap<Person, Integer> scoreboard) {
        this.scoreboard = scoreboard;
    }

    public LinkedHashMap<Person, Integer> getScoreboard() {
        return scoreboard;
    }

    public Person[] getPlayers() {
        Person[] players = scoreboard.keySet();
        return players;
    }


    public void addPlayer(Person person) {
        this.scoreboard.put(person, 0);
    }

    public void removePlayer(Person person) {
        this.scoreboard.remove(person);
    }

    public void updateScore(Person person, Integer newScore){
       Integer oldScore = pullOldScore(person);
        for(Map.Entry<Person, Integer> entry: this.scoreboard.entrySet()) {
            if(person.equals(entry)) {
                this.scoreboard.replace(person, oldScore, newScore);
            }
        }

    }

    //for updateScore method
    public Integer pullOldScore(Person person) {
        return this.scoreboard.get(person);
    }

    //at end of game for running tally display
    public LinkedHashMap<Person, Integer> recordScore() {
        return this.scoreboard;
    }

    public void resetScoreboardForSamePlayers() {
        this.scoreboard.clear();
    }

    public void clearScoreboardOfPlayersAndScores(LinkedHashMap<Person, Integer> scoreboard) {
        scoreboard.clear();
    }


    //single player score at request of player during game
    public Integer getScore(Person person) {
        return scoreboard.get(person);
    }

    public String displayScoreboardSingleGame(LinkedHashMap scoreboard) {
        return null;
    }

    public String displayRunningGameTally(LinkedHashMap scoreboard) {

        for(Map.Entry<Person, Integer> entry: scoreboard.entrySet()) {
            if()
        }
        return null;
    }


}
