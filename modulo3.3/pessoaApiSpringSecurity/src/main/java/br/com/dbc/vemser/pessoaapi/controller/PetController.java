package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
import br.com.dbc.vemser.pessoaapi.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pet")
@Validated
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<List<PetDTO>> listarPets(){
        return ResponseEntity.ok(petService.listarPets());
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<PetDTO> create(@PathVariable ("idPessoa") Integer idPessoa,
                                         @Valid @RequestBody PetCreateDTO pet) throws Exception{
        return ResponseEntity.ok(petService.criarPet(idPessoa, pet));
    }

    @PutMapping("/{idPet}")
    public ResponseEntity<PetDTO> atualizarPet(@PathVariable("idPet") Integer idPet,
                                               @Valid @RequestBody PetCreateDTO petAtualizado) throws Exception{
        return ResponseEntity.ok(petService.atualizarPet(idPet, petAtualizado));
    }

    @DeleteMapping("/{idPet}")
    public void deletar(@PathVariable("idPet") Integer idPet) throws Exception{
        petService.deletar(idPet);
    }
}
