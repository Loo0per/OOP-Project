package com.report;

public class StudentResult {
	private int id;
    private String name;
    private int attendance;
    private int marks;
    private String grade;

    public StudentResult(int id, String name, int attendance, int marks, String grade) {
        this.id = id;
        this.name = name;
        this.attendance = attendance;
        this.marks = marks;
        this.grade = grade;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAttendance() {
        return attendance;
    }

    public int getMarks() {
        return marks;
    }

    public String getGrade() {
        return grade;
    }
}
