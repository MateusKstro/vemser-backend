package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import br.com.dbc.vemser.pessoaapi.service.DadosPessoaisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/dadosPessoais")
@Validated
public class DadosPessoaisController {

    @Autowired
    private DadosPessoaisService dadosPessoaisService;


    @Operation(summary = "Listar dados pessoais", description = "Lista dados pessoais do banco de dados!")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de dados"),
                    @ApiResponse(responseCode = "400", description = "Nao dados a serem exibidos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @Schema(description = "listando dados pessoais")
    @GetMapping
    public List<DadosPessoaisDTO> listaDadosPessoais(){
        return dadosPessoaisService.listaDadosPessoais();
    }


    @Operation(summary = "Criar novo dado pessoal", description = "Cria um novo dado pessoal e insere no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Dados pessoais criado"),
                    @ApiResponse(responseCode = "400", description = "Requisicao inválida"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @Schema(description = "criando dados pessoais")
    @PostMapping
    public DadosPessoaisDTO create (@RequestBody DadosPessoaisDTO dadosPessoaisDTO) throws Exception {
        return dadosPessoaisService.create(dadosPessoaisDTO);
    }

    @Operation(summary = "Editar dados pessoais por CPF", description = "Edita dados pessoais e mantém no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Dados pessoais editado"),
                    @ApiResponse(responseCode = "400", description = "Dado pessoal nao existe"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @Schema(description = "Editando dado pessoal")
    @PutMapping("/{cpf}")
    public DadosPessoaisDTO update (@PathVariable("cpf") String cpf, @RequestBody DadosPessoaisDTO dadosPessoaisDTO) throws Exception {
        return dadosPessoaisService.update(cpf, dadosPessoaisDTO);
    }


    @Operation(summary = "Listar dados pessoais por CPF", description = "Lista dados pessoais por CPF do banco de dados!")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de dados pessoais por CPF"),
                    @ApiResponse(responseCode = "400", description = "CPF nao existe"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @Schema(description = "Listando dados por CPF")
    @GetMapping("/{cpf}")
    public DadosPessoaisDTO getByCpf(@PathVariable("cpf") String cpf){
        return dadosPessoaisService.getByCpf(cpf);
    }

    @Operation(summary = "Deletar dados pessoais por CPF", description = "Deleta dados pessoais por CPF do banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Dados pessoais deletado"),
                    @ApiResponse(responseCode = "400", description = "CPF nao existe"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @Schema(description = "Deletando dados pessoais")
    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable("cpf") String cpf){
        dadosPessoaisService.delete(cpf);
    }
}
