package com.example.fujitsu.model;

import jakarta.persistence.*;

@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String stationName;
    private long WMO;
    private double temperature;
    private double windSpeed;
    private String phenomenon;

    public Weather(Long id, String stationName, long wmo, double temperature, double windSpeed, String phenomenon) {
        this.id = id;
        this.stationName = stationName;
        WMO = wmo;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.phenomenon = phenomenon;
    }

    public Weather() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
