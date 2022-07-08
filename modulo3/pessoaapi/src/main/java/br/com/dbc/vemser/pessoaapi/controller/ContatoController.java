package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato") //localhost:8080/contato
@Validated
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

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Contato> create(@PathVariable("idPessoa") Integer idPessoa,
                                          @Valid @RequestBody Contato contato) throws Exception {
        return ResponseEntity.ok(contatoService.criarContato(idPessoa, contato));
    }

    @PutMapping("/{idContato}") //localhost:8080/contato/50
    public ResponseEntity<Contato> atualizarContato(@PathVariable("idContato") Integer idContato,
                                    @Valid @RequestBody Contato contatoAtualizado) throws Exception {
        return ResponseEntity.ok(contatoService.atualizarContato(idContato, contatoAtualizado));
    }

    @DeleteMapping("/{idContato}") //localhost:8080/contato/50
    public void deletar(@PathVariable("idContato") Integer id) throws Exception{
        contatoService.deletar(id);
    }
}
