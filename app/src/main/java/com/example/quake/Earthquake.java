package com.example.quake;

public class Earthquake {
    private String location;
    private long timeMilliseconds;
    private double magnitude;

    public Earthquake(String location, long timeMilliseconds, double magnitude) {
        this.location = location;
        this.timeMilliseconds = timeMilliseconds;
        this.magnitude = magnitude;
    }

    public String getLocation() {
        return location;
    }

    public long getTimeMilliseconds(){
        return timeMilliseconds;
    }

    public double getMagnitude() {
        return magnitude;
    }
}
