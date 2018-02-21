package io.zipcoder.casino;

import io.zipcoder.casino.Profile;

public class Player {
    public Player(){

    }

    private Profile someProfile;

    public Player(Profile someProfile) {
        this.someProfile = someProfile;
    }

    public void setSomeProfile(Profile someProfile) {
        this.someProfile = someProfile;
    }
}
