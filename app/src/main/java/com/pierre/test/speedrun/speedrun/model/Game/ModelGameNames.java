package com.pierre.test.speedrun.speedrun.model.game;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ModelGameNames implements Parcelable {

    @SerializedName("international")
    private String international;

    public ModelGameNames(String international) {
        this.international = international;
    }

    protected ModelGameNames(Parcel in) {
        international = in.readString();
    }

    public static final Creator<ModelGameNames> CREATOR = new Creator<ModelGameNames>() {
        @Override
        public ModelGameNames createFromParcel(Parcel in) {
            return new ModelGameNames(in);
        }

        @Override
        public ModelGameNames[] newArray(int size) {
            return new ModelGameNames[size];
        }
    };

    public String getInternational() {
        return international;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(international);
    }
}
