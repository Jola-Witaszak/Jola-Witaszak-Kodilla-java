package com.kodilla.stream.person;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.sun.source.util.SourcePositions;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMine {
    public static void main(String[] args) {
        People.getList().stream()
                .filter(s -> s.length() > 11)
                .filter(s -> s.substring(0, 1).equals("M"))
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);

        System.out.println();

        BookDirectory bookDirectory = new BookDirectory();
        List<Book> theResultListOfBooks = bookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());

        System.out.println("# elements: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach(System.out::println);

        System.out.println();

        BookDirectory bookDirectory1 = new BookDirectory();
        Map<String, Book> theResultMapOfBooks = bookDirectory1.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

        System.out.println();

        BookDirectory bookDirectory2 = new BookDirectory();
        String theResultStringOfBooks = bookDirectory2.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n", "<<", ">>"));

        System.out.println(theResultStringOfBooks);

    }
}
