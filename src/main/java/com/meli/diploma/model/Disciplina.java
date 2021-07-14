package com.meli.diploma.model;

public class Disciplina {
    private int nota;
    private String nome;

    public Disciplina(int nota, String nome) {
        this.nota = nota;
        this.nome = nome;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
