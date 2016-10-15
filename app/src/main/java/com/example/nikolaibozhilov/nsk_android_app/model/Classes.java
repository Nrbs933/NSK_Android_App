package com.example.nikolaibozhilov.nsk_android_app.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.orm.SugarRecord;

/**
 * Created by Nikolai Bozhilov on 09-Oct-16.
 */

public class Classes extends SugarRecord implements Parcelable {

    private String className;
    private String classRole;
    private String classPrimaryStat;
    private String classResource;
    private int classImageInMemory;
    private String imageURI;
    private String resourceBarColor;
    public Classes(){

    }
    public Classes(String className, String classRole, String classPrimaryStat, String classResource, int classImageInMemory, String imageURI,String resourceBarColor){
        this.setClassName(className);
        this.setClassRole(classRole);
        this.setClassPrimaryStat(classPrimaryStat);
        this.setClassResource(classResource);
        this.setClassImageInMemory(classImageInMemory);
        this.setImageURI(imageURI);
        this.setResourceBarColor(resourceBarColor);

    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassRole() {
        return classRole;
    }

    public void setClassRole(String classRole) {
        this.classRole = classRole;
    }

    public String getClassPrimaryStat() {
        return classPrimaryStat;
    }

    public void setClassPrimaryStat(String classPrimaryStat) {
        this.classPrimaryStat = classPrimaryStat;
    }
    public String getImageURI() {
        return imageURI;
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }
    public String getResourceBarColor() {
        return resourceBarColor;
    }

    public void setResourceBarColor(String resourceBarColor) {
        this.resourceBarColor = resourceBarColor;
    }

    public String getClassResource() {
        return classResource;
    }

    public void setClassResource(String classResource) {
        this.classResource = classResource;
    }

    public int getClassImageURI() {
        return classImageInMemory;
    }

    public void setClassImageInMemory(int classImageURI) {
        this.classImageInMemory = classImageURI;
    }

    protected Classes(Parcel in) {
        className = in.readString();
        classRole = in.readString();
        classPrimaryStat = in.readString();
        classResource = in.readString();
        classImageInMemory = in.readInt();
        imageURI = in.readString();
        resourceBarColor = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(className);
        dest.writeString(classRole);
        dest.writeString(classPrimaryStat);
        dest.writeString(classResource);
        dest.writeInt(classImageInMemory);
        dest.writeString(imageURI);
        dest.writeString(resourceBarColor);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Classes> CREATOR = new Parcelable.Creator<Classes>() {
        @Override
        public Classes createFromParcel(Parcel in) {
            return new Classes(in);
        }

        @Override
        public Classes[] newArray(int size) {
            return new Classes[size];
        }
    };



}
