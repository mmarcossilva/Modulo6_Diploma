package com.meli.diploma.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.diploma.dto.StudentDTO;
import com.meli.diploma.dto.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest()
@AutoConfigureMockMvc
public class DiplomaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldCreateDiploma() throws Exception {
        SubjectDTO subject = new SubjectDTO(10, "Matematica");
        SubjectDTO subject2 = new SubjectDTO(5, "MatematicaA");
        SubjectDTO subject3 = new SubjectDTO(0, "MatematicaB");
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject);
        subjects.add(subject2);
        subjects.add(subject3);
        StudentDTO student = new StudentDTO("Mateus Marcos", subjects);

        String payLoad = mapper.writeValueAsString(student);
        mvc.perform(post("/analyzeNotes")
                .contentType("application/json")
                .content(payLoad))
                .andExpect(status().isCreated());
    }
}
