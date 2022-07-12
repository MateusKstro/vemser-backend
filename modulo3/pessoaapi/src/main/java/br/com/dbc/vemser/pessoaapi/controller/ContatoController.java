package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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


    @Operation(summary = "Listar contatos", description = "Lista todos os contatos do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de contatos"),
                    @ApiResponse(responseCode = "400", description = "Não há contatos a serem exibidas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @Schema(description = "listando contatos")
    @GetMapping//localhost:8080/contato
    public ResponseEntity<List<ContatoDTO>> listarContatos(){
        return ResponseEntity.ok(contatoService.listarContatos());
    }

    @Operation(summary = "Listar contato por idPessoa", description = "Lista um contato por idPessoa do banco de dados!")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna contato por idPessoa"),
                    @ApiResponse(responseCode = "400", description = "Contato nao existe"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @Schema(description = "Listando um contato por idPessoa")
    @GetMapping("/{idPessoa}")//localhost:8080/contato
    public ResponseEntity<List<ContatoDTO>> buscarContatoPorIdPessoa(@PathVariable("{idPessoa}") Integer id) throws Exception {
        return ResponseEntity.ok(contatoService.buscarContatoPorIdPessoa(id));
    }

    @Operation(summary = "Criar novo contato", description = "Cria um novo contato e insere no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Contato criada"),
                    @ApiResponse(responseCode = "400", description = "Requisicao inválida"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @Schema(description = "criando contato")
    @PostMapping("/{idPessoa}")
    public ResponseEntity<ContatoDTO> create(@PathVariable("idPessoa") Integer idPessoa,
                                          @Valid @RequestBody ContatoCreateDTO contato) throws Exception {
        return ResponseEntity.ok(contatoService.criarContato(idPessoa, contato));
    }

    @Operation(summary = "Editar contato", description = "Edita um contato e mantém no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Contato editado"),
                    @ApiResponse(responseCode = "400", description = "Contato nao existe"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @Schema(description = "Editando um contato")
    @PutMapping("/{idContato}") //localhost:8080/contato/50
    public ResponseEntity<ContatoDTO> atualizarContato(@PathVariable("idContato") Integer idContato,
                                    @Valid @RequestBody ContatoCreateDTO contatoAtualizado) throws Exception {
        return ResponseEntity.ok(contatoService.atualizarContato(idContato, contatoAtualizado));
    }

    @Operation(summary = "Deletar contato", description = "Deleta um contato do banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Contato deletado"),
                    @ApiResponse(responseCode = "400", description = "Contato nao existe"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @Schema(description = "Deletando um contato")
    @DeleteMapping("/{idContato}") //localhost:8080/contato/50
    public void deletar(@PathVariable("idContato") Integer id) throws Exception{
        contatoService.deletar(id);
    }
}
