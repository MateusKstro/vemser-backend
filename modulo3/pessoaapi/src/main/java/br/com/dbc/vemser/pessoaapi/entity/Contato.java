package br.com.dbc.vemser.pessoaapi.entity;


import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contato {

    private Integer idContato;

    private Integer idPessoa;

    private String tipoContato;

    private String numero;

    private String descricao;

}
