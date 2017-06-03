package com.example.android.tourguideapp;

/**
 * Created by Han on 6/2/2017.
 */

public class Place {
    private String mName;
    private String mLocation;
    private String mAddress;
    private String mStreet;
    private String mCity;
    private String mState;
    private String mZipCode;

    /**
     * Only sets name
     * @param name
     */
    public Place(String name) {
        this.mName = name;
    }

    /**
     * Add name and address of place
     * @param name
     * @param street
     * @param city
     * @param state
     * @param zipCode
     */
    public Place(String name, String street, String city, String state, String zipCode) {
        this.mName = name;
        this.mStreet = street;
        this.mCity = city;
        this.mState = state;
        this.mZipCode = zipCode;
    }

    /**
     * Getter for mName
     * @return name of place
     */
    public String getName() {
        return mName;
    }

    /**
     * Getter for location
     * @return
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     * Getter for adress
     * @return
     */
    public String getAddress() {
        return mAddress;
    }

    public String getStreet() {
        return mStreet;
    }

    public String getCity() {
        return mCity;
    }

    public String getState() {
        return mState;
    }

    public String getZipCode() {
        return mZipCode;

    }

    public String getCityStateZip() {
        return mCity + ", " + mState + ", " + mZipCode;
    }
}
