package br.com.dbc.vemser.pessoaapi.entity;


import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contato {

    private Integer idContato;

    private Integer idPessoa;

    @NotNull
    private String tipoContato;
    @NotEmpty
    @Size (max = 13)
    private String numero;
    @NotEmpty
    private String descricao;

}
