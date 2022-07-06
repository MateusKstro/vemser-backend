package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato") //localhost:8080/contato
public class ContatoController {

    private ContatoService contatoService;

    public ContatoController() {
        contatoService = new ContatoService();
    }

    @GetMapping//localhost:8080/contato
    public List<Contato> listarContatos(){
        return contatoService.listarContatos();
    }

    @GetMapping("/byidpessoa")//localhost:8080/contato/byidpessoa?id=3
    public List<Contato> BuscarContatoPorIdPessoa(@RequestParam("id") Integer id){
        return contatoService.BuscarContatoPorIdPessoa(id);
    }

    @PostMapping // localhost:8080/contato
    public Contato criarContato(@RequestBody Contato contato){
        return contatoService.criarContato(contato);
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