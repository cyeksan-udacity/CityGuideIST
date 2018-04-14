package com.example.android.tourguideapp;

/**
 * Created by Cansu on 10.04.2018.
 */

public class Place {

    private String mNameOfPlace;
    private String mShortAddress;
    private String mDescription;
    private String mLongAddress;
    private String mWorkingHoursOrPrice;
    private double mLongitude;
    private double mLatitude;
    private String mPhone;
    private String mWebPage;
    private int mImageResourceId;

    //Public constructor of the Place object for Popular Places and Museums:

    public Place(String nameOfPlace, String shortAddress, String description, String longAddress,
                 String workingHoursOrPrice, double longitude, double latitude, String phone, String webPage, int imageResourceId){

        mNameOfPlace = nameOfPlace;
        mShortAddress = shortAddress;
        mDescription = description;
        mLongAddress = longAddress;
        mWorkingHoursOrPrice = workingHoursOrPrice;
        mLongitude = longitude;
        mLatitude = latitude;
        mPhone = phone;
        mWebPage = webPage;
        mImageResourceId = imageResourceId;

    }
    //Public constructor of the Place object for Cafe & Restaurant, Cinema, Hospital, Shopping and Hotel:

    public Place(String nameOfPlace, String shortAddress, String longAddress,
                 String workingHoursOrPrice, double longitude, double latitude, String phone, String webPage, int imageResourceId){

        mNameOfPlace = nameOfPlace;
        mShortAddress = shortAddress;
        mLongAddress = longAddress;
        mWorkingHoursOrPrice = workingHoursOrPrice;
        mLongitude = longitude;
        mLatitude = latitude;
        mPhone = phone;
        mWebPage = webPage;
        mImageResourceId = imageResourceId;


    }

    //Public constructor of the Place object for Cinema and Airport:

    public Place(String nameOfPlace, String shortAddress, String longAddress,
                 double longitude, double latitude, String phone, String webPage, int imageResourceId){

        mNameOfPlace = nameOfPlace;
        mShortAddress = shortAddress;
        mLongAddress = longAddress;
        mLongitude = longitude;
        mLatitude = latitude;
        mPhone = phone;
        mWebPage = webPage;
        mImageResourceId = imageResourceId;


    }

    //Public constructor of the Place object for Bus:

    public Place(String nameOfPlace, String shortAddress, String longAddress, double longitude, double latitude,
                 String phone, int imageResourceId){

        mNameOfPlace = nameOfPlace;
        mShortAddress = shortAddress;
        mLongAddress = longAddress;
        mLongitude = longitude;
        mLatitude = latitude;
        mPhone = phone;
        mImageResourceId = imageResourceId;


    }


    public String getNameOfPlace(){

        return mNameOfPlace;
    }

    public String getShortAddress(){

        return mShortAddress;
    }

    public String getLongAddress(){

        return mLongAddress;
    }

    public String getDescription(){

        return mDescription;
    }

    public String getWorkingHoursOrPrice(){

        return mWorkingHoursOrPrice;
    }

    public double getLongitude(){

        return mLongitude;
    }

    public double getLatitude(){

        return mLatitude;
    }

    public String getPhone(){

        return mPhone;
    }

    public String getWebPage(){

        return mWebPage;
    }


    public int getImageResourceId() {

        return mImageResourceId;
    }

}
