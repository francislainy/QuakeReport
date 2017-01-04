package com.example.android.quakereport;

/**
 * Created by Francislainy on 03/01/2017.
 */

public class Earthquake {

    private double magnitude;
    private String place;
    private String date;
    private String time;

    public Earthquake(double magnitude, String place, String date, String time) {
        this.magnitude = magnitude;
        this.place = place;
        this.date = date;
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getDate() {
        return date;
    }

    public String geTime() {
        return time;
    }

}
