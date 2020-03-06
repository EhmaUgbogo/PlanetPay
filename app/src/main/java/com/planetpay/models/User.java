package com.planetpay.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.firestore.IgnoreExtraProperties;

import java.util.Date;

@IgnoreExtraProperties
public class User implements Parcelable {
    private String uid;
    private String firstName;
    private String lastName;
    private String middleName;
    private String bvn;
    private String dob;
    private String email;
    private String phoneNo;
    private String imageUrl;

    public User() {
        //Needed
    }

    public User(String firstName, String email, String phoneNo) {
        this.firstName = firstName;
        this.email = email;
        this.phoneNo=phoneNo;
    }

    public User(String firstName, String middleName, String lastName, String dob, String bvn, String email, String phoneNo) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
        this.bvn = bvn;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getBvn() {
        return bvn;
    }

    public void setBvn(String bvn) {
        this.bvn = bvn;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    protected User(Parcel in) {
        uid = in.readString();
        firstName = in.readString();
        email = in.readString();
        phoneNo = in.readString();
        bvn = in.readString();
        middleName = in.readString();
        lastName = in.readString();
        imageUrl = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(uid);
        parcel.writeString(firstName);
        parcel.writeString(email);
        parcel.writeString(phoneNo);
        parcel.writeString(imageUrl);
        parcel.writeString(dob);
        parcel.writeString(bvn);
        parcel.writeString(lastName);
        parcel.writeString(middleName);


    }
}
