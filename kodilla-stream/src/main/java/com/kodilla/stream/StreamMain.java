package com.kodilla.stream;


import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.person.People;

public class StreamMain {
   public static void main(String[] args) {

       People.getList().stream()
               .map(s -> s.toUpperCase())
               .forEach(System.out :: println);
    }
}
