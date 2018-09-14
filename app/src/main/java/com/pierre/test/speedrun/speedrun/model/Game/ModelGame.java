package com.pierre.test.speedrun.speedrun.model.game;

import com.google.gson.annotations.SerializedName;

public class ModelGame {

    @SerializedName("id")
    private String id;

    @SerializedName("names")
    private ModelGameNames names;

    @SerializedName("assets")
    private ModelGameAssets assets;

    public ModelGame(String id, ModelGameNames names, ModelGameAssets assets) {
        this.id = id;
        this.names = names;
        this.assets = assets;
    }

    public String getId() {
        return id;
    }

    public ModelGameNames getNames() {
        return names;
    }

    public ModelGameAssets getAssets() {
        return assets;
    }
}
