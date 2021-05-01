package com.kodilla.patterns2.observer.homework;

public interface Receiver {
    void update(JobQueue jobQueue);
    void addStudent(Student student);
}
