package com.kodilla.patterns.factory.tasks;

public interface Task {
    String getTaskName();
    int executeTask();
    boolean isTaskExecuted();
}
