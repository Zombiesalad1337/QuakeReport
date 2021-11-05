package com.example.quake;

public class Earthquake {
    private String location;
    private String date;
    private double magnitude;

    public Earthquake(String location, String date, double magnitude) {
        this.location = location;
        this.date = date;
        this.magnitude = magnitude;
    }

    public String getLocation() {
        return location;
    }

    public String getDate(){
        return date;
    }

    public double getMagnitude() {
        return magnitude;
    }
}
