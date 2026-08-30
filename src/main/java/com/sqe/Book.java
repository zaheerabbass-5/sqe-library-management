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

        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be empty");
        }

        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty");
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
     * Returns the book ID.
     */
    public String getBookId() {
        return bookId;
    }

    /**
     * Returns the book title.
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * Returns the author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the current available quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Returns the current available quantity.
     */
    public int getAvailableQuantity() {
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
     * Decreases the available quantity when a book is borrowed.
     *
     * @throws IllegalStateException if no copies are available
     */
    public void borrowBook() {

        if (quantity <= 0) {
            throw new IllegalStateException("No copies are available.");
        }

        quantity--;
    }

    /**
     * Adds a rating score to the book.
     *
     * @param rating numerical rating score
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