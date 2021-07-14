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
    private List<SubjectDTO> subjectDTOs;

    public StudentDTO() {
    }

    public StudentDTO(Student student){
        this.name = student.getName();
        this.subjectDTOs = student.getSubjects().stream().map(SubjectDTO::new).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubjectDTO> getSubjectDTOs() {
        return subjectDTOs;
    }

    public void setSubjectDTOs(List<SubjectDTO> subjectDTOs) {
        this.subjectDTOs = subjectDTOs;
    }

    public Student convert(){
        return new Student(this.name, subjectDTOs.stream().map(SubjectDTO::convert).collect(Collectors.toList()));
    }
}
