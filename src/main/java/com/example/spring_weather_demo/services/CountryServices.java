package com.example.spring_weather_demo.services;

import com.example.spring_weather_demo.repository.CountryRepository;
import com.example.spring_weather_demo.weather.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServices {
    @Autowired
    private CountryRepository countryRipository;


    //Get all country
    public Iterable<Country> getAllCountries() {
        return countryRipository.findAll();

    }
    //Get one country by id
    public Optional<Country> getCountryById(Long id) {
        return countryRipository.findById(id);
    }

    //Update one country
    public Country updateCountry(Long id, Country country) {
        country.setCountryId(id);
        return countryRipository.save(country);
    }


    //Create country
    public Country createCountry(Country country){
        return countryRipository.save(country);

}
    //Delete one country

    public boolean deleteCountryById(Long id){
        if (countryRipository.existsById(id)){
            countryRipository.deleteById(id);
            return true;
        }
        return false;
    }

}


