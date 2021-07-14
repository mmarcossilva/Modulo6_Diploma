package com.meli.diploma.dto;

import com.meli.diploma.model.Subject;

import javax.validation.constraints.*;

public class SubjectDTO {
    @NotNull
    @Min(0)
    @Max(10)
    private int note;

    @NotNull
    @Pattern(regexp = "^[A-Za-z_áíó]*$")
    @Size(min = 8, max = 50)
    private String subject;

    public SubjectDTO() {
    }

    public SubjectDTO(Subject subject){
        this.note = subject.getNote();
        this.subject = subject.getSubject();
    }

    public SubjectDTO(int note, String subject) {
        this.note = note;
        this.subject = subject;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Subject convert() {
        return new Subject(this.note,this.subject);
    }
}
