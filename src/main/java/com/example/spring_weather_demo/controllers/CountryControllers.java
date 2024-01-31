package com.example.spring_weather_demo.controllers;

import com.example.spring_weather_demo.services.CountryServices;
import com.example.spring_weather_demo.weather.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(path = "/api/countries")
public class CountryControllers {

    @Autowired
    private CountryServices services;


    // Create one country
    // POST: /api/countries
    @PostMapping()
    public Country postCountry(@RequestBody Country country) {
        return services.createCountry(country);

    }

    // Read one country by id
    // GET: /api/countries/{id}

    @GetMapping("/{id}")
    public Optional<Country> getOneCountry(@PathVariable Long id) {
        return services.getCountryById(id);
    }

    // Read all countries
    // GET: /api/countries
    @GetMapping
    public Iterable<Country> getAllCountries() {
        return services.getAllCountries();

    }

    // Update one countries
    // PUT: /api/countries/{id}
    @PutMapping(path = "/{id}")
    public Country putCountry(@PathVariable Long id, @RequestBody Country country) {

        return services.updateCountry(id,country);

    }
    // Delete one country
    // DELETE: /api/countries{id}

    @DeleteMapping(path = "/{id}")
    public boolean deleteOneById(@PathVariable Long id) {
        return services.deleteCountryById(id);
    }
}