package com.sqe;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private List<Double> ratings;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.ratings = new ArrayList<>();
    }

    public void addRating(double rating) {
        this.ratings.add(rating);
    }
}
