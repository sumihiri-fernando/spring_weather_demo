package com.example.spring_weather_demo.controllers;

import com.example.spring_weather_demo.services.CityServices;
import com.example.spring_weather_demo.services.WeatherDataServices;
import com.example.spring_weather_demo.weather.City;
import com.example.spring_weather_demo.weather.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api/weatherData")
public class WeatherDataControllers {


    @Autowired
    private WeatherDataServices services;
    @Autowired
    private CityServices cityServices;



// Create one weather data
// POST: /api/weatherData
@PostMapping()
public ResponseEntity<?> postWeatherData(@RequestBody Weather weather) {
    Long cityId = weather.getCityId();

    Optional<City> existingCity = cityServices.getCityById(cityId);

    if (existingCity.isPresent()) {
        // Set the City object for the Weather data
        weather.setCity(existingCity.get());

        // Save the Weather data
        Weather savedWeather = services.createWeatherData(weather);

        // Return response with created status and the created weather data
        return ResponseEntity.status(HttpStatus.CREATED).body(savedWeather);
    } else {
        // Return response with not found status and error message
        String errorMessage = "City not found with ID: " + cityId;
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
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



