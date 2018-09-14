package com.pierre.test.speedrun.speedrun.services;

import com.pierre.test.speedrun.speedrun.model.game.ModelGame;
import com.pierre.test.speedrun.speedrun.model.speedrun.ModelSpeedRun;

import java.util.List;

import io.reactivex.Observable;

public class SpeedRunService {

    /**
     * Get the speedrun games from the server
     * Transform the model from the server into a list of game
     *
     * return Observable containing the speedrun games
     */
    public static Observable<List<ModelGame>> getGames() {
        SpeedRunApi api = RestClient.getSpeedRunApi();

        return api.getGames()
                .map(responseGames -> responseGames.getGames());
    }

    /**
     * Get the speedrun from a specified game
     * Transform the model from the server into a list of speedruns
     *
     * return Observable containing the speedrun
     */
    public static Observable<List<ModelSpeedRun>> getSpeedruns(String gameId) {
        SpeedRunApi api = RestClient.getSpeedRunApi();

        return api.getSpeedRuns(gameId)
                .map(responseSpeedruns -> responseSpeedruns.getSpeedruns());
    }
}
