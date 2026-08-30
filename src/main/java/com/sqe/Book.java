package com.sqe;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a library book with rating and availability management.
 */
public class Book {

    private String bookTitle;
    private String author;
    private int availableQuantity;
    private List<Double> ratings;

    public Book(String title, String author, int availableQuantity) {

        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be empty");
        }

        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty");
        }

        if (availableQuantity < 0) {
            throw new IllegalArgumentException("Available quantity cannot be negative");
        }

        this.bookTitle = title;
        this.author = author;
        this.availableQuantity = availableQuantity;
        this.ratings = new ArrayList<>();
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
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

    /**
     * Decreases the available quantity when a book is borrowed.
     *
     * @throws IllegalStateException if no copies are available
     */
    public void borrowBook() {

        if (availableQuantity <= 0) {
            throw new IllegalStateException("No copies are available.");
        }

        availableQuantity--;
    }
}
