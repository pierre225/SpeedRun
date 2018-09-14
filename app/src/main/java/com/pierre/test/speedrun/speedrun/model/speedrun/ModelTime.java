package com.pierre.test.speedrun.speedrun.model.speedrun;

import com.google.gson.annotations.SerializedName;

public class ModelTime {

    @SerializedName("realtime_t")
    private Integer time;

    public Integer getTime() {
        return time;
    }
}
