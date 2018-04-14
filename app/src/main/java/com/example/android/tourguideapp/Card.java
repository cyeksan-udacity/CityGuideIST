package com.example.android.tourguideapp;

/**
 * Created by Cansu on 11.04.2018.
 */

public class Card {

    //This class is for creating CardView arrays.

    private String mName;
    private String mHookSentence;
    private String mShortAddress;
    private int mImageResourceID;
    private String mDescription;
    private String mLongAddress;
    private String mWorkingHoursOrPrice;
    private double mLongitude;
    private double mLatitude;
    private String mPhone;
    private String mWebPage;


    public Card(String name, String hookSentence, String shortAddress, int imageResourceID, String description,
                String longAddress, String workingHoursOrPrice, double longitude, double latitude, String phone, String webpage){

        mName = name;
        mHookSentence = hookSentence;
        mShortAddress = shortAddress;
        mImageResourceID = imageResourceID;
        mDescription = description;
        mLongAddress = longAddress;
        mWorkingHoursOrPrice = workingHoursOrPrice;
        mLongitude = longitude;
        mLatitude = latitude;
        mPhone = phone;
        mWebPage = webpage;
    }

    public Card(String name, String hookSentence, String shortAddress, int imageResourceID,
                String longAddress, String workingHoursOrPrice, double longitude, double latitude, String phone, String webpage){

        mName = name;
        mHookSentence = hookSentence;
        mShortAddress = shortAddress;
        mImageResourceID = imageResourceID;
        mLongAddress = longAddress;
        mWorkingHoursOrPrice = workingHoursOrPrice;
        mLongitude = longitude;
        mLatitude = latitude;
        mPhone = phone;
        mWebPage = webpage;
    }

    public String getName() {
        return mName;
    }

    public String getHookSentence() {
        return mHookSentence;
    }

    public String getShortAddress() {
        return mShortAddress;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getLongAddress() {
        return mLongAddress;
    }

    public String getWorkingHoursOrPrice() {
        return mWorkingHoursOrPrice;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getWebPage() {
        return mWebPage;
    }

    public int getImageResourceID() {
        return mImageResourceID;
    }
}
