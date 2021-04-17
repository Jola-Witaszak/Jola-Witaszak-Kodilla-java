package com.kodilla.patterns2.observer.homework;

import java.util.*;

public class JobQueue implements Sender {
    private final String course;
    private final Student student;
    private final Deque<String> tasks = new ArrayDeque<>();
    private final List<Receiver> receivers = new ArrayList<>();

    public JobQueue(String course, Student student) {
        this.course = course;
        this.student = student;
    }

    public void addTask(String taskAddress) {
        tasks.offer(taskAddress);
        notifyReceives();
    }

    @Override
    public void addReceiver(Receiver receiver) {
        receivers.add(receiver);
    }

    @Override
    public void notifyReceives() {
        receivers.forEach(receiver -> receiver.update(this));
    }

    @Override
    public void removeReceiver(Receiver receiver) {
        receivers.remove(receiver);
    }

    public String getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public Deque<String> getTasks() {
        return tasks;
    }

    public List<Receiver> getReceivers() {
        return receivers;
    }
}
