package com.sqe;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a library book with rating management.
 */
public class Book {
    private String title;
    private String author;
    private List<Double> ratings;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.ratings = new ArrayList<>();
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
