// Weather.java

package com.example.spring_weather_demo.weather;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String temperature;

    @Column(name = "city_id")
    private Long cityId;

    @Column(name = "weather_condition")
    private String condition;

    @ManyToOne
    @JoinColumn(name = "city_id", insertable = false, updatable = false)
    @JsonBackReference
    private City city;

    public Weather(String temperature, String condition) {
        this.temperature = temperature;
        this.condition = condition;
    }

    public Weather() {

    }

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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Long getCityId() {
        return cityId;
    }
}
