package io.zipcoder.casino.Players;

public class Player {


    protected String name;
    protected Integer age;



    public Player(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public Player(){
        this.name = "";
        this.age = Integer.MAX_VALUE;
    }


    public Player(String name, Integer age, Integer balance) {
        this.name = name;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
