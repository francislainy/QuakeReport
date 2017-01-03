package com.example.android.quakereport;

/**
 * Created by Francislainy on 03/01/2017.
 */

public class Earthquake {

    private String magnitude;
    private String place;
    private String date;
    private String time;

    public Earthquake(String magnitude, String place, String date, String time) {
        this.magnitude = magnitude;
        this.place = place;
        this.date = date;
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getDate() {
        return date;
    }

    public String geTime() {
        return time;
    }

}
