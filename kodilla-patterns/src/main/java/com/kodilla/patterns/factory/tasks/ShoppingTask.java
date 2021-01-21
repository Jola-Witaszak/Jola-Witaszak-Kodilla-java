package com.kodilla.patterns.factory.tasks;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public final class ShoppingTask implements Task {
    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    private boolean executed;


    public ShoppingTask(final String taskName, final String whatToBuy, final double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public void executeTask() {
        System.out.println("Executing task: " + this);
        executed = true;
    }

    @Override
    public boolean isTaskExecuted() {
        return executed;
    }
}
