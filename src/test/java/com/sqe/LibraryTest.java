
package com.sqe;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LibraryTest {

    // Test 1: Library constructor
    @Test
    void testLibraryConstructor() {

        Library library = new Library();

        assertNotNull(library);
        assertEquals(0, library.totalAvailableCopies());
    }

    // Test 2: Add a valid book
    @Test
    void testAddValidBook() {

        Library library = new Library();

        Book book = new Book("LIB001", "Java Basics", "James", 5);

        library.addBook(book);

        assertEquals(5, library.totalAvailableCopies());
    }

    // Test 3: Add a null book
    @Test
    void testAddNullBook() {

        Library library = new Library();

        assertThrows(
            IllegalArgumentException.class,
            () -> library.addBook(null)
        );
    }

    // Test 4: Negative overdue days
    @Test
    void testFineTierNegativeDays() {

        assertThrows(
            IllegalArgumentException.class,
            () -> Library.fineTier(-1)
        );
    }

    // Test 5: Zero overdue days
    @Test
    void testFineTierZeroDays() {

        assertEquals("None", Library.fineTier(0));
    }

    // Test 6: Low fine boundaries
    @Test
    void testFineTierLowBoundaries() {

        assertEquals("Low", Library.fineTier(1));
        assertEquals("Low", Library.fineTier(7));
    }

    // Test 7: Medium fine boundaries
    @Test
    void testFineTierMediumBoundaries() {

        assertEquals("Medium", Library.fineTier(8));
        assertEquals("Medium", Library.fineTier(14));
    }

    // Test 8: High fine boundaries
    @Test
    void testFineTierHighBoundaries() {

        assertEquals("High", Library.fineTier(15));
        assertEquals("High", Library.fineTier(30));
    }

    // Test 9: Severe fine
    @Test
    void testFineTierSevere() {

        assertEquals("Severe", Library.fineTier(31));
    }

    // Test 10: Valid 13-digit ISBN
    @Test
    void testValidateIsbnValid() {

        assertTrue(Library.validateIsbn("1234567890123"));
    }

    // Test 11: ISBN with fewer than 13 digits
    @Test
    void testValidateIsbnShortLength() {

        assertFalse(Library.validateIsbn("123456789012"));
    }

    // Test 12: ISBN with more than 13 digits
    @Test
    void testValidateIsbnLongLength() {

        assertFalse(Library.validateIsbn("12345678901234"));
    }

    // Test 13: ISBN containing letters
    @Test
    void testValidateIsbnWithLetters() {

        assertFalse(Library.validateIsbn("12345678901AB"));
    }

    // Test 14: Null ISBN
    @Test
    void testValidateIsbnNull() {

        assertFalse(Library.validateIsbn(null));
    }

    // Test 15: Successful catalogue export using Mockito
    @Test
    void testExportCatalogSuccessfully() throws IOException {

        Library library = new Library();

        Book book = new Book(
            "LIB002",
            "Software Engineering",
            "Pressman",
            4
        );

        library.addBook(book);

        CatalogWriter writer = mock(CatalogWriter.class);

        String expectedContent =
            "LIB002, Software Engineering, Pressman, 4"
            + System.lineSeparator();

        library.exportCatalog("catalog.txt", writer);

        verify(writer).write("catalog.txt", expectedContent);
    }

    // Test 16: Catalogue export handles IOException
    @Test
    void testExportCatalogIOException() throws IOException {

        Library library = new Library();

        CatalogWriter writer = mock(CatalogWriter.class);

        doThrow(new IOException("Disk error"))
            .when(writer)
            .write(anyString(), anyString());

        RuntimeException exception = assertThrows(
            RuntimeException.class,
            () -> library.exportCatalog("catalog.txt", writer)
        );

        assertEquals(
            "Unable to export catalogue.",
            exception.getMessage()
        );

        assertInstanceOf(IOException.class, exception.getCause());
    }
}
