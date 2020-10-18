package com.kodilla.testing.weather.mock;

import com.kodilla.testing.Temperatures;
import com.kodilla.testing.WeatherForecast;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

    @Mock
    private Temperatures temperaturesMock;
    private Map<String, Double> temperaturesMap;

    @BeforeEach
    public void readsTemperaturesFromSensors() {
        temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
    }

    @Test
    public void testCalculateForecastWithMock() {
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();
        //Then
        assertEquals(5, quantityOfSensors);
    }

    @Test
    void testCalculateAverageCurrentTemperature() {
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        //When
        double currentAverageTemperature = weatherForecast.calculateAverageCurrentTemperature(temperaturesMap);
        double testAverageTemperature = 20.5;
        //Then
        assertEquals(testAverageTemperature, currentAverageTemperature);
    }

    @Test
    void testCalculateMedianCurrentTemperatures() {
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        //When
        weatherForecast.calculateMedianCurrentTemperatures(temperaturesMap);
        double testMedianTemperature = 25.5;
        //Ten
        assertEquals(testMedianTemperature, weatherForecast.calculateMedianCurrentTemperatures(temperaturesMap));
    }
}
