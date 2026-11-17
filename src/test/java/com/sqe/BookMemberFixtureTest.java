
package com.sqe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTotalCopiesTest {

    // Existing Library tests

    @Test
    void emptyLibraryShouldHaveZeroCopies() {
        Library library = new Library();

        assertEquals(0, library.totalAvailableCopies());
    }

    @Test
    void singleBookShouldReturnItsQuantity() {
        Library library = new Library();
        Book book = new Book("B001", "Java Basics", "Ali", 5);

        library.addBook(book);

        assertEquals(5, library.totalAvailableCopies());
    }

    @Test
    void multipleBooksShouldReturnTotalQuantity() {
        Library library = new Library();

        library.addBook(new Book("B002", "C Basics", "Ahmed", 3));
        library.addBook(new Book("B003", "Python", "Sara", 5));
        library.addBook(new Book("B004", "Java", "Usman", 2));

        assertEquals(10, library.totalAvailableCopies());
    }

    // Book constructor tests

    @Test
    void bookShouldBeCreatedWithValidDetails() {
        Book book = new Book("B101", "Java", "Ali", 5);

        assertEquals("B101", book.getBookId());
        assertEquals("Java", book.getBookTitle());
        assertEquals("Ali", book.getAuthor());
        assertEquals(5, book.getQuantity());
    }

    @Test
    void bookWithoutQuantityShouldDefaultToZero() {
        Book book = new Book("B102", "Python", "Ahmed");

        assertEquals(0, book.getQuantity());
    }

    @Test
    void emptyBookTitleShouldBeRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Book("B103", "", "Ali", 5));
    }

    @Test
    void emptyAuthorShouldBeRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Book("B104", "Java", " ", 5));
    }

    @Test
    void negativeBookQuantityShouldBeRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Book("B105", "Java", "Ali", -1));
    }

    @Test
    void duplicateBookIdShouldBeRejected() {
        new Book("B106", "Java", "Ali", 5);

        assertThrows(IllegalArgumentException.class,
                () -> new Book("B106", "Python", "Ahmed", 3));
    }

    // Book quantity tests

    @Test
    void setQuantityShouldUpdateBookQuantity() {
        Book book = new Book("B107", "Java", "Ali", 5);

        book.setQuantity(10);

        assertEquals(10, book.getQuantity());
        assertEquals(10, book.getAvailableQuantity());
    }

    @Test
    void negativeQuantityUpdateShouldBeRejected() {
        Book book = new Book("B108", "Java", "Ali", 5);

        assertThrows(IllegalArgumentException.class,
                () -> book.setQuantity(-1));
    }

    @Test
    void borrowBookShouldDecreaseQuantity() {
        Book book = new Book("B109", "Java", "Ali", 5);

        book.borrowBook();

        assertEquals(4, book.getQuantity());
    }

    @Test
    void borrowingUnavailableBookShouldBeRejected() {
        Book book = new Book("B110", "Java", "Ali", 0);

        assertThrows(IllegalStateException.class,
                () -> book.borrowBook());
    }

    // Book rating tests

    @Test
    void bookShouldAcceptValidRating() {
        Book book = new Book("B111", "Java", "Ali", 5);

        assertDoesNotThrow(() -> book.addRating(4.5));
    }

    @Test
    void negativeRatingShouldBeRejected() {
        Book book = new Book("B112", "Java", "Ali", 5);

        assertThrows(IllegalArgumentException.class,
                () -> book.addRating(-1));
    }
}
