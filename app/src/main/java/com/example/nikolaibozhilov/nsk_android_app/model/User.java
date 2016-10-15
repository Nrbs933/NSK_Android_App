package com.example.nikolaibozhilov.nsk_android_app.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.orm.SugarRecord;

/**
 * Created by Nikolai Bozhilov on 07-Oct-16.
 */

public class User extends SugarRecord implements Parcelable {

    private String username;
    private String password;
    private String email;
    private String favoriteClass;

    public User(){

    }

    public User(String username, String password, String email, String favoriteClass){
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.setFavoriteClass(favoriteClass);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    protected User(Parcel in) {
        username = in.readString();
        password = in.readString();
        email = in.readString();
        favoriteClass = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(password);
        dest.writeString(email);
        dest.writeString(favoriteClass);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getFavoriteClass() {
        return favoriteClass;
    }

    public void setFavoriteClass(String favoriteClass) {
        this.favoriteClass = favoriteClass;
    }
}
