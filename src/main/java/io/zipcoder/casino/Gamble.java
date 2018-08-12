package io.zipcoder.casino;


public interface Gamble<T> {
    public Integer takeBet(T player);
    public void resetBets();


}
