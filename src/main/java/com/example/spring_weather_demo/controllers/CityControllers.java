package com.example.spring_weather_demo.controllers;


import com.example.spring_weather_demo.services.CityServices;
import com.example.spring_weather_demo.weather.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public Optional<City>getOneCity(@PathVariable Long id){
    return services.getCityById(id);

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
