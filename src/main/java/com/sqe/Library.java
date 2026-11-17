package com.sqe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {

        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }

        books.add(book);
    }

    public int totalAvailableCopies() {

        int total = 0;

        for (Book book : books) {
            total += book.getAvailableQuantity();
        }

        return total;
    }

    public void exportCatalog(String fileName, CatalogWriter writer) {

        StringBuilder content = new StringBuilder();

        for (Book book : books) {

            content.append(book.getBookId())
                   .append(", ")
                   .append(book.getBookTitle())
                   .append(", ")
                   .append(book.getAuthor())
                   .append(", ")
                   .append(book.getAvailableQuantity())
                   .append(System.lineSeparator());
        }

        try {
            writer.write(fileName, content.toString());

        } catch (IOException e) {
            throw new RuntimeException("Unable to export catalogue.", e);
        }
    }

    public static String fineTier(int daysOverdue) {

        if (daysOverdue < 0) {
            throw new IllegalArgumentException("Days overdue cannot be negative.");
        }

        if (daysOverdue == 0) {
            return "None";
        }

        if (daysOverdue <= 7) {
            return "Low";
        }

        if (daysOverdue <= 14) {
            return "Medium";
        }

        if (daysOverdue <= 30) {
            return "High";
        }

        return "Severe";
    }

    public static boolean validateIsbn(String isbn) {

        if (isbn == null || isbn.length() != 13) {
            return false;
        }

        for (int i = 0; i < isbn.length(); i++) {

            if (!Character.isDigit(isbn.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}