package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task createTask(final String taskClass) throws IllegalArgumentException {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("Painting articles", "chalk paints", 10);
            case PAINTING:
                return new PaintingTask("Christmas decorations", "red", "baubles");
            case DRIVING:
                return new DrivingTask("Shopping trip", "gallery", "Bentley Continental");
            default:
                throw new IllegalArgumentException("The task type " + taskClass + " is not recognized.");
        }
    }
}
