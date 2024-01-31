package com.example.spring_weather_demo.repository;

import com.example.spring_weather_demo.weather.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {
}
