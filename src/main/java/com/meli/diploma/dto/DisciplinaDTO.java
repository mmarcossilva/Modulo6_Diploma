package com.meli.diploma.dto;

import com.meli.diploma.model.Disciplina;

import javax.validation.constraints.*;

public class DisciplinaDTO {
    @NotNull
    @Min(0)
    @Max(10)
    private int nota;

    @NotNull
    @Pattern(regexp = "^[A-Za-z_áíó]*$")
    @Size(min = 8, max = 50)
    private String nome;

    public DisciplinaDTO() {
    }

    public DisciplinaDTO(Disciplina disciplina){
        this.nota = disciplina.getNota();
        this.nome = disciplina.getNome();
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

    public Disciplina convert() {
        return new Disciplina(this.nota,this.nome);
    }
}
