package com.pierre.test.speedrun.speedrun.model.speedrun;

import com.google.gson.annotations.SerializedName;

public class ModelPlayer {

    @SerializedName("name")
    String name;

    @SerializedName("id")
    String id;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
