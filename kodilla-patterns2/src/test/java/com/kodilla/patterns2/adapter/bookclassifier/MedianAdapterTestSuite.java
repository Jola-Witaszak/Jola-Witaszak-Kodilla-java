package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest() {
        //Given
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("Author", "Title", 1950, "ISBN 200"));
        bookSet.add(new Book("Poet", "Poem", 2008, "ISBN 202"));
        bookSet.add(new Book("Journalist", "Note", 2010, "ISBN 280"));
        MedianAdapter medianAdapter = new MedianAdapter();
        //When
        int result = medianAdapter.publicationYearMedian(bookSet);
        //Then
        assertEquals(2008, result);
    }
}