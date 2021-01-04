package com.kodilla.testing;

import java.util.*;

public class WeatherForecast {
    private final Temperatures temperatures;

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

    public double calculateAverageCurrentTemperature(Map<String, Double> correctTemperaturesMap) {
       double sumOfTemperatures = 0.0;
        for (Map.Entry<String, Double> entry : correctTemperaturesMap.entrySet()) {
            sumOfTemperatures += entry.getValue();
        }
        return sumOfTemperatures / correctTemperaturesMap.size();
    }

    public double calculateMedianCurrentTemperatures(Map<String, Double> correctTemperaturesMap) {
        List<Double> values = new LinkedList<>();
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            values.add(temperature.getValue());
        }
        Collections.sort(values);
        if (values.size() % 2 == 0) {
            return (values.get(values.size() / 2) + values.get(values.size() / 2 - 1)) / 2;
        } else {
            return values.get(values.size() / 2);
        }
    }
}
