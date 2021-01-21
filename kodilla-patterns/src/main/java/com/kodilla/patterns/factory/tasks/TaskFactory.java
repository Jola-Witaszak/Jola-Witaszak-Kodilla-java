package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

    public final Task createTask(TaskType taskType, String taskName, String param1, Object param2) throws IllegalArgumentException {
        switch (taskType) {
            case SHOPPING:
                return new ShoppingTask(taskName, param1, (Double) param2);
            case PAINTING:
                return new PaintingTask(taskName, param1, (String) param2);
            case DRIVING:
                return new DrivingTask(taskName, param1, (String) param2);
            default:
                throw new IllegalArgumentException("The task type " + taskType + " is not recognized.");
        }
    }
}
