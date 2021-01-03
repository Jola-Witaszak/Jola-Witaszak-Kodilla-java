package com.kodilla.patterns.factory.tasks;

import java.util.HashMap;
import java.util.Map;

public final class DrivingTask implements Task{
    private final String taskName;
    private final String where;
    private final String using;
    private final Map<String, String> trip = new HashMap<>();

    public DrivingTask(final String taskName, final String where, final String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public int executeTask() {
        trip.put(where, using);
        return trip.size();
    }

    @Override
    public boolean isTaskExecuted() {
        boolean isExecuted = false;
        if (executeTask() > 0) {
            isExecuted = true;
        }
        return isExecuted;
    }
}
