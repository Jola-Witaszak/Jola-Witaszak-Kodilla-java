package com.kodilla.stream.book;

import java.util.ArrayList;
import java.util.List;

public final class BookDirectory {
    private final List<Book> theBookList = new ArrayList<>();

    public BookDirectory() {
        theBookList.add(new Book("prgbt", "Dylan Murphy", "Wolf of the mountains", 2003));
        theBookList.add(new Book("grtuy", "Phoebe Pearson", "Slaves of dreams", 2012));
        theBookList.add(new Book("12589", "Morgan Walsh", "Obliteration of heaven", 2001));
        theBookList.add(new Book("htyg9", "Aimee Murphy", "Rejecting the night", 2015));
        theBookList.add(new Book("nhy67", "Ryan Talley", "Gangsters and kings", 2007));
        theBookList.add(new Book("jyu78", "Madelynn Carson", "Unity without duty", 2007));
        theBookList.add(new Book("ju786", "Giancarlo Guerrero", "Enemies of eternity", 2009));
    }

    public List<Book> getList() {
        return new ArrayList<>(theBookList);
    }
}
