package com.example.android.quakereport;

/**
 * Created by Francislainy on 03/01/2017.
 */

public class Earthquake {

    private String magnitude;
    private String city;
    private String date;

    public Earthquake(String magnitude, String city, String date) {
        this.magnitude = magnitude;
        this.city = city;
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getDate() {
        return date;
    }

}
