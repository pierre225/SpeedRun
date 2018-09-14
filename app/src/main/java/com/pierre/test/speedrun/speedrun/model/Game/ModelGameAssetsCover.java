package com.pierre.test.speedrun.speedrun.model.Game;

import com.google.gson.annotations.SerializedName;

public class ModelGameAssetsCover {

    @SerializedName("uri")
    private String uri;

    public ModelGameAssetsCover(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }
}
