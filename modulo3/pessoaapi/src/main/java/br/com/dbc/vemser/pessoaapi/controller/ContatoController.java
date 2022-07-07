package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato") //localhost:8080/contato
public class ContatoController {

    @Autowired
    private ContatoService contatoService;


    @GetMapping//localhost:8080/contato
    public List<Contato> listarContatos(){
        return contatoService.listarContatos();
    }

    @GetMapping("/{idPessoa}")//localhost:8080/contato
    public List<Contato> buscarContatoPorIdPessoa(@PathVariable("{idPessoa}") Integer id) throws Exception {
        return contatoService.buscarContatoPorIdPessoa(id);
    }

    @PostMapping("/{idPessoa}") // localhost:8080/contato
    public Contato criarContato(@PathVariable("idPessoa") Integer id,
                                @RequestBody Contato contato) throws Exception {
        return contatoService.criarContato(id, contato);
    }

    @PutMapping("/{idContato}") //localhost:8080/contato/50
    public Contato atualizarContato(@PathVariable("idContato") Integer id,
                                    @RequestBody Contato contatoAtualizado) throws Exception {
        return contatoService.atualizarContato(id, contatoAtualizado);
    }

    @DeleteMapping("/{idContato}") //localhost:8080/contato/50
    public void deletar(@PathVariable("idContato") Integer id) throws Exception{
        contatoService.deletar(id);
    }
}
