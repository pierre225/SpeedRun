package com.pierre.test.speedrun.speedrun.model.game;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ModelGame implements Parcelable {

    @SerializedName("id")
    private String id;

    @SerializedName("names")
    private ModelGameNames names;

    @SerializedName("assets")
    private ModelGameAssets assets;

    public String getId() {
        return id;
    }

    public ModelGameNames getNames() {
        return names;
    }

    public ModelGameAssets getAssets() {
        return assets;
    }

    protected ModelGame(Parcel in) {
        id = in.readString();
        names = in.readParcelable(ModelGameNames.class.getClassLoader());
        assets = in.readParcelable(ModelGameAssets.class.getClassLoader());
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeParcelable(names, i);
        parcel.writeParcelable(assets, i);
    }
}
