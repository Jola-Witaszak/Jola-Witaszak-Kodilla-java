package com.kodilla.patterns.factory.tasks;

import java.util.HashMap;
import java.util.Map;

public final class PaintingTask implements Task {
    private final String taskName;
    private final String color;
    private final String whatToPaint;
    private final Map<String, String> paintedItems = new HashMap<>();

    public PaintingTask(final String taskName, final String color, final String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public int executeTask() {
        paintedItems.put(whatToPaint, color);
        return paintedItems.size();
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
