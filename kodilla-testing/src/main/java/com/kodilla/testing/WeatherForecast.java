package com.kodilla.testing;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();
            for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
                resultMap.put(temperature.getKey(), temperature.getValue() + 1);
            }
            return resultMap;
    }

    public double calculateAverageCurrentTemperature(Map<String, Double> resultMap) {
        return 0.0;
    }

    public double calculateMedianCurrentTemperatures(Map<String, Double> resultMap) {
        return 0.0;
    }

}
