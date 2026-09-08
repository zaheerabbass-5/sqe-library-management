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
}
