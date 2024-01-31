package com.example.spring_weather_demo.repository;

import com.example.spring_weather_demo.weather.Weather;
import org.springframework.data.repository.CrudRepository;

public interface WeatherDataRepository extends CrudRepository<Weather,Long> {


}
