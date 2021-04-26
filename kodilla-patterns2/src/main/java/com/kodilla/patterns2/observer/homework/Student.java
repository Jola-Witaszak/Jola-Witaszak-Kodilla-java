package com.kodilla.patterns2.observer.homework;

public class Student {
    private final String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return getName().equals(student.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
