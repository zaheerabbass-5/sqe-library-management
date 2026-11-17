package com.sqe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTotalCopiesTest {

    @Test
    void testEmptyLibrary() {

        Library library = new Library();

        assertEquals(0, library.totalAvailableCopies());
    }

    @Test
    void testSingleBook() {

        Library library = new Library();

        Book book = new Book(
            "BOOK-T2-001",
            "Clean Code",
            "Robert C. Martin",
            5
        );

        library.addBook(book);

        assertEquals(5, library.totalAvailableCopies());
    }

    @Test
    void testMultipleBooks() {

        Library library = new Library();

        Book book1 = new Book(
            "BOOK-T2-002",
            "Clean Code",
            "Robert C. Martin",
            3
        );

        Book book2 = new Book(
            "BOOK-T2-003",
            "Java Programming",
            "James Gosling",
            5
        );

        Book book3 = new Book(
            "BOOK-T2-004",
            "Software Engineering",
            "Ian Sommerville",
            2
        );

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        assertEquals(10, library.totalAvailableCopies());
    }
}