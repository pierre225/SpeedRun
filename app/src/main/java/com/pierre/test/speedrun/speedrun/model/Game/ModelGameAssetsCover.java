package com.pierre.test.speedrun.speedrun.model.game;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ModelGameAssetsCover implements Parcelable {

    @SerializedName("uri")
    private String uri;

    public String getUri() {
        return uri;
    }

    protected ModelGameAssetsCover(Parcel in) {
        uri = in.readString();
    }

    public static final Creator<ModelGameAssetsCover> CREATOR = new Creator<ModelGameAssetsCover>() {
        @Override
        public ModelGameAssetsCover createFromParcel(Parcel in) {
            return new ModelGameAssetsCover(in);
        }

        @Override
        public ModelGameAssetsCover[] newArray(int size) {
            return new ModelGameAssetsCover[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(uri);
    }
}
