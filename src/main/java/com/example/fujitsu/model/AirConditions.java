package com.example.fujitsu.model;

import com.fasterxml.jackson.annotation.JsonGetter;


public class AirConditions {

    private String stationName;
    private long WMO;
    private double temperature;
    private double windSpeed;
    private String phenomenon;

    public AirConditions(String stationName, long WMO, double temperature, double windSpeed, String phenomenon) {
        this.stationName = stationName;
        this.WMO = WMO;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.phenomenon = phenomenon;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public long getWMO() {
        return WMO;
    }

    public void setWMO(long WMO) {
        this.WMO = WMO;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getPhenomenon() {
        return phenomenon;
    }

    public void setPhenomenon(String phenomenon) {
        this.phenomenon = phenomenon;
    }

}
