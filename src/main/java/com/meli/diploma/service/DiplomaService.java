package com.meli.diploma.service;

import com.meli.diploma.model.Aluno;
import com.meli.diploma.model.Disciplina;
import org.springframework.stereotype.Service;

@Service
public class DiplomaService {


    public double validaNotas(Aluno aluno) {
        if(aluno.getDisciplinas().size() == 0)
            throw new RuntimeException();
        return (double) (aluno.getDisciplinas().stream().map(Disciplina::getNota).reduce(0, Integer::sum))
                        /aluno.getDisciplinas().size();
    }

    public String getMessage(double nota) {
        String message = "Sua média foi de " + nota;
        if (nota > 9)
            return message + " Parabens";
        if (nota < 6)
            return message + " REPROVADO";
        return message;
    }
}
