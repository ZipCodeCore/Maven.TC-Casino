package io.zipcoder.casino;

public class Player {

    String name;
    Integer age;
    Integer balance;

    public Player(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public Player(String name, Integer age, Integer balance) {
        this.name = name;
        this.age = age;
        this.balance = balance;
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
    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

}
