package com.sqe;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a library book with rating and quantity management.
 */
public class Book {

    private String bookTitle;
    private String author;
    private int quantity;
    private List<Double> ratings;

    public Book(String title, String author, int quantity) {

        if (quantity < 0) {
            throw new IllegalArgumentException(
                "Book quantity cannot be negative."
            );
        }

        this.bookTitle = title;
        this.author = author;
        this.quantity = quantity;
        this.ratings = new ArrayList<>();
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
