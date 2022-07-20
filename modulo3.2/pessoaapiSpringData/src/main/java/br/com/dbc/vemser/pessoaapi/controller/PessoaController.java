package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.*;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
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
@RequestMapping("/pessoa") // localhost:8080/pessoa
@Validated
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaRepository pessoaRepository;


    @Operation(summary = "Criar nova pessoa", description = "Cria uma nova pessoa e insere no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Pessoa criada"),
                    @ApiResponse(responseCode = "400", description = "Requisicao inválida"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping // localhost:8080/pessoa
    @Schema(description = "criando pessoa")
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) {
        return ResponseEntity.ok(pessoaService.create(pessoa));
    }

    @Operation(summary = "Listar pessoas", description = "Lista todas as pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "400", description = "Não há pessoas a serem exibidas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping // localhost:8080/pessoa
    @Schema(description = "listando pessoas")
    public ResponseEntity<List<PessoaDTO>> list() {
        return ResponseEntity.ok(pessoaService.list());
    }

//    @GetMapping("/byname")
//    public List<PessoaEntity> listByName(@RequestParam("nome") String nome) { // apenas para fins academicos nao utilizar Repository na Controller
//        return pessoaRepository.findByNomeContainsIgnoreCase(nome);
//    }

//    @GetMapping("/getByCpf")
//    public List<PessoaEntity> listByCpf(@RequestParam("cpf") String cpf) { //apenas para fins academicos nao utilizar Repository na Controller
//        return pessoaRepository.findByCpf(cpf);
//    }
    @GetMapping("/getListPessoasComContatos")
    public List<PessoaDTOComContatos> listarPessoasComContatos(@RequestParam(value = "id", required = false) Integer id) throws Exception {
        return pessoaService.listarPessoasComContatos(id);
    }

    @GetMapping("/getListPessoasComEnderecos")
    public List<PessoaDTOComEnderecos> listarPessoasComEnderecos(@RequestParam(value = "id", required = false) Integer id) throws Exception {
        return pessoaService.listarPessoasComEnderecos(id);
    }

    @GetMapping("/getListPessoasComPets")
    public List<PessoaDTOComPets> listarPessoasComPets(@RequestParam(value = "id", required = false) Integer id) throws Exception {
        return pessoaService.listarPessoasComPets(id);
    }
    @Operation(summary = "Editar pessoa", description = "Edita uma nova pessoa e mantém ela no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Pessoa editada"),
                    @ApiResponse(responseCode = "400", description = "Pessoa nao existe"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @Schema(description = "Editando uma pessoa")
    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/7
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                                         @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception {
        return ResponseEntity.ok(pessoaService.update(id, pessoaAtualizar));
    }



    @Operation(summary = "Deletar pessoa", description = "Deleta uma nova pessoa do banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Pessoa deletada"),
                    @ApiResponse(responseCode = "400", description = "Pessoa nao existe"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @Schema(description = "Deletando uma pessoa")
    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }
}
