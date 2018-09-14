package com.pierre.test.speedrun.speedrun.model.Game;

import com.google.gson.annotations.SerializedName;

public class ModelGameNames {

    @SerializedName("international")
    private String international;

    public ModelGameNames(String international) {
        this.international = international;
    }

    public String getInternational() {
        return international;
    }
}
