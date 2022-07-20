package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.dto.entity.TipoContato;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContatoCreateDTO {

    private Integer idPessoa;

    @NotNull
    private TipoContato tipoContato;

    @NotEmpty
    @Size(max = 13)
    private String numero;

    @NotEmpty
    private String descricao;
}
