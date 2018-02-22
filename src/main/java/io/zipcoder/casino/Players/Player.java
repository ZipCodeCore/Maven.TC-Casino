package io.zipcoder.casino;

public class Player {

    private String name;
    private Integer age;
    private Double balance;



    public Player(String name, Integer age){
        this.name = name;
        this.age = age;
    }


    public Player(String name, Integer age, Double balance) {
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
