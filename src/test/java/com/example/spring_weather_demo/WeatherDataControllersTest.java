package com.example.spring_weather_demo;

import com.example.spring_weather_demo.controllers.WeatherDataControllers;
;
import com.example.spring_weather_demo.weather.Weather;
import com.example.spring_weather_demo.services.WeatherDataServices;
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

@WebMvcTest(WeatherDataControllers.class)


public class WeatherDataControllersTest {


    @MockBean
    private WeatherDataServices service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getWeatherData_ShouldReturnListOfWeatherData() throws Exception{
        when(service.getAllWeatherData()).thenReturn(getMockWeatherData());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/weatherData"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }


    private static Iterable<Weather> getMockWeatherData(){
        Weather[] weatherDataArray = {
                new Weather("-25°C","cool"),
        };

        return Arrays.stream(weatherDataArray).toList();
    }


}
