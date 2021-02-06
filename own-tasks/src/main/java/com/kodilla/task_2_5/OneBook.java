package com.kodilla.task_2_5;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class OneBook {
    private String title;
    private int year;
    private List<OneBook> books = new LinkedList<>();
    private Random random = new Random();

    public OneBook(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public OneBook() {
    }

    public OneBook getBook () {
        title = "" + random.nextInt(200);
        year = random.nextInt(121) + 1900;
        return new OneBook(title, year);
    }

    public List<OneBook> getBooks() {
        for (int i = 0; i < 19; i++) {
            books.add(getBook());
        }
        return books;
    }

    public void sortedBooks(List<OneBook> books) {
        for (OneBook book : books) {
            if (book.getYear() >= 2000) {
                System.out.println("sorted books: " + book);
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "OneBook{" +
                "title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}
