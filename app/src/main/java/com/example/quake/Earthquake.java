package com.example.quake;

public class Earthquake {
    private String location;
    private int day;
    private String month;
    private int year;
    private double magnitude;

    public Earthquake(String location, int day, String month, int year, double magnitude) {
        this.location = location;
        this.day = day;
        this.month = month;
        this.year = year;
        this.magnitude = magnitude;
    }

    public String getLocation() {
        return location;
    }

    public int getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public double getMagnitude() {
        return magnitude;
    }
}
