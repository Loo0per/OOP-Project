package com.report;

public class Grade {
	public static String calculateGrade(double totalPercentage) {
        if (totalPercentage >= 80) {
            return "A";
        } else if (totalPercentage >= 65) {
            return "B";
        } else if (totalPercentage >= 55) {
            return "C";
        } else if (totalPercentage >= 40) {
            return "D";
        } else {
            return "F";
        }
    }
}
