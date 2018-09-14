package com.pierre.test.speedrun.speedrun.model.game;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ModelGameAssets implements Parcelable{

    @SerializedName("cover-tiny")
    private ModelGameAssetsCover cover;

    public ModelGameAssetsCover getCover() {
        return cover;
    }

    protected ModelGameAssets(Parcel in) {
        cover = in.readParcelable(ModelGameAssetsCover.class.getClassLoader());
    }

    public static final Creator<ModelGameAssets> CREATOR = new Creator<ModelGameAssets>() {
        @Override
        public ModelGameAssets createFromParcel(Parcel in) {
            return new ModelGameAssets(in);
        }

        @Override
        public ModelGameAssets[] newArray(int size) {
            return new ModelGameAssets[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(cover, i);
    }
}
