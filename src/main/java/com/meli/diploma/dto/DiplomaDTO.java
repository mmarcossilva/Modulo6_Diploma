package com.meli.diploma.dto;

public class DiplomaDTO {
    private String message;
    private double average;
    private StudentDTO student;

    public DiplomaDTO(String message, double average, StudentDTO studentDTO) {
        this.message = message;
        this.average = average;
        this.student = studentDTO;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }
}
