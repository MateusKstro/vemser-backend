package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco") //localhost:8080/endereco
@Validated
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> listarEndereco(){
        return ResponseEntity.ok(enderecoService.listarEnderecos());
    }

    @GetMapping("/{idEndereco}")
    public EnderecoDTO buscarEnderecoPorId(@PathVariable("idEndereco") Integer id) throws Exception{
        return enderecoService.buscarPorIdEndereco(id);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public ResponseEntity<List<EnderecoDTO>> buscarEnderecoPorPessoa(@PathVariable("idPessoa") Integer id) throws Exception {
        return ResponseEntity.ok(enderecoService.buscarEnderecoPorIdPessoa(id));
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoDTO> create(@PathVariable("idPessoa") Integer idPessoa,
                                          @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception {
        return ResponseEntity.ok(enderecoService.criarEndereco(idPessoa, endereco));
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> updateEndereco(@PathVariable("idEndereco") Integer idEndereco,
                          @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception{
        return ResponseEntity.ok(enderecoService.atualizarEndereco(idEndereco, endereco));
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.deletar(id);
    }
}
