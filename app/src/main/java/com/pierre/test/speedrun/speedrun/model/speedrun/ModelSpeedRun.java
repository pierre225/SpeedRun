package com.pierre.test.speedrun.speedrun.model.speedrun;

import com.google.gson.annotations.SerializedName;

public class ModelSpeedRun {

    @SerializedName("id")
    private String id;

    @SerializedName("game")
    private String gameId;

    @SerializedName("videos")
    private ModelVideo video;
}
