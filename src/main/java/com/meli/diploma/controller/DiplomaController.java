package com.meli.diploma.controller;

import com.meli.diploma.dto.AlunoDTO;
import com.meli.diploma.dto.DiplomaDTO;
import com.meli.diploma.service.DiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/analyzeNotes")
public class DiplomaController {

    private DiplomaService diplomaService;

    @Autowired
    public DiplomaController(DiplomaService diplomaService) {
        this.diplomaService = diplomaService;
    }

    @PostMapping
    public ResponseEntity<DiplomaDTO> getProductByCode(@Valid @RequestBody AlunoDTO alunoDTO){
        double nota = diplomaService.validaNotas(alunoDTO.convert());
        String mensagem = diplomaService.getMessage(nota);

        return new ResponseEntity<>(new DiplomaDTO(mensagem, nota, alunoDTO), HttpStatus.CREATED);
    }

}
