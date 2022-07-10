package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
@Validated
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/hello") // localhost:8080/pessoa/hello
    public String hello() {
        return "Hello world!";
    }

    @PostMapping // localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) {
        return ResponseEntity.ok(pessoaService.create(pessoa));
    }

    @GetMapping // localhost:8080/pessoa
    public ResponseEntity<List<PessoaDTO>> list() {
        return ResponseEntity.ok(pessoaService.list());
    }

    @GetMapping("/byname") // localhost:8080/pessoa/byname?nome=Rafa
    public ResponseEntity<List<PessoaDTO>> listByName(@RequestParam("nome") String nome) {
        return ResponseEntity.ok(pessoaService.listByName(nome));
    }

    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/7
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                                         @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception {
        return ResponseEntity.ok(pessoaService.update(id, pessoaAtualizar));
    }

    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }
}
