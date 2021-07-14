package com.meli.diploma.service;

import com.meli.diploma.model.Student;
import com.meli.diploma.model.Subject;
import org.springframework.stereotype.Service;

@Service
public class DiplomaService {


    public double validateNotes(Student student) {
        if(student.getSubjects().size() == 0)
            throw new RuntimeException();
        return (double) (student.getSubjects().stream().map(Subject::getNote).reduce(0, Integer::sum))
                        / student.getSubjects().size();
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
