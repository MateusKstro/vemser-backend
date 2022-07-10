package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
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
    public ResponseEntity<List<ContatoDTO>> listarContatos(){
        return ResponseEntity.ok(contatoService.listarContatos());
    }

    @GetMapping("/{idPessoa}")//localhost:8080/contato
    public ResponseEntity<List<ContatoDTO>> buscarContatoPorIdPessoa(@PathVariable("{idPessoa}") Integer id) throws Exception {
        return ResponseEntity.ok(contatoService.buscarContatoPorIdPessoa(id));
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<ContatoDTO> create(@PathVariable("idPessoa") Integer idPessoa,
                                          @Valid @RequestBody ContatoCreateDTO contato) throws Exception {
        return ResponseEntity.ok(contatoService.criarContato(idPessoa, contato));
    }

    @PutMapping("/{idContato}") //localhost:8080/contato/50
    public ResponseEntity<ContatoDTO> atualizarContato(@PathVariable("idContato") Integer idContato,
                                    @Valid @RequestBody ContatoCreateDTO contatoAtualizado) throws Exception {
        return ResponseEntity.ok(contatoService.atualizarContato(idContato, contatoAtualizado));
    }

    @DeleteMapping("/{idContato}") //localhost:8080/contato/50
    public void deletar(@PathVariable("idContato") Integer id) throws Exception{
        contatoService.deletar(id);
    }
}
