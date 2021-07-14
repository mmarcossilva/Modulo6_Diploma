package com.meli.diploma.model;

public class Subject {
    private int note;
    private String subject;

    public Subject(int note, String subject) {
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
}
