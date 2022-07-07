package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Endereco postEndereco(@PathVariable("idPessoa") Integer id,
                             @RequestBody Endereco endereco) throws Exception {
        return enderecoService.criarEndereco(id, endereco);
    }

    @PutMapping("/{idEndereco}")
    public Endereco updateEndereco(@PathVariable("idEndereco") Integer id,
                          @RequestBody Endereco endereco) throws Exception{
        return enderecoService.atualizarEndereco(id, endereco);
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.deletar(id);
    }
}
