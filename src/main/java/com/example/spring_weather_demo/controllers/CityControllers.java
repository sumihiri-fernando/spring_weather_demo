package com.example.spring_weather_demo.controllers;


import com.example.spring_weather_demo.services.CityServices;
import com.example.spring_weather_demo.weather.City;
import com.example.spring_weather_demo.weather.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/cities")
public class CityControllers {


    @Autowired
    private CityServices services;



    // Create one city
    // POST: /api/cities
@PostMapping()
public City postCity(@RequestBody City city){
  return services.createCity(city);

}



    // Read one city by id
    // GET: /api/cities/{id}

    @GetMapping(path = "/{id}")
    public String getOneCity(@PathVariable Long id) {
        Optional<City> optionalCity = services.getCityById(id);
        StringBuilder cityInfo = new StringBuilder();

        optionalCity.ifPresent(city -> {
            cityInfo.append("City ID: ").append(city.getCityId()).append("\n");
            cityInfo.append("City Name: ").append(city.getCityName()).append("\n");
            cityInfo.append("Country ID: ").append(city.getCountryId()).append("\n");

            List<Weather> weatherList = city.getWeatherList();

            if (!weatherList.isEmpty()) {
                Weather latestWeather = weatherList.get(weatherList.size() - 1);
                cityInfo.append("Latest Condition: ").append(latestWeather.getCondition()).append("\n");
                cityInfo.append("Latest Temperature: ").append(latestWeather.getTemperature()).append("\n");
            } else {
                cityInfo.append("No weather data available for this city.");
            }
        });

        return cityInfo.toString();
    }




    // Read all cities
    // GET: /api/cities
@GetMapping
public Iterable<City>getAllCities(){
    return services.getAllCities();
}


    // Update one city
    // PUT: /api/cities/{id}
    @PutMapping(path = "/{id}")
    public City putCity(@PathVariable Long id , @RequestBody City city) {
        return services.updateCity(id, city);

    }
    // Delete one city
    // DELETE: /api/cities/{id}

@DeleteMapping(path = "/{id}")
    public boolean deleteOneById(@PathVariable Long id){
    return services.deleteCityById(id);
}
}
