package com.pierre.test.speedrun.speedrun.model.speedrun;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelSpeedRun {

    @SerializedName("id")
    private String id;

    @SerializedName("game")
    private String gameId;

    @SerializedName("videos")
    private ModelVideo video;

    @SerializedName("times")
    private ModelTime times;

    @SerializedName("players")
    private List<ModelPlayer> players;

    public String getId() {
        return id;
    }

    public String getGameId() {
        return gameId;
    }

    public ModelVideo getVideo() {
        return video;
    }

    public ModelTime getTimes() {
        return times;
    }

    public List<ModelPlayer> getPlayers() {
        return players;
    }
}
