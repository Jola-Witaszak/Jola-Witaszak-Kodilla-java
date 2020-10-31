package com.kodilla.testing.weather.stub;

import com.kodilla.testing.Temperatures;
import com.kodilla.testing.WeatherForecast;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherForecastTestSuite {
    @Test
    public void testCalculateForecastWithStub() {
        //Given
        Temperatures temperatures = new TemperaturesStub();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);
        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();
        //Then
        assertEquals(5, quantityOfSensors);
    }
}
