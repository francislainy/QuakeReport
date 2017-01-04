package com.example.android.quakereport;

/**
 * Created by Francislainy on 03/01/2017.
 */

public class Earthquake {

    private double magnitude;
    private String place;
    private String date;
    private String time;
    private String url;

    public Earthquake(double magnitude, String place, String date, String time) {
        this.magnitude = magnitude;
        this.place = place;
        this.date = date;
        this.time = time;
    }

    public Earthquake(double magnitude, String place, String date, String time, String url) {
        this.magnitude = magnitude;
        this.place = place;
        this.date = date;
        this.time = time;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

}
