package com.sqe;

public class Library {

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
