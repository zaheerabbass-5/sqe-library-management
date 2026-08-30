package com.sqe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Represents a library book with rating management.
 */
public class Book {

    private String bookId;
    private String bookTitle;
    private String author;
    private List<Double> ratings;

    private static Set<String> bookIds = new HashSet<>();

    public Book(String bookId, String title, String author) {

        if (bookIds.contains(bookId)) {
            throw new IllegalArgumentException("Book ID already exists.");
        }

        this.bookId = bookId;
        this.bookTitle = title;
        this.author = author;
        this.ratings = new ArrayList<>();

        bookIds.add(bookId);
    }

    /**
     * Adds a rating score to the book.
     *
     * @param rating Numerical rating score
     * @throws IllegalArgumentException if rating is negative
     */
    public void addRating(double rating) {

        if (rating < 0) {
            throw new IllegalArgumentException("Rating score cannot be negative.");
        }

        this.ratings.add(rating);
    }
}
