package com.example.spring_weather_demo.controllers;

import com.example.spring_weather_demo.services.WeatherDataServices;
import com.example.spring_weather_demo.weather.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api/weatherData")
public class WeatherDataControllers {


    @Autowired
    private WeatherDataServices services;



// Create one weather data
// POST: /api/weatherData
@PostMapping()
public Weather postWeatherData(@RequestBody Weather weather) {
    return services.createWeatherData(weather);
}


// Read one weather data  by id
// GET: /api/weatherData/{id}
@GetMapping("/{id}")
public Optional<Weather> getOneWeatherDataById(@PathVariable Long id) {
    return services.getWeatherDataById(id);

}
// Read all weather data
// GET: /api/weatherData
@GetMapping
public Iterable<Weather>getAllWeatherData() {
    return services.getAllWeatherData();
}


// Update one weather data
// PUT: /api/weatherData/{id}

@PutMapping(path = "/{id}")
public Weather putWeatherData(@PathVariable Long id , @RequestBody Weather weatherdata) {
    return services.updateWeatherData(id, weatherdata);
}
// Delete one weather data
// DELETE: /api/weatherData/{id}
@DeleteMapping(path = "/{id}")
public boolean deleteOneById(@PathVariable Long id){

    return services.deleteWeatherDataById(id);
}


}



