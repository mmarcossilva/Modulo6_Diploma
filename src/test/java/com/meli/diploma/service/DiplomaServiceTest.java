package com.meli.diploma.service;

import com.meli.diploma.model.Aluno;
import com.meli.diploma.model.Disciplina;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class DiplomaServiceTest {

    private DiplomaService diplomaService;

    @BeforeEach
    void setUp() {
        this.diplomaService = new DiplomaService();
    }

    @Test
    public void deveSerPossivelValidarNotas(){
        Disciplina disciplina = new Disciplina(10, "Matematica");
        Disciplina disciplina2 = new Disciplina(5, "Matematica1");
        Disciplina disciplina3 = new Disciplina(0, "Matematica2");
        List<Disciplina> disciplinas = new ArrayList<>();
        disciplinas.add(disciplina);
        disciplinas.add(disciplina2);
        disciplinas.add(disciplina3);
        Aluno aluno = new Aluno("Mateus Marcos", disciplinas);
        assertEquals(this.diplomaService.validaNotas(aluno), 5);
    }

    @Test
    public void deveLevantarExceptionValidarNotas(){
        Aluno aluno = new Aluno("Mateus Marcos", new ArrayList<>());
        assertThrows(
                RuntimeException.class,
                () -> this.diplomaService.validaNotas(aluno),
                "failed"
        );
    }

    @Test
    public void deveReceberParabensGetMessage(){
        String message = "Sua média foi de 9.5 Parabens";
        assertEquals(message, this.diplomaService.getMessage(9.5));
    }

    @Test
    public void naoDeveReceberParabensGetMessage(){
        String message = "Sua média foi de 7.0";
        assertEquals(message, this.diplomaService.getMessage(7));
    }

}
