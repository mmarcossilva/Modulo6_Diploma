package com.meli.diploma.dto;

import com.meli.diploma.model.Student;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

public class StudentDTO {

    @NotNull
    @Pattern(regexp = "^[A-Za-z_ ]*$")
    @Size(min = 8, max = 50)
    private String name;
    @Valid
    private List<SubjectDTO> subjects;

    public StudentDTO() {
    }

    public StudentDTO(Student student){
        this.name = student.getName();
        this.subjects = student.getSubjects().stream().map(SubjectDTO::new).collect(Collectors.toList());
    }

    public StudentDTO(String name, List<SubjectDTO> subjectDTOs) {
        this.name = name;
        this.subjects = subjectDTOs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubjectDTO> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDTO> subjects) {
        this.subjects = subjects;
    }

    public Student convert(){
        return new Student(this.name, subjects.stream().map(SubjectDTO::convert).collect(Collectors.toList()));
    }
}
