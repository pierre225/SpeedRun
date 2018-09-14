package com.pierre.test.speedrun.speedrun.model.speedrun;

import com.google.gson.annotations.SerializedName;

public class ModelLink {

    @SerializedName("uri")
    private String uri;

    public String getUri() {
        return uri;
    }
}
