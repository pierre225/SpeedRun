package com.pierre.test.speedrun.speedrun.services;

import io.reactivex.Observable;

public class SpeedRunService {

    /**
     * Get the speedrun games
     *
     * return Observable containing the speedrun games
     */
    public static Observable<String> getGames() {
        SpeedRunApi api = RestClient.getSpeedRunApi();
        return api.getGames();
    }
}
