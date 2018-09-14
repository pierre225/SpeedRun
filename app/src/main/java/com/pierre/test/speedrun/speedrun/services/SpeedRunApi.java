package com.pierre.test.speedrun.speedrun.services;

import com.pierre.test.speedrun.speedrun.model.game.ModelResponseGameList;
import com.pierre.test.speedrun.speedrun.model.speedrun.ModelResponseSpeedrunList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SpeedRunApi {

    @GET("games")
    Observable<ModelResponseGameList> getGames();

    @GET("runs")
    Observable<ModelResponseSpeedrunList> getSpeedRuns(@Query("game") String game);
}
