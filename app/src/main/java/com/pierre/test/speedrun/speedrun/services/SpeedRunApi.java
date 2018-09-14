package com.pierre.test.speedrun.speedrun.services;

import com.pierre.test.speedrun.speedrun.model.game.ModelResponseGameList;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface SpeedRunApi {

    @GET("games")
    Observable<ModelResponseGameList> getGames();
}
