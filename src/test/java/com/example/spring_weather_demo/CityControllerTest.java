package com.example.spring_weather_demo;

import com.example.spring_weather_demo.controllers.CityControllers;
import com.example.spring_weather_demo.weather.City;
import com.example.spring_weather_demo.services.CityServices;
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

@WebMvcTest(CityControllers.class)
public class CityControllerTest {

    @MockBean
    private CityServices service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCity_ShouldReturnListOfCities() throws Exception{
        when(service.getAllCities()).thenReturn(getMockCities());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/cities"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }
    private static Iterable<City>getMockCities(){
     City[] citiesArray={
             new City("Stockholm", 1)

        };

      return Arrays.stream(citiesArray).toList();
    }

}
