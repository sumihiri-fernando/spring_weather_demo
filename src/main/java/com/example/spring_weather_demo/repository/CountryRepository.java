package com.example.spring_weather_demo.repository;

import com.example.spring_weather_demo.weather.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {
}
