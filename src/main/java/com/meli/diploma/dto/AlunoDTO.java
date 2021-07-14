package com.meli.diploma.dto;

import com.meli.diploma.model.Aluno;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

public class AlunoDTO {

    @NotNull
    @Pattern(regexp = "^[A-Za-z_ ]*$")
    @Size(min = 8, max = 50)
    private String nome;
    @Valid
    private List<DisciplinaDTO> disciplinas;

    public AlunoDTO() {
    }

    public AlunoDTO(Aluno aluno){
        this.nome = aluno.getNome();
        this.disciplinas = aluno.getDisciplinas().stream().map(DisciplinaDTO::new).collect(Collectors.toList());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<DisciplinaDTO> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<DisciplinaDTO> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Aluno convert(){
        return new Aluno(this.nome, disciplinas.stream().map(DisciplinaDTO::convert).collect(Collectors.toList()));
    }
}
