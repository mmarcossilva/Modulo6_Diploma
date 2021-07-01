package com.meli.diploma;

import org.springframework.web.bind.annotation.*;

@RestController
public class DiplomaController {

    @PostMapping
    public String getProductByCode(@RequestBody Aluno aluno){
        return aluno.getDiploma();
    }

}
