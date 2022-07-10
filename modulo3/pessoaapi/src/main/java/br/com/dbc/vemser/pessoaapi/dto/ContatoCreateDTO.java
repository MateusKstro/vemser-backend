package br.com.dbc.vemser.pessoaapi.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContatoCreateDTO {

    private Integer idPessoa;

    @NotNull
    private String tipoContato;

    @NotEmpty
    @Size(max = 13)
    private String numero;

    @NotEmpty
    private String descricao;
}
