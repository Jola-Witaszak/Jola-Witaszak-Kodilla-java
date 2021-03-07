package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {
    @Test
    void testGetBooks() {
        //Given
        Library library = new Library("City Library");
        IntStream.iterate(0, n -> n + 1)
                .limit(12)
                .forEach(n -> library.getBooks().add(new Book(" book" + n, "author" + n, 2000 + n)));

        //making a shallow clone of the object Library
        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            shallowClonedLibrary.setName("School Library");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //making a deep clone of the object Library
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("University Library");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //When
        library.getBooks().add(new Book("Excel 2016. Formulas", "Michael Alexander", 2017));

        //Then
        assertEquals(13, library.getBooks().size());
        assertEquals(13, shallowClonedLibrary.getBooks().size());
        assertEquals(12, deepClonedLibrary.getBooks().size());
        assertEquals(shallowClonedLibrary.getBooks().size(), library.getBooks().size());
        assertNotEquals(deepClonedLibrary.getBooks().size(), library.getBooks().size());
    }
}
