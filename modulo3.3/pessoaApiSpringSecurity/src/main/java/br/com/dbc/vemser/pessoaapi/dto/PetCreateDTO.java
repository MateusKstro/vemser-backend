package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoPet;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class PetCreateDTO {

    private Integer idPessoa;

    @NotEmpty
    private String nome;

    @NotNull
    private TipoPet tipoPet;
}
