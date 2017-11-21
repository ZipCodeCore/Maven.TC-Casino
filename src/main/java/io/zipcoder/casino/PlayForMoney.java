package io.zipcoder.casino;

public interface PlayForMoney {
    void takeBet(Double betAmount );



    double betReceiveFromPlayers();

    void resolveBets();
}
