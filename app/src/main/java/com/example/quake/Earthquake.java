package com.example.quake;

public class Earthquake {
    private String location;
    private long timeMilliseconds;
    private double magnitude;
    private String url;

    public Earthquake(String location, long timeMilliseconds, double magnitude, String url) {
        this.location = location;
        this.timeMilliseconds = timeMilliseconds;
        this.magnitude = magnitude;
        this.url = url;
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

    public String getUrl(){
        return url;
    }
}
