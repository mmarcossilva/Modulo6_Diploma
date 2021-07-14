package com.meli.diploma.model;

import java.util.List;

public class Student {
    private String name;
    private List<Subject> subjects;

    public Student(String nome, List<Subject> subjects) {
        this.name = nome;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public int getMedia(){
        return subjects.stream().map(Subject::getNote).reduce(0, Integer::sum)/ subjects.size();
    }

    public String getDiploma() {
        double media = getMedia();
        String mensagem = name + " teve media " + media;
        if (media>9)
            return mensagem + ". Parabens";
        return mensagem;
    }
}
