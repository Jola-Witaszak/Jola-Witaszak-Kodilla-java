package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Mentor implements Receiver{
    private final String name;
    private final List<Student> students = new ArrayList<>();
    private int updateCount = 0;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(JobQueue jobQueue) {
        updateCount++;
        System.out.println(this.getName() + ", your student " + jobQueue.getStudent().getName()
                + " on course " + jobQueue.getCourse() + " has sent a new task to: " +
                jobQueue.getTasks().peek());
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
