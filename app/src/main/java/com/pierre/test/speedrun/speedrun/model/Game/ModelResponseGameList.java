package com.pierre.test.speedrun.speedrun.model.game;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelResponseGameList {

    @SerializedName("data")
    private List<ModelGame> games;

    public ModelResponseGameList(List<ModelGame> games) {
        this.games = games;
    }

    public List<ModelGame> getGames() {
        return games;
    }
}
