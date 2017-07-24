package com.example.kazi.igtandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Kazi on 22/06/2017.
 */

public class GameDataParcel implements Parcelable {

    public String gameName;
    public String gameDate;
    public String gameJackpot;

    public GameDataParcel(String gameName, String gameDate, String gameJackpot) {

        this.gameName = gameName;
        this.gameDate = gameDate;
        this.gameJackpot = gameJackpot;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.gameName);
        dest.writeString(this.gameDate);
        dest.writeString(this.gameJackpot);

    }

    protected GameDataParcel(Parcel in) {
        this.gameName = in.readString();
        this.gameDate = in.readString();
        this.gameJackpot = in.readString();
    }

    public static final Creator<GameDataParcel> CREATOR = new Creator<GameDataParcel>() {
        public GameDataParcel createFromParcel(Parcel source) {
            return new GameDataParcel(source);
        }

        public GameDataParcel[] newArray(int size) {
            return new GameDataParcel[size];
        }
    };
}
