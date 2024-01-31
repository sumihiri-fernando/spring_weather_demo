package com.example.spring_weather_demo.services;

import com.example.spring_weather_demo.repository.CityRepository;
import com.example.spring_weather_demo.weather.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityServices {
    @Autowired
    private CityRepository cityRepository;


    //Get all cities
    public Iterable<City> getAllCities() {
        return cityRepository.findAll();}



    //Get one city by id
    public Optional<City> getCityById(Long id) {
        return cityRepository.findById(id);
    }

    //Update one city
    public City updateCity(Long id, City city){
        city.setCityId(id);
        return cityRepository.save(city);
    }


    //Create city
    public City createCity (City city){
        return cityRepository.save(city);

    }


   //Delete one city

    public boolean deleteCityById(Long id){
      if (cityRepository.existsById(id)){
          cityRepository.deleteById(id);
          return true;
      }
       return false;
    }

}



