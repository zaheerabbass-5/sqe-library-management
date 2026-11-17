
package com.sqe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    // Test 1: Valid member constructor
    @Test
    void testValidMemberConstructor() {

        Member member = new Member("Ali", "M001");

        assertEquals("Ali", member.getName());
        assertEquals("M001", member.getMemberId());
        assertEquals(0, member.getBooksOnLoan());
    }

    // Test 2: Null member name
    @Test
    void testNullMemberName() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new Member(null, "M002")
        );
    }

    // Test 3: Empty member name
    @Test
    void testEmptyMemberName() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new Member("", "M003")
        );
    }

    // Test 4: Blank member name
    @Test
    void testBlankMemberName() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new Member("   ", "M004")
        );
    }

    // Test 5: Null member ID
    @Test
    void testNullMemberId() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new Member("Ali", null)
        );
    }

    // Test 6: Empty member ID
    @Test
    void testEmptyMemberId() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new Member("Ali", "")
        );
    }

    // Test 7: Negative books on loan
    @Test
    void testSetNegativeBooksOnLoan() {

        Member member = new Member("Ahmed", "M007");

        assertThrows(
            IllegalArgumentException.class,
            () -> member.setBooksOnLoan(-1)
        );
    }

    // Test 8: Set valid books on loan
    @Test
    void testSetValidBooksOnLoan() {

        Member member = new Member("Sara", "M008");

        member.setBooksOnLoan(3);

        assertEquals(3, member.getBooksOnLoan());
    }

    // Test 9: Borrow a valid book
    @Test
    void testBorrowValidBook() {

        Member member = new Member("Usman", "M009");
        Book book = new Book("MEM001", "Java Basics", "James", 5);

        member.borrowBook(book);

        assertEquals(1, member.getBooksOnLoan());
        assertEquals(4, book.getAvailableQuantity());
    }

    // Test 10: Borrow a null book
    @Test
    void testBorrowNullBook() {

        Member member = new Member("Hassan", "M010");

        assertThrows(
            IllegalArgumentException.class,
            () -> member.borrowBook(null)
        );

        assertEquals(0, member.getBooksOnLoan());
    }

    // Test 11: Maximum borrowing limit
    @Test
    void testMaximumBorrowingLimit() {

        Member member = new Member("Ahmed", "M011");

        member.setBooksOnLoan(5);

        Book book = new Book("MEM002", "Python Basics", "Guido", 3);

        assertThrows(
            IllegalArgumentException.class,
            () -> member.borrowBook(book)
        );

        assertEquals(5, member.getBooksOnLoan());
        assertEquals(3, book.getAvailableQuantity());
    }

    // Test 12: Borrow an unavailable book
    @Test
    void testBorrowUnavailableBook() {

        Member member = new Member("Bilal", "M012");

        Book book = new Book("MEM003", "C Programming", "Dennis", 0);

        assertThrows(
            IllegalStateException.class,
            () -> member.borrowBook(book)
        );

        assertEquals(0, member.getBooksOnLoan());
        assertEquals(0, book.getAvailableQuantity());
    }
}
