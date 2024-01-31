package com.example.spring_weather_demo.services;

import com.example.spring_weather_demo.weather.Weather;
import com.example.spring_weather_demo.repository.WeatherDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherDataServices {

    @Autowired
    private WeatherDataRepository weatherDataRepository;



    //Get all weatherData
    public Iterable<Weather> getAllWeatherData() {
        return weatherDataRepository.findAll();
    }



    //Get one weatherData by id
    public Optional<Weather> getWeatherDataById(Long id) {
        return weatherDataRepository.findById(id);

    }

    //Update one weatherData
    public Weather updateWeatherData(Long id, Weather weather){
        weather.setWeatherId(id);
        return weatherDataRepository.save(weather);
    }


    //Create weatherData
    public Weather createWeatherData (Weather weather){
        return weatherDataRepository.save(weather);
    }


    //Delete one weatherData

    public boolean deleteWeatherDataById(Long id){
        if (weatherDataRepository.existsById(id)){
            weatherDataRepository.deleteById(id);
            return true;
        }
        return false;
    }
    }




