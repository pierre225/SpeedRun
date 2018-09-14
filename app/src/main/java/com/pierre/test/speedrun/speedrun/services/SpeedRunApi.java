package com.pierre.test.speedrun.speedrun.services;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface SpeedRunApi {

    @GET("games")
    Observable<String> getGames();
}
