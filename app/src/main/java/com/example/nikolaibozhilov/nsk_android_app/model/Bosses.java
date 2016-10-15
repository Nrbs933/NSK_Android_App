package com.example.nikolaibozhilov.nsk_android_app.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.orm.SugarRecord;

/**
 * Created by Nikolai Bozhilov on 09-Oct-16.
 */

public class Bosses extends SugarRecord implements Parcelable {

    private String bossName;
    private String bossType;
    private String bossLevel;
    private String bossDamageType;
    private Dungeons bossDungeon;
    private String bossImageURI;
    private int backgroundImageInMemory;

    public Bosses(){

    }

    public Bosses(String bossName, String bossType, String bossLevel, String bossDamageType, Dungeons bossDungeon, String bossImageURI, int backgroundImageInMemory){
        this.setBossName(bossName);
        this.setBossType(bossType);
        this.setBossLevel(bossLevel);
        this.setBossDamageType(bossDamageType);
        this.setBossDungeon(bossDungeon);
        this.setBackgroundImageInMemory(backgroundImageInMemory);
        this.setBossImageURI(bossImageURI);
    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }

    public String getBossType() {
        return bossType;
    }

    public void setBossType(String bossType) {
        this.bossType = bossType;
    }

    public String getBossLevel() {
        return bossLevel;
    }

    public void setBossLevel(String bossLevel) {
        this.bossLevel = bossLevel;
    }

    public String getBossDamageType() {
        return bossDamageType;
    }

    public void setBossDamageType(String bossDamageType) {
        this.bossDamageType = bossDamageType;
    }


    public String getBossImageURI() {
        return bossImageURI;
    }

    public void setBossImageURI(String bossImageURI) {
        this.bossImageURI = bossImageURI;
    }

    public int getBackgroundImageInMemory() {
        return backgroundImageInMemory;
    }

    public void setBackgroundImageInMemory(int backgroundImageInMemory) {
        this.backgroundImageInMemory = backgroundImageInMemory;
    }
    public Dungeons getBossDungeon() {
        return bossDungeon;
    }

    public void setBossDungeon(Dungeons bossDungeon) {
        this.bossDungeon = bossDungeon;
    }

    protected Bosses(Parcel in) {
        bossName = in.readString();
        bossType = in.readString();
        bossLevel = in.readString();
        bossDamageType = in.readString();
        bossDungeon = (Dungeons) in.readValue(Dungeons.class.getClassLoader());
        backgroundImageInMemory = in.readInt();
        bossImageURI = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(bossName);
        dest.writeString(bossType);
        dest.writeString(bossLevel);
        dest.writeString(bossDamageType);
        dest.writeValue(bossDungeon);
        dest.writeInt(backgroundImageInMemory);
        dest.writeString(bossImageURI);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Bosses> CREATOR = new Parcelable.Creator<Bosses>() {
        @Override
        public Bosses createFromParcel(Parcel in) {
            return new Bosses(in);
        }

        @Override
        public Bosses[] newArray(int size) {
            return new Bosses[size];
        }
    };


}
