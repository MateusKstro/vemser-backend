package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.ProfessorEntity;
import br.com.dbc.vemser.pessoaapi.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping
    public ResponseEntity<List<ProfessorEntity>> listar(){
        return ResponseEntity.ok(professorRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<ProfessorEntity> create(@RequestBody ProfessorEntity professor){
        return ResponseEntity.ok(professorRepository.save(professor));
    }
}
