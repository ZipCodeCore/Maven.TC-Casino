package io.zipcoder.casino;

public interface Gambler<T> {

    public void bet(double amount);
    public void win();
    public void lose();

}
