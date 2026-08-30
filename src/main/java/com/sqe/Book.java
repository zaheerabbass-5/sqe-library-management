package com.sqe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Represents a library book with rating, ID, and quantity management.
 */
public class Book {

    private String bookId;
    private String bookTitle;
    private String author;
    private int quantity;
    private List<Double> ratings;

    private static Set<String> bookIds = new HashSet<>();

    /**
     * Creates a book with ID, title, author, and quantity.
     */
    public Book(String bookId, String title, String author, int quantity) {

        if (bookIds.contains(bookId)) {
            throw new IllegalArgumentException("Book ID already exists.");
        }

        if (quantity < 0) {
            throw new IllegalArgumentException(
                "Book quantity cannot be negative."
            );
        }

        this.bookId = bookId;
        this.bookTitle = title;
        this.author = author;
        this.quantity = quantity;
        this.ratings = new ArrayList<>();

        bookIds.add(bookId);
    }

    /**
     * Creates a book with ID, title, and author.
     * Quantity defaults to 0.
     */
    public Book(String bookId, String title, String author) {
        this(bookId, title, author, 0);
    }

    /**
     * Returns the current available quantity of the book.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Updates the book quantity.
     *
     * @param quantity new quantity
     * @throws IllegalArgumentException if quantity is negative
     */
    public void setQuantity(int quantity) {

        if (quantity < 0) {
            throw new IllegalArgumentException(
                "Book quantity cannot be negative."
            );
        }

        this.quantity = quantity;
    }

    /**
     * Adds a rating score to the book.
     *
     * @param rating Numerical rating score
     * @throws IllegalArgumentException if rating is negative
     */
    public void addRating(double rating) {

        if (rating < 0) {
            throw new IllegalArgumentException(
                "Rating score cannot be negative."
            );
        }

        this.ratings.add(rating);
    }
}