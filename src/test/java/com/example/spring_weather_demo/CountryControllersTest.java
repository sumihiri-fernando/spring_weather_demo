package com.example.spring_weather_demo;


import com.example.spring_weather_demo.controllers.CountryControllers;
import com.example.spring_weather_demo.weather.Country;
import com.example.spring_weather_demo.services.CountryServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CountryControllers.class)
public class CountryControllersTest {


    @MockBean
    private CountryServices service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCountries_ShouldReturnListOfCountries() throws Exception{
        when(service.getAllCountries()).thenReturn(getMockCountries());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/countries"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }


    private static Iterable<Country> getMockCountries(){
        Country[] countriesArray = {
                new Country("Sweden")

        };

        return Arrays.stream(countriesArray).toList();
    }
}


