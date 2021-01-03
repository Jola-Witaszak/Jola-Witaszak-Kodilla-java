package com.kodilla.patterns.factory.tasks;

import java.util.HashMap;
import java.util.Map;

public final class ShoppingTask implements Task {
    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    private final Map<String, Double> shoppingList = new HashMap<>();

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
    public int executeTask() {
        shoppingList.put(whatToBuy, quantity);
        return shoppingList.size();
    }

    @Override
    public boolean isTaskExecuted() {
        return executeTask() > 0;
    }
}
