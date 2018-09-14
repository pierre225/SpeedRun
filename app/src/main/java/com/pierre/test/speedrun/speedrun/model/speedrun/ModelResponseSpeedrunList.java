package com.pierre.test.speedrun.speedrun.model.speedrun;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelResponseSpeedrunList {

    @SerializedName("data")
    private List<ModelSpeedRun> speedruns;

    public List<ModelSpeedRun> getSpeedruns() {
        return speedruns;
    }
}
