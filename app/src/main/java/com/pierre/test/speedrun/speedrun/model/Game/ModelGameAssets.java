package com.pierre.test.speedrun.speedrun.model.game;

import com.google.gson.annotations.SerializedName;

public class ModelGameAssets {

    @SerializedName("cover-tiny")
    private ModelGameAssetsCover cover;

    public ModelGameAssets(ModelGameAssetsCover cover) {
        this.cover = cover;
    }

    public ModelGameAssetsCover getCover() {
        return cover;
    }
}
