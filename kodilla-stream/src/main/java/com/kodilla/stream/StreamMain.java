package com.kodilla.stream;


import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.person.People;

public class StreamMain {
   public static void main(String[] args) {

       People.getList().stream()
               .map(String::toUpperCase)
               .forEach(System.out :: println);

       BookDirectory bookDirectory = new BookDirectory();
       bookDirectory.getList().stream()
               .filter(book -> book.getYearOfPublication() > 2005)
               .forEach(System.out::println);
    }
}
