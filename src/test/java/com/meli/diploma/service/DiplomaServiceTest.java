package com.meli.diploma.service;

import com.meli.diploma.model.Student;
import com.meli.diploma.model.Subject;
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
    public void shouldBePossibleValidateNotes(){
        Subject subject = new Subject(10, "Matematica");
        Subject subject2 = new Subject(5, "Matematica1");
        Subject subject3 = new Subject(0, "Matematica2");
        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject);
        subjects.add(subject2);
        subjects.add(subject3);
        Student student = new Student("Mateus Marcos", subjects);
        assertEquals(this.diplomaService.validateNotes(student), 5);
    }

    @Test
    public void shouldRaiseExceptionValidateNotes(){
        Student student = new Student("Mateus Marcos", new ArrayList<>());
        assertThrows(
                RuntimeException.class,
                () -> this.diplomaService.validateNotes(student),
                "failed"
        );
    }

    @Test
    public void shouldCongratulateGetMessage(){
        String message = "Sua média foi de 9.5 Parabens";
        assertEquals(message, this.diplomaService.getMessage(9.5));
    }

    @Test
    public void shouldNotCongratulateGetMessage(){
        String message = "Sua média foi de 7.0";
        assertEquals(message, this.diplomaService.getMessage(7));
    }

}
