package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco") //localhost:8080/endereco
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> listarEndereco(){
        return enderecoService.listarEnderecos();
    }

    @GetMapping("/{idEndereco}")
    public Endereco buscarEnderecoPorId(@PathVariable("idEndereco") Integer id) throws Exception{
        return enderecoService.buscarPorIdEndereco(id);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> buscarEnderecoPorPessoa(@PathVariable("idPessoa") Integer id) throws Exception {
        return enderecoService.buscarEnderecoPorIdPessoa(id);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Endereco> create(@PathVariable("idPessoa") Integer idPessoa,
                                          @Valid @RequestBody Endereco endereco) throws Exception {
        return ResponseEntity.ok(enderecoService.criarEndereco(idPessoa, endereco));
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<Endereco> updateEndereco(@PathVariable("idEndereco") Integer idEndereco,
                          @Valid @RequestBody Endereco endereco) throws Exception{
        return ResponseEntity.ok(enderecoService.atualizarEndereco(idEndereco, endereco));
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.deletar(id);
    }
}
