package com.kodilla.patterns2.observer.homework;

import java.util.List;

public interface Receiver {
    void update(JobQueue jobQueue);
    void addStudent(Student student);
}
