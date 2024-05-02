package com.report;

public class Grade {
	public static String calculateGrade(double totalPercentage) {
        if (totalPercentage >= 90) {
            return "A";
        } else if (totalPercentage >= 80) {
            return "B";
        } else if (totalPercentage >= 70) {
            return "C";
        } else if (totalPercentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
