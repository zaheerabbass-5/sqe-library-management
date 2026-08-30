package com.sqe;

/**
 * Represents a library member.
 */
public class Member {

    private String name;
    private String memberId;

    public Member(String name, String memberId) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Member name cannot be empty");
        }

        if (memberId == null || memberId.trim().isEmpty()) {
            throw new IllegalArgumentException("Member ID cannot be empty");
        }

        this.name = name;
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }

    /**
     * Attempts to borrow a book.
     *
     * @param book the book to borrow
     */
    public void borrowBook(Book book) {

        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }

        book.borrowBook();

        System.out.println(name + " borrowed " + book.getBookTitle());
    }
}
