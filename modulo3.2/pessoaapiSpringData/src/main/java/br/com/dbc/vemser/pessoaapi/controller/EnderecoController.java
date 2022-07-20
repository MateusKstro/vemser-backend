package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.models.security.SecurityScheme;
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

    @Operation(summary = "Listar endereco", description = "Lista todos os enderecos do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de endercos"),
                    @ApiResponse(responseCode = "400", description = "Não há enderecos a serem exibidas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @Schema(description = "listando endereco")
    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> listarEndereco(){
        return ResponseEntity.ok(enderecoService.listarEnderecos());
    }

    @Operation(summary = "Listar endereco por id", description = "Lista um endereco por id do banco de dados!")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de endereco por id"),
                    @ApiResponse(responseCode = "400", description = "endereco nao existe"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @Schema(description = "Listando um endereco")
    @GetMapping("/{idEndereco}")
    public EnderecoDTO buscarEnderecoPorId(@PathVariable("idEndereco") Integer id) throws Exception{
        return enderecoService.buscarPorIdEndereco(id);
    }


    @Operation(summary = "Criar novo endereco", description = "Cria um novo endereco e insere no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Endereco criada"),
                    @ApiResponse(responseCode = "400", description = "Requisicao inválida"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @Schema(description = "criando endereco")
    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoDTO> create(@Valid @RequestBody EnderecoCreateDTO endereco,
                                              @RequestParam("idPessoa")Integer idPessoa) throws Exception {
        return ResponseEntity.ok(enderecoService.criarEndereco(idPessoa, endereco));
    }

    @Operation(summary = "Editar endereco", description = "Edita um endereco e mantém no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Endereco editado"),
                    @ApiResponse(responseCode = "400", description = "Endereco nao existe"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @Schema(description = "Editando um endereco")
    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> updateEndereco(@PathVariable("idEndereco") Integer idEndereco,
                          @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception{
        return ResponseEntity.ok(enderecoService.atualizarEndereco(idEndereco, endereco));
    }

    @Operation(summary = "Deletar endereco", description = "Deleta um endereco do banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Endereco deletado"),
                    @ApiResponse(responseCode = "400", description = "Endereco nao existe"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @Schema(description = "Deletando um endereco")
    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.deletar(id);
    }

}
