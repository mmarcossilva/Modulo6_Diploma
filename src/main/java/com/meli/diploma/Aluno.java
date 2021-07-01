package com.meli.diploma;

import java.util.List;

public class Aluno {
    private String nome;
    private List<Disciplina> disciplinas;

    public Aluno(String nome, List<Disciplina> disciplinas) {
        this.nome = nome;
        this.disciplinas = disciplinas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public double getMedia(){
        return disciplinas.stream().map(Disciplina::getNota).reduce(0.0, Double::sum)/disciplinas.size();
    }

    public String getDiploma() {
        double media = getMedia();
        String mensagem = nome + " teve media " + media;
        if (media>9)
            return mensagem + ". Parabens";
        return mensagem;
    }
}
