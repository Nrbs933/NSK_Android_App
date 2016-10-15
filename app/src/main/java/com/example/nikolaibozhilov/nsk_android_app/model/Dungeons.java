package com.example.nikolaibozhilov.nsk_android_app.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.orm.SugarRecord;

/**
 * Created by Nikolai Bozhilov on 09-Oct-16.
 */

public class Dungeons extends SugarRecord implements Parcelable {

    private String dungeonName;
    private String dungeonLevelRange;
    private String dungeonDifficulty;
    private String dungeonBossName;
    private int dungeonBackgroundInMemory;

    public Dungeons(){

    }
    public Dungeons(String dungeonName, String dungeonLevelRange, String dungeonDifficulty, String dungeonBossName, int dungeonBackgroundInMemory){
        this.setDungeonName(dungeonName);
        this.setDungeonLevelRange(dungeonLevelRange);
        this.setDungeonDifficulty(dungeonDifficulty);
        this.setDungeonBossName(dungeonBossName);
        this.setDungeonBackgroundInMemory(dungeonBackgroundInMemory);
    }

    public String getDungeonName() {
        return dungeonName;
    }

    public void setDungeonName(String dungeonName) {
        this.dungeonName = dungeonName;
    }

    public String getDungeonLevelRange() {
        return dungeonLevelRange;
    }

    public void setDungeonLevelRange(String dungeonLevelRange) {
        this.dungeonLevelRange = dungeonLevelRange;
    }

    public String getDungeonDifficulty() {
        return dungeonDifficulty;
    }

    public void setDungeonDifficulty(String dungeonDifficulty) {
        this.dungeonDifficulty = dungeonDifficulty;
    }

    public String getDungeonBossName() {
        return dungeonBossName;
    }

    public void setDungeonBossName(String dungeonBossName) {
        this.dungeonBossName = dungeonBossName;
    }
    public int getDungeonBackgroundInMemory() {
        return dungeonBackgroundInMemory;
    }

    public void setDungeonBackgroundInMemory(int dungeonBackgroundInMemory) {
        this.dungeonBackgroundInMemory = dungeonBackgroundInMemory;
    }

    protected Dungeons(Parcel in) {
        dungeonName = in.readString();
        dungeonLevelRange = in.readString();
        dungeonDifficulty = in.readString();
        dungeonBossName = in.readString();
        dungeonBackgroundInMemory = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(dungeonName);
        dest.writeString(dungeonLevelRange);
        dest.writeString(dungeonDifficulty);
        dest.writeString(dungeonBossName);
        dest.writeInt(dungeonBackgroundInMemory);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Dungeons> CREATOR = new Parcelable.Creator<Dungeons>() {
        @Override
        public Dungeons createFromParcel(Parcel in) {
            return new Dungeons(in);
        }

        @Override
        public Dungeons[] newArray(int size) {
            return new Dungeons[size];
        }
    };



}
