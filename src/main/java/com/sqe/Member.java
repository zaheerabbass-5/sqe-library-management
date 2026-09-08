package com.sqe;

public class Member {

    private String name;
    private String memberId;
    private int booksOnLoan;

    public Member(String name, String memberId) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Member name cannot be empty");
        }

        if (memberId == null || memberId.trim().isEmpty()) {
            throw new IllegalArgumentException("Member ID cannot be empty");
        }

        this.name = name;
        this.memberId = memberId;
        this.booksOnLoan = 0;
    }

    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }

    public int getBooksOnLoan() {
        return booksOnLoan;
    }

    public void setBooksOnLoan(int booksOnLoan) {

        if (booksOnLoan < 0) {
            throw new IllegalArgumentException(
                "Books on loan cannot be negative."
            );
        }

        this.booksOnLoan = booksOnLoan;
    }

    public void borrowBook(Book book) {

        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }

        if (booksOnLoan >= 5) {
            throw new IllegalArgumentException(
                "Member cannot have more than 5 books on loan."
            );
        }

        book.borrowBook();
        booksOnLoan++;

        System.out.println(name + " borrowed " + book.getBookTitle());
    }
}
