package com.kodilla.task_2_5;

public class AppRun {
    public static void main(String[] args) {
        ComputerScienceLesson lesson = new ComputerScienceLesson();
        System.out.println("Grades: " + lesson.getGrades());
        System.out.println("Min grade: " + lesson.getMin(lesson.getGrades()));
        System.out.println("Max grade: " + lesson.getMax(lesson.getGrades()));
        System.out.println("Average of grades: " + lesson.getAverage(lesson.getGrades()));

        OneBook book = new OneBook();
        System.out.println("Books: " + book.getBooks());
        System.out.println("Books size: " + book.getBooks().size());
        book.sortedBooks(book.getBooks());
    }
}
