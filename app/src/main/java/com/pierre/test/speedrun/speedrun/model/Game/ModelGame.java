package com.pierre.test.speedrun.speedrun.model.game;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ModelGame implements Parcelable {

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

    protected ModelGame(Parcel in) {
        id = in.readString();
    }

    public static final Creator<ModelGame> CREATOR = new Creator<ModelGame>() {
        @Override
        public ModelGame createFromParcel(Parcel in) {
            return new ModelGame(in);
        }

        @Override
        public ModelGame[] newArray(int size) {
            return new ModelGame[size];
        }
    };

    public String getId() {
        return id;
    }

    public ModelGameNames getNames() {
        return names;
    }

    public ModelGameAssets getAssets() {
        return assets;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
    }
}
