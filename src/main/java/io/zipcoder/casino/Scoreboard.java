package io.zipcoder.casino;

import java.util.*;



public class Scoreboard {

    private LinkedHashMap<Person, Integer> scoreboard;



    public Scoreboard() {
        this.scoreboard = new LinkedHashMap<Person, Integer>();
    }

    public Scoreboard(Person... people) {
        this.scoreboard = new LinkedHashMap<Person, Integer>();
        for(int i = 0; i<people.length; i++) {
            scoreboard.put(people[i],0);
        }
    }

    public Scoreboard(LinkedHashMap<Person, Integer> scoreboard) {
        this.scoreboard = scoreboard;

    }

    public void setScoreboard(LinkedHashMap<Person, Integer> scoreboard) {
        this.scoreboard = scoreboard;
    }

    public LinkedHashMap<Person, Integer> getScoreboard() {
        return scoreboard;
    }

    public Person[] getPlayers() {
        Set<Person> players = scoreboard.keySet();
        Person[] playerArray = players.toArray(new Person[players.size()]);
        return playerArray;
    }

    public void addPlayer(Person person) {
        this.scoreboard.put(person, 0);
    }

    public void removePlayer(Person person) {
        this.scoreboard.remove(person);
    }

    public void updateScore(Person person, Integer newScore){
        for(Map.Entry<Person, Integer> entry: this.scoreboard.entrySet()) {
            if(scoreboard.containsKey(person) && person.equals(entry.getKey())) {
                scoreboard.put(person, newScore);
            }
        }
    }


    public void resetScoreboardForSamePlayers() {
        for(Map.Entry<Person, Integer> entry: this.scoreboard.entrySet()) {
            if(entry.getKey().equals(entry.getKey())) {
                scoreboard.put(entry.getKey(), 0);
            }
        }
    }

    public void clearScoreboardOfPlayersAndScores() {
        this.scoreboard.clear();
    }


    //single player score at request of player during game
    public Integer getScore(Person person) {
        return scoreboard.get(person);
    }


    public String displayScoreboardSingleGame() {
        String display = String.format("%-15s | %-10s\n", "Name", "Score");
        display += "------------------------\n";
        for(Map.Entry<Person, Integer> entry: scoreboard.entrySet()) {
            String name = entry.getKey().getName();
            String score = entry.getValue().toString();
            display += String.format("%-15s | ", name);
            display += String.format("%-10s\n", score);
        }
        return display;
    }

/*    public String displayRunningGameTally() {
        LinkedHashMap<Person, ArrayList<Integer>> runningTally = new LinkedHashMap<Person, ArrayList<Integer>>();
        String tally = String.format("%-15s | %-10s \n", "Name", "Games");
        tally += "---------------------------------------\n";
        for(Map.Entry<Person, Integer> entry: scoreboard.entrySet()) {
            for(Map.Entry<Person, ArrayList<Integer>> secondEntry: runningTally.entrySet()) {
                if(!(runningTally.containsKey(entry.getKey()))) {
                    ArrayList<Integer> tallyList = new ArrayList<Integer>(Arrays.asList(entry.getValue()));
                    runningTally.put(entry.getKey(), tallyList);
                }
                if((runningTally.containsKey(entry.getKey()))) {
                    secondEntry.getValue().add(entry.getValue());
                }
            }
        }
        for(Map.Entry<Person, ArrayList<Integer>> secondEntry: runningTally.entrySet()) {
            String key = secondEntry.getKey().getName();
            tally += String.format("%-15s | \n", key);
        }
        return tally;
    }
    */


}
