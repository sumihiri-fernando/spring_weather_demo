package com.example.spring_weather_demo.weather;// WeatherData.java

import jakarta.persistence.*;

@Entity
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String temperature;

    @Column(name = "weather_condition")
    private String condition;

    private Long cityId;

    // Constructors

    public Weather() {
    }

    public Weather(String temperature, String condition, Long cityId) {
        this.temperature = temperature;
        this.condition = condition;
        this.cityId = cityId;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public void setWeatherId(Long id) {
        this.id=id;
    }
}
