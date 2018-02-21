package io.zipcoder.casino;

import io.zipcoder.casino.Profile;

public class Player {

    private Profile someProfile;

    public Player(Profile someProfile) {
        this.someProfile = someProfile;
    }

    public Player(){

    }

    public void setSomeProfile(Profile someProfile) {
        this.someProfile = someProfile;
    }
}
