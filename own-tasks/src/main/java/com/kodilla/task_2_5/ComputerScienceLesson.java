package com.kodilla.task_2_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerScienceLesson {
    private List<Double> grades = new ArrayList<>();
    private Random random = new Random();

    public List<Double> getGrades() {
        for (int i = 0; i < 19; i++) {
            double grade = random.nextInt(5)+1.5;
            grades.add(grade);
        }
        return grades;
    }

    public double getMin(List<Double> grades) {
        double min = 6.0;
        for (double grade : grades) {
            if (grade < min) {
                min = grade;
            }
        }
        return min;
    }

    public double getMax(List<Double> grades) {
        double max = 0;
        for (Double grade : grades) {
            if (grade > max) {
                max = grade;
            }
        }
        return max;
    }

    public double getAverage(List<Double> grades) {
        double sum = 0;
        for (Double grade : grades) {
            sum += grade;
        }
        return (sum - getMax(getGrades()) - getMin(getGrades())) / grades.size() - 2;
    }
}
